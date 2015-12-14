package es.jmgarrido.skynet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.jmgarrido.skynet.Models.Movie;
import es.jmgarrido.skynet.Services.MovieDAO;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_detail);

        int id = getIntent().getExtras().getInt("movie");

        MovieDAO movieDAO = new MovieDAO();
        Movie movie = movieDAO.getMovieById(id);

        this.setTitle(movie.getTitle());
    }
}
