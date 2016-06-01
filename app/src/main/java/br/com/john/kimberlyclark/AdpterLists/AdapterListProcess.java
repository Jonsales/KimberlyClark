package br.com.john.kimberlyclark.AdpterLists;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.john.kimberlyclark.Classes.Process;
import br.com.john.kimberlyclark.MainActivity;
import br.com.john.kimberlyclark.ProcessFragment;
import br.com.john.kimberlyclark.R;

/**
 * Created by Jonathan on 18/05/16.
 */
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

        listView = ProcessFragment.listViewProcess;
    }
    static class ViewHolder {
        LinearLayout linearBackground;
        TextView textDate;
        TextView textProcess;
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




}
