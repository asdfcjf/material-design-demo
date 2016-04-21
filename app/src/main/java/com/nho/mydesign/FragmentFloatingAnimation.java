package com.nho.mydesign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

/**
 * Created by nho on 3/7/2016.
 */
public class FragmentFloatingAnimation extends Fragment{
    FloatingActionButton fab1;
    FloatingActionButton fab2;
    FloatingActionButton fab3;
    Animation fab_open,fap_close,rotate_back,rotate_forwad;
    boolean isFabOpen = false;
    TextView textView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.floating_action_animations,container,false);
        fab1 = (FloatingActionButton) view.findViewById(R.id.fab1);
        fab2 = (FloatingActionButton) view.findViewById(R.id.fab2);
        fab3 = (FloatingActionButton) view.findViewById(R.id.fab3);
        textView = (TextView) view.findViewById(R.id.textView2);

        fab_open = AnimationUtils.loadAnimation(getContext(),R.anim.fab_open);
        fap_close = AnimationUtils.loadAnimation(getContext(),R.anim.fab_close);
        rotate_back = AnimationUtils.loadAnimation(getContext(),R.anim.rotate_back);
        rotate_forwad = AnimationUtils.loadAnimation(getContext(),R.anim.rotate_forward);

        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate();
            }
        });
        fab2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Back !");
            }
        });
        fab3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView.setText("Đã check !");
            }
        });

        return view;
    }
    private void animate()
    {
        if(isFabOpen)
        {
            fab1.startAnimation(rotate_back);
            fab2.startAnimation(fap_close);
            fab3.startAnimation(fap_close);
            fab2.setClickable(false);
            fab3.setClickable(false);
            isFabOpen = false;
        }
        else
        {
            fab1.startAnimation(rotate_forwad);
            fab2.startAnimation(fab_open);
            fab3.startAnimation(fab_open);
            fab2.setClickable(true);
            fab3.setClickable(true);
            isFabOpen = true;
        }
    }
}
