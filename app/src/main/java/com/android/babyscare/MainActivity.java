package com.android.babyscare;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;
import java.sql.SQLException;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DataBaseHelper myDB = new DataBaseHelper(this);
        try {
            Log.i("create","h");
            myDB.createDataBase();
        } catch (IOException e) {
            e.printStackTrace();
            Log.i("create error",e.getMessage());
        }
        try {
            Log.i("Open","YES");
            myDB.openDataBase();
        } catch (SQLException e) {
            e.printStackTrace();
            Log.i("Open Error",e.getMessage());
        }

        /*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        */

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /* Disables the 3 dot settings menu from all screens
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        /* Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);*/


        //calling the method displayselectedscreen and passing the id of selected menu
        displaySelectedScreen(item.getItemId());
        return true;
    }


    private void displaySelectedScreen(int itemId) {

        //creating fragment object
        Fragment fragment = null;

        //initializing the fragment object which is selected
        switch (itemId) {
            /*case R.id.nav_home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;*/
            case R.id.nav_nutrition:
                Intent intent1 = new Intent(this, NutritionActivity.class);
                startActivity(intent1);
                break;
            case R.id.nav_treatment:
                Intent intent2 = new Intent(this, TreatmentActivity.class);
                startActivity(intent2);
                break;
            case R.id.nav_emergency:
                Intent intent3 = new Intent(this, EmergencyActivity.class);
                startActivity(intent3);
                break;
            case R.id.nav_care:
                Intent intent4 = new Intent(this, CareActivity.class);
                startActivity(intent4);
                break;
        }

        //replacing the fragment
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
    }

    /**
     * nutritionClick method will be called when NutritionLayout is clicked
     * and it will open the NutritionActivity
     */
    /*
    public void nutritionClick(View view) {
        Fragment fragment = new Nutrition();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
    }*/
    public void nutritionClick(View view) {
        Intent intent1 = new Intent(this, NutritionActivity.class);
        startActivity(intent1);
    }

    /**
     * treatmentClick method will be called when TreatmentLayout is clicked
     * and it will open the TreatmentActivity
     */
    /*
    public void treatmentClick(View view) {
        Fragment fragment = new Treatment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
    }*/
    public void treatmentClick(View view) {
        Intent intent1 = new Intent(this, TreatmentActivity.class);
        startActivity(intent1);
    }

    /**
     * emergencyClick method will be called when EmergencyLayout is clicked
     * and it will open the EmergencyActivity
     */
    /*
    public void emergencyClick(View view) {
        Fragment fragment = new Emergency();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
    }*/
    public void emergencyClick(View view) {
        Intent intent1 = new Intent(this, EmergencyActivity.class);
        startActivity(intent1);
    }

    /**
     * careClick method will be called when CareLayout is clicked
     * and it will open the CareActivity
     */
    /*
    public void careClick(View view) {
        Fragment fragment = new Care();
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
    }*/
    public void careClick(View view) {
        Intent intent1 = new Intent(this, CareActivity.class);
        startActivity(intent1);
    }

    /*public void nutritionClick(View view) {
        Intent i = new Intent(this, Nutrition.class);
        startActivity(i);
    }*/
}
