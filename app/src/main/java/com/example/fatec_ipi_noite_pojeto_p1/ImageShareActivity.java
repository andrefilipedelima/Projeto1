package com.example.fatec_ipi_noite_pojeto_p1;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ImageShareActivity extends AppCompatActivity {

    private ImageButton homeButton;
    private ImageButton textButton;
    private ImageButton imageButton;

    private GridView imagesGridView;

    Integer[] imageIDs = {
            R.drawable.ic_launcher_background, R.drawable.ic_launcher_foreground, R.drawable.img_home,
            R.drawable.img_image, R.drawable.img_play, R.drawable.img_text
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_share);

        homeButton = findViewById(R.id.homeButton);
        textButton = findViewById(R.id.textButton);
        imageButton = findViewById(R.id.imageButton);

        imagesGridView = findViewById(R.id.imagesGridView);

        imagesGridView.setAdapter(new ImageAdapterGridView(this));
        imagesGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent,
                                    View v, int position, long id) {
                Intent intent = new Intent(ImageShareActivity.this, DisplayImageActivity.class);
                intent.putExtra("Image Int", imageIDs[position]);
                startActivity(intent, ActivityOptions.makeSceneTransitionAnimation(ImageShareActivity.this).toBundle());
            }
        });

        imageButton.setBackgroundColor(getColor(R.color.colorMenuActive));

        textButton.setOnClickListener((view) -> {

            Intent intent = new Intent(ImageShareActivity.this,  TextShareActivity.class);
            startActivity(intent);

        });

        homeButton.setOnClickListener(view ->{

            Intent intent = new Intent(ImageShareActivity.this,  MainActivity.class);
            startActivity(intent);

        });
    }


    public class ImageAdapterGridView extends BaseAdapter {
        private Context mContext;

        public ImageAdapterGridView(Context c) {
            mContext = c;
        }

        public int getCount() {
            return imageIDs.length;
        }

        public Object getItem(int position) {
            return null;
        }

        public long getItemId(int position) {
            return 0;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView mImageView;

            if (convertView == null) {
                mImageView = new ImageView(mContext);
                mImageView.setLayoutParams(new GridView.LayoutParams(130, 130));
                mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                mImageView.setPadding(16, 16, 16, 16);
            } else {
                mImageView = (ImageView) convertView;
            }
            mImageView.setImageResource(imageIDs[position]);
            return mImageView;
        }
    }
}
