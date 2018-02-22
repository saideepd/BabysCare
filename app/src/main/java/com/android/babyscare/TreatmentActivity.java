package com.android.babyscare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class TreatmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treatment);
    }

    /**
     * firstMonthsClick method will intent to
     * FirstMonthsActivity Activity
     */
    public void firstMonthsClick(View view) {
        Intent intent = new Intent(this, FirstMonthsActivity.class);
        startActivity(intent);
    }

    /**
     * childhoodIllnessClick method will intent to
     * ChildhoodIllness Activity
     */
    public void childhoodIllnessClick(View view) {
        Intent intent = new Intent(this, ChildhoodIllnessActivity.class);
        startActivity(intent);
    }
}
