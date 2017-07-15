package com.example.eventerbeta;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link fragDetailedView.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link fragDetailedView#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragDetailedView extends Fragment {
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;
    JSONObject jsonResponse;
    String url = "http://gambasoft.xyz/GetEventsBasic.php?offset=0";
    ArrayList<EventoDetailed> lista;

    private OnFragmentInteractionListener mListener;

    public fragDetailedView() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragDetailedView.
     */
    public static fragDetailedView newInstance(String param1, String param2) {
        fragDetailedView fragment = new fragDetailedView();
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
    RecyclerView rvDetailed;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_frag_detailed_view, container, false);

        //Start recycle view
        rvDetailed = (RecyclerView)view.findViewById(R.id.rvDetailed);
        LinearLayoutManager llm = new LinearLayoutManager(this.getActivity());
        rvDetailed.setLayoutManager(llm);

        //Get events list
        EventQuery(url);
        lista = new ArrayList<>();

        //Place events on adapter
        AdaptadorRvDetailed adaptadorRvDetailed = new AdaptadorRvDetailed(lista, getContext());
        rvDetailed.setAdapter(adaptadorRvDetailed);

        return view;
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
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
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public void EventQuery(String url) {
        Toast.makeText(getActivity().getApplicationContext(), ""+url, Toast.LENGTH_SHORT).show();
        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.length()>0){
                    AddElementsToList(response);
                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });
        queue.add(stringRequest);
    }

    public void AddElementsToList(String response) {
        try {
            jsonResponse = new JSONObject(response);
            Log.i("sizejson",""+jsonResponse.length());
            JSONArray eventArray = jsonResponse.getJSONArray("event");
            for(int i=0; i<eventArray.length(); i++) {
                JSONObject jsonEvent = eventArray.getJSONObject(i);
                String name = jsonEvent.getString("name");
                String date = jsonEvent.getString("date");
                String organizer = jsonEvent.getString("organizer");
                String imageUrl = jsonEvent.getString("image_url");
                int category1 = jsonEvent.getInt("category1");
                int category2 = jsonEvent.getInt("category2");
                EventoDetailed event = new EventoDetailed(imageUrl, name, date, organizer,
                        true, true, category1, category2);
                lista.add(event);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AdaptadorRvDetailed adaptadorRvDetailed = new AdaptadorRvDetailed(lista, getContext());
        rvDetailed.setAdapter(adaptadorRvDetailed);
    }
}