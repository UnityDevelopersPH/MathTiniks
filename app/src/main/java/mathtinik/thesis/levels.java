package mathtinik.thesis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class levels extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    levelAdapter levelAdapter;

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

    }




















}