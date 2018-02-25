package com.android.babyscare;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CareActivity extends AppCompatActivity {
    ExpandableListView expandableListView;
    DataBaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_care);
        expandableListView = this.findViewById(R.id.expandable_care);
        myDB= new DataBaseHelper(this);

        List<String> Heading = new ArrayList<String>();
        List<String > property =  new ArrayList<String>();
        HashMap<String,String> Childitem = new HashMap<String ,String>();
        Cursor res;
        res = myDB.getData("TIPS");

        byte []img = new byte[0];
        Bitmap b;
        List<Bitmap> photo = new ArrayList<Bitmap>();
        while(res.moveToNext()){
            Heading.add(res.getString(3));
            String str ="\n" + res.getString(2);
            property.add(str);
            img = res.getBlob(1);
            b = BitmapFactory.decodeByteArray(img,0,img.length);
            photo.add(b);
        }
        for (int i = 0;i<Heading.size();i++){
            Childitem.put(Heading.get(i),property.get(i));
        }
        MyAdapter myAdapter = new MyAdapter(this,Heading,Childitem,photo);

        expandableListView.setAdapter(myAdapter);
    }
}
