package mathtinik.thesis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.mozilla.javascript.tools.jsc.Main;

import java.security.Key;
import java.util.ArrayList;
import java.util.logging.Logger;

public class level_choice extends AppCompatActivity {

    ImageView level1,level2,level3,btnBack;
    StoringData storingData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_choice);
        UI();

        if (MainActivity.prefs.getString("MLevelSelected",null).equals("Easy")) {
            if (MainActivity.prefs.getString("operation", null) == "Addition") {
                if (MainActivity.prefs.getInt("AUnlock02", 0) == 1) {
                    level2.setImageResource(R.drawable.level_two);
                }
                if (MainActivity.prefs.getInt("AUnlock03", 0) == 1) {
                    level3.setImageResource(R.drawable.level_three);
                }
            }
            if (MainActivity.prefs.getString("operation", null) == "Subraction") {
                if (MainActivity.prefs.getInt("SUnlock02", 0) == 1) {
                    level2.setImageResource(R.drawable.level_two);
                }
                if (MainActivity.prefs.getInt("SUnlock03", 0) == 1) {
                    level3.setImageResource(R.drawable.level_three);
                }
            }
            if (MainActivity.prefs.getString("operation", null) == "Multiplication") {
                if (MainActivity.prefs.getInt("MUnlock02", 0) == 1) {
                    level2.setImageResource(R.drawable.level_two);
                }
                if (MainActivity.prefs.getInt("MUnlock03", 0) == 1) {
                    level3.setImageResource(R.drawable.level_three);
                }
            }
            if (MainActivity.prefs.getString("operation", null) == "Division") {
                if (MainActivity.prefs.getInt("DUnlock02", 0) == 1) {
                    level2.setImageResource(R.drawable.level_two);
                }
                if (MainActivity.prefs.getInt("DUnlock03", 0) == 1) {
                    level3.setImageResource(R.drawable.level_three);
                }
            }
        }else if (MainActivity.prefs.getString("MLevelSelected",null).equals("Medium")) {
            if (MainActivity.prefs.getString("operation", null) == "Addition") {
                if (MainActivity.prefs.getInt("MAUnlock02", 0) == 1) {
                    level2.setImageResource(R.drawable.level_two);
                }
                if (MainActivity.prefs.getInt("MAUnlock03", 0) == 1) {
                    level3.setImageResource(R.drawable.level_three);
                }
            }
            if (MainActivity.prefs.getString("operation", null) == "Subraction") {
                if (MainActivity.prefs.getInt("MSUnlock02", 0) == 1) {
                    level2.setImageResource(R.drawable.level_two);
                }
                if (MainActivity.prefs.getInt("MSUnlock03", 0) == 1) {
                    level3.setImageResource(R.drawable.level_three);
                }
            }
            if (MainActivity.prefs.getString("operation", null) == "Multiplication") {
                if (MainActivity.prefs.getInt("MMUnlock02", 0) == 1) {
                    level2.setImageResource(R.drawable.level_two);
                }
                if (MainActivity.prefs.getInt("MMUnlock03", 0) == 1) {
                    level3.setImageResource(R.drawable.level_three);
                }
            }
            if (MainActivity.prefs.getString("operation", null) == "Division") {
                if (MainActivity.prefs.getInt("MDUnlock02", 0) == 1) {
                    level2.setImageResource(R.drawable.level_two);
                }
                if (MainActivity.prefs.getInt("MDUnlock03", 0) == 1) {
                    level3.setImageResource(R.drawable.level_three);
                }
            }
        }else if (MainActivity.prefs.getString("MLevelSelected",null).equals("Hard")) {
            if (MainActivity.prefs.getString("operation", null) == "Addition") {
                if (MainActivity.prefs.getInt("HAUnlock02", 0) == 1) {
                    level2.setImageResource(R.drawable.level_two);
                }
                if (MainActivity.prefs.getInt("HAUnlock03", 0) == 1) {
                    level3.setImageResource(R.drawable.level_three);
                }
            }
            if (MainActivity.prefs.getString("operation", null) == "Subraction") {
                if (MainActivity.prefs.getInt("HSUnlock02", 0) == 1) {
                    level2.setImageResource(R.drawable.level_two);
                }
                if (MainActivity.prefs.getInt("HSUnlock03", 0) == 1) {
                    level3.setImageResource(R.drawable.level_three);
                }
            }
            if (MainActivity.prefs.getString("operation", null) == "Multiplication") {
                if (MainActivity.prefs.getInt("HMUnlock02", 0) == 1) {
                    level2.setImageResource(R.drawable.level_two);
                }
                if (MainActivity.prefs.getInt("HMUnlock03", 0) == 1) {
                    level3.setImageResource(R.drawable.level_three);
                }
            }
            if (MainActivity.prefs.getString("operation", null) == "Division") {
                if (MainActivity.prefs.getInt("HDUnlock02", 0) == 1) {
                    level2.setImageResource(R.drawable.level_two);
                }
                if (MainActivity.prefs.getInt("HDUnlock03", 0) == 1) {
                    level3.setImageResource(R.drawable.level_three);
                }
            }
        }

        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.editor.putString("selectlevel","level1");
                MainActivity.editor.commit();
                Intent intent = new Intent(getApplicationContext(),levels.class);
                startActivity(intent);
                finish();

            }
        });

        level2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(level2.getDrawable().getConstantState() == getResources().getDrawable(R.drawable.disabled_two).getConstantState()){
                    final AlertDialog cdialog = new AlertDialog.Builder(level_choice.this).create();
                    LayoutInflater inflater = getLayoutInflater();
                    View cView = (View) inflater.inflate(R.layout.activity_unlock, null);
                    Button unlockBtn = cView.findViewById(R.id.unlock);
                    cdialog.setView(cView);
                    cdialog.setCanceledOnTouchOutside(true);
                    cdialog.setCancelable(false);
                    cdialog.show();
                    unlockBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                           if (MainActivity.prefs.getInt("Coins",0) >= 25){
                               int getCurrentCoins = MainActivity.prefs.getInt("Coins",0) - 25;
                               MainActivity.editor.putInt("Coins",getCurrentCoins);
                               if (MainActivity.prefs.getString("MLevelSelected",null).equals("Easy")) {
                                   if (MainActivity.prefs.getString("operation", null) == "Addition") {
                                       MainActivity.editor.putInt("AUnlock02", 1);
                                       MainActivity.editor.apply();
                                   }
                                   if (MainActivity.prefs.getString("operation", null) == "Subraction") {
                                       MainActivity.editor.putInt("SUnlock02", 1);
                                       MainActivity.editor.apply();
                                   }
                                   if (MainActivity.prefs.getString("operation", null) == "Multiplication") {
                                       MainActivity.editor.putInt("MUnlock02", 1);
                                       MainActivity.editor.apply();
                                   }
                                   if (MainActivity.prefs.getString("operation", null) == "Division") {
                                       MainActivity.editor.putInt("DUnlock02", 1);
                                       MainActivity.editor.apply();
                                   }
                               }else if (MainActivity.prefs.getString("MLevelSelected",null).equals("Medium")) {
                                   if (MainActivity.prefs.getString("operation", null) == "Addition") {
                                       MainActivity.editor.putInt("MAUnlock02", 1);
                                       MainActivity.editor.apply();
                                   }
                                   if (MainActivity.prefs.getString("operation", null) == "Subraction") {
                                       MainActivity.editor.putInt("MSUnlock02", 1);
                                       MainActivity.editor.apply();
                                   }
                                   if (MainActivity.prefs.getString("operation", null) == "Multiplication") {
                                       MainActivity.editor.putInt("MMUnlock02", 1);
                                       MainActivity.editor.apply();
                                   }
                                   if (MainActivity.prefs.getString("operation", null) == "Division") {
                                       MainActivity.editor.putInt("MDUnlock02", 1);
                                       MainActivity.editor.apply();
                                   }
                               }else if (MainActivity.prefs.getString("MLevelSelected",null).equals("Hard")) {
                                   if (MainActivity.prefs.getString("operation", null) == "Addition") {
                                       MainActivity.editor.putInt("HAUnlock02", 1);
                                       MainActivity.editor.apply();
                                   }
                                   if (MainActivity.prefs.getString("operation", null) == "Subraction") {
                                       MainActivity.editor.putInt("HSUnlock02", 1);
                                       MainActivity.editor.apply();
                                   }
                                   if (MainActivity.prefs.getString("operation", null) == "Multiplication") {
                                       MainActivity.editor.putInt("HMUnlock02", 1);
                                       MainActivity.editor.apply();
                                   }
                                   if (MainActivity.prefs.getString("operation", null) == "Division") {
                                       MainActivity.editor.putInt("HDUnlock02", 1);
                                       MainActivity.editor.apply();
                                   }
                               }
                               MainActivity.editor.apply();
                               cdialog.dismiss();
                               Intent intent = new Intent(getApplicationContext(),level_choice.class);
                               startActivity(intent);
                               finish();

                           }else{
                               Toast.makeText(level_choice.this, "Your coins is not enough", Toast.LENGTH_SHORT).show();
                               cdialog.dismiss();

                           }
                        }
                    });

                }else{
                    MainActivity.editor.putString("selectlevel","level31");
                    MainActivity.editor.commit();

                    Intent intent = new Intent(getApplicationContext(),level31.class);
                    startActivity(intent);
                    finish();
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
                    Button unlockBtn = cView.findViewById(R.id.unlock);
                    unlockBtn.setText("Unlock Now - 50 Coins");
                    cdialog.setView(cView);
                    cdialog.setCancelable(false);
                    cdialog.setCanceledOnTouchOutside(true);
                    cdialog.show();
                    unlockBtn.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if (MainActivity.prefs.getInt("Coins",0) >= 50){
                                int getCurrentCoins = MainActivity.prefs.getInt("Coins",0) - 50;
                                MainActivity.editor.putInt("Coins",getCurrentCoins);
                                if (MainActivity.prefs.getString("MLevelSelected",null).equals("Easy")) {
                                    if (MainActivity.prefs.getString("operation", null) == "Addition") {
                                        MainActivity.editor.putInt("AUnlock03", 1);
                                        MainActivity.editor.apply();
                                    }
                                    if (MainActivity.prefs.getString("operation", null) == "Subraction") {
                                        MainActivity.editor.putInt("SUnlock03", 1);
                                        MainActivity.editor.apply();
                                    }
                                    if (MainActivity.prefs.getString("operation", null) == "Multiplication") {
                                        MainActivity.editor.putInt("MUnlock03", 1);
                                        MainActivity.editor.apply();
                                    }
                                    if (MainActivity.prefs.getString("operation", null) == "Division") {
                                        MainActivity.editor.putInt("DUnlock03", 1);
                                        MainActivity.editor.apply();
                                    }
                                }else if (MainActivity.prefs.getString("MLevelSelected",null).equals("Medium")) {
                                    if (MainActivity.prefs.getString("operation", null) == "Addition") {
                                        MainActivity.editor.putInt("MAUnlock03", 1);
                                        MainActivity.editor.apply();
                                    }
                                    if (MainActivity.prefs.getString("operation", null) == "Subraction") {
                                        MainActivity.editor.putInt("MSUnlock03", 1);
                                        MainActivity.editor.apply();
                                    }
                                    if (MainActivity.prefs.getString("operation", null) == "Multiplication") {
                                        MainActivity.editor.putInt("MMUnlock03", 1);
                                        MainActivity.editor.apply();
                                    }
                                    if (MainActivity.prefs.getString("operation", null) == "Division") {
                                        MainActivity.editor.putInt("MDUnlock03", 1);
                                        MainActivity.editor.apply();
                                    }
                                }else if (MainActivity.prefs.getString("MLevelSelected",null).equals("Hard")) {
                                    if (MainActivity.prefs.getString("operation", null) == "Addition") {
                                        MainActivity.editor.putInt("HAUnlock03", 1);
                                        MainActivity.editor.apply();
                                    }
                                    if (MainActivity.prefs.getString("operation", null) == "Subraction") {
                                        MainActivity.editor.putInt("HSUnlock03", 1);
                                        MainActivity.editor.apply();
                                    }
                                    if (MainActivity.prefs.getString("operation", null) == "Multiplication") {
                                        MainActivity.editor.putInt("HMUnlock03", 1);
                                        MainActivity.editor.apply();
                                    }
                                    if (MainActivity.prefs.getString("operation", null) == "Division") {
                                        MainActivity.editor.putInt("HDUnlock03", 1);
                                        MainActivity.editor.apply();
                                    }
                                }
                                MainActivity.editor.apply();
                                cdialog.dismiss();
                                Intent intent = new Intent(getApplicationContext(),level_choice.class);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(level_choice.this, "Your coins is not enough", Toast.LENGTH_SHORT).show();
                                cdialog.dismiss();
                            }
                        }
                    });

                }else{
                    MainActivity.editor.putString("selectlevel","level61");
                    MainActivity.editor.commit();
                    Intent intent = new Intent(getApplicationContext(),level61.class);
                    startActivity(intent);
                    finish();
                }

            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(getApplicationContext(), gamechoices.class);
                startActivity(b);
                finish();
            }
        });


    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK)
            Toast.makeText(getApplicationContext(), "back press",
                    Toast.LENGTH_LONG).show();

        return false;
    }

    public void UI(){
        storingData = new StoringData();
        level1 = findViewById(R.id.level_one);
        level2 = findViewById(R.id.level_2);
        level3 = findViewById(R.id.level_3);
        btnBack = findViewById(R.id.back);
    }
}