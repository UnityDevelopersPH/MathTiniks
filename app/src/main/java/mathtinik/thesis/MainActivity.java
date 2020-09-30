package mathtinik.thesis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageButton imgplay, exitapp;
    public static SharedPreferences.Editor editor;
    public static SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgplay = findViewById(R.id.playButton);
        exitapp = findViewById(R.id.exit);
        editor = getSharedPreferences("StoringData", MODE_PRIVATE).edit();
        prefs = getSharedPreferences("StoringData", MODE_PRIVATE);

        editor.remove("operation");
        editor.commit();




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
                cdialog.setView(cView);
                cdialog.show();
            }
        });


    }
}