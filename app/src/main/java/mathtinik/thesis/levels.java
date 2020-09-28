package mathtinik.thesis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class levels extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    levelAdapter levelAdapter;
    ImageView backtoChoose;

    String[] arr = {
            "1","2","3","4","5",
            "6","7","8","9","10",
            "11","12","13","14","15",
            "16","17","18","19","20",
            "21","22","23","24","25",
            "26","27","28","29","30"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager=new GridLayoutManager(this,5);
        recyclerView.setLayoutManager(layoutManager);
        levelAdapter=new levelAdapter(arr);
        recyclerView.setAdapter(levelAdapter);
        recyclerView.setHasFixedSize(true);

        backtoChoose = findViewById(R.id.backtoChooseLevel);

        backtoChoose.setOnClickListener(new View.OnClickListener(){
            @Override
                    public void onClick(View v){
                Intent b = new Intent(getApplicationContext(), challenge_template.class);
                startActivity(b);
                finishActivity(1);
            }
        });

    }




















}