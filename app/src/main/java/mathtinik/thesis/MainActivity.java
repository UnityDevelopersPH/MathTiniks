package mathtinik.thesis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton imgplay, exitapp;
    public static SharedPreferences.Editor editor;
    public static SharedPreferences prefs;
    AudioManager audioManager;
    ImageView settings;
    int maxVolume,currentVolume;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_main);
        audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        currentVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        imgplay = findViewById(R.id.playButton);
        exitapp = findViewById(R.id.exit);
        editor = getSharedPreferences("StoringData", MODE_PRIVATE).edit();
        prefs = getSharedPreferences("StoringData", MODE_PRIVATE);

        editor.remove("operation");
        editor.commit();

       settings = findViewById(R.id.settings);

       settings.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               final AlertDialog cdialog = new AlertDialog.Builder(MainActivity.this).create();
               LayoutInflater inflater = getLayoutInflater();
               View cView = (View) inflater.inflate(R.layout.activity_settings, null);
               SeekBar seekBar= cView.findViewById(R.id.seekBar);
               Button resetGame = cView.findViewById(R.id.resetGame);
               Button applySetting = cView.findViewById(R.id.applySetting);
               seekBar.setMax(maxVolume);
               seekBar.setProgress(currentVolume);
               cdialog.setCanceledOnTouchOutside(true);
               cdialog.setCancelable(false);
               cdialog.setView(cView);

               applySetting.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       cdialog.dismiss();
                   }
               });

               resetGame.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {

                       cdialog.dismiss();

                       final AlertDialog rdialog = new AlertDialog.Builder(MainActivity.this).create();
                       LayoutInflater inflater = getLayoutInflater();
                       View rView = (View) inflater.inflate(R.layout.reset_game_alert, null);
                       Button yesReset = rView.findViewById(R.id.yes);
                       Button noReset = rView.findViewById(R.id.no);
                       rdialog.setView(rView);

                       yesReset.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               prefs.edit().clear().commit();
                               rdialog.dismiss();
                           }
                       });
                       noReset.setOnClickListener(new View.OnClickListener() {
                           @Override
                           public void onClick(View v) {
                               rdialog.dismiss();
                           }
                       });
                       rdialog.show();

                   }
               });

               seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                   @Override
                   public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                       audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,progress,0);
                   }

                   @Override
                   public void onStartTrackingTouch(SeekBar seekBar) {

                   }

                   @Override
                   public void onStopTrackingTouch(SeekBar seekBar) {

                   }
               });
               cdialog.show();
           }
       });


        doBindService();
        Intent music = new Intent();
        music.setClass(this, MusicService.class);
        startService(music);



        imgplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Intent choice = new Intent(getApplicationContext(), gamechoices.class);
               startActivity(choice);
            }
        });

        exitapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog cdialog = new AlertDialog.Builder(MainActivity.this).create();
                LayoutInflater inflater = getLayoutInflater();
                View cView = (View) inflater.inflate(R.layout.activity_exitdialog, null);
                Button yesExit = cView.findViewById(R.id.exit_yes);
                Button noExit = cView.findViewById(R.id.exit_no);
                cdialog.setCancelable(false);
                cdialog.setCanceledOnTouchOutside(true);
                cdialog.setView(cView);

                yesExit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.exit(0);
                    }
                });
                noExit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        cdialog.dismiss();
                    }
                });
                cdialog.show();
            }
        });


    }

    //Bind/Unbind music service
    private boolean mIsBound = false;
    private MusicService mServ;
    private ServiceConnection Scon =new ServiceConnection(){

        public void onServiceConnected(ComponentName name, IBinder
                binder) {
            mServ = ((MusicService.ServiceBinder)binder).getService();
        }

        public void onServiceDisconnected(ComponentName name) {
            mServ = null;
        }
    };

    void doBindService(){
        bindService(new Intent(this,MusicService.class),
                Scon, Context.BIND_AUTO_CREATE);
        mIsBound = true;
    }

    void doUnbindService()
    {
        if(mIsBound)
        {
            unbindService(Scon);
            mIsBound = false;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mServ != null) {
            mServ.resumeMusic();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        //UNBIND music service
        doUnbindService();
        Intent music = new Intent();
        music.setClass(this,MusicService.class);
        stopService(music);

    }


}