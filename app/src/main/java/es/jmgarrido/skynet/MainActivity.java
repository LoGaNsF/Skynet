package es.jmgarrido.skynet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.jmgarrido.skynet.Adapters.ItemAdapter;
import es.jmgarrido.skynet.Models.Movie;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.list_items) RecyclerView listItems;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        List<Movie> movies = new LinkedList<Movie>();

        adapter = new ItemAdapter(movies);
        listItems.setAdapter(adapter);

        manager = new LinearLayoutManager(this);
        listItems.setLayoutManager(manager);

        LoadTask task = new LoadTask("http://api.themoviedb.org/3/movie/upcoming?api_key=6607b23bd32c73196d95cb154d8be4b0", getApplicationContext(), listItems);
        task.execute();
    }

}
