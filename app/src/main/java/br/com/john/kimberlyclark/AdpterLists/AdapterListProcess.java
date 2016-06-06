package br.com.john.kimberlyclark.AdpterLists;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.john.kimberlyclark.Classes.Process;
import br.com.john.kimberlyclark.MainActivity;
import br.com.john.kimberlyclark.RoutesFragment;
import br.com.john.kimberlyclark.R;

/**
 * Created by Jonathan on 18/05/16.
 */

public class AdapterListProcess extends BaseExpandableListAdapter {
    private Context context;
    private ArrayList<Process> list;
    private HashMap<Process, List<String>> childDataSource;

    private static Activity act;

    public static int currentPosition = 0;


    public AdapterListProcess(Context context, ArrayList<Process> list, HashMap<Process, List<String>> child) {
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
        TextView textDate;
        TextView textProcess;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolderParentGroup viewHolder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_row_process_list, null);
            viewHolder = new ViewHolderParentGroup();
            viewHolder.linearBackground = (LinearLayout) convertView.findViewById(R.id.linear_background_list_process);
            viewHolder.textDate = (TextView) convertView.findViewById(R.id.text_date_process);
            viewHolder.textProcess = (TextView) convertView.findViewById(R.id.text_details_process);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderParentGroup) convertView.getTag();
        }

        viewHolder.textDate.setText(list.get(groupPosition).getDate());
        viewHolder.textProcess.setText(list.get(groupPosition).getProcess());
        currentPosition = groupPosition;
        return convertView;
    }

    static class viewHolderChild{
        TextView textView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolderParentGroup viewHolder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_row_process_list, null);
            viewHolder = new ViewHolderParentGroup();
            viewHolder.linearBackground = (LinearLayout) convertView.findViewById(R.id.linear_background_list_process);
            viewHolder.textDate = (TextView) convertView.findViewById(R.id.text_date_process);
            viewHolder.textProcess = (TextView) convertView.findViewById(R.id.text_details_process);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolderParentGroup) convertView.getTag();
        }

        String childName = (String)getChild(groupPosition, childPosition);

        viewHolder.textDate.setText(childName);

        currentPosition = groupPosition;
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
/*
public class AdapterListProcess extends ArrayAdapter<String> {

    private final Context context;
    private static Activity act;
    private final String[] Values;
    private ArrayList<Process> list;
    public static int currentPosition = 0;

    ListView listView;

    public void setActivity(Activity act){
        this.act = act;
    }
    public Activity getActivity(){
        return act;
    }

    public AdapterListProcess(Context context, String[] values, ArrayList<Process> list) {
        super(context, R.layout.layout_row_process_list, values);
        this.context = context;
        Values = values;
        this.list = list;

        listView = RoutesFragment.listViewProcess;
    }
    static class ViewHolder {
        LinearLayout linearBackground;
        TextView textDate;
        TextView textProcess;
        ExpandableListView listRoutes;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_row_process_list, null);
            viewHolder = new ViewHolder();
            viewHolder.linearBackground = (LinearLayout) convertView.findViewById(R.id.linear_background_list_process);
            viewHolder.textDate = (TextView) convertView.findViewById(R.id.text_date_process);
            viewHolder.textProcess = (TextView) convertView.findViewById(R.id.text_details_process);
            viewHolder.listRoutes = (ExpandableListView) convertView.findViewById(R.id.list_routes);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.linearBackground.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click(position);
            }
        });
        viewHolder.textDate.setText(list.get(position).getDate());
        viewHolder.textProcess.setText(list.get(position).getProcess());
        currentPosition = position;
        return convertView;
    }

    public void click(int position){
        currentPosition = position;

        MainActivity.linearInfo.setVisibility(View.VISIBLE);
        MainActivity.textInfoMachine.setText(list.get(position).getMachine());
        MainActivity.textInfoSystem.setText(list.get(position).getSystem());
        MainActivity.textInfoGroup.setText(list.get(position).getGroup());
    }




}*/
