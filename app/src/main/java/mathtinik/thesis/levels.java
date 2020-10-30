package mathtinik.thesis;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class levels extends AppCompatActivity {

    private RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    levelAdapter levelAdapter;
    ImageView backtoChoose;
    TextView coinCount,selectOperation;
    ImageView coins;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);
        coins =findViewById(R.id.coins);
        recyclerView = findViewById(R.id.recyclerView);
        coinCount = findViewById(R.id.coinCount);
        selectOperation = findViewById(R.id.selectOperation);
        layoutManager=new GridLayoutManager(this,5);
        recyclerView.setLayoutManager(layoutManager);
                levelAdapter=new levelAdapter(MainActivity.one_30, levels.this);
                recyclerView.setAdapter(levelAdapter);
                levelAdapter.notifyDataSetChanged();

        recyclerView.setHasFixedSize(true);
        selectOperation.setText(MainActivity.prefs.getString("operation",null));

        coinCount.setText(String.valueOf(MainActivity.prefs.getInt("Coins",0)));
        FlipAnimator(getApplicationContext(),coins);
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

    public static void FlipAnimator(Context c,ImageView coins){
        AnimatorSet flip_anim;
        flip_anim = (AnimatorSet) AnimatorInflater.loadAnimator(c,R.animator.flip_anim);
        flip_anim.setTarget(coins);
        flip_anim.start();
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