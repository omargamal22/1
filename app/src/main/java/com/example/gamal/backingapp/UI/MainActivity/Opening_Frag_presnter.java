package com.example.gamal.backingapp.UI.MainActivity;

import android.content.Context;

import com.example.gamal.backingapp.Model.DataManager;

public class Opening_Frag_presnter implements Opening_Frag_MVP_Presnter {
    private DataManager Mdatamanager;
    private  Opening_Frag_MVP_Viewer mMvpView;
    public Opening_Frag_presnter(){
        Mdatamanager=new DataManager();
    }

    @Override
    public void load_data(Context con) {
        try {
            Mdatamanager.Load_Data(con);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onAttach(Opening_Frag_MVP_Viewer mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void update_UI() {
        mMvpView.OpenNextFrag();
    }
}
