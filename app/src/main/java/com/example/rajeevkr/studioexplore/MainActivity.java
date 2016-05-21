package com.example.rajeevkr.studioexplore;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private RecyclerView mToDoRecyclerView;
    private FloatingActionButton mAddToDoButton;
    private View mEmptyView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mToDoRecyclerView = (RecyclerView) findViewById(R.id.recyclerview_todo);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mToDoRecyclerView.setLayoutManager(layoutManager);

        mAddToDoButton = (FloatingActionButton) findViewById(R.id.fab_todo);
        mAddToDoButton.setOnClickListener(this);

        mEmptyView = findViewById(R.id.layout_empty_view);
    }

    @Override
    public void onClick(View v) {
        //TODO:Accept input fro user & add to firebase
    }
}
