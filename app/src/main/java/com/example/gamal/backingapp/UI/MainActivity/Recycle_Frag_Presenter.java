package com.example.gamal.backingapp.UI.MainActivity;

import com.example.gamal.backingapp.Model.DataManager;

import java.util.ArrayList;

public class Recycle_Frag_Presenter implements Recycle_Frag_MVP_Presnter {
    private  Recycle_Frag_MVP_Viewer mMvpView;
    private DataManager Mdatamanager;

    public Recycle_Frag_Presenter(){
        Mdatamanager=new DataManager();
    }

    @Override
    public void onAttach(Recycle_Frag_MVP_Viewer mvpView) {
        mMvpView = mvpView;
    }

    @Override
    public void Update_View() {
        ArrayList<String>a=Mdatamanager.GetNames();
        mMvpView.ShowDate(a);
    }

    @Override
    public void Open_Details(int ID) {
        mMvpView.Open_Detail_frag(ID);
    }

    @Override
    public void check_con(int id) {
        if(!Mdatamanager.check_connection()){
            mMvpView.Remov_Item(id);
        }
    }
}
