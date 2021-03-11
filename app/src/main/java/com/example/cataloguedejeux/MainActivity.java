package com.example.cataloguedejeux;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import Data.GameRecyclerView;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerview;
    private GameRecyclerView gamerecyclerview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}