package br.com.john.kimberlyclark;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.john.kimberlyclark.AdpterLists.AdapterListProcess;
import br.com.john.kimberlyclark.Classes.Process;
import br.com.john.kimberlyclark.Services.AllActivitys;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ProcessFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ProcessFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ProcessFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    //TODO: Component fragment
    public static ListView listViewProcess;


    private OnFragmentInteractionListener mListener;

    public ProcessFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ProcessFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ProcessFragment newInstance(String param1, String param2) {
        ProcessFragment fragment = new ProcessFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        listViewProcess = (ListView) view.findViewById(R.id.list_process);

        listViewProcess.setVisibility(View.VISIBLE);

        String[] values;
        values = new String[3];

        values[0] = "Processo 01";
        values[1] = "Processo 02";
        values[2] = "Processo 03";

        ArrayList<Process> listProcess = new ArrayList<Process>();
        
        for(int i = 0; i<=2; i++){
            Process obj = new Process();
            obj.setId(String.valueOf(i));
            obj.setDate(String.valueOf(i+" mai"));
            obj.setProcess(String.valueOf("Process"+i));
            obj.setMachine(String.valueOf("Machine "+i));
            obj.setGroup(String.valueOf("Group "+i));
            obj.setSystem(String.valueOf("System "+i));
            listProcess.add(obj);
        }

        AdapterListProcess adapter = new AdapterListProcess(AllActivitys.mainActivity, values, listProcess);

        listViewProcess.setAdapter(adapter);

        MainActivity.textInit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callScreenDetailsProcess();
            }
        });
    }

    public void callScreenDetailsProcess(){
        Log.i("Current Position ", AdapterListProcess.currentPosition+"");
        MainActivity.linearInfo.setVisibility(View.GONE);
        MainActivity.cleanInfos();
        Intent i = new Intent(AllActivitys.mainActivity, DetailsProcessActivity.class);
        startActivity(i);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_process, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
