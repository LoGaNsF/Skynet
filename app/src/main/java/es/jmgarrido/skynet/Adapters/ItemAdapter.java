package es.jmgarrido.skynet.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.LinkedList;

import butterknife.Bind;
import butterknife.ButterKnife;
import es.jmgarrido.skynet.Models.Item;
import es.jmgarrido.skynet.R;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {

    private LinkedList<Item> listItems;

    public ItemAdapter(LinkedList<Item> listItems) {
        this.listItems = listItems;
    }

    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_item, parent, false);

        return new ItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int i) {
        holder.title.setText(listItems.get(i).getTitle());
        holder.year.setText(listItems.get(i).getYear());
        holder.description.setText(listItems.get(i).getDescription());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.item_title) TextView title;
        @Bind(R.id.item_year) TextView year;
        @Bind(R.id.item_description) TextView description;

        public ItemViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

}
