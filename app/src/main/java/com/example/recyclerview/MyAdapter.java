package com.example.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MyAdapter  extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private ArrayList<User> usersList;
    private  RecyclerViewClickLisstener lisstener;


    public MyAdapter(ArrayList<User> usersList, RecyclerViewClickLisstener lisstener) {
        this.usersList = usersList;
        this.lisstener = lisstener;
    }

    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
      View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);
      return  new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {

        String name = usersList.get(position).getUsername();
        holder.nameTxt.setText(name);

    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }

    public  interface RecyclerViewClickLisstener{

        void  onClick(View v , int position);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements  View.OnClickListener{

        private TextView nameTxt;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTxt = itemView.findViewById(R.id.usernameID);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            lisstener.onClick(view,getAdapterPosition());

        }
    }
}
