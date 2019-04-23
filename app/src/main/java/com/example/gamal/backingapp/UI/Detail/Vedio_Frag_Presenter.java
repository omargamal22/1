package com.example.gamal.backingapp.UI.Detail;

import com.example.gamal.backingapp.Model.DataManager;

public class Vedio_Frag_Presenter implements Vedio_Frag_MVP_Presenter {

    private  Vedio_Frag_MVP_Viewer mMvpView;
    private DataManager Mdatamanager;

    @Override
    public void onAttach(Vedio_Frag_MVP_Viewer mvpView) {
        mMvpView = mvpView;
        Mdatamanager=new DataManager();
    }

    @Override
    public void Get_Step(int id1, int id2) {
        String uri = Mdatamanager.get_uri(id1,id2);
        if(uri!=null) {
            mMvpView.play_Step(uri);
            return ;
        }

    }

    @Override
    public void Get_Description(int id1, int id2) {
        String desc = Mdatamanager.get_Desc(id1,id2);
        if(desc!=null) {
            mMvpView.Show_Description(desc);
            return;
        }
        mMvpView.Show_Toast();
    }

    @Override
    public void save(int id) {
        Mdatamanager.SaveOffline(id);
    }

}
