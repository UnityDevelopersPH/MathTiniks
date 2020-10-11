package mathtinik.thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;

public class matching extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    Button b1,b2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matching_template);

        /*b1 = findViewById(R.id.b_one);

        radioGroup = findViewById(R.id.radiogroup);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioId = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioId);

                Toast.makeText(matching.this, "Select"+radioButton.getText().toString(), Toast.LENGTH_SHORT).show();

                if (radioButton.getText().toString().equals(b1.getText().toString())){
                    radioButton.setVisibility(View.GONE);
                    b1.setVisibility(View.GONE);
                }else{
                    radioButton.setVisibility(View.VISIBLE);
                    b1.setVisibility(View.VISIBLE );
                }
            }
        });*/
    }

/*
    public void checkButton(View v){
        int radioId = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(radioId);

        Toast.makeText(matching.this, "Select"+radioButton.getText().toString(), Toast.LENGTH_SHORT).show();
    }*/
}