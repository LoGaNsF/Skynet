package es.jmgarrido.skynet;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import es.jmgarrido.skynet.Adapters.ItemAdapter;
import es.jmgarrido.skynet.Converters.MovieDTOToMovieConverter;
import es.jmgarrido.skynet.DTOs.MovieDTO;
import es.jmgarrido.skynet.DTOs.MoviesDTO;
import es.jmgarrido.skynet.Models.Movie;
import es.jmgarrido.skynet.Services.MovieDAO;


public class LoadTask extends AsyncTask<Void, Integer, MoviesDTO> {

    private final String url;

    private final Context baseContext;

    private final RecyclerView listView;

    public LoadTask(String url, Context baseContext, RecyclerView listView){
        this.url = url;
        this.baseContext = baseContext;
        this.listView = listView;
    }

    @Override
    protected MoviesDTO doInBackground(Void... params) {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String responseJsonStr = "";

        try {
            Uri builtUri = Uri.parse(this.url).buildUpon().build();
            URL url = new URL(builtUri.toString());

            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.connect();

            InputStream inputStream = urlConnection.getInputStream();
            StringBuffer buffer = new StringBuffer();

            reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                buffer.append(line);
            }

            responseJsonStr = buffer.toString();
        } catch (Exception e) {
            Log.e("CONN_ERROR", "Error durante la conexion.");
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }

            if (reader != null) {
                try {
                    reader.close();
                } catch (final IOException e) {
                    Log.e("LoadTask", "Skynet se ha revelado.");
                }
            }
        }

        MoviesDTO movies = getMovieList(responseJsonStr);

        return movies;
    }

    public MoviesDTO getMovieList (String json){
        MoviesDTO movies = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            movies = mapper.readValue(json, MoviesDTO.class);

            return movies;


        }catch (IOException e){
            Log.e("Error 1", "Error en descarga de productos", e);
        }

        return null;
    }

    @Override
    protected void onPostExecute(MoviesDTO movies) {
        super.onPostExecute(movies);

        if(listView != null){

            MovieDTOToMovieConverter productToProductDTOConverter = new MovieDTOToMovieConverter();

            List<Movie> listMovies = new LinkedList<Movie>();

            for(MovieDTO movieDTO: movies.getMovies()){
                Movie movie = productToProductDTOConverter.converter(movieDTO);
                listMovies.add(movie);
            }

            MovieDAO movieDAO = new MovieDAO();
            movieDAO.save(listMovies);

            listView.setAdapter(new ItemAdapter(listMovies));
        }
    }

}
