package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class salleDeBains extends AppCompatActivity implements View.OnClickListener {
    FirebaseDatabase database ;
    DatabaseReference myRef ;
    Button go22 , SalleDeBainsOpen ,SalleDeBainsclose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salle_de_bains);

        SalleDeBainsOpen=findViewById(R.id.SalleDeBainsOpen);
        SalleDeBainsclose=findViewById(R.id.SalleDeBainsclose);

        SalleDeBainsOpen.setOnClickListener(this);
        SalleDeBainsclose.setOnClickListener(this);

        database =  FirebaseDatabase.getInstance();
        myRef = database.getReference("SalleDeBains/window");

        go22=findViewById(R.id.acceuil22);
        go22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (salleDeBains.this, application.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slideleft,R.anim.slideoutright);

            }
        });

    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.SalleDeBainsOpen :
                myRef.setValue("on");
                break ;
            case R.id.SalleDeBainsclose :
                myRef.setValue("off");
                break ;
        }
    }
}
