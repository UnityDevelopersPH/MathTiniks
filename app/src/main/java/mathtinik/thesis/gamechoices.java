package mathtinik.thesis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class gamechoices extends AppCompatActivity {

    ImageView add, subtracts, multiply, divides, backButton;
    TextView choicex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamechoices);

        add = findViewById(R.id.addition);
        subtracts = findViewById(R.id.subtraction);
        multiply = findViewById(R.id.multiplication);
        divides = findViewById(R.id.division);
        backButton = findViewById(R.id.backHome);
        choicex = findViewById(R.id.choicex);
        mathematicsGroupBtn();

    }

    public void mathematicsGroupBtn(){
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getchoiceX("Addition");
            }
        });
        subtracts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getchoiceX("Subraction");
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getchoiceX("Multiplication");
            }
        });
        divides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getchoiceX("Division");
            }
        });
    }


    public void getchoiceX(String mathematics){
        choicex.setText("");
        choicex.setText(mathematics);
    }

}

