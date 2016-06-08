package br.com.john.kimberlyclark.AdpterLists;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.john.kimberlyclark.Classes.Uploads;
import br.com.john.kimberlyclark.RoutesFragment;
import br.com.john.kimberlyclark.R;
import br.com.john.kimberlyclark.Services.AllActivitys;

/**
 * Created by Jonathan on 19/05/16.
 */
public class AdapterListUploads extends ArrayAdapter<String> {

    private final Context context;
    private static Activity act;
    private final String[] Values;
    private ArrayList<Uploads> list;

    ListView listView;

    public AdapterListUploads(Context context, String[] values, ArrayList<Uploads> list) {
        super(context, R.layout.layout_row_uploads_list, values);
        this.context = context;
        Values = values;
        this.list = list;

        listView = RoutesFragment.listViewProcess;
    }
    static class ViewHolder {
        LinearLayout linearBackground;
        TextView textDetails;
        TextView textStatus;
        ImageView imgReload;
        LinearLayout linearBackgroundImg;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ViewHolder viewHolder = null;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.layout_row_uploads_list, null);
            viewHolder = new ViewHolder();
            viewHolder.linearBackground = (LinearLayout) convertView.findViewById(R.id.linear_background_uploads);
            viewHolder.textDetails = (TextView) convertView.findViewById(R.id.text_details_uploads);
            viewHolder.textStatus = (TextView) convertView.findViewById(R.id.text_status_uploads);
            viewHolder.imgReload = (ImageView) convertView.findViewById(R.id.img_reload_uploads);
            viewHolder.linearBackgroundImg = (LinearLayout) convertView.findViewById(R.id.linear_background_img_reload);

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
        viewHolder.textDetails.setText(list.get(position).getDetails());
        String status = list.get(position).getStatus();
        if(status.equals("pending")){
            viewHolder.textStatus.setText("Pendente de Sincronização");
            viewHolder.textStatus.setBackground(AllActivitys.mainActivity.getResources().getDrawable(R.drawable.background_status_pending));
        }
        else if(status.equals("fail")){
            viewHolder.textStatus.setText("Falha");
            viewHolder.textStatus.setBackground(AllActivitys.mainActivity.getResources().getDrawable(R.drawable.background_status_fail));
        }
        else if(status.equals("success")){
            viewHolder.textStatus.setText("Sucesso");
            viewHolder.textStatus.setBackground(AllActivitys.mainActivity.getResources().getDrawable(R.drawable.background_status_success));
            viewHolder.linearBackgroundImg.setVisibility(View.GONE);
        }

        return convertView;
    }

    public void click(int position){
        Log.i("position", position+"");
    }



}
