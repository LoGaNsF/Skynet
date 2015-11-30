package es.jmgarrido.skynet;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.LinkedList;

import es.jmgarrido.skynet.Adapters.ItemAdapter;
import es.jmgarrido.skynet.Models.Item;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listItems;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listItems = (RecyclerView) findViewById(R.id.list_items);

        LinkedList<Item> items = new LinkedList<Item>();

        for (int i = 1; i <= 10; i++) {
            String title = "Pelicula " + i;
            String description = "Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.";

            Item item = new Item(title, 2015, description);
            items.add(item);
        }

        // Obtener el Recycler
        listItems = (RecyclerView) findViewById(R.id.list_items);

        // Usar un administrador para LinearLayout
        manager = new LinearLayoutManager(this);
        listItems.setLayoutManager(manager);

        // Crear un nuevo adaptador
        adapter = new ItemAdapter(items);
        listItems.setAdapter(adapter);
    }
}
