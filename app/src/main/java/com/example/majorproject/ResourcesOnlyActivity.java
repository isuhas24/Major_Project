package com.example.majorproject;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResourcesOnlyActivity extends AppCompatActivity {
    public static final String VIDEO_ID_KEY = "";



    TextView headlinetxt,infolinetxt,linktxt;
    ImageView first;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resources_only_activity);

        //id findings
        headlinetxt = findViewById(R.id.headline);
        infolinetxt = findViewById(R.id.infoline);
        first = findViewById(R.id.imageview1);

        linktxt= findViewById(R.id.Linkshow);

        //Image getting
        Intent intent = getIntent();
        byte[] byteArray = intent.getByteArrayExtra("image_byte_array");
        if(byteArray != null && byteArray.length > 0) {
            Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
            if (bitmap != null) {
                first.setImageBitmap(bitmap);
            }
        }
       // byte[] byteArray = intent.getByteArrayExtra("image_byte_array");
        //Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        //first.setImageBitmap(bitmap);




        //for head text
        String Headtxt = getIntent().getStringExtra("Headtext_id");
        headlinetxt.setText(Headtxt);
        //for info text
        String infotext = getIntent().getStringExtra("infotext_id");
        infolinetxt.setText(infotext);
        //file link setter
        String setlink = getIntent().getStringExtra("Link_file");
        linktxt.setText(setlink);



    }

}

