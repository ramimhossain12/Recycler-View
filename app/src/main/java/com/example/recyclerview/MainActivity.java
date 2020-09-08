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
                if (position == 0){
                    Intent intent = new Intent(MainActivity.this,MainActivity3.class);
                    startActivity(intent);
                }

                if (position == 1){
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    startActivity(intent);
                }
                if (position == 9){
                    Intent intent = new Intent(MainActivity.this,MainActivity4.class);
                    startActivity(intent);
                }

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