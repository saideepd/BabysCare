package com.android.babyscare;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FeedingGuidanceActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    DataBaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feeding_guidance);
        expandableListView = this.findViewById(R.id.expandable_food_guide);
        myDB = new DataBaseHelper(this);

        List<String> Heading = new ArrayList<String>() ;
        List<String> property = new ArrayList<String>();

        HashMap<String , String> childitems = new HashMap<String, String >();

        Cursor res = myDB.getData("FEEDING_GUIDANCE");

        while (res.moveToNext()){
            Heading.add(res.getString(1));
            String str = "What TO Feed?\n" + res.getString(2)+"\n\nFeeding Tips?\n" + res.getString(3);
            property.add(str);
        }
        for(int i = 0; i < Heading.size();i++){
            childitems.put(Heading.get(i),property.get(i));
        }

        Adapter_feeding_guide adapter_feeding_guide = new Adapter_feeding_guide(this,Heading,childitems);

        expandableListView.setAdapter(adapter_feeding_guide);
    }
}
