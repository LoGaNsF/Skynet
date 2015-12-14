package es.jmgarrido.skynet.Adapters;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.LinkedList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.jmgarrido.skynet.MainActivity;
import es.jmgarrido.skynet.Models.Movie;
import es.jmgarrido.skynet.MovieDetailActivity;
import es.jmgarrido.skynet.R;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private List<Movie> listItems;

    public ItemAdapter(List<Movie> listItems) {
        this.listItems = listItems;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, final int i) {
        final View itemView = holder.getItemView();

        Movie movie = listItems.get(i);

        holder.title.setText(movie.getTitle());
        holder.year.setText(movie.getYear());
        holder.description.setText(movie.getDescription());
        Picasso.with(itemView.getContext()).load(movie.getPoster()).resize(100, 150).into(holder.image);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movieDetail = new Intent(itemView.getContext(), MovieDetailActivity.class);
                movieDetail.putExtra("movie", i);
                itemView.getContext().startActivity(movieDetail);

            }
        });
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_title) TextView title;
        @Bind(R.id.item_year) TextView year;
        @Bind(R.id.item_description) TextView description;
        @Bind(R.id.item_image) ImageView image;
        final View itemView;

        public ItemViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            ButterKnife.bind(this, itemView);
        }

        public View getItemView() {
            return itemView;
        }
    }

}
