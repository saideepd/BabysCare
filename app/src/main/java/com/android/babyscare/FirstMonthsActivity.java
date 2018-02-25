package com.android.babyscare;

import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FirstMonthsActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textView;
    DataBaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_months);
        myDB = new DataBaseHelper(this);

        List<String> Heading = new ArrayList<String>();
        List<String > property =  new ArrayList<String>();
        HashMap<String,String> Childitem = new HashMap<String ,String>();
        Cursor res;
        res = myDB.getData("FIRST_MONTHS");

        byte []img = new byte[0];
        Bitmap b = null;
        List<Bitmap> photo = new ArrayList<Bitmap>();
        while(res.moveToNext()){
            String str ="Introduction:-\n" +res.getString(2) + " \n\n\n1. Feeding:-\n" + res.getString(3) + "\n\n2. Sleeping:- \n" + res.getString(4) + "\n\n3, Behaviour:-\n" + res.getString(5) + "\n\n4. Development Milestones:-\n" + res.getString(6) + "\n\n5. Growth:-\n" + res.getString(7) + "\n\n6. Keeping Well:- \n" + res.getString(8)+"\n\n7. Staying Safe :- \n" + res.getString(9)+ "\n\n8. Play And Interaction:-\n" + res.getString(10)+ "\n\n\n";
            property.add(str);
            img = res.getBlob(1);
            b = BitmapFactory.decodeByteArray(img,0,img.length);
            photo.add(b);
        }
        for (int i = 0;i<Heading.size();i++){
            Childitem.put(Heading.get(i),property.get(i));
        }

        imageView = this.findViewById(R.id.first_month_imageview);
        imageView.setImageBitmap(b);
        textView = this.findViewById(R.id.first_month_textview);
        textView.setText(property.get(0));
        textView.setMovementMethod(new ScrollingMovementMethod());
    }
}
