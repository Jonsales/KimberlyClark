package br.com.john.kimberlyclark;

import android.os.Bundle;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.john.kimberlyclark.AdpterLists.AdapterListDetails;
import br.com.john.kimberlyclark.AdpterLists.AdapterListHistoric;
import br.com.john.kimberlyclark.AdpterLists.ItemListDetails;
import br.com.john.kimberlyclark.AdpterLists.ItemListHistoric;
import br.com.john.kimberlyclark.Services.AllActivitys;

//import com.melnykov.fab.FloatingActionButton;

public class DetailsProcessActivity extends AppCompatActivity {
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_process);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = (ListView) findViewById(R.id.list_activitys);

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
}
