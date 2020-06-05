package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Acceuil extends AppCompatActivity {
      Button page1;
      Button goPageApp;
      Button goSmartHouse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        page1=findViewById(R.id.goAcceuil1);




       page1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
              Intent intent = new Intent(Acceuil.this, MainActivity.class);
               startActivity(intent);
               overridePendingTransition(R.anim.slideleft,R.anim.slideoutright);



           }
       });

        goPageApp=findViewById(R.id.ButtonStartApp);
        goPageApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Acceuil.this, application.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideright,R.anim.slidedoutleft);


            }
        });


         goSmartHouse=findViewById(R.id.SmartHouseNews);
         goSmartHouse.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                        Intent intent=new Intent(Acceuil.this, SmartHouse.class);
                        startActivity(intent);
                 overridePendingTransition(R.anim.slideright,R.anim.slidedoutleft);

             }
         });


    }
}
