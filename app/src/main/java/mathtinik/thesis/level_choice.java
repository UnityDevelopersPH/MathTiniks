package mathtinik.thesis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class level_choice extends AppCompatActivity {

    ImageView level1,level2,level3,btnBack;
    StoringData storingData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_choice);
        UI();

        level1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                            Log.d("s","unlcik");
                        }
                    });

                }else{

                }


            }
        });

        level3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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