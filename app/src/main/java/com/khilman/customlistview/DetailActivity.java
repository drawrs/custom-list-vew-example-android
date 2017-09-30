package com.khilman.customlistview;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class DetailActivity extends AppCompatActivity {

    ImageView imageBuah;
    TextView titleBuah;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        // inisialisasi widget
        imageBuah = (ImageView) findViewById(R.id.imageBuah);
        titleBuah = (TextView) findViewById(R.id.titleBuah);
        // tangkap data dari intent

        String nama_buah = getIntent().getStringExtra("nb");
        int gambar_buah = getIntent().getIntExtra("gb", 0);
        int suara_buah = getIntent().getIntExtra("sb", 0);
        //
        Log.d("Info", "" + nama_buah);
        Log.d("Info", "" + gambar_buah);
        // set value ke widget
        imageBuah.setImageResource(gambar_buah);
        titleBuah.setText(nama_buah);

        putarAudio(suara_buah);
    }

    private void putarAudio(int suara_buah) {
        // Media player
        MediaPlayer mediaPlayer = new MediaPlayer();
        // dapatkan lokasi file
        Uri lokasi_audio = Uri.parse("android.resource://" + getPackageName() + "/"  + suara_buah);
        // set audio manager
        mediaPlayer.setAudioSessionId(AudioManager.STREAM_MUSIC);
        // set data lokasi audio / resource ke mediaplayer
        try {
            mediaPlayer.setDataSource(getApplicationContext(), lokasi_audio);
            mediaPlayer.prepare();
            mediaPlayer.start(); // putar audio
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
