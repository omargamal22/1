package com.example.gamal.backingapp.UI.MainActivity;

import android.animation.ObjectAnimator;
import android.os.AsyncTask;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ProgressBar;

import com.example.gamal.backingapp.R;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class Opening_Frag extends Fragment implements Opening_Frag_MVP_Viewer {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.opening_frag,container,false);
        new Data_Load_Task().execute(this,null);
        ProgressBar progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        ObjectAnimator animation = ObjectAnimator.ofInt(progressBar, "progress", 0, 500); // see this max value coming back here, we animate towards that value
        animation.setDuration(1200); // in milliseconds
        animation.setRepeatCount(Animation.INFINITE);
        animation.setInterpolator(new DecelerateInterpolator());
        animation.start();
        return view;
    }

    @Override
    public void OpenNextFrag() {
        Fragment fragment = new Recycle_Frag();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        this.onDestroy();
        fragmentTransaction.hide(this);
        fragmentTransaction.replace(R.id.Countainer,fragment);
        fragmentTransaction.commit();
    }
    private class Data_Load_Task extends AsyncTask<Opening_Frag_MVP_Viewer,Void, Opening_Frag_presnter> {
        @Override
        protected Opening_Frag_presnter doInBackground(Opening_Frag_MVP_Viewer... opening_frag_mvp_viewers) {
            Opening_Frag_presnter OFP = new Opening_Frag_presnter();
            OFP.onAttach(opening_frag_mvp_viewers[0]);
            OFP.load_data(getContext());
            return OFP;
        }

        @Override
        protected void onPostExecute(Opening_Frag_presnter opening_frag_presnter) {
            opening_frag_presnter.update_UI();
        }
    }
}
