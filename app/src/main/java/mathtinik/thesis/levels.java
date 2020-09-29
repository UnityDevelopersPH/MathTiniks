package mathtinik.thesis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class levels extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    levelAdapter levelAdapter;
    ImageView backtoChoose;
    TextView coinCount,selectOperation;

    String[] level1_30 = {
            "1","2","3","4","5",
            "6","7","8","9","10",
            "11","12","13","14","15",
            "16","17","18","19","20",
            "21","22","23","24","25",
            "26","27","28","29","30"
    };
    String[] level31_60 = {
            "31","32","33","34","35","36",
            "37","38","39","40","41","42",
            "43","44","45","46","47","48",
            "49","50","51","52","53","54","55","56","57","58"
            ,"59","60"
    };
    String[] level61_90 = {
            "61","62","63","64","65","66","67","68"
            ,"69","70","71","72","73","74","75","76"
            ,"77","78","79","80","81","82","83"
            ,"84","85","86","87","88","89"
            ,"90"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        recyclerView = findViewById(R.id.recyclerView);
        coinCount = findViewById(R.id.coinCount);
        selectOperation = findViewById(R.id.selectOperation);
        layoutManager=new GridLayoutManager(this,5);
        recyclerView.setLayoutManager(layoutManager);

        levelAdapter=new levelAdapter(level1_30, levels.this);
        recyclerView.setAdapter(levelAdapter);

        recyclerView.setHasFixedSize(true);

        selectOperation.setText(MainActivity.prefs.getString("operation",null));

        coinCount.setText(String.valueOf(MainActivity.prefs.getInt("Coins",0)));

        backtoChoose = findViewById(R.id.backtoChooseLevel);

        backtoChoose.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){

            }
        });

    }




















}