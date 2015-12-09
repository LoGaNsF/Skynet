package es.jmgarrido.skynet;

import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class LoadTask extends AsyncTask<Void, Integer, String> {

    private final String url;

    public LoadTask(String url) {
        this.url = url;
    }

    @Override
    protected String doInBackground(Void... params) {
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

        return responseJsonStr;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }

}
