package br.com.john.kimberlyclark;

import android.content.Intent;
import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.eazegraph.lib.charts.ValueLineChart;
import org.eazegraph.lib.models.ValueLinePoint;
import org.eazegraph.lib.models.ValueLineSeries;

import java.util.ArrayList;

import br.com.john.kimberlyclark.AdpterLists.AdapterListDetails;
import br.com.john.kimberlyclark.AdpterLists.AdapterListHistoric;
import br.com.john.kimberlyclark.AdpterLists.ItemListDetails;
import br.com.john.kimberlyclark.AdpterLists.ItemListHistoric;
import br.com.john.kimberlyclark.Services.AllActivitys;

//import com.melnykov.fab.FloatingActionButton;

public class DetailsProcessActivity extends AppCompatActivity {
    ListView listView;
    public static LinearLayout linearInfoActivity;
    public static TextView textCancel, textSave;
    public static EditText editStatus, editLimits, editComments;
    public static ImageView imgButtonPrevious, imgButtonNext;
    Button buttonHistoric, buttonHistoricInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_process);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.list_activitys);

        linearInfoActivity = (LinearLayout) findViewById(R.id.linear_info_activity);
        textCancel = (TextView) findViewById(R.id.text_cancel_info_activity);
        textSave = (TextView) findViewById(R.id.text_save_info_activity);
        editStatus = (EditText) findViewById(R.id.edit_status);
        editLimits = (EditText) findViewById(R.id.edit_limits);
        editComments = (EditText) findViewById(R.id.edit_comments);
        imgButtonPrevious = (ImageView) findViewById(R.id.button_previous);
        imgButtonNext = (ImageView) findViewById(R.id.button_next);

        buttonHistoricInfo = (Button) findViewById(R.id.button_historic);
        buttonHistoric = (Button) findViewById(R.id.btn_call_historic);
        buttonHistoric.setOnClickListener(goGraphic);
        buttonHistoricInfo.setOnClickListener(goGraphic);

        linearInfoActivity.setOnClickListener(hideInfo);
        textCancel.setOnClickListener(hideInfo);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });



        String[] values;
        values = new String[3];

        values[0] = "Historico 01";
        values[1] = "Historico 02";
        values[2] = "Historico 03";

        ArrayList<ItemListDetails> listDetails = new ArrayList<ItemListDetails>();


        for(int i = 0; i<=2; i++){
            ItemListDetails obj = new ItemListDetails();
            obj.setId(String.valueOf(i));
            obj.setDate(String.valueOf(i+" mai"));
            obj.setActivity(String.valueOf("Atividade "+i));
            obj.setNumber(""+i);

            listDetails.add(obj);
        }

        AdapterListDetails adapter = new AdapterListDetails(DetailsProcessActivity.this, values, listDetails);

        listView.setAdapter(adapter);

    }


    public static void cleanInfos(){
        editComments.setText("");
        editLimits.setText("");
        editStatus.setText("");
    }

    public static View.OnClickListener hideInfo = new View.OnClickListener() {
        public void onClick(View v) {
            linearInfoActivity.setVisibility(View.GONE);
        }
    };

    public View.OnClickListener goGraphic = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(DetailsProcessActivity.this, GraphicActivity.class);
            startActivity(i);
        }
    };

    @Override
    public void onBackPressed(){
        DetailsProcessActivity.this.finish();
    }
}
