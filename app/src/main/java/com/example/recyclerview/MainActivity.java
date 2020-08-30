package com.example.recyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<User> usersList;
    private RecyclerView recyclerView;
    private MyAdapter.RecyclerViewClickLisstener lisstener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerID);

        usersList = new ArrayList<>();

        setuserInfo();
        setAdapter();
    }

    private void setAdapter() {

        setOnClickListner();
        MyAdapter adapter = new MyAdapter(usersList,lisstener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);
    }

    private void setOnClickListner() {
        lisstener = new MyAdapter.RecyclerViewClickLisstener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent = new Intent( getApplicationContext(),ProfileActivity.class);
                intent.putExtra("username",usersList.get(position).getUsername());
                startActivity(intent);

            }
        };
    }

    private void setuserInfo() {

        usersList.add(new User("Ramim"));
        usersList.add(new User("Hossain"));
        usersList.add(new User("Rakib"));
        usersList.add(new User("Santo"));
        usersList.add(new User("Rakib"));
        usersList.add(new User("Rouf"));
        usersList.add(new User("Rumi"));
        usersList.add(new User("Ritu"));
        usersList.add(new User("Alice"));
        usersList.add(new User("Mark"));
    }
}