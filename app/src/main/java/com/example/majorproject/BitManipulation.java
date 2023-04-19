package com.example.majorproject;

import android.animation.LayoutTransition;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class BitManipulation extends AppCompatActivity {
    LinearLayout layout1,layout2,layout3;
    TextView code1,code2,code3;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bit_manipulation);

        //for 1st card view
        layout1=(LinearLayout) findViewById(R.id.layout_bit_manipulation_q1);
        layout1.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        code1=(TextView) findViewById(R.id.code_bit_manipulation_q1);

        //for 2nd card view
        layout2=(LinearLayout) findViewById(R.id.layout_bit_manipulation_q2);
        layout2.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        code2=(TextView) findViewById(R.id.code_bit_manipulation_q2);

        //for 3rd card view
        layout3=(LinearLayout) findViewById(R.id.layout_bit_manipulation_q3);
        layout3.getLayoutTransition().enableTransitionType(LayoutTransition.CHANGING);
        code3=(TextView) findViewById(R.id.code_bit_manipulation_q3);
    }

    public void expand_bit_manipulation_q1(View v){
        int v1=(code1.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;
        TransitionManager.beginDelayedTransition(layout1,new AutoTransition());
        code1.setVisibility(v1);
    }

    //expanding code for 2nd card view
    public void expand_bit_manipulation_q2(View v){
        int v2=(code2.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;
        TransitionManager.beginDelayedTransition(layout2,new AutoTransition());
        code2.setVisibility(v2);
    }

    //expanding code for 3rd card view
    public void expand_bit_manipulation_q3(View v){
        int v3=(code3.getVisibility()==View.GONE)?View.VISIBLE:View.GONE;
        TransitionManager.beginDelayedTransition(layout3,new AutoTransition());
        code3.setVisibility(v3);
    }
}
