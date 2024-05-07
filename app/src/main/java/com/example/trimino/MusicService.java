package com.example.trimino;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;


public class MusicService extends Service {
    private MediaPlayer mediaPlayer;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this, R.raw.melodi);
        mediaPlayer.setLooping(true); // Зацикливание музыки
        mediaPlayer.start(); // Начало воспроизведения музыки
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.stop(); // Остановка воспроизведения музыки при уничтожении службы
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
