package br.com.john.kimberlyclark.AdpterLists;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.john.kimberlyclark.Classes.Equipament;
import br.com.john.kimberlyclark.Classes.Group;
import br.com.john.kimberlyclark.R;

/**
 * Created by Jonathan on 07/06/16.
 */



    //public AdapterExpandableListGroups(Context context, ArrayList<Routes> list, HashMap<Routes, List<String>> child) {

public class AdapterExpandableListGroups extends BaseExpandableListAdapter{
    private Context context;
    private ArrayList<Group> list;
    private HashMap<Group, List<Equipament>> childDataSource;

    private static Activity act;

    public static int groupPosition = 0, childPosition = 0;


    public AdapterExpandableListGroups(Context context, ArrayList<Group> list, HashMap<Group, List<Equipament>> child) {
        this.context = context;
        this.list = list;
        this.childDataSource = child;
    }

    @Override
    public int getGroupCount() {
        return this.list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.childDataSource.get(this.list.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return this.childDataSource.get(list.get(groupPosition)).get(childPosition);
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
    static class ViewHolderParentGroup {
        LinearLayout linearBackground;
        TextView textCod;
        TextView textDesc;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolderParentGroup viewHolder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_row_group_expandable, null);
            viewHolder = new ViewHolderParentGroup();
            viewHolder.linearBackground = (LinearLayout) convertView.findViewById(R.id.linear_background_exapandable_group);
            viewHolder.textCod = (TextView) convertView.findViewById(R.id.text_cod_group);
            viewHolder.textDesc = (TextView) convertView.findViewById(R.id.text_desc_group);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderParentGroup) convertView.getTag();
        }

        viewHolder.textCod.setText(list.get(groupPosition).getCod());
        viewHolder.textDesc.setText(list.get(groupPosition).getGroup());
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolderParentGroup viewHolder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_row_equipament_expandable, null);
            viewHolder = new ViewHolderParentGroup();
            viewHolder.linearBackground = (LinearLayout) convertView.findViewById(R.id.linear_background_exapandable_equipament);
            viewHolder.textCod = (TextView) convertView.findViewById(R.id.text_cod_equipament);
            viewHolder.textDesc = (TextView) convertView.findViewById(R.id.text_desc_equipament);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderParentGroup) convertView.getTag();
        }
        Equipament e = ((Equipament)getChild(groupPosition, childPosition));

        viewHolder.textCod.setText(e.getCodEquipament());
        viewHolder.textDesc.setText(e.getType());

        viewHolder.linearBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Equipament e = ((Equipament)getChild(AdapterExpandableListGroups.groupPosition, AdapterExpandableListGroups.childPosition));
                //Toast toast = Toast.makeText(context, e.getCodEquipament(),Toast.LENGTH_SHORT);
                //toast.show();
            }
        });

        this.groupPosition = groupPosition;
        this.childPosition = childPosition;
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }

}
