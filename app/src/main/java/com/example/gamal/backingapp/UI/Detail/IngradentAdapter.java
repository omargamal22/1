package com.example.gamal.backingapp.UI.Detail;


import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gamal.backingapp.UI.Array_Adapter;

import java.util.ArrayList;

import androidx.annotation.NonNull;

/*public class IngradentAdapter extends Food_Adapter {
    public IngradentAdapter(ArrayList<String> names, RecyclerViewClickListener itemListener) {
        super(names, itemListener);
    }

    @NonNull
    @Override
    public Food_View_Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View V =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.ingradent_row,viewGroup,false);
        return new Food_View_Holder(V);
    }

    public  class Food_View_Holder extends RecyclerView.ViewHolder  {
        public TextView TX ;
        public Food_View_Holder(@NonNull View itemView) {
            super(itemView);
            TX = itemView.findViewById(R.id.Food_Name);
            itemView.setOnClickListener(this);
        }

    }
}*/
public class IngradentAdapter extends Array_Adapter{
    private int Text_view_res;

    public IngradentAdapter(ArrayList<String> names, int lay_out_res, int text_View_res) {
        super(names, lay_out_res);
        Text_view_res = text_View_res;
    }

    @NonNull
    @Override
    public My_View_Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return super.onCreateViewHolder(viewGroup, i);
    }

    @Override
    public void onBindViewHolder(@NonNull My_View_Holder my_view_holder, int i) {
        //super.onBindViewHolder(my_view_holder, i);
        TextView TV = my_view_holder.itemView.findViewById(Text_view_res);
        TV.setText(Names.get(i));
    }
}