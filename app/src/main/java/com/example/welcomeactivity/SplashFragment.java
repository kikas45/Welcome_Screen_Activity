package com.example.welcomeactivity;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class SplashFragment extends Fragment {


    Handler handler;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_splash, container, false);

        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final NavController navController = Navigation.findNavController(view);

        handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {

                if (onBoardFinished()){
                    navController.navigate(R.id.action_splashFragment2_to_homeFragment);
                }else {
                    navController.navigate(R.id.action_splashFragment2_to_viewPagerFragment2);
                }
            }
        }, 3000);




    }

    private boolean  onBoardFinished(){
        SharedPreferences sharedPreferences = getContext().getSharedPreferences("onBoard", MODE_PRIVATE);
        return sharedPreferences.getBoolean("Finish", false);
    }



}