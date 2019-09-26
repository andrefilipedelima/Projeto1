package com.example.fatec_ipi_noite_pojeto_p1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class DisplayImageActivity extends AppCompatActivity {

    private ImageView displayImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_image);

        displayImageView = findViewById(R.id.displayImageView);

        int imageInt = getIntent().getIntExtra("Image Int", R.drawable.img_ops);
        displayImageView.setImageResource(imageInt);
    }
}
