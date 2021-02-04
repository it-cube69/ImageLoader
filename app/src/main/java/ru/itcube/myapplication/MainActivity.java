package ru.itcube.myapplication;

import android.graphics.Bitmap;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageFragment imageFragment = (ImageFragment) getSupportFragmentManager().findFragmentById(R.id.picture);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Bitmap bitmap = (Bitmap) bundle.get("picture");
            imageFragment.loadPicture(bitmap);
        }
    }
}