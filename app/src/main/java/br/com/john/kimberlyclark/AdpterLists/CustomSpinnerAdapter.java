package br.com.john.kimberlyclark.AdpterLists;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.john.kimberlyclark.DetailsProcessActivity;
import br.com.john.kimberlyclark.R;
import br.com.john.kimberlyclark.Services.AllActivitys;

/**
 * Created by Jonathan on 31/05/16.
 */
public class CustomSpinnerAdapter extends BaseAdapter implements SpinnerAdapter {

    private final Context activity;
    private ArrayList<String> asr;

    public CustomSpinnerAdapter(Context context,ArrayList<String> asr) {
        this.asr=asr;
        activity = context;
    }



    public int getCount()
    {
        return asr.size();
    }

    public Object getItem(int i)
    {
        return asr.get(i);
    }

    public long getItemId(int i)
    {
        return (long)i;
    }



    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView txt = new TextView(AllActivitys.detailsProcessActivity);
        final float scale = AllActivitys.detailsProcessActivity.getResources().getDisplayMetrics().density;
        txt.setPadding((int)(20 * scale + 0.5f), (int)(10 * scale + 0.5f),
                (int)(20 * scale + 0.5f), (int)(10 * scale + 0.5f));
        txt.setTextSize(16);
        txt.setGravity(Gravity.LEFT);
        txt.setText(asr.get(position));
        txt.setTextColor(AllActivitys.detailsProcessActivity.getResources().getColor(R.color.color_style_default));
        return  txt;
    }

    public View getView(int i, View view, ViewGroup viewgroup) {
        TextView txt = new TextView(AllActivitys.detailsProcessActivity);
        txt.setGravity(Gravity.LEFT);
        final float scale = AllActivitys.detailsProcessActivity.getResources().getDisplayMetrics().scaledDensity;
        txt.setPadding(0, 0,
                (int)(5 * scale + 0.5f), 0);
        txt.setTextSize(16);
        txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.icon_dropdown_spinner, 0);
        txt.setText(asr.get(i));
        txt.setSingleLine(true);
        txt.setTextColor(AllActivitys.detailsProcessActivity.getResources().getColor(R.color.color_style_default));
        return  txt;
    }

}