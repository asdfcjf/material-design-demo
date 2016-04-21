package com.nho.mydesign;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by nho on 3/8/2016.
 */
public class ExpandableListViewAdapter extends BaseExpandableListAdapter{
    private List<String> parentList;
    private HashMap<String,List<String>> childList;
    private Context context;

    public ExpandableListViewAdapter(List<String> parentList, HashMap<String, List<String>> childList, Context context) {
        this.parentList = parentList;
        this.childList = childList;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return parentList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childList.get(parentList.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return parentList.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childList.get(parentList.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.parent_layout,parent,false);
        }
        String parentHeader = (String) getGroup(groupPosition);
        TextView textView = (TextView) view.findViewById(R.id.txtParentLayout);
        textView.setText(parentHeader);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        View view = convertView;
        if(view==null)
        {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.child_layout,parent,false);
        }
        String childHeader = (String) getChild(groupPosition,childPosition);
        TextView textView = (TextView) view.findViewById(R.id.txtChildLayout);
        textView.setText(childHeader);
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
