package com.example.gamal.backingapp.UI.Detail;

import java.util.ArrayList;

public interface Detail_Frag_MVP_Viewer {
    void Show_Gradiants(ArrayList<String> Ingredients );
    void Show_Steps(ArrayList<String> Steps);
    void Open_Steps_frag(int id);
    void set_prog();
    void clear_prog();
    void set_saved();
    void get_back();
}
