package com.example.gamal.backingapp.UI.Detail;

public interface Vedio_Frag_MVP_Presenter<V extends Vedio_Frag_MVP_Viewer> {
    void onAttach(V mvpView) ;
    void Get_Step(int id1 , int id2);
    void Get_Description(int id1 , int id2);
    void save(int id);
}
