package mathtinik.thesis;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyService extends Service {
    private MediaPlayer mMediaPlayer;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate()
    {
        Toast.makeText(this, "Service created", Toast.LENGTH_SHORT).show();
        mMediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.music_bg);
        mMediaPlayer.setLooping(false);
    }

    public void onStart(Intent intent, int startid){
        mMediaPlayer.start();
    }

    public void onDestroy(){
        mMediaPlayer.stop();
    }



}
