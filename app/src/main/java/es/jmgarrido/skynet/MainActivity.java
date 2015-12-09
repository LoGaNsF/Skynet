package es.jmgarrido.skynet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.LinkedList;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.jmgarrido.skynet.Adapters.ItemAdapter;
import es.jmgarrido.skynet.Models.Item;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.list_items) RecyclerView listItems;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinkedList<Item> items = new LinkedList<Item>();

        LoadTask task = new LoadTask("http://api.themoviedb.org/3/movie/upcoming?api_key=6607b23bd32c73196d95cb154d8be4b0");
        task.execute();

        for (int i = 1; i <= 10; i++) {
            String title = "Pelicula " + i;
            String description = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.";

            Item item = new Item(title, "2015", description);
            items.add(item);
        }

        manager = new LinearLayoutManager(this);
        listItems.setLayoutManager(manager);

        adapter = new ItemAdapter(items);
        listItems.setAdapter(adapter);
    }
}
