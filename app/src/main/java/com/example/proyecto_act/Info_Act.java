package com.example.proyecto_act;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class Info_Act extends AppCompatActivity {

    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_);

        videoView = (VideoView)findViewById(R.id.vd);

        String ruta = "android.resource://" + getPackageName() + "/" + R.raw.video;  //Obtenemos la ruta del video
        Uri uri = Uri.parse(ruta);
        videoView.setVideoURI(uri);

        //Controles del video
        MediaController media = new MediaController(this);
        videoView.setMediaController(media);
    }
}