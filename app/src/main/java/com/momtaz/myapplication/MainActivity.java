package com.momtaz.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView.Adapter adapterCources;
    public RecyclerView recyclerViewCources;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<CourseDomain> IteamsArrayList=new ArrayList<>();
        IteamsArrayList.add(new CourseDomain("Quick Learn C# Language","Jammie Young",120,4.6,"pic1"));
        IteamsArrayList.add(new CourseDomain("Full Course android Kotlin","Alix Alba",560,4.0,"pic2"));
        IteamsArrayList.add(new CourseDomain("Qick Learn Java language","Sara Anderson",1000,4.7,"pic1"));
        recyclerViewCources =findViewById(R.id.view);
        recyclerViewCources.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        adapterCources =new CourseAdapter(IteamsArrayList);
        recyclerViewCources.setAdapter(adapterCources);
    }
}