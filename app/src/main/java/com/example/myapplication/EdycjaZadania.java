package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EdycjaZadania extends AppCompatActivity {
    private EditText tytul, opis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edycja_lista);

        tytul = findViewById(R.id.edycjaTytul);
        opis = findViewById(R.id.edycjaOpis);
        Button buttonUpdateTask = findViewById(R.id.edycjaPrzycisk);

        Intent intent = getIntent();
        int pozycja = intent.getIntExtra("pozycja", -1);
        String nazwaZadania = intent.getStringExtra("nazwa");
        String opisZadania = intent.getStringExtra("opis");

        tytul.setText(nazwaZadania);
        opis.setText(opisZadania);

        buttonUpdateTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String zmienionyTytul = tytul.getText().toString();
                String zmienionyOpis = opis.getText().toString();

                Intent resultIntent = new Intent();
                resultIntent.putExtra("pozycja", pozycja);
                resultIntent.putExtra("nazwa", zmienionyTytul);
                resultIntent.putExtra("opis", zmienionyOpis);
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}