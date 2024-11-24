package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private AdapterListy adapter;
    private ArrayList<Zadanie> zadania;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recView = findViewById(R.id.recyclerView);
        FloatingActionButton przycisk = findViewById(R.id.przycisk);
        zadania = new ArrayList<>();
        adapter = new AdapterListy(zadania, i -> {
            Intent intent = new Intent(MainActivity.this, EdycjaZadania.class);
            intent.putExtra("pozycja", i);
            intent.putExtra("nazwa", zadania.get(i).getName());
            intent.putExtra("opis", zadania.get(i).getOpis());
            startActivityForResult(intent, 2);
        });

        recView.setLayoutManager(new LinearLayoutManager(this));
        recView.setAdapter(adapter);
        przycisk.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DodajZadanie.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int req, int res, @Nullable Intent data) {
        super.onActivityResult(req, res, data);
        if (req == 1 && res == RESULT_OK) {
            String nazwa = data.getStringExtra("nazwa");
            String opis = data.getStringExtra("opis");
            zadania.add(new Zadanie(nazwa, opis));
            adapter.notifyItemInserted(zadania.size() - 1);
        } else if (req == 2 && res == RESULT_OK) {
            int index = data.getIntExtra("index", -1);
            String name = data.getStringExtra("nazwa");
            String opis = data.getStringExtra("opis");
            if (index != -1) {
                zadania.get(index).setName(name);
                zadania.get(index).setOpis(opis);
                adapter.notifyItemChanged(index);
            }
        }
    }
}