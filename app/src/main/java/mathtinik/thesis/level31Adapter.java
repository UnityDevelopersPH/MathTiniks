package mathtinik.thesis;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class level31Adapter extends RecyclerView.Adapter<level31Adapter.LevelHolder> {

    Context context;
    ArrayList<String> arr;

    public level31Adapter(ArrayList<String> arr,Context context) {
        this.arr = arr;
        this.context = context;
    }

    @NonNull
    @Override
    public LevelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.body_level,parent,false);
        LevelHolder levelHolder = new LevelHolder(view,context,arr);


        return levelHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull LevelHolder holder, int position) {

        holder.num_level.setText(arr.get(position));
        String getNumLevel = holder.num_level.getText().toString();
        for (int i = 0; i<Integer.parseInt(getNumLevel);i++){
            if (MainActivity.prefs.getString("MLevelSelected",null).equals("Easy")) {
                if (MainActivity.prefs.getString("operation", null) == "Addition") {
                    if (i == MainActivity.prefs.getInt("31addLevel", 31)) {
                        holder.num_level.setText("");
                    }
                } else if (MainActivity.prefs.getString("operation", null) == "Subraction") {
                    if (i == MainActivity.prefs.getInt("31subLevel", 31)) {
                        holder.num_level.setText("");
                    }
                } else if (MainActivity.prefs.getString("operation", null) == "Multiplication") {
                    if (i == MainActivity.prefs.getInt("31mulLevel", 31)) {
                        holder.num_level.setText("");
                    }
                } else if (MainActivity.prefs.getString("operation", null) == "Division") {
                    if (i == MainActivity.prefs.getInt("31diviLevel", 31)) {
                        holder.num_level.setText("");
                    }
                }
            }else if(MainActivity.prefs.getString("MLevelSelected",null).equals("Medium")) {
                if (MainActivity.prefs.getString("operation", null) == "Addition") {
                    if (i == MainActivity.prefs.getInt("M31addLevel", 31)) {
                        holder.num_level.setText("");
                    }
                } else if (MainActivity.prefs.getString("operation", null) == "Subraction") {
                    if (i == MainActivity.prefs.getInt("M31subLevel", 31)) {
                        holder.num_level.setText("");
                    }
                } else if (MainActivity.prefs.getString("operation", null) == "Multiplication") {
                    if (i == MainActivity.prefs.getInt("M31mulLevel", 31)) {
                        holder.num_level.setText("");
                    }
                } else if (MainActivity.prefs.getString("operation", null) == "Division") {
                    if (i == MainActivity.prefs.getInt("M31diviLevel", 31)) {
                        holder.num_level.setText("");
                    }
                }
            }else if(MainActivity.prefs.getString("MLevelSelected",null).equals("Hard")) {
                if (MainActivity.prefs.getString("operation", null) == "Addition") {
                    if (i == MainActivity.prefs.getInt("H31addLevel", 31)) {
                        holder.num_level.setText("");
                    }
                } else if (MainActivity.prefs.getString("operation", null) == "Subraction") {
                    if (i == MainActivity.prefs.getInt("H31subLevel", 31)) {
                        holder.num_level.setText("");
                    }
                } else if (MainActivity.prefs.getString("operation", null) == "Multiplication") {
                    if (i == MainActivity.prefs.getInt("H31mulLevel", 31)) {
                        holder.num_level.setText("");
                    }
                } else if (MainActivity.prefs.getString("operation", null) == "Division") {
                    if (i == MainActivity.prefs.getInt("H31diviLevel", 31)) {
                        holder.num_level.setText("");
                    }
                }
            }
        }

    }

    @Override
    public int getItemCount() {
        if (arr == null)
            return 0;
        else
            return  arr.size();
    }

    public class LevelHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView num_level;
        Context context;
        ArrayList<String> arr;

        public LevelHolder(@NonNull View itemView, Context context, ArrayList<String>  arr) {
            super(itemView);
            num_level=itemView.findViewById(R.id.level_num);
            itemView.setOnClickListener(this);
            this.context = context;
            this.arr = arr;

        }

        @Override
        public void onClick(View v) {

            if (!num_level.getText().toString().equals("")){
                if (MainActivity.prefs.getString("MLevelSelected",null).equals("Easy")) {
                    Intent intent = new Intent(context, chall31_template.class);
                    context.startActivity(intent);
                    ((Activity)context).finish();
                }else if(MainActivity.prefs.getString("MLevelSelected",null).equals("Medium")) {
                    Intent intent = new Intent(context, matching.class);
                    context.startActivity(intent);
                    ((Activity)context).finish();
                }else if(MainActivity.prefs.getString("MLevelSelected",null).equals("Hard")) {
                    Intent intent = new Intent(context, hard_matching.class);
                    context.startActivity(intent);
                    ((Activity)context).finish();
                }
                MainActivity.editor.putInt("getLevelSelected",Integer.parseInt(num_level.getText().toString()));
                MainActivity.editor.commit();
            }else{
                Log.d("results","Please Unlock");
            }

        }
    }






}
