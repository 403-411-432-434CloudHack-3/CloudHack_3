package com.example.progressive.ui.welcome;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.progressive.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
//mport com.google.firebase.database.FirebaseDatabase;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class PopUpWindow extends AppCompatActivity {
    private EditText exercise;
    private EditText weight;
    private EditText reps;
    private Button submit;
   // private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_window);
        exercise = findViewById(R.id.exercise);
        weight = findViewById(R.id.weight);
        reps = findViewById(R.id.reps);
        submit = findViewById(R.id.button2);

       // FirebaseDatabase.getInstance().getReference().child("hello").push().child("a").setValue("b");


        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width  = dm.widthPixels;
        int height = dm.heightPixels;
        getWindow().setLayout((int)(width),(int)(height*0.5));
        WindowManager.LayoutParams params = getWindow().getAttributes();
        params.gravity = Gravity.CENTER;
        getWindow().setAttributes(params);

        HashMap<String , Object > map = new HashMap<>();
        map.put("Weight" , weight.getText().toString());
        map.put("Reps" , reps.getText().toString());

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(PopUpWindow.this,"hello",Toast.LENGTH_SHORT).show();
                //FirebaseDatabase.getInstance().getReference().child("workout").child(exercise.getText().toString()).updateChildren(map);
                //System.out.println("hello");
            }
        });


    }
}