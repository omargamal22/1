package com.example.gamal.backingapp.UI.MainActivity;

import android.content.Context;

public interface Opening_Frag_MVP_Presnter <V extends Opening_Frag_MVP_Viewer>  {
    void load_data(Context con);
    void onAttach(V mvpView) ;
    void update_UI();

}
