package com.example.myapplication;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DodajZadanie extends AppCompatActivity {
    private EditText tytul, opis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dodaj_zadanie);

        tytul = findViewById(R.id.nazwaDodaj);
        opis = findViewById(R.id.opisDodaj);
        Button przycisk = findViewById(R.id.przyciskDodaj);

        przycisk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("nazwa", tytul.getText().toString());
                resultIntent.putExtra("opis", opis.getText().toString());
                setResult(RESULT_OK, resultIntent);
                finish();
            }
        });
    }
}