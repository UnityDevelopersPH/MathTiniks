package mathtinik.thesis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.ClipData;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.icu.util.LocaleData;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.DragEvent;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class chall61_template extends AppCompatActivity {

    ArrayList<Integer> answers = new ArrayList<>();
    Animation animBlink,animShake;
    int locatiionOfCorrectAnswer;
    int num1;
    int num2;
    int checkCounts,wrongCounts;
    TextView question_One,question_Two,operation,ans1,ans2,ans3,ans4;
    Button submitBtn;
    EditText targetAns;
    StoringData storingData;
    int coinCounts;
    TextView checkCount,wrongCount,coinCount;
    ImageView life_one,life_two,life_three;
    ImageView backBtn,hint;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chall61_template);

        question_One = findViewById(R.id.question_One);
        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        ans4 = findViewById(R.id.ans4);
        storingData = new StoringData();
        checkCount = findViewById(R.id.countCheck);
        wrongCount = findViewById(R.id.countWrong);
        coinCount = findViewById(R.id.coinCount);
        operation = findViewById(R.id.operation);
        life_one = findViewById(R.id.life_one);
        life_two = findViewById(R.id.life_two);
        life_three = findViewById(R.id.life_three);
        backBtn = findViewById(R.id.backBtn);
        hint = findViewById(R.id.hint);

        question_Two = findViewById(R.id.question_Two);

        submitBtn = findViewById(R.id.submitBtn);
        targetAns = findViewById(R.id.targetAns);

        ans1.setOnLongClickListener(longClickListener);
        ans2.setOnLongClickListener(longClickListener);
        ans3.setOnLongClickListener(longClickListener);
        ans4.setOnLongClickListener(longClickListener);

        targetAns.setOnDragListener(dragListener);

        animBlink = AnimationUtils.loadAnimation(chall61_template.this,
                R.anim.blinking_effect);
        animShake = AnimationUtils.loadAnimation(chall61_template.this, R.anim.shaking);
        hint.startAnimation(animShake);

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),level61.class);
                startActivity(intent);
                finish();
            }
        });

        generateQuestion();
        submitBtn();
        if (MainActivity.prefs.getInt("Coins",0) == 0){
            coinCount.setText("0");
        }else{
            coinCount.setText(String.valueOf(MainActivity.prefs.getInt("Coins",0)));
        }

        if (MainActivity.prefs.getString("operation",null) == "Addition"){
            operation.setText("+");
        }else if(MainActivity.prefs.getString("operation",null) == "Subraction"){
            operation.setText("-");
        }else if(MainActivity.prefs.getString("operation",null) == "Multiplication"){
            operation.setText("x");
        }else if(MainActivity.prefs.getString("operation",null) == "Division"){
            operation.setText("÷");
        }

        hint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hintAns = 0;

                if (MainActivity.prefs.getInt("Coins", 0) >= 5) {
                    int getCurrentCoins = MainActivity.prefs.getInt("Coins", 0) - 5;
                    MainActivity.editor.putInt("Coins", getCurrentCoins);
                    MainActivity.editor.apply();
                    coinCount.setText(String.valueOf(MainActivity.prefs.getInt("Coins", 0)));
                    if (MainActivity.prefs.getString("operation", null) == "Addition") {
                        hintAns = Integer.parseInt(question_One.getText().toString()) + Integer.parseInt(question_Two.getText().toString());
                    } else if (MainActivity.prefs.getString("operation", null) == "Subraction") {
                        hintAns = Integer.parseInt(question_One.getText().toString()) - Integer.parseInt(question_Two.getText().toString());
                    } else if (MainActivity.prefs.getString("operation", null) == "Multiplication") {
                        hintAns = Integer.parseInt(question_One.getText().toString()) * Integer.parseInt(question_Two.getText().toString());
                    } else if (MainActivity.prefs.getString("operation", null) == "Division") {
                        hintAns = Integer.parseInt(question_One.getText().toString()) / Integer.parseInt(question_Two.getText().toString());
                    }

                    if (ans1.getText().toString().equals(String.valueOf(hintAns))) {
                        ans1.startAnimation(animBlink);
                    } else if (ans2.getText().toString().equals(String.valueOf(hintAns))) {
                        ans2.startAnimation(animBlink);

                    } else if (ans3.getText().toString().equals(String.valueOf(hintAns))) {
                        ans3.startAnimation(animBlink);
                    } else if (ans4.getText().toString().equals(String.valueOf(hintAns))) {
                        ans4.startAnimation(animBlink);
                    }

                }
            }
        });


    }

    View.OnLongClickListener longClickListener = new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data,shadowBuilder,v,0);
            return true;
        }
    };

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int dragEvent = event.getAction();
            final View view = (View)event.getLocalState();
            switch (dragEvent){

                case DragEvent.ACTION_DRAG_ENTERED:

                    if (view.getId() == R.id.ans1){
                        String getAns1= ans1.getText().toString();
                        targetAns.setText(getAns1);
                    }else  if (view.getId() == R.id.ans2){
                        String getAns2= ans2.getText().toString();
                        targetAns.setText(getAns2);
                    }else  if (view.getId() == R.id.ans3){
                        String getAns3= ans3.getText().toString();
                        targetAns.setText(getAns3);
                    }else  if (view.getId() == R.id.ans4){
                        String getAns4= ans4.getText().toString();
                        targetAns.setText(getAns4);
                    }
                    break;
                case  DragEvent.ACTION_DRAG_EXITED:
                    if (view.getId() == R.id.ans1){
                        String getAns1= ans1.getText().toString();
                        targetAns.setText(getAns1);
                    }else  if (view.getId() == R.id.ans2){
                        String getAns2= ans2.getText().toString();
                        targetAns.setText(getAns2);
                    }else  if (view.getId() == R.id.ans3){
                        String getAns3= ans3.getText().toString();
                        targetAns.setText(getAns3);
                    }else  if (view.getId() == R.id.ans4){
                        String getAns4= ans4.getText().toString();
                        targetAns.setText(getAns4);
                    }
                    break;
                case DragEvent.ACTION_DROP:
                    if (view.getId() == R.id.ans1){
                        String getAns1= ans1.getText().toString();
                        targetAns.setText(getAns1);
                        ans1.setVisibility(View.GONE);
                        ans2.setVisibility(View.VISIBLE);
                        ans3.setVisibility(View.VISIBLE);
                        ans4.setVisibility(View.VISIBLE);
                    }else  if (view.getId() == R.id.ans2){
                        String getAns2= ans2.getText().toString();
                        targetAns.setText(getAns2);
                        ans1.setVisibility(View.VISIBLE);
                        ans2.setVisibility(View.GONE);
                        ans3.setVisibility(View.VISIBLE);
                        ans4.setVisibility(View.VISIBLE);
                    }else  if (view.getId() == R.id.ans3){
                        String getAns3= ans3.getText().toString();
                        targetAns.setText(getAns3);
                        ans1.setVisibility(View.VISIBLE);
                        ans2.setVisibility(View.VISIBLE);
                        ans3.setVisibility(View.GONE);
                        ans4.setVisibility(View.VISIBLE);
                    }else  if (view.getId() == R.id.ans4){
                        String getAns4= ans4.getText().toString();
                        targetAns.setText(getAns4);
                        ans1.setVisibility(View.VISIBLE);
                        ans2.setVisibility(View.VISIBLE);
                        ans3.setVisibility(View.VISIBLE);
                        ans4.setVisibility(View.GONE);
                    }
                    break;
            }
            return true;
        }
    };

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK)
            Toast.makeText(getApplicationContext(), "back press",
                    Toast.LENGTH_LONG).show();

        return false;
        // Disable back button..............
    }

    public void generateQuestion() {
        Random rand = new Random();
        int answer = 0;
        int threeWrongAnswers = 0;
        int lvlCountFinal = MainActivity.prefs.getInt("getLevelSelected", 0);
        if (MainActivity.prefs.getString("operation", null) == "Division") {
            Log.d("yesSir", String.valueOf(lvlCountFinal));
            if (lvlCountFinal >= 61 && lvlCountFinal <= 70) {
                num1 = rand.nextInt(10) * 5;
                if (num1 == 0){
                    generateQuestion();
                }
                num2 = 5;
            }
            if (lvlCountFinal >= 71 && lvlCountFinal <= 80) {
                num1 = rand.nextInt(10) * 8;
                if (num1 == 0){
                    generateQuestion();
                }
                num2 =8;
            }
            if (lvlCountFinal >= 81 && lvlCountFinal <= 90) {
                num1 = rand.nextInt(10) * 11;
                if (num1 == 0){
                    generateQuestion();
                }
                num2 = 11;
            }
        } else {
            num1 = rand.nextInt(160) + 1;
            num2 = rand.nextInt(190) + 1;
        }

        if (num1 >= num2) {
            question_One.setText(Integer.toString(num1));
            question_Two.setText(Integer.toString(num2));
        } else {
            question_One.setText(Integer.toString(num2));
            question_Two.setText(Integer.toString(num1));
        }
        if (MainActivity.prefs.getString("operation", null) == "Addition") {
            answer = num1 + num2;
        } else if (MainActivity.prefs.getString("operation", null) == "Subraction") {
            answer = num1 - num2;
        } else if (MainActivity.prefs.getString("operation", null) == "Multiplication") {
            answer = num1 * num2;
        } else if (MainActivity.prefs.getString("operation", null) == "Division") {
            answer = num1 / num2;
        }

        answers.add(Math.abs(answer));
        answers.add(Math.abs(answer + 1));
        answers.add(Math.abs(answer + 3));
        answers.add(Math.abs(answer - 5));
        Collections.shuffle(answers);

        for (int x = 0; x < answers.size(); x++) {
            if (answer == answers.get(x)) {
                locatiionOfCorrectAnswer = x;
            }
        }

        ans1.setText(Integer.toString(answers.get(0)));
        ans2.setText(Integer.toString(answers.get(1)));
        ans3.setText(Integer.toString(answers.get(2)));
        ans4.setText(Integer.toString(answers.get(3)));
        Log.d("showError", Integer.toString(answers.get(0)) + Integer.toString(answers.get(1)));

        answers.clear();

    }

    public void submitBtn(){

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                ans1.setVisibility(View.VISIBLE);
                ans2.setVisibility(View.VISIBLE);
                ans3.setVisibility(View.VISIBLE);
                ans4.setVisibility(View.VISIBLE);
                ans1.clearAnimation();
                ans2.clearAnimation();
                ans3.clearAnimation();
                ans4.clearAnimation();

                int Fnum1 = Integer.parseInt(question_One.getText().toString());
                int Fnum2 = Integer.parseInt(question_Two.getText().toString());
                int checkAns = 0;
                int lvlCount = MainActivity.prefs.getInt("getLevelSelected",0);
                if (MainActivity.prefs.getString("operation",null) == "Addition"){
                    checkAns = Fnum1 + Fnum2;
                }else if(MainActivity.prefs.getString("operation",null) == "Subraction"){
                    checkAns = Fnum1 - Fnum2;
                }else if(MainActivity.prefs.getString("operation",null) == "Multiplication"){
                    checkAns = Fnum1 * Fnum2;
                }else if(MainActivity.prefs.getString("operation",null) == "Division"){
                    checkAns = Fnum1 / Fnum2;
                }

                Log.d("s",String.valueOf(checkAns));

                if (targetAns.getText().toString().equals("")) {

                    Toast.makeText(chall61_template.this, "Please Drag and Drop your Answer", Toast.LENGTH_SHORT).show();

                }else if (targetAns.getText().toString().equals(String.valueOf(checkAns))){
                        checkCounts++;
                        checkCount.setText(String.valueOf(checkCounts));
                        int getCoins = Integer.parseInt(coinCount.getText().toString());
                        getCoins++;
                        if (MainActivity.prefs.getString("operation", null) == "Addition") {
                            int getLevelUnlock = MainActivity.prefs.getInt("61addLevel", 61);
                            getLevelUnlock++;
                            MainActivity.editor.putInt("61addLevel", getLevelUnlock);
                            MainActivity.editor.apply();
                        } else if (MainActivity.prefs.getString("operation", null) == "Subraction") {
                            int getLevelUnlock = MainActivity.prefs.getInt("61subLevel", 61);
                            getLevelUnlock++;
                            MainActivity.editor.putInt("61subLevel", getLevelUnlock);
                            MainActivity.editor.apply();
                        } else if (MainActivity.prefs.getString("operation", null) == "Multiplication") {
                            int getLevelUnlock = MainActivity.prefs.getInt("61mulLevel", 61);
                            getLevelUnlock++;
                            MainActivity.editor.putInt("61mulLevel", getLevelUnlock);
                            MainActivity.editor.apply();
                        } else if (MainActivity.prefs.getString("operation", null) == "Division") {
                            int getLevelUnlock = MainActivity.prefs.getInt("61diviLevel", 61);
                            getLevelUnlock++;
                            MainActivity.editor.putInt("61diviLevel", getLevelUnlock);
                            MainActivity.editor.apply();
                        }
                        MainActivity.editor.putInt("Coins", getCoins);
                        MainActivity.editor.apply();
                        final AlertDialog cdialog = new AlertDialog.Builder(chall61_template.this).create();
                        LayoutInflater inflater = getLayoutInflater();
                        View cView = (View) inflater.inflate(R.layout.correct, null);
                        cdialog.setView(cView);
                        cdialog.getWindow().getAttributes().windowAnimations = R.style.DialogScale;
                        cdialog.setCanceledOnTouchOutside(true);
                        cdialog.setCancelable(false);
                        cdialog.show();
                        final Handler handler = new Handler();
                        final Runnable r = new Runnable() {
                            public void run() {
                                generateQuestion();
                                cdialog.dismiss();
                            }
                        };
                        handler.postDelayed(r, 1000);
                        coinCount.setText(String.valueOf(MainActivity.prefs.getInt("Coins", 0)));
                        targetAns.setText("");
                    lvlCount++;
                    MainActivity.editor.putInt("getLevelSelected",lvlCount);
                    MainActivity.editor.commit();

                    if (lvlCount == 91){
                        final AlertDialog gdialog = new AlertDialog.Builder(chall61_template.this).create();
                        LayoutInflater ginflater = getLayoutInflater();
                        View gView = (View) ginflater.inflate(R.layout.congrats, null);
                        TextView cgetCoins = gView.findViewById(R.id.earnCoins);
                        Button close_gameover = gView.findViewById(R.id.backToGame);
                        cgetCoins.setText(checkCount.getText().toString());
                        gdialog.setView(gView);

                        close_gameover.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent backToHome = new Intent(chall61_template.this, gamechoices.class);
                                startActivity(backToHome);
                                finish();
                            }
                        });
                        gdialog.setCanceledOnTouchOutside(true);
                        gdialog.setCancelable(false);

                        gdialog.getWindow().getAttributes().windowAnimations = R.style.DialogScale;

                        gdialog.show();
                    }
                }else{
                    wrongCounts++;
                    wrongCount.setText(String.valueOf(wrongCounts));
                    targetAns.setText("");

                    final AlertDialog wdialog = new AlertDialog.Builder(chall61_template.this).create();
                    LayoutInflater inflater = getLayoutInflater();
                    View wView = (View) inflater.inflate(R.layout.wrong, null);
                    wdialog.setView(wView);
                    wdialog.getWindow().getAttributes().windowAnimations = R.style.DialogScale;
                    wdialog.setCanceledOnTouchOutside(true);
                    wdialog.setCancelable(false);
                    wdialog.show();
                    final Handler handler = new Handler();
                    final Runnable r = new Runnable()
                    {
                        public void run()
                        {
                            generateQuestion();
                            wdialog.dismiss();
                        }
                    };
                    handler.postDelayed(r, 1000);

                    if (wrongCount.getText().toString().equals("1")){
                        life_one.setVisibility(View.GONE);
                    }
                    if (wrongCount.getText().toString().equals("2")){
                        life_two.setVisibility(View.GONE);
                    }
                    if (wrongCount.getText().toString().equals("3")){
                        life_two.setVisibility(View.GONE);
                        final AlertDialog gdialog = new AlertDialog.Builder(chall61_template.this).create();
                        LayoutInflater ginflater = getLayoutInflater();
                        View gView = (View) inflater.inflate(R.layout.gameover, null);
                        TextView getCoins = gView.findViewById(R.id.getCoins);
                        Button close_gameover = gView.findViewById(R.id.close_gameover);
                        getCoins.setText(checkCount.getText().toString());
                        gdialog.setView(gView);

                        close_gameover.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Intent backToHome = new Intent(chall61_template.this,gamechoices.class);
                                startActivity(backToHome);
                                finish();
                            }
                        });
                        gdialog.setCanceledOnTouchOutside(true);
                        gdialog.setCancelable(false);

                        gdialog.getWindow().getAttributes().windowAnimations = R.style.DialogScale;

                        gdialog.show();
                    }

                }
            }

        });

    }


    private void restoreUI(){
        ans1.setBackgroundColor(ContextCompat.getColor(chall61_template.this,R.color.colorPrimary));
        ans2.setBackgroundColor(ContextCompat.getColor(chall61_template.this,R.color.colorPrimary));
        ans3.setBackgroundColor(ContextCompat.getColor(chall61_template.this,R.color.colorPrimary));
        ans4.setBackgroundColor(ContextCompat.getColor(chall61_template.this,R.color.colorPrimary));
    }













}