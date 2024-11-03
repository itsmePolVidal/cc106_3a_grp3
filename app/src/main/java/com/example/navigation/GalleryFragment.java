package com.example.navigation;

import android.os.Bundle;
import android.widget.GridView;
import androidx.fragment.app.Fragment;
import android.widget.AdapterView;
import android.widget.Toast;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class GalleryFragment extends Fragment {


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    private String mParam1;
    private String mParam2;

    private String[] UBMap = {"BLDG A", "BLDG B", "BLDG C", "Canteen", "Gym", "Bookstore","Study Area" };
    private int[] image = {R.drawable.a,R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g};

    public GalleryFragment() {

    }



    public static GalleryFragment newInstance(String param1, String param2) {
        GalleryFragment fragment = new GalleryFragment();
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_gallery, container, false);

        GridView gridView = view.findViewById(R.id.gridView); // Replace with your GridView ID
        GridAdapter gridAdapter = new GridAdapter(getContext(), UBMap, image);
        gridView.setAdapter(gridAdapter);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(getContext(), "You clicked on " + UBMap[position], Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}