package mathtinik.thesis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class level_choice extends AppCompatActivity {

    ImageView level1,level2,level3,btnBack;
    StoringData storingData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_choice);
        UI();


        if(MainActivity.prefs.getInt("level2unlock",0) == 2){
            level2.setImageResource(R.drawable.level_two);
        }
        if(MainActivity.prefs.getInt("level3unlock",0) == 3){
            level3.setImageResource(R.drawable.level_three);
        }


        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.editor.putString("SelectedLevel","Level1");
                MainActivity.editor.apply();
                Intent intent = new Intent(getApplicationContext(),levels.class);
                startActivity(intent);

            }
        });

        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level2.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.disabled_two).getConstantState()){
                    final AlertDialog cdialog = new AlertDialog.Builder(level_choice.this).create();
                    LayoutInflater inflater = getLayoutInflater();
                    View cView = (View) inflater.inflate(R.layout.activity_unlock, null);
                    Button unlockBtn = cView.findViewById(R.id.unclock);
                    cdialog.setView(cView);
                    cdialog.show();
                    unlockBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                           if (MainActivity.prefs.getInt("Coins",0) >= 2){
                               int getCurrentCoins = MainActivity.prefs.getInt("Coins",0) - 2;
                               MainActivity.editor.putInt("Coins",getCurrentCoins);
                               MainActivity.editor.putInt("level2unlock",2);
                               MainActivity.editor.apply();
                           }else{
                               Toast.makeText(level_choice.this, "mababa pa ang pera mo", Toast.LENGTH_SHORT).show();
                           }
                        }
                    });

                }else{
                    MainActivity.editor.putString("SelectedLevel","Level2");
                    MainActivity.editor.apply();
                    Intent intent = new Intent(getApplicationContext(),levels.class);
                    startActivity(intent);
                }


            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(level3.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.disabled_three).getConstantState()){
                    final AlertDialog cdialog = new AlertDialog.Builder(level_choice.this).create();
                    LayoutInflater inflater = getLayoutInflater();
                    View cView = (View) inflater.inflate(R.layout.activity_unlock, null);
                    Button unlockBtn = cView.findViewById(R.id.unclock);
                    cdialog.setView(cView);
                    cdialog.show();
                    unlockBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (MainActivity.prefs.getInt("Coins",0) >= 2){
                                int getCurrentCoins = MainActivity.prefs.getInt("Coins",0) - 2;
                                MainActivity.editor.putInt("Coins",getCurrentCoins);
                                MainActivity.editor.putInt("level3unlock",3);
                                MainActivity.editor.apply();
                                cdialog.dismiss();
                            }else{
                                Toast.makeText(level_choice.this, "mababa pa ang pera mo", Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }else{
                    MainActivity.editor.putString("SelectedLevel","Level3");
                    MainActivity.editor.apply();
                    Intent intent = new Intent(getApplicationContext(),levels.class);
                    startActivity(intent);
                }

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(), gamechoices.class);
                startActivity(b);
                finishActivity(1);
            }
        });


    }

    public void UI(){
        storingData = new StoringData();
        level1 = findViewById(R.id.level_one);
        level2 = findViewById(R.id.level_2);
        level3 = findViewById(R.id.level_3);
        btnBack = findViewById(R.id.back);
    }
}