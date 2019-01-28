package com.example.hendi.recycleviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class ListPresidentAdapter extends RecyclerView.Adapter<ListPresidentAdapter.CategoryViewHolder> {
    Context context;
    private ArrayList<PresidentSetGet> listPresident;

    public ArrayList<PresidentSetGet> getListPresident() {
        return listPresident;
    }

    public void setListPresident(ArrayList<PresidentSetGet> listPresident) {
        this.listPresident = listPresident;
    }

    public ListPresidentAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemRow= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_row_president,viewGroup,false);
        return new CategoryViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder categoryViewHolder, int position) {
        categoryViewHolder.namaPresident.setText(getListPresident().get(position).getName());
        categoryViewHolder.presidentKe.setText(getListPresident().get(position).getRemarks());
        Glide.with(context)
                .load(getListPresident().get(position).getPhoto())
                .apply(new RequestOptions().override(55, 55))
                .into(categoryViewHolder.fotoPresident);
    }

    @Override
    public int getItemCount() {
        return getListPresident().size();
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView namaPresident;
        TextView presidentKe;
        ImageView fotoPresident;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            namaPresident = itemView.findViewById(R.id.tv_item_name);
            presidentKe = itemView.findViewById(R.id.tv_item_remaks);
            fotoPresident = itemView.findViewById(R.id.img_item_photo);
        }
    }
}
