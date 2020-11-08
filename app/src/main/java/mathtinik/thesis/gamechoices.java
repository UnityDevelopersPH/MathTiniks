package mathtinik.thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class gamechoices extends AppCompatActivity implements Animation.AnimationListener {

    ImageView add, subtracts, multiply, divides, backButton;
    TextView choicex,coinCount;
    StoringData storingData;
    Animation animBounceUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamechoices);
        View decorView = getWindow().getDecorView();

        MainActivity.editor.remove("operation").commit();


        add = findViewById(R.id.addition);
        subtracts = findViewById(R.id.subtraction);
        multiply = findViewById(R.id.multiplication);
        divides = findViewById(R.id.division);
        backButton = findViewById(R.id.backHome);
        choicex = findViewById(R.id.choicex);
        animBounceUp = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.bounce_in_up);
        animBounceUp.setAnimationListener(this);

        mathematicsGroupBtn();
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void mathematicsGroupBtn(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getchoiceX("Addition");
                add.startAnimation(animBounceUp);
            }
        });
        subtracts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getchoiceX("Subraction");
                subtracts.startAnimation(animBounceUp);
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getchoiceX("Multiplication");
                multiply.startAnimation(animBounceUp);
            }
        });
        divides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getchoiceX("Division");
                divides.startAnimation(animBounceUp);
            }
        });
    }

    public void selection(View v){

        String getMath = choicex.getText().toString();

        switch (v.getId()){
            case R.id.easys:
                if (getMath.equals("Addition")){
                    MainActivity.editor.putString("operation","Addition");
                    MainActivity.editor.commit();
                    Log.d("result",MainActivity.prefs.getString("operation",null));
                    Intent intent = new Intent(gamechoices.this,level_choice.class);
                    startActivity(intent);
                    finish();
                }else if(getMath.equals("Subraction")){
                    MainActivity.editor.putString("operation","Subraction");
                    MainActivity.editor.commit();
                    Log.d("result",MainActivity.prefs.getString("operation",null));
                    Intent intent = new Intent(gamechoices.this,level_choice.class);
                    startActivity(intent);
                    finish();
                }else if(getMath.equals("Multiplication")){
                    MainActivity.editor.putString("operation","Multiplication");
                    MainActivity.editor.commit();
                    Log.d("result",MainActivity.prefs.getString("operation",null));
                    Intent intent = new Intent(gamechoices.this,level_choice.class);
                    startActivity(intent);
                    finish();
                }else if(getMath.equals("Division")){
                    MainActivity.editor.putString("operation","Division");
                    MainActivity.editor.commit();
                    Log.d("result",MainActivity.prefs.getString("operation",null));
                    Intent intent = new Intent(gamechoices.this,level_choice.class);
                    startActivity(intent);
                    finish();
                }

                MainActivity.editor.putString("MLevelSelected","Easy").commit();

                MainActivity.editor.remove("getLevelSelected").commit();

                break;
            case R.id.mediums:
                if (getMath.equals("Addition")){
                    MainActivity.editor.putString("operation","Addition");
                    MainActivity.editor.commit();
                    Log.d("result",MainActivity.prefs.getString("operation",null));
                    Intent intent = new Intent(gamechoices.this,level_choice.class);
                    startActivity(intent);
                    finish();
                }else if(getMath.equals("Subraction")){
                    MainActivity.editor.putString("operation","Subraction");
                    MainActivity.editor.commit();
                    Log.d("result",MainActivity.prefs.getString("operation",null));
                    Intent intent = new Intent(gamechoices.this,level_choice.class);
                    startActivity(intent);
                    finish();
                }else if(getMath.equals("Multiplication")){
                    MainActivity.editor.putString("operation","Multiplication");
                    MainActivity.editor.commit();
                    Log.d("result",MainActivity.prefs.getString("operation",null));
                    Intent intent = new Intent(gamechoices.this,level_choice.class);
                    startActivity(intent);
                    finish();
                }else if(getMath.equals("Division")){
                    MainActivity.editor.putString("operation","Division");
                    MainActivity.editor.commit();
                    Log.d("result",MainActivity.prefs.getString("operation",null));
                    Intent intent = new Intent(gamechoices.this,level_choice.class);
                    startActivity(intent);
                    finish();
                }


                MainActivity.editor.putString("MLevelSelected","Medium").commit();
                break;
            case R.id.hards:
                if (getMath.equals("Addition")){
                    MainActivity.editor.putString("operation","Addition");
                    MainActivity.editor.commit();
                    Log.d("result",MainActivity.prefs.getString("operation",null));
                    Intent intent = new Intent(gamechoices.this,level_choice.class);
                    startActivity(intent);
                    finish();
                }else if(getMath.equals("Subraction")){
                    MainActivity.editor.putString("operation","Subraction");
                    MainActivity.editor.commit();
                    Log.d("result",MainActivity.prefs.getString("operation",null));
                    Intent intent = new Intent(gamechoices.this,level_choice.class);
                    startActivity(intent);
                    finish();
                }else if(getMath.equals("Multiplication")){
                    MainActivity.editor.putString("operation","Multiplication");
                    MainActivity.editor.commit();
                    Log.d("result",MainActivity.prefs.getString("operation",null));
                    Intent intent = new Intent(gamechoices.this,level_choice.class);
                    startActivity(intent);
                    finish();
                }else if(getMath.equals("Division")){
                    MainActivity.editor.putString("operation","Division");
                    MainActivity.editor.commit();
                    Log.d("result",MainActivity.prefs.getString("operation",null));
                    Intent intent = new Intent(gamechoices.this,level_choice.class);
                    startActivity(intent);
                    finish();
                }


                MainActivity.editor.putString("MLevelSelected","Hard").commit();
                break;
            default:
                break;
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK)
            Toast.makeText(getApplicationContext(), "back press",
                    Toast.LENGTH_LONG).show();

        return false;
        // Disable back button..............
    }


    public void getchoiceX(String mathematics){
        choicex.setText("");
        choicex.setText(mathematics);
    }

    @Override
    public void onAnimationStart(Animation animation) {

    }

    @Override
    public void onAnimationEnd(Animation animation) {
        if (animation == animBounceUp) {
            add.clearAnimation();
            subtracts.clearAnimation();
            multiply.clearAnimation();
            divides.clearAnimation();
        }
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }
}

