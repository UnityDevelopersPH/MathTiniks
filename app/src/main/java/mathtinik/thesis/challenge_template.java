package mathtinik.thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class challenge_template extends AppCompatActivity {

    String operation;
    ArrayList<Integer> answers = new ArrayList<>();
    int locatiionOfCorrectAnswer;
    int num1;
    int num2;
    TextView question_One,ans1,ans2,ans3,ans4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_template);
        question_One = findViewById(R.id.question_One);
        ans1 = findViewById(R.id.ans1);
        ans2 = findViewById(R.id.ans2);
        ans3 = findViewById(R.id.ans3);
        ans4 = findViewById(R.id.ans4);
        generateQuestion();
    }


    public void generateQuestion(){
        Random rand= new Random();
        int answer=0;
        int threeWrongAnswers=0;
        num1 = rand.nextInt(10)+1;
        num2 = rand.nextInt(10)+1;

        answer = num1 + num2;
        question_One.setText(Integer.toString(num1)+"+"+Integer.toString(num2));
        answers.add(answer);
        answers.add(answer+1);
        answers.add(answer+2);
        answers.add(answer -1);
        Collections.shuffle(answers);
        Log.i("MyActivity","New question");

        for(int x = 0;x<answers.size();x++){
            if (answer == answers.get(x)){
                locatiionOfCorrectAnswer = x;
            }
        }

        ans1.setText(Integer.toString(answers.get(0)));
        ans2.setText(Integer.toString(answers.get(1)));
        ans3.setText(Integer.toString(answers.get(2)));
        ans4.setText(Integer.toString(answers.get(3)));

        answers.clear();



    }










}