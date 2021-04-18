package com.example.fragmentapp;

import android.annotation.TargetApi;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceControl;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.app.Fragment;

public class FirstFragment extends Fragment {

    Button btnSwitch;
    boolean dual;

    public FirstFragment(){
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_fragment, container, false);
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        dual = false;
        View details = getActivity().findViewById(R.id.details);
        if (details != null && details.getVisibility() == View.VISIBLE) {
            dual = true;
        }
    }
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);
        btnSwitch = (Button)getView().findViewById(R.id.btnSwitchOne);
        btnSwitch.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @Override
            public void onClick(View view) {
                if (dual){
                    FragmentTransaction ft = getActivity().getFragmentManager().beginTransaction();
                    SecondFragment sf = (SecondFragment)getFragmentManager().findFragmentById(R.id.details);

                    if (sf == null){
                        sf = new SecondFragment();
                        ft.replace(R.id.details, sf);
                        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                        ft.commit();
                    }
                } else {
                    Intent i = new Intent();
                    i.setClass(getActivity(), SecondActivity.class);
                    startActivity(i);

                }
            }
        });
    }
}