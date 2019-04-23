package com.example.gamal.backingapp.UI.Detail;

import com.example.gamal.backingapp.Model.DataManager;

import java.util.ArrayList;

public class Detail_Frag_Presenter implements Detail_Frag_MVP_Presenter {

    private  Detail_Frag_MVP_Viewer mMvpView;
    private DataManager Mdatamanager;
    @Override
    public void onAttach(Detail_Frag_MVP_Viewer mvpView) {
        mMvpView = mvpView;
        Mdatamanager=new DataManager();
    }

    @Override
    public void GET_Ingradiants(int ID) {
        ArrayList<String> a=Mdatamanager.GetIngradiants(ID);
        mMvpView.Show_Gradiants(a);
    }

    @Override
    public void GET_STEPS(int ID) {
        ArrayList<String> a=Mdatamanager.GetSteps(ID);
        mMvpView.Show_Steps(a);
    }

    @Override
    public void Open_Steps(int ID) {
        mMvpView.Open_Steps_frag(ID);
    }

    @Override
    public void save(int id) {

        Mdatamanager.SaveOffline(id);
    }

    @Override
    public void Befor_save() {
        mMvpView.set_prog();
    }

    @Override
    public void saved() {
        mMvpView.clear_prog();
    }

    @Override
    public void Is_Saved(int id) {

        if(Mdatamanager.Saved(id)){
            mMvpView.set_saved();
        }
    }

    @Override
    public void delete_meal(int id) {
        Mdatamanager.delete_Meal_from_data_base(id);
    }

    @Override
    public void get_back() {
        if(!Mdatamanager.check_connection()){
            mMvpView.get_back();
        }
    }
}
