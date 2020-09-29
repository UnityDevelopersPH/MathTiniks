package mathtinik.thesis;

import android.content.Context;
import android.content.Intent;
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

            Intent intent = new Intent(context,challenge_template.class);
            context.startActivity(intent);

        }
    }






}
