package com.android.babyscare;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NutritionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
    }

    /**
     * foodInformationClick method will intent to
     * FoodInformation Activity
     */
    public void foodInformationClick(View view) {
        Intent intent = new Intent(this, FoodInformationActivity.class);
        startActivity(intent);
    }

    /**
     * feedingGuidanceClick method will intent to
     * FeedingGuidance Activity
     */
    public void feedingGuidanceClick(View view) {
        Intent intent = new Intent(this, FeedingGuidanceActivity.class);
        startActivity(intent);
    }

    /**
     * foodStockClick method will intent to
     * FoodStock Activity
     */
    public void foodStockClick(View view) {
        Intent intent = new Intent(this, FoodStockActivity.class);
        startActivity(intent);
    }
}
