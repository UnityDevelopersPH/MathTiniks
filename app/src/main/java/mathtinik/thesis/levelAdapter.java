package mathtinik.thesis;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class levelAdapter extends RecyclerView.Adapter<levelAdapter.LevelHolder> {

    Context context;
    String[] arr;

    public levelAdapter(String[] arr,Context context) {
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

        holder.num_level.setText(arr[position]);
        String getNumLevel = holder.num_level.getText().toString();
        for (int i = 0; i<Integer.parseInt(getNumLevel);i++){
            if (MainActivity.prefs.getString("operation",null) == "Addition"){
                if (i == MainActivity.prefs.getInt("addLevel",1)){
                    holder.num_level.setText("");
                }
            }else
            if (MainActivity.prefs.getString("operation",null) == "Subraction"){
                if (i == MainActivity.prefs.getInt("subLevel",1)){
                    holder.num_level.setText("");
                }
            }else
            if (MainActivity.prefs.getString("operation",null) == "Multiplication"){
                if (i == MainActivity.prefs.getInt("mulLevel",1)){
                    holder.num_level.setText("");
                }
            }else
            if (MainActivity.prefs.getString("operation",null) == "Division"){
                if (i == MainActivity.prefs.getInt("diviLevel",1)){
                    holder.num_level.setText("");
                }
            }
        }

    }

    @Override
    public int getItemCount() {
        return arr.length;
    }

    public class LevelHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        TextView num_level;
        Context context;
        String[] arr;

        public LevelHolder(@NonNull View itemView, Context context,String[] arr) {
            super(itemView);
            num_level=itemView.findViewById(R.id.level_num);
            itemView.setOnClickListener(this);
            this.context = context;
            this.arr = arr;

        }

        @Override
        public void onClick(View v) {

            if (!num_level.getText().toString().equals("")){
                Intent intent = new Intent(context,challenge_template.class);
                context.startActivity(intent);
            }else{
                Log.d("results","Please Unlock");
            }

        }
    }






}
