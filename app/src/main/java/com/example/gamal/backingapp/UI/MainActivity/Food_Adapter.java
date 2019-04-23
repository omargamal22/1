package com.example.gamal.backingapp.UI.MainActivity;


import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gamal.backingapp.R;
import com.example.gamal.backingapp.UI.Array_Adapter;
import com.example.gamal.backingapp.UI.RecyclerViewClickListener;

import java.util.ArrayList;

import androidx.annotation.NonNull;

/*public class Food_Adapter extends RecyclerView.Adapter<Food_Adapter.Food_View_Holder> {
    private ArrayList<String >Names;
    private RecyclerViewClickListener itemListener;

    public Food_Adapter(ArrayList<String> names , RecyclerViewClickListener itemListener) {
        Names = names;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public Food_View_Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View V =  LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.food_row,viewGroup,false);
        return new Food_View_Holder(V);
    }

    @Override
    public void onBindViewHolder(@NonNull Food_View_Holder food_view_holder, int i) {
        food_view_holder.TX.setText(Names.get(i));
    }

    @Override
    public int getItemCount() {
        return Names.size();
    }

    public  class Food_View_Holder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView TX ;
        public Food_View_Holder(@NonNull View itemView) {
            super(itemView);
            TX = itemView.findViewById(R.id.Food_Name);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            itemListener.recyclerViewListClicked(v, this.getPosition());
        }
    }

}*/
public class Food_Adapter extends Array_Adapter {
    private int Img_res;
    private int Text_view_res;
    private RecyclerViewClickListener itemListener;
    public void Remov_Item (int pos){
        Names.remove(pos);
    }
    private Food_Adapter(ArrayList<String> names, int lay_out_res, int text_View_res) {
        super(names, lay_out_res);
    }

    public Food_Adapter(ArrayList<String> names, int lay_out_res, int img_res, int text_view_res, RecyclerViewClickListener itemListener) {
        super(names, lay_out_res);
        Img_res = img_res;
        Text_view_res = text_view_res;
        this.itemListener = itemListener;
    }

    @NonNull
    @Override
    public Food_View_Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
         My_View_Holder MVH = super.onCreateViewHolder(viewGroup, i);
        return new Food_View_Holder(MVH.itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull My_View_Holder food_view_holder, int i) {
        //super.onBindViewHolder(food_view_holder, i);
        TextView TV =food_view_holder.itemView.findViewById(Text_view_res);
        TV.setText(Names.get(i));
        ImageView IV = food_view_holder.itemView.findViewById(Img_res);
        IV.setImageResource(R.mipmap.loaf5);
    }

    public  class Food_View_Holder extends My_View_Holder implements View.OnClickListener {

        public Food_View_Holder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
        }
        @Override
        public void onClick(View v) {
            itemListener.onItemClick(v, this.getPosition());
        }
    }
}