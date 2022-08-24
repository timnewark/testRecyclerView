package com.example.testrecyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

class recyclerViewAdapter extends RecyclerView.Adapter<recyclerViewAdapter.MyViewHolder>{
    private final RecyclerViewInterface recyclerViewInterface;
    Context context;
    ArrayList<bridgeModel> bridgeModels;

    public recyclerViewAdapter(Context context, ArrayList<bridgeModel>bridgeModels,
    RecyclerViewInterface recyclerViewInterface){
        this.context = context;
        this.bridgeModels = bridgeModels;
        this.recyclerViewInterface = recyclerViewInterface;

    }


    @NonNull
    @Override
    public recyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // This is where you inflate the layout (give a look to each of our rows)
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_row, parent, false);
        return new recyclerViewAdapter.MyViewHolder(view, recyclerViewInterface);
    }

    @Override
    public void onBindViewHolder(@NonNull recyclerViewAdapter.MyViewHolder holder, int position) {
        // assigning values to each of our rows as they come bac kon the screen
        //based on the position of the recycler view
        holder.tvName.setText(bridgeModels.get(position).getBridgePartName());
        holder.tv3Letter.setText(bridgeModels.get(position).getBridgePartAbbreviation());
        holder.tv1Letter.setText(bridgeModels.get(position).getBridgePartAbbreviationSmall());
        holder.iView.setImageResource(bridgeModels.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return bridgeModels.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        //grabbing all the views from our recycler_view_row layout file
        //works similar to the onCreate method

        ImageView iView;
        TextView tvName, tv3Letter, tv1Letter;


        public MyViewHolder(@NonNull View itemView, RecyclerViewInterface recyclerViewInterface) {
            super(itemView);

            iView = itemView.findViewById(R.id.MA2imageView);
            tvName = itemView.findViewById(R.id.MA2TV1BPname);
            tv3Letter = itemView.findViewById(R.id.MA2TV2threeLetter);
            tv1Letter = itemView.findViewById(R.id.MA2TV2oneLetter);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(recyclerViewInterface != null){
                        int pos = getAdapterPosition();
                        if (pos != RecyclerView.NO_POSITION){
                            recyclerViewInterface.onItemClick(pos);
                        }
                    }
                }
            });
        }
    }
}
