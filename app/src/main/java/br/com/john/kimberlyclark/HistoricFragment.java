package br.com.john.kimberlyclark;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

import br.com.john.kimberlyclark.AdpterLists.AdapterListHistoric;
import br.com.john.kimberlyclark.Classes.Historic;
import br.com.john.kimberlyclark.Services.AllActivitys;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HistoricFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HistoricFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HistoricFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public static ListView listView;

    private OnFragmentInteractionListener mListener;

    public HistoricFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistoricFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HistoricFragment newInstance(String param1, String param2) {
        HistoricFragment fragment = new HistoricFragment();
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
        listView = (ListView) view.findViewById(R.id.list_historic);

        listView.setVisibility(View.VISIBLE);

        String[] values;
        values = new String[3];

        values[0] = "Historico 01";
        values[1] = "Historico 02";
        values[2] = "Historico 03";

        ArrayList<Historic> listProcess = new ArrayList<Historic>();


        for(int i = 0; i<=2; i++){
            Historic obj = new Historic();
            obj.setId(String.valueOf(i));
            obj.setDate(String.valueOf(i+" mai"));
            obj.setHistoric(String.valueOf("Historico"+i));

            listProcess.add(obj);
        }

        AdapterListHistoric adapter = new AdapterListHistoric(AllActivitys.mainActivity, values, listProcess);

        listView.setAdapter(adapter);
    }

    public static void callGraphicActivity(){
        Intent i = new Intent(AllActivitys.mainActivity, GraphicActivity.class);
        AllActivitys.mainActivity.startActivity(i);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_historic, container, false);
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
            /*throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");*/
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
