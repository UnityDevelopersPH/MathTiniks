package mathtinik.thesis;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class levelAdapter extends RecyclerView.Adapter<levelAdapter.LevelHolder> {

    String[] arr;

    public levelAdapter(String[] arr) {
        this.arr = arr;
    }

    @NonNull
    @Override
    public LevelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.body_level,parent,false);
        LevelHolder levelHolder = new LevelHolder(view);


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

    public class LevelHolder extends RecyclerView.ViewHolder{

        TextView num_level;

        public LevelHolder(@NonNull View itemView) {
            super(itemView);
            num_level=itemView.findViewById(R.id.level_num);

        }
    }






}
