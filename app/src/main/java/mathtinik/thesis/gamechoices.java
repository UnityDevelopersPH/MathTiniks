package mathtinik.thesis;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class gamechoices extends AppCompatActivity {

    ImageView add, subtracts, multiply, divides;
    TextView choicex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gamechoices);

        add = findViewById(R.id.addition);
        subtracts = findViewById(R.id.subtraction);
        multiply = findViewById(R.id.multiplication);
        divides = findViewById(R.id.division);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choicex.setText("Addition");
            }
        });

        subtracts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choicex.setText("Subtraction");
            }
        });

        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choicex.setText("Multiplication");
            }
        });

        divides.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choicex.setText("Division");
            }
        });

    }
}

