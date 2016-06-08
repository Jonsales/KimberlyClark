package br.com.john.kimberlyclark;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import br.com.john.kimberlyclark.AdpterLists.AdapterExpandableListGroups;
import br.com.john.kimberlyclark.Classes.Equipament;
import br.com.john.kimberlyclark.Classes.Group;
import br.com.john.kimberlyclark.Classes.Routes;

import static android.widget.ExpandableListView.*;

public class GroupRoutesActivity extends AppCompatActivity {
    public static ExpandableListView expandableListView;
    private static AdapterExpandableListGroups expandableListViewAdapter;
    ArrayList<Group> listProcess;
    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_routes);

        ctx = GroupRoutesActivity.this;
        expandableListView = (ExpandableListView) findViewById(R.id.expandable_group_routes);
        expandableListView.setGroupIndicator(null);
        expandableListView.setChildIndicator(null);

        listProcess = new ArrayList<Group>();

        for(int i = 0; i<=2; i++){
            Group obj = new Group();
            obj.setId(String.valueOf(i));
            obj.setGroup(String.valueOf("Group "+i));
            obj.setCod("Cod Group "+String.valueOf(i));
            listProcess.add(obj);
        }

        HashMap<Group, List<Equipament>> allChildItems = returnGroupedChildItems();

        expandableListViewAdapter =
                new AdapterExpandableListGroups(GroupRoutesActivity.this,listProcess, allChildItems);


        expandableListView.setAdapter(expandableListViewAdapter);

        expandableListView.setOnChildClickListener(new OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {

                expandableListViewAdapter.onChildClick(parent, v, groupPosition, childPosition,id);
                return true;
            }
        });


    }

    private HashMap<Group, List<Equipament>> returnGroupedChildItems() {

        HashMap<Group, List<Equipament>> childContent = new HashMap<Group, List<Equipament>>();

        List<Equipament> equipaments = new ArrayList<Equipament>();
        for(int i=0; i<=2; i++){
            Equipament e = new Equipament();
            e.setId(String.valueOf(i));
            e.setType("Equipamemt "+i);
            e.setCodEquipament("Cod Equip. "+String.valueOf(i));
            equipaments.add(e);
            childContent.put(listProcess.get(i), equipaments);
        }
        return childContent;
    }


}
