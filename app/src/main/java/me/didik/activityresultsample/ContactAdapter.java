package me.didik.activityresultsample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by didik on 12/21/16.
 * A
 */

public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.MyViewHolder> {
    private List<Contact> dataset;

    class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name, phone, type;

        public MyViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.tv_name);
            phone = (TextView) itemView.findViewById(R.id.tv_phone);
            type = (TextView) itemView.findViewById(R.id.tv_type);
        }
    }

    public ContactAdapter(List<Contact> dataset) {
        this.dataset = dataset;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row_contact, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact contact = dataset.get(position);

        holder.name.setText(contact.getName());
        holder.type.setText(contact.getType());
        holder.phone.setText(contact.getPhone());
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }
}
