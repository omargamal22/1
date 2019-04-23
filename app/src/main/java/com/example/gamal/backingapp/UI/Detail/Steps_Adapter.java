package com.example.gamal.backingapp.UI.Detail;


import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gamal.backingapp.UI.Array_Adapter;
import com.example.gamal.backingapp.UI.RecyclerViewClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;

public class Steps_Adapter extends Array_Adapter {
    private int Text_view_res;
    private RecyclerViewClickListener itemListener;

    public Steps_Adapter(ArrayList<String> names, int lay_out_res , int text_View_res, RecyclerViewClickListener itemListener) {
        super(names, lay_out_res);
        Text_view_res = text_View_res;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public My_View_Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final My_View_Holder MH = super.onCreateViewHolder(viewGroup, i);
        MH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemListener.onItemClick(v, MH.getAdapterPosition());
            }
        });
        return MH;
    }

    @Override
    public void onBindViewHolder(@NonNull My_View_Holder my_view_holder, int i) {
        //super.onBindViewHolder(my_view_holder, i);
        TextView TV = my_view_holder.itemView.findViewById(Text_view_res);
        TV.setText(Names.get(i));
    }
}
