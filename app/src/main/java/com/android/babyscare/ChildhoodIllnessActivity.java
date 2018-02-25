package com.android.babyscare;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChildhoodIllnessActivity extends AppCompatActivity {

    ExpandableListView expandableListView;
    DataBaseHelper myDB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_childhood_illness);
        expandableListView = this.findViewById(R.id.expandable_childhood_ill);
        myDB = new DataBaseHelper(this);

        List<String> Heading = new ArrayList<String>();
        List<String> property = new ArrayList<String>();
        HashMap<String, String> childnode = new HashMap<String ,String>();
        Cursor res;
        res = myDB.getData("CHILDHOOD");
        while (res.moveToNext()){
            Heading.add(res.getString(1));
            property.add(res.getString(2));
        }

        for(int i = 0;i<Heading.size();i++){
            childnode.put(Heading.get(i),property.get(i));
        }

        Adapter_feeding_guide adapter_feeding_guide = new Adapter_feeding_guide(this,Heading,childnode);

        expandableListView.setAdapter(adapter_feeding_guide);
    }
}
