package br.com.john.kimberlyclark.AdpterLists;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.john.kimberlyclark.Classes.Routes;
import br.com.john.kimberlyclark.MainActivity;
import br.com.john.kimberlyclark.RoutesFragment;
import br.com.john.kimberlyclark.R;
import br.com.john.kimberlyclark.Services.AllActivitys;

/**
 * Created by Jonathan on 18/05/16.
 */

public class AdapterListProcess extends ArrayAdapter<String> {
    private final Context context;
    private static Activity act;
    private final String[] Values;
    private ArrayList<Routes> list;
    public static int currentPosition = 0;

    ListView listView;

    public void setActivity(Activity act){
        this.act = act;
    }
    public Activity getActivity(){
        return act;
    }

    public AdapterListProcess(Context context, String[] values, ArrayList<Routes> list) {
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
        ImageView iconStatus;
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
            viewHolder.textDate = (TextView) convertView.findViewById(R.id.text_info_time);
            viewHolder.textProcess = (TextView) convertView.findViewById(R.id.text_details_process);
            viewHolder.iconStatus = (ImageView)convertView.findViewById(R.id.icon_status_routes);
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
        if(list.get(position).getStatus().equals("execute")){
             viewHolder.iconStatus.setImageDrawable(AllActivitys.mainActivity.getDrawable(R.drawable.icon_in_execute));
        }
        else if(list.get(position).getStatus().equals("done"))
            viewHolder.iconStatus.setImageDrawable(AllActivitys.mainActivity.getDrawable(R.drawable.icon_done));

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
}
