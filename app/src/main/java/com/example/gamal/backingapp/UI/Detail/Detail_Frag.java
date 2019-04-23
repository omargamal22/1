package com.example.gamal.backingapp.UI.Detail;

import android.content.ClipData;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.example.gamal.backingapp.R;
import com.example.gamal.backingapp.UI.Events;
import com.example.gamal.backingapp.UI.GlobalBus;
import com.example.gamal.backingapp.UI.MainActivity.Opening_Frag_MVP_Viewer;
import com.example.gamal.backingapp.UI.MainActivity.Opening_Frag_presnter;
import com.example.gamal.backingapp.UI.MainActivity.Recycle_Frag;
import com.example.gamal.backingapp.UI.RecyclerViewClickListener;

import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class Detail_Frag extends Fragment implements Detail_Frag_MVP_Viewer  {
    View view;
    RecyclerView RCV;
    RecyclerView RCV1;
    RecyclerView.LayoutManager LM;
    IngradentAdapter FD;
    Steps_Adapter SA;
   static int ID = 1;
    Detail_Frag_Presenter RFP;
    ProgressBar pro;
    ImageView im;
    boolean flag_saved=false;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.detail_frag,container,false);
        RCV = view.findViewById(R.id.Ingradiants);
        LM=new LinearLayoutManager(getContext());
        ((LinearLayoutManager) LM).setOrientation(LinearLayoutManager.HORIZONTAL);
        RCV.setLayoutManager(LM);
        RCV1=view.findViewById(R.id.steps);
        LM=new LinearLayoutManager(getContext());
        RCV1.setLayoutManager(LM);
        GlobalBus.getBus().register(this);

        RFP=new Detail_Frag_Presenter();
        RFP.onAttach(this);

        RFP.GET_Ingradiants(ID);
        RFP.GET_STEPS(ID);
        RFP.Is_Saved(ID);
        ((AppCompatActivity)getActivity()).getSupportActionBar().show();

        setHasOptionsMenu(true);

        pro=view.findViewById(R.id.progressBar1);
        im=view.findViewById(R.id.Img_Prog);
        return view;
    }

    @Override
    public void Show_Gradiants(ArrayList<String> Ingredients) {
        FD=new IngradentAdapter(Ingredients,R.layout.ingradent_row,R.id.Food_Ingrdent);
        RCV.setAdapter(FD);
    }

    @Override
    public void Show_Steps(ArrayList<String> Steps) {
        RecyclerViewClickListener RVCL = new RecyclerViewClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                RFP.Open_Steps(position);
            }
        };
        SA=new Steps_Adapter(Steps,R.layout.ingradent_row,R.id.Food_Ingrdent,RVCL);
        RCV1.setAdapter(SA);
    }

    @Override
    public void Open_Steps_frag(int id) {
        GlobalBus.getBus().postSticky(new Events.FragmentFragmentMessage(ID,id));
        Fragment fragment = new Vedio_Frag();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        this.onDestroy();
        fragmentTransaction.replace(R.id.countainer1,fragment)
        .addToBackStack("tag").commit();

    }

    @Override
    public void set_prog() {
        pro.setVisibility(View.VISIBLE);
        im.setVisibility(View.VISIBLE);
    }

    @Override
    public void clear_prog() {
        pro.setVisibility(View.GONE);
        im.setVisibility(View.GONE);
    }

    @Override
    public void set_saved() {
        flag_saved=true;
    }

    @Override
    public void get_back() {
        ((AppCompatActivity)getActivity()).dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_BACK));
        ((AppCompatActivity)getActivity()).dispatchKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_BACK));
    }

    @Subscribe(sticky = true)
    public void getMessage(Events.ActivityActivityMessage activityFragmentMessage) {
        //Write code to perform action after event is received
        ID=Integer.valueOf(activityFragmentMessage.getMessage());
    }
    @Override
    public void onDestroyView() {
        // Unregister the registered event.
        GlobalBus.getBus().unregister(this);
        super.onDestroyView();

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.mybutton) {
            new Data_save_offline_Task().execute(RFP,null);
            // do something
            if(flag_saved){
                item.setIcon(R.mipmap.ht32);
                GlobalBus.getBus().post(new Events.FragmentNotifyMessage(ID , flag_saved));

                RFP.get_back();
            }
            else {
                item.setIcon(R.mipmap.ht321);
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.favorite, menu);
        MenuItem item = menu.getItem(0);
        if(flag_saved){
            item.setIcon(R.mipmap.ht321);
        }
        super.onCreateOptionsMenu(menu, inflater);
    }

    private class Data_save_offline_Task extends AsyncTask< Detail_Frag_Presenter,Void,  Detail_Frag_Presenter> {

        @Override
        protected Detail_Frag_Presenter doInBackground(Detail_Frag_Presenter... detail_frag_presenters) {
            if(flag_saved){
                detail_frag_presenters[0].delete_meal(ID);
                flag_saved=false;
            }
            else {
                detail_frag_presenters[0].save(ID);
                flag_saved=true;
            }
            return detail_frag_presenters[0];
        }

        @Override
        protected void onPreExecute() {
            RFP.Befor_save();
        }

        @Override
        protected void onPostExecute(Detail_Frag_Presenter detail_frag_presenter) {
            detail_frag_presenter.saved();

        }
    }
}
