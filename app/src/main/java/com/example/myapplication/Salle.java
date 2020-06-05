package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Salle extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase database ;
    TextView res ;
    DatabaseReference myRefled , myReffireplace , myrefRes , myrefTest , myrefwindow ;
    Button go26 , salleLedOn ,salleLedOff , fireplaceOn , fireplaceOff,windowOn ,windowOff ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salle);

        salleLedOn=findViewById(R.id.salleLedOn);
        salleLedOff=findViewById(R.id.salleLedOff);
        fireplaceOn=findViewById(R.id.fireplaceOn);
        fireplaceOff=findViewById(R.id.fireplaceOff);
        windowOn=findViewById(R.id.windowOn);
        windowOff=findViewById(R.id.windowOff);
        res = findViewById(R.id.res) ;

        salleLedOn.setOnClickListener(this);
        salleLedOff.setOnClickListener(this);
        fireplaceOn.setOnClickListener(this);
        fireplaceOff.setOnClickListener(this);
        windowOn.setOnClickListener(this);
        windowOff.setOnClickListener(this);

        database =  FirebaseDatabase.getInstance();
        myRefled = database.getReference("Salle/Led");
        myReffireplace = database.getReference("Salle/fireplace");
        myrefRes = database.getReference("Salle/flame");
        myrefwindow = database.getReference("Salle/window");

        myrefTest = database.getReference("Salle/7riga") ;
        myrefTest.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                res.setText(dataSnapshot.getValue(String.class)) ;
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        }) ;
        myrefRes.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                res.setText(value);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
         go26=findViewById(R.id.acceuil26);
         go26.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent =new Intent (Salle.this, application.class );
                 startActivity(intent);
                 overridePendingTransition(R.anim.slideleft,R.anim.slideoutright);


             }
         });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.salleLedOn :
                myRefled.setValue("on");
                break ;
            case R.id.salleLedOff :
                myRefled.setValue("off");
                break ;
            case R.id.fireplaceOn :
                myReffireplace.setValue("on");
                break ;
            case R.id.fireplaceOff :
                myReffireplace.setValue("off");
                break ;
            case R.id.windowOn :
                myrefwindow.setValue("on");
                break ;
            case R.id.windowOff :
                myrefwindow.setValue("off");
                break ;
        }

    }
}
