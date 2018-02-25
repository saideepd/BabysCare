package com.android.babyscare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EmergencyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
    }

    /**
     * firstAidClick method will intent to
     * FirstAid Activity
     */
    public void firstAidClick(View view) {
        Intent intent = new Intent(this, FirstAidActivity.class);
        startActivity(intent);
    }

    /**
     * mapClick method will intent to
     * Map Activity
     */
    public void mapClick(View view) {
        Intent intent = new Intent(this, MapsActivity.class);
        startActivity(intent);
    }
}
