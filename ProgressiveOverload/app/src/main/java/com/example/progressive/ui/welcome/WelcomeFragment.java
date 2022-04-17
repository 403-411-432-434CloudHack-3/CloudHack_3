package com.example.progressive.ui.welcome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.progressive.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class WelcomeFragment extends Fragment {

    Activity context;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {


        context = getActivity();
        View root = inflater.inflate(R.layout.fragment_welcome, container, false);



        return root;

    }

    @Override
    public void onStart() {
        super.onStart();
        FloatingActionButton btn =  context.findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent popUp = new Intent(getContext(),PopUpWindow.class);
                startActivity(popUp);
                TableLayout ll = context.findViewById(R.id.ll);
                TableRow tr;
                tr = new TableRow(context);
                ArrayList<EditText> edt = new ArrayList<EditText>(3);
                ArrayList<CardView> crd = new ArrayList<CardView>(3);
                for(int i = 0; i<3;i++){
                   // edt. = new EditText(context);
                    crd.add(new CardView(context));
                    crd.get(i).setMinimumWidth((ll.getWidth()/3));
                   // crd.get(i).setMinimumHeight(ll.getMinimumHeight()/10);
                   crd.get(i).setCardBackgroundColor(255);
                   crd.get(i).setRadius(8);
                   crd.get(i).setPadding(16,16,16,16);
                   crd.get(i).setId(i+10);
                    edt.add(new EditText(context));
                    edt.get(i).setTextSize(9);
                    edt.get(i).setHint("hello");
                    edt.get(i).setId(i);
                    crd.get(i).addView(edt.get(i));
                    crd.get(i).getChildAt(0).setForegroundGravity(Gravity.CENTER_HORIZONTAL);
                    edt.get(i).setGravity(Gravity.CENTER_HORIZONTAL);

                    tr.addView(crd.get(i));

                }
                ll.addView(tr);
                //ll.addView(edt);
                /*LayoutInflater inflater = LayoutInflater.from(context);
                inflater.inflate(R.layout.fragment_view , ll , false);*/
            }


        });


    }


}
