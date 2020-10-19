package mathtinik.thesis;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class matching extends AppCompatActivity {
    ArrayList<String> Answers = new ArrayList<>();
    ArrayList<String> Question = new ArrayList<>();
    RadioButton q1,q2,q3,q4,q5,q6,q7,q8,q9,
                a1,a2,a3,a4,a5,a6,a7,a8,a9;
    TextView coins,life;

    ImageView heart;
    Animation Pulse;

    String getA1,getA2,getA3,getA4,getA5,getA6,getA7,getA8,getA9;
    int getQ1,getQ2,getQ3,getQ4,getQ5,getQ6,getQ7,getQ8,getQ9;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matching_template);
        ImplementUI();
        QandAGenerate();
        coins.setText(String.valueOf(MainActivity.prefs.getInt("Coins",0)));

    }

    //Function -> QuestionToAnswer
    public void QuestionToAnswer(View v){
        ConvertQuestionMath();
        Boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()){
            case R.id.q1:
                if (checked){
                    q1.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(q2,q3,q4,q5,q6,q7,q8,q9);
                    FunctionButton(q1,String.valueOf(getQ1), a1, a2, a3, a4, a5, a6, a7, a8, a9,getA1,getA2,getA3,getA4,getA5,getA6,getA7,getA8,getA9);
                }
                break;
            case R.id.q2:
                if (checked){
                    q2.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(q1,q3,q4,q5,q6,q7,q8,q9);
                    FunctionButton(q2,String.valueOf(getQ2), a1, a2, a3, a4, a5, a6, a7, a8, a9,getA1,getA2,getA3,getA4,getA5,getA6,getA7,getA8,getA9);
                }
                break;
            case R.id.q3:
                if (checked){
                    q3.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(q1,q2,q4,q5,q6,q7,q8,q9);
                    FunctionButton(q3,String.valueOf(getQ3), a1, a2, a3, a4, a5, a6, a7, a8, a9,getA1,getA2,getA3,getA4,getA5,getA6,getA7,getA8,getA9);
                }
                break;
            case R.id.q4:
                if (checked){
                    q4.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(q1,q2,q3,q5,q6,q7,q8,q9);
                    FunctionButton(q4,String.valueOf(getQ4), a1, a2, a3, a4, a5, a6, a7, a8, a9,getA1,getA2,getA3,getA4,getA5,getA6,getA7,getA8,getA9);
                }
                break;
            case R.id.q5:
                if (checked){
                    q5.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(q1,q2,q3,q4,q6,q7,q8,q9);
                    FunctionButton(q5,String.valueOf(getQ5), a1, a2, a3, a4, a5, a6, a7, a8, a9,getA1,getA2,getA3,getA4,getA5,getA6,getA7,getA8,getA9);
                }
                break;
            case R.id.q6:
                if (checked){
                    q6.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(q1,q2,q3,q4,q5,q7,q8,q9);
                    FunctionButton(q6,String.valueOf(getQ6), a1, a2, a3, a4, a5, a6, a7, a8, a9,getA1,getA2,getA3,getA4,getA5,getA6,getA7,getA8,getA9);
                }
                break;
            case R.id.q7:
                if (checked){
                    q7.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(q1,q2,q3,q4,q5,q6,q8,q9);
                    FunctionButton(q7,String.valueOf(getQ7), a1, a2, a3, a4, a5, a6, a7, a8, a9,getA1,getA2,getA3,getA4,getA5,getA6,getA7,getA8,getA9);
                }
                break;
            case R.id.q8:
                if (checked){
                    q8.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(q1,q2,q3,q4,q5,q6,q7,q9);
                    FunctionButton(q8,String.valueOf(getQ8), a1, a2, a3, a4, a5, a6, a7, a8, a9,getA1,getA2,getA3,getA4,getA5,getA6,getA7,getA8,getA9);
                }
                break;
            case R.id.q9:
                if (checked){
                    q9.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(q1,q2,q3,q4,q5,q6,q7,q8);
                    FunctionButton(q9,String.valueOf(getQ9), a1, a2, a3, a4, a5, a6, a7, a8, a9,getA1,getA2,getA3,getA4,getA5,getA6,getA7,getA8,getA9);
                }
                break;
        }

    }


    public void AnswerToQuestion(View v){
        ConvertQuestionMath();
        Boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()){
            case R.id.a1:
                if (checked){
                    a1.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(a2,a3,a4,a5,a6,a7,a8,a9);
                    FunctionButton(a1,getA1,q1, q2, q3, q4, q5, q6, q7, q8, q9,String.valueOf(getQ1),String.valueOf(getQ2),String.valueOf(getQ3),String.valueOf(getQ4),String.valueOf(getQ5),String.valueOf(getQ6),String.valueOf(getQ7),String.valueOf(getQ8),String.valueOf(getQ9));
                }
                break;
            case R.id.a2:
                if (checked){
                    a2.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(a1,a3,a4,a5,a6,a7,a8,a9);
                    FunctionButton(a2,getA2,q1, q2, q3, q4, q5, q6, q7, q8, q9,String.valueOf(getQ1),String.valueOf(getQ2),String.valueOf(getQ3),String.valueOf(getQ4),String.valueOf(getQ5),String.valueOf(getQ6),String.valueOf(getQ7),String.valueOf(getQ8),String.valueOf(getQ9));
                }
                break;
            case R.id.a3:
                if (checked){
                    a3.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(a1,a2,a4,a5,a6,a7,a8,a9);
                    FunctionButton(a3,getA3,q1, q2, q3, q4, q5, q6, q7, q8, q9,String.valueOf(getQ1),String.valueOf(getQ2),String.valueOf(getQ3),String.valueOf(getQ4),String.valueOf(getQ5),String.valueOf(getQ6),String.valueOf(getQ7),String.valueOf(getQ8),String.valueOf(getQ9));
                }
                break;
            case R.id.a4:
                if (checked){
                    a4.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(a1,a2,a3,a5,a6,a7,a8,a9);
                    FunctionButton(a4,getA4,q1, q2, q3, q4, q5, q6, q7, q8, q9,String.valueOf(getQ1),String.valueOf(getQ2),String.valueOf(getQ3),String.valueOf(getQ4),String.valueOf(getQ5),String.valueOf(getQ6),String.valueOf(getQ7),String.valueOf(getQ8),String.valueOf(getQ9));
                }
                break;
            case R.id.a5:
                if (checked){
                    a5.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(a1,a2,a3,a4,a6,a7,a8,a9);
                    FunctionButton(a5,getA5,q1, q2, q3, q4, q5, q6, q7, q8, q9,String.valueOf(getQ1),String.valueOf(getQ2),String.valueOf(getQ3),String.valueOf(getQ4),String.valueOf(getQ5),String.valueOf(getQ6),String.valueOf(getQ7),String.valueOf(getQ8),String.valueOf(getQ9));
                }
                break;
            case R.id.a6:
                if (checked){
                    a6.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(a1,a2,a3,a4,a5,a7,a8,a9);
                    FunctionButton(a6,getA6,q1, q2, q3, q4, q5, q6, q7, q8, q9,String.valueOf(getQ1),String.valueOf(getQ2),String.valueOf(getQ3),String.valueOf(getQ4),String.valueOf(getQ5),String.valueOf(getQ6),String.valueOf(getQ7),String.valueOf(getQ8),String.valueOf(getQ9));
                }
                break;
            case R.id.a7:
                if (checked){
                    a7.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(a1,a2,a3,a4,a5,a6,a8,a9);
                    FunctionButton(a7,getA7,q1, q2, q3, q4, q5, q6, q7, q8, q9,String.valueOf(getQ1),String.valueOf(getQ2),String.valueOf(getQ3),String.valueOf(getQ4),String.valueOf(getQ5),String.valueOf(getQ6),String.valueOf(getQ7),String.valueOf(getQ8),String.valueOf(getQ9));
                }
                break;
            case R.id.a8:
                if (checked){
                    a8.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(a1,a2,a3,a4,a5,a6,a7,a9);
                    FunctionButton(a8,getA8,q1, q2, q3, q4, q5, q6, q7, q8, q9,String.valueOf(getQ1),String.valueOf(getQ2),String.valueOf(getQ3),String.valueOf(getQ4),String.valueOf(getQ5),String.valueOf(getQ6),String.valueOf(getQ7),String.valueOf(getQ8),String.valueOf(getQ9));
                }
                break;
            case R.id.a9:
                if (checked){
                    a9.setBackgroundResource(R.drawable.select_rb);
                    checkRadioBTN(a1,a2,a3,a4,a5,a6,a7,a8);
                    FunctionButton(a9,getA9,q1, q2, q3, q4, q5, q6, q7, q8, q9,String.valueOf(getQ1),String.valueOf(getQ2),String.valueOf(getQ3),String.valueOf(getQ4),String.valueOf(getQ5),String.valueOf(getQ6),String.valueOf(getQ7),String.valueOf(getQ8),String.valueOf(getQ9));
                }
                break;
        }

    }


    public void ConvertQuestionMath(){
        try {
            ScriptEngine e = new ScriptEngineManager().getEngineByName("js");
            getQ1 = ((Number)e.eval(q1.getText().toString())).intValue();
            getQ2 = ((Number)e.eval(q2.getText().toString())).intValue();
            getQ3 = ((Number)e.eval(q3.getText().toString())).intValue();
            getQ4 = ((Number)e.eval(q4.getText().toString())).intValue();
            getQ5 = ((Number)e.eval(q5.getText().toString())).intValue();
            getQ6 = ((Number)e.eval(q6.getText().toString())).intValue();
            getQ7 = ((Number)e.eval(q7.getText().toString())).intValue();
            getQ8 = ((Number)e.eval(q8.getText().toString())).intValue();
            getQ9 = ((Number)e.eval(q9.getText().toString())).intValue();
        } catch (ScriptException scriptException) {
            scriptException.printStackTrace();
        }

        getA1 = a1.getText().toString();
        getA2 = a2.getText().toString();
        getA3 = a3.getText().toString();
        getA4 = a4.getText().toString();
        getA5 = a5.getText().toString();
        getA6 = a6.getText().toString();
        getA7 = a7.getText().toString();
        getA8 = a8.getText().toString();
        getA9 = a9.getText().toString();


    }

    public void checkRadioBTN(RadioButton R1,RadioButton R2,RadioButton R3,RadioButton R4,RadioButton R5,RadioButton R6,RadioButton R7,RadioButton R8){
        R1.setChecked(false);
        R2.setChecked(false);
        R3.setChecked(false);
        R4.setChecked(false);
        R5.setChecked(false);
        R6.setChecked(false);
        R7.setChecked(false);
        R8.setChecked(false);
        R1.setBackgroundResource(R.drawable.unselect_rb);
        R2.setBackgroundResource(R.drawable.unselect_rb);
        R3.setBackgroundResource(R.drawable.unselect_rb);
        R4.setBackgroundResource(R.drawable.unselect_rb);
        R5.setBackgroundResource(R.drawable.unselect_rb);
        R6.setBackgroundResource(R.drawable.unselect_rb);
        R7.setBackgroundResource(R.drawable.unselect_rb);
        R8.setBackgroundResource(R.drawable.unselect_rb);
    }


    public void QandAGenerate(){
        Random rand = new Random();
        int ans;
        for (int num =0; num < 9; num++){
                int num1=rand.nextInt(13)+1;
                int num2=rand.nextInt(13)+1;
                String mergeNum = num1+"+"+num2;
                ans = num1+num2;
                Question.add(mergeNum);
                Answers.add(String.valueOf(ans));
        }
        Collections.shuffle(Answers);
        Collections.shuffle(Question);

        setNumberRB(a1,Answers.get(0),a2,Answers.get(1),a3,Answers.get(2),a4,Answers.get(3),a5,Answers.get(4),a6,Answers.get(5),a7,Answers.get(6),a8,Answers.get(7),a9,Answers.get(8));
        setNumberRB(q1,Question.get(0),q2,Question.get(1),q3,Question.get(2),q4,Question.get(3),q5,Question.get(4),q6,Question.get(5),q7,Question.get(6),q8,Question.get(7),q9,Question.get(8));

    }

    //Function->SetNumberToRadioButton
    public void setNumberRB(RadioButton RB1,String N1,RadioButton RB2,String N2,RadioButton RB3,String N3,RadioButton RB4,String N4,RadioButton RB5,String N5,RadioButton RB6,String N6,RadioButton RB7,String N7,RadioButton RB8,String N8,RadioButton RB9,String N9){
        RB1.setText(N1);
        RB2.setText(N2);
        RB3.setText(N3);
        RB4.setText(N4);
        RB5.setText(N5);
        RB6.setText(N6);
        RB7.setText(N7);
        RB8.setText(N8);
        RB9.setText(N9);

    }

    //Function->Button
    public void FunctionButton(RadioButton Selected,String Main,RadioButton R1,RadioButton R2,RadioButton R3,RadioButton R4,RadioButton R5,RadioButton R6,RadioButton R7,RadioButton R8,RadioButton R9,
                               String getR1,String getR2,String getR3,String getR4,String getR5,String getR6,String getR7,String getR8,String getR9){
        int lifeCount = Integer.parseInt(life.getText().toString());
        int getCurrentCoins = MainActivity.prefs.getInt("Coins",0);
        int getEarnedCoins = 0;
            if (R1.isChecked()) {
                if (Main.equals(getR1)) {
                        CorrectAnswer(getCurrentCoins, getEarnedCoins, Selected, R1);
                } else {
                    lifeCount--;
                    if (lifeCount ==0){
                        GameOver();
                    }else {
                        life.setText(String.valueOf(lifeCount));
                        ResetRadioButton();
                    }
                }
            } else if (R2.isChecked()) {
                if (Main.equals(getR2)) {
                        CorrectAnswer(getCurrentCoins, getEarnedCoins, Selected, R2);
                } else {
                    lifeCount--;
                    if (lifeCount ==0){
                        GameOver();
                    }else {
                        life.setText(String.valueOf(lifeCount));
                        ResetRadioButton();
                    }
                }
            } else if (R3.isChecked()) {
                if (Main.equals(getR3)) {
                        CorrectAnswer(getCurrentCoins, getEarnedCoins, Selected, R3);
                } else {
                    lifeCount--;
                    if (lifeCount ==0){
                        GameOver();
                    }else {
                        life.setText(String.valueOf(lifeCount));
                        ResetRadioButton();
                    }
                }
            } else if (R4.isChecked()) {
                if (Main.equals(getR4)) {
                        CorrectAnswer(getCurrentCoins, getEarnedCoins, Selected, R4);
                } else {
                    lifeCount--;
                    if (lifeCount ==0){
                        GameOver();
                    }else {
                        life.setText(String.valueOf(lifeCount));
                        ResetRadioButton();
                    }
                }
            } else if (R5.isChecked()) {
                if (Main.equals(getR5)) {
                        CorrectAnswer(getCurrentCoins, getEarnedCoins, Selected, R5);
                } else {
                    lifeCount--;
                    if (lifeCount ==0){
                        GameOver();
                    }else {
                        life.setText(String.valueOf(lifeCount));
                        ResetRadioButton();
                    }
                }
            } else if (R6.isChecked()) {
                if (Main.equals(getR6)) {
                        CorrectAnswer(getCurrentCoins, getEarnedCoins, Selected, R6);
                } else {
                    lifeCount--;
                    if (lifeCount ==0){
                        GameOver();
                    }else {
                        life.setText(String.valueOf(lifeCount));
                        ResetRadioButton();
                    }
                }
            } else if (R7.isChecked()) {
                if (Main.equals(getR7)) {
                        CorrectAnswer(getCurrentCoins, getEarnedCoins, Selected, R7);
                } else {
                    lifeCount--;
                    if (lifeCount ==0){
                        GameOver();
                    }else {
                        life.setText(String.valueOf(lifeCount));
                        ResetRadioButton();
                    }
                }
            } else if (R8.isChecked()) {
                if (Main.equals(getR8)) {
                        CorrectAnswer(getCurrentCoins, getEarnedCoins, Selected, R8);
                } else {
                    lifeCount--;
                    if (lifeCount ==0){
                        GameOver();
                    }else {
                        life.setText(String.valueOf(lifeCount));
                        ResetRadioButton();
                    }
                }
            } else if (R9.isChecked()) {
                if (Main.equals(getR9)) {
                        CorrectAnswer(getCurrentCoins, getEarnedCoins, Selected, R9);
                } else {
                    lifeCount--;
                    if (lifeCount ==0){
                        GameOver();
                    }else {
                        life.setText(String.valueOf(lifeCount));
                        ResetRadioButton();
                    }
                }
            }
    }

    public void ResetRadioButton(){
        q1.setChecked(false);
        q2.setChecked(false);
        q3.setChecked(false);
        q4.setChecked(false);
        q5.setChecked(false);
        q6.setChecked(false);
        q7.setChecked(false);
        q8.setChecked(false);
        q9.setChecked(false);
        a1.setChecked(false);
        a2.setChecked(false);
        a3.setChecked(false);
        a4.setChecked(false);
        a5.setChecked(false);
        a6.setChecked(false);
        a7.setChecked(false);
        a8.setChecked(false);
        a9.setChecked(false);
        q1.setBackgroundResource(R.drawable.unselect_rb);
        q2.setBackgroundResource(R.drawable.unselect_rb);
        q3.setBackgroundResource(R.drawable.unselect_rb);
        q4.setBackgroundResource(R.drawable.unselect_rb);
        q5.setBackgroundResource(R.drawable.unselect_rb);
        q6.setBackgroundResource(R.drawable.unselect_rb);
        q7.setBackgroundResource(R.drawable.unselect_rb);
        q8.setBackgroundResource(R.drawable.unselect_rb);
        q9.setBackgroundResource(R.drawable.unselect_rb);
        a1.setBackgroundResource(R.drawable.unselect_rb);
        a2.setBackgroundResource(R.drawable.unselect_rb);
        a3.setBackgroundResource(R.drawable.unselect_rb);
        a4.setBackgroundResource(R.drawable.unselect_rb);
        a5.setBackgroundResource(R.drawable.unselect_rb);
        a6.setBackgroundResource(R.drawable.unselect_rb);
        a7.setBackgroundResource(R.drawable.unselect_rb);
        a8.setBackgroundResource(R.drawable.unselect_rb);
        a9.setBackgroundResource(R.drawable.unselect_rb);
    }



    public void GameOver(){
        ResetRadioButton();
        final AlertDialog gdialog = new AlertDialog.Builder(matching.this).create();
        LayoutInflater ginflater = getLayoutInflater();
        View gView = ginflater.inflate(R.layout.gameover,null);
        TextView CoinsEarned = gView.findViewById(R.id.getCoins);
        CoinsEarned.setText(String.valueOf(MainActivity.prefs.getInt("earnedCoins",0)));
        gdialog.setView(gView);
        gdialog.setCanceledOnTouchOutside(true);
        gdialog.setCancelable(false);

        gdialog.getWindow().getAttributes().windowAnimations = R.style.DialogScale;

        gdialog.show();
    }




    //CorrectAnswer
    public void CorrectAnswer(int getCurrentCoins,int getEarnedCoins,RadioButton s,RadioButton r){
        int solver =MainActivity.prefs.getInt("Solver",9);
        solver--;
        MainActivity.editor.putInt("Solver",solver);
        MainActivity.editor.commit();
        Log.d("SolverCount",String.valueOf(MainActivity.prefs.getInt("Solver",0)));
        if (solver == 0){
            Toast.makeText(this, "Next Level", Toast.LENGTH_SHORT).show();
        }else {
            getCurrentCoins++;
            getEarnedCoins++;
            coins.setText(String.valueOf(getCurrentCoins));
            MainActivity.editor.putInt("earnedCoins", getEarnedCoins);
            MainActivity.editor.putInt("Coins", getCurrentCoins);
            MainActivity.editor.apply();
            s.setVisibility(View.GONE);
            r.setVisibility(View.GONE);
            ResetRadioButton();
        }
    }


    //ImplementUI();
    public void ImplementUI(){
        //Answer
        a1 = findViewById(R.id.a1);
        a2 = findViewById(R.id.a2);
        a3 = findViewById(R.id.a3);
        a4 = findViewById(R.id.a4);
        a5 = findViewById(R.id.a5);
        a6 = findViewById(R.id.a6);
        a7 = findViewById(R.id.a7);
        a8 = findViewById(R.id.a8);
        a9 = findViewById(R.id.a9);

        //Question
        q1 = findViewById(R.id.q1);
        q2 = findViewById(R.id.q2);
        q3 = findViewById(R.id.q3);
        q4 = findViewById(R.id.q4);
        q5 = findViewById(R.id.q5);
        q6 = findViewById(R.id.q6);
        q7 = findViewById(R.id.q7);
        q8 = findViewById(R.id.q8);
        q9 = findViewById(R.id.q9);


        //Ui
        heart = findViewById(R.id.heart);
        coins =findViewById(R.id.coins);
        life =findViewById(R.id.life);


        //Animation
        Pulse = AnimationUtils.loadAnimation(matching.this,R.anim.pulse);


        //Start Animation
        heart.startAnimation(Pulse);

        //Reset SharedPreference
        MainActivity.editor.remove("Solver").commit();
        MainActivity.editor.remove("earnedCoins").commit();

    }


    //Back Press Disable
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK)
            Toast.makeText(getApplicationContext(), "back press",
                    Toast.LENGTH_LONG).show();

        return false;
        // Disable back button..............
    }
}