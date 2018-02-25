package com.android.babyscare;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by hites on 2/24/2018.
 */

public class Adapter_feeding_guide extends BaseExpandableListAdapter {

    private Context ctx;
    private List<String > heading_title;
    private HashMap<String , String> child_title;
    Adapter_feeding_guide(Context ctx, List<String> heading_title, HashMap<String, String> child_title){
        this.ctx = ctx;
        this.child_title = child_title;
        this.heading_title = heading_title;
    }

    @Override
    public int getGroupCount() {
        return heading_title.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return 1;
    }

    @Override
    public Object getGroup(int i) {
        return heading_title.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return child_title.get(heading_title.get(i));
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
        String title = (String) this.getGroup(i);

        if (view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.parent_layout,null);
        }
        TextView textView = view.findViewById(R.id.heading_item);
        textView.setText(title);
        return view;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
        String title = (String) this.getChild(i, i1);
        if(view == null){
            LayoutInflater layoutInflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.child_feeding_guide,null);
        }
        TextView textView = view.findViewById(R.id.child_items);
        textView.setText(title);
        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
