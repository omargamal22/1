package com.example.gamal.backingapp.UI.MainActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gamal.backingapp.R;
import com.example.gamal.backingapp.UI.Detail.Detail_Actvity;
import com.example.gamal.backingapp.UI.Events;
import com.example.gamal.backingapp.UI.GlobalBus;
import com.example.gamal.backingapp.UI.RecyclerViewClickListener;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Recycle_Frag extends Fragment implements Recycle_Frag_MVP_Viewer  {
    View view;
    RecyclerView RCV;
    RecyclerView.LayoutManager LM;
    Food_Adapter FD;
    RecyclerViewClickListener RVCL;
    Recycle_Frag_Presenter RFP;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recycle_frag,container,false);
        RCV = view.findViewById(R.id.food_list);
        LM=new LinearLayoutManager(getContext());
        RCV.setLayoutManager(LM);
        GlobalBus.getBus().register(this);

        RFP=new Recycle_Frag_Presenter();
        RFP.onAttach(this);
        RVCL = new RecyclerViewClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                RFP.Open_Details(position);
            }
        };


        RFP.Update_View();
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getContext(),
                LinearLayoutManager.VERTICAL);
        RCV.addItemDecoration(dividerItemDecoration);
        return view;
    }


    @Override
    public void ShowDate(ArrayList<String> Arr) {
        FD=new Food_Adapter(Arr,R.layout.food_row,R.id.food_img,R.id.Food_Name,RVCL);
        RCV.setAdapter(FD);
    }

    @Override
    public void Open_Detail_frag(int ID) {
        //GlobalBus.getBus().register(Detail_Frag.class);
        GlobalBus.getBus().postSticky(new Events.ActivityActivityMessage(ID));
        Intent i = new Intent(getActivity(),Detail_Actvity.class);
        startActivity(i);
    }

    @Override
    public void Remov_Item(int pos) {
        FD.Remov_Item(pos);
        FD.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        // Unregister the registered event.
        GlobalBus.getBus().unregister(this);
        super.onDestroyView();

    }
    @Subscribe()
    public void getMessage(Events.FragmentNotifyMessage activityFragmentMessage) {
        //Write code to perform action after event is received
        RFP.check_con(activityFragmentMessage.getNot());
    }
}
