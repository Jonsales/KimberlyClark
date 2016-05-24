package br.com.john.kimberlyclark.AdpterLists;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.john.kimberlyclark.ProcessFragment;
import br.com.john.kimberlyclark.R;

/**
 * Created by Jonathan on 24/05/16.
 */
public class AdapterListDetails extends ArrayAdapter<String> {

    private final Context context;
    private final String[] Values;
    private ArrayList<ItemListDetails> list;

    ListView listView;

    public AdapterListDetails(Context context, String[] values, ArrayList<ItemListDetails> list) {
        super(context, R.layout.layout_row_details_process, values);
        this.context = context;
        Values = values;
        this.list = list;
    }
    static class ViewHolder {
        LinearLayout linearBackground;
        TextView textDate;
        TextView textActivity;
        TextView textNumber;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_row_details_process, null);
            viewHolder = new ViewHolder();
            viewHolder.linearBackground = (LinearLayout) convertView.findViewById(R.id.linear_background_details);
            viewHolder.textDate = (TextView) convertView.findViewById(R.id.text_date_row_activity);
            viewHolder.textActivity = (TextView) convertView.findViewById(R.id.text_row_activity);
            viewHolder.textNumber = (TextView) convertView.findViewById(R.id.text_number_row_activity);
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
        viewHolder.textActivity.setText(list.get(position).getActivity());
        viewHolder.textNumber.setText(list.get(position).getNumber());

        return convertView;
    }

    public void click(int position){
        Log.i("position", position+"");
    }
}