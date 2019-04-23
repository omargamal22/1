package com.example.gamal.backingapp.UI.MainActivity;

public interface Recycle_Frag_MVP_Presnter <V extends Recycle_Frag_MVP_Viewer> {
    void onAttach(V mvpView) ;
    void Update_View();
    void Open_Details(int ID);
    void check_con(int id);
}
