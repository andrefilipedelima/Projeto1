package com.example.fatec_ipi_noite_pojeto_p1;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.widget.ImageButton;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class TextShareActivity extends AppCompatActivity {

    private ImageButton homeButton;
    private ImageButton textButton;
    private ImageButton imageButton;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.telacompartilhartexto);

        homeButton = findViewById(R.id.homeButton);
        textButton = findViewById(R.id.textButton);
        imageButton = findViewById(R.id.imageButton);

        textButton.setBackgroundColor(getColor(R.color.colorMenuActive));


        homeButton.setOnClickListener((view) -> {

            Intent intent = new Intent(TextShareActivity.this,  MainActivity.class);
            startActivity(intent);

        });

        imageButton.setOnClickListener(view ->{

            Intent intent = new Intent(TextShareActivity.this,  ImageShareActivity.class);
            startActivity(intent);

        });



    }
}
