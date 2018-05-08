package com.nimsdev.firebaseprimer;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends Activity {

    TextView displayTextView;
    Button greenButton, blueButton;
    Firebase firebaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
         super.onStart();

        displayTextView = (TextView) findViewById(R.id.displayTextView);
        greenButton = (Button) findViewById(R.id.greenButton);
        blueButton = (Button) findViewById(R.id.blueButton);

        firebaseReference = new Firebase("https://fir-primer-68e5e.firebaseio.com/data/type");
        firebaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue(String.class);
                displayTextView.setText(text);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    public void setGreen(View view) {
        firebaseReference.setValue("Emerald");
        displayTextView.setBackgroundResource(R.color.colorGreen);
    }

    public void setBlue(View view) {
        firebaseReference.setValue("Saffire");
        displayTextView.setBackgroundResource(R.color.colorBlue);
    }

}
