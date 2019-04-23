package com.example.gamal.backingapp.UI.Detail;



public interface Detail_Frag_MVP_Presenter <V extends Detail_Frag_MVP_Viewer>  {

    void onAttach(V mvpView) ;
    void GET_Ingradiants(int ID);
    void GET_STEPS(int ID);
    void Open_Steps(int ID);
    void save(int id);
    void Befor_save();
    void saved();
    void Is_Saved(int id);
    void delete_meal(int id);
    void get_back();
}
