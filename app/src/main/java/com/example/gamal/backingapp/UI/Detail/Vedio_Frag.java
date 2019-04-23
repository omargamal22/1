package com.example.gamal.backingapp.UI.Detail;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.example.gamal.backingapp.R;
import com.example.gamal.backingapp.UI.Events;
import com.example.gamal.backingapp.UI.GlobalBus;

import org.greenrobot.eventbus.Subscribe;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Vedio_Frag extends Fragment implements Vedio_Frag_MVP_Viewer {

    private Button btnonce, btncontinuously, btnstop, btnplay ,next , last ;
    private VideoView vv;
    private MediaController mediacontroller;
    private Uri guri;
    private boolean isContinuously = false;
    private ProgressBar progressBar;
    private static int ID1 = 0;
    private static int ID2 = 0;
    private Vedio_Frag_Presenter VFP;
    private TextView TX ;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vedio_frag,container,false);

        GlobalBus.getBus().register(this);

        progressBar = (ProgressBar) view.findViewById(R.id.progrss);
        vv = (VideoView) view.findViewById(R.id.vv);
        TX=view.findViewById(R.id.DESC);
        next=view.findViewById(R.id.nextStep);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID2+=1;
                VFP.Get_Step(ID1,ID2);
                VFP.Get_Description(ID1,ID2);
            }
        });
        last=view.findViewById(R.id.lastStep);
        last.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ID2-=1;
                VFP.Get_Step(ID1,ID2);
                VFP.Get_Description(ID1,ID2);
            }
        });
        VFP=new Vedio_Frag_Presenter();
        VFP.onAttach(this);
        VFP.Get_Step(ID1,ID2);
        VFP.Get_Description(ID1,ID2);

        return view;
    }



    @Subscribe(sticky = true)
    public void getMessage(Events.FragmentFragmentMessage activityFragmentMessage) {
        //Write code to perform action after event is received
        ID1=Integer.valueOf(activityFragmentMessage.getMessage1());
        ID2=Integer.valueOf(activityFragmentMessage.getMessade2());


    }
    @Override
    public void onDestroyView() {
        // Unregister the registered event.
        GlobalBus.getBus().unregister(this);
        super.onDestroyView();

    }

    @Override
    public void play_Step(String uri) {
        mediacontroller = new MediaController(getContext());
        mediacontroller.setAnchorView(vv);
        String uriPath = uri; //update package name
        guri = Uri.parse(uriPath);
        progressBar.setVisibility(View.VISIBLE);
        vv.setMediaController(mediacontroller);
        vv.setVideoURI(guri);
        vv.requestFocus();
        vv.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            // Close the progress bar and play the video
            public void onPrepared(MediaPlayer mp) {
                progressBar.setVisibility(View.GONE);
            }
        });
        vv.start();
    }

    @Override
    public void Show_Description(String desc) {
        TX.setText(desc);
    }

    @Override
    public void Show_Toast() {
        Toast.makeText(getContext(), "This is the last Step", Toast.LENGTH_SHORT).show();
    }
}
