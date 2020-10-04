package mathtinik.thesis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class level31 extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    level31Adapter levelAdapter;
    ImageView backtoChoose;
    TextView coinCount,selectOperation;

    String[] level31_60 = {
            "31","32","33","34","35",
            "36","37","38","39","40",
            "41","42","43","44","45",
            "56","57","58","59","60",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.level31);





        recyclerView = findViewById(R.id.recyclerView);
        coinCount = findViewById(R.id.coinCount);
        selectOperation = findViewById(R.id.selectOperation);
        layoutManager=new GridLayoutManager(this,5);
        recyclerView.setLayoutManager(layoutManager);
                levelAdapter=new level31Adapter(level31_60, level31.this);
                recyclerView.setAdapter(levelAdapter);
                levelAdapter.notifyDataSetChanged();

        recyclerView.setHasFixedSize(true);
        selectOperation.setText(MainActivity.prefs.getString("operation",null));
        coinCount.setText(String.valueOf(MainActivity.prefs.getInt("Coins",0)));
        backtoChoose = findViewById(R.id.backtoChooseLevel);

        backtoChoose.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),level_choice.class);
                startActivity(intent);
                finish();
            }
        });

    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode== KeyEvent.KEYCODE_BACK)
            Toast.makeText(getApplicationContext(), "back press",
                    Toast.LENGTH_LONG).show();

        return false;
        // Disable back button..............
    }




















}