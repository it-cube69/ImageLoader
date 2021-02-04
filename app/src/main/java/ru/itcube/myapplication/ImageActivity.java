package ru.itcube.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;

import java.io.IOException;

public class ImageActivity extends AppCompatActivity {

    Bitmap bitmap;
    Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            bitmap = (Bitmap) bundle.get("picture");
            uri    = (Uri) bundle.get("uri");
            ImageFragment imageFragment = (ImageFragment) getSupportFragmentManager().findFragmentById(R.id.picture);
            if (uri != null) {
                try {
                    bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            imageFragment.loadPicture(bitmap);
        }
    }
}