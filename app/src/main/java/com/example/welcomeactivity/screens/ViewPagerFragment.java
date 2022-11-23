package com.example.welcomeactivity.screens;

import static android.content.Context.MODE_PRIVATE;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.welcomeactivity.PageerAdapter.ViewPagerAdapter;
import com.example.welcomeactivity.R;

public class ViewPagerFragment extends Fragment {

    TextView button;
    ViewPager2 pager2;

    Handler handler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_pager, container, false);
        button  = view.findViewById(R.id.nextText);
        handler = new Handler(Looper.getMainLooper());

        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager(), getLifecycle());
        pager2 = view.findViewById(R.id.pager);
        pager2.setAdapter(adapter);





        return view;
    }

    private Runnable runnable = new Runnable() {
        @SuppressLint("SetTextI18n")
        @Override
        public void run() {
            if (pager2.getCurrentItem() == 2){
                button.setText("Finish");

            }else {
                button.setText("Next");
            }


            handler.postDelayed(runnable, 100);
        }
    };
    @Override
    public void onStart() {
        super.onStart();
        handler.postDelayed(runnable , 100);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (handler !=null){
            handler.removeCallbacks(runnable);
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (handler !=null){
            handler.removeCallbacks(runnable);
        }
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (pager2.getCurrentItem() == 0){
                    pager2.setCurrentItem(1);
                }else if (pager2.getCurrentItem() == 1){
                    pager2.setCurrentItem(2);

                }else if (pager2.getCurrentItem() == 2){
                    final NavController navController = Navigation.findNavController(view);
                    navController.navigate(R.id.action_viewPagerFragment2_to_homeFragment);

                    SavedOnBaordData(true);
                }

            }
        });


    }

    private void SavedOnBaordData (boolean key){

       SharedPreferences sharedPreferences = getContext().getSharedPreferences("onBoard", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean("Finish", key);
        editor.apply();
    }
}