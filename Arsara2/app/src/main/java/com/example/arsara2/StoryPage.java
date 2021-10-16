package com.example.arsara2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

public class StoryPage extends AppCompatActivity {

    String title[];
    int img[]={R.drawable.surabaya,R.drawable.malinkundang};
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_page);

        recyclerView = findViewById(R.id.recycleView);

        title = getResources().getStringArray(R.array.title_story);

        MyAdapter myAdapter = new MyAdapter(this, title, img);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}