package com.example.navigation;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BuildingCFragment extends Fragment {

    private FrameLayout floorContainer;
    private EditText searchBar;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Lock orientation to landscape when the fragment is created
        requireActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_building_c2, container, false);
        floorContainer = view.findViewById(R.id.floor_container);
        searchBar = view.findViewById(R.id.search_bar);

        view.findViewById(R.id.btn_switch_floor_c1).setOnClickListener(v -> loadFloorLayout(R.layout.building_c_1st_floor));
        view.findViewById(R.id.btn_switch_floor_c2).setOnClickListener(v -> loadFloorLayout(R.layout.building_c_2nd_floor));
        view.findViewById(R.id.btn_switch_floor_c3).setOnClickListener(v -> loadFloorLayout(R.layout.building_c_3rd_floor));
        view.findViewById(R.id.btn_switch_floor_c4).setOnClickListener(v -> loadFloorLayout(R.layout.building_c_4th_floor));

        searchBar.setOnEditorActionListener((v, actionId, event) -> {
            handleSearch(searchBar.getText().toString().trim());
            return true;
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        // Hide the bottom navigation
        requireActivity().findViewById(R.id.bottomNavigationView).setVisibility(View.GONE);
        requireActivity().findViewById(R.id.bottomAppBar).setVisibility(View.GONE);
        requireActivity().findViewById(R.id.fab).setVisibility(View.GONE);
    }

    @Override
    public void onPause() {
        super.onPause();
        // Show the bottom navigation again when leaving the fragment
        requireActivity().findViewById(R.id.bottomNavigationView).setVisibility(View.VISIBLE);
        requireActivity().findViewById(R.id.bottomAppBar).setVisibility(View.GONE);
        requireActivity().findViewById(R.id.fab).setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Reset orientation to the default when leaving the fragment
        requireActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    }

    private void loadFloorLayout(int layoutResId) {
        floorContainer.removeAllViews();
        try {
            View floorView = LayoutInflater.from(getContext()).inflate(layoutResId, floorContainer, false);
            floorContainer.addView(floorView);
        } catch (Exception e) {
            Log.e("BuildingAFragment", "Error loading floor layout: ", e);
        }
    }

    private void handleSearch(String searchText) {
        if (searchText.isEmpty()) {
            Toast.makeText(getContext(), "Please enter a room number to search", Toast.LENGTH_SHORT).show();
            return;
        }

        switch (searchText.toLowerCase()) {
            case "itcroom":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_itcroom");
                break;
            case "facultyloungue":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_facultyloungue");
                break;
            case "c-117":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_c117");
                break;
            case "cmtfacultyroom":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_cmtfacultyroom");
                break;
            case "officestaffarea":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_officestaffarea");
                break;
            case "cmtprogramheadroom":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_cmtprogramheadroom");
                break;
            case "travelandtoursroom":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_travelandtoursroom");
                break;
            case "c-105":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_c105");
                break;
            case "c-107":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_c107");
                break;
            case "c-109":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_c109");
                break;
            case "laundryroom":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_laundryroom");
                break;

                //
            case "cenarfacultyoffice":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_cenarfacultyoffice");
                break;
            case "cenarprogramheadsoffice":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_cenarprogramheadsoffice");
                break;
            case "citecdeansoffice":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_citecdeansoffice");
                break;
            case "citecfacultyoffice":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_citecfacultyoffice");
                break;
            case "cmtsimroom":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_cmtsimroom");
                break;
            case "mainlobby":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_mainlobby");
                break;
            case "cbioffice":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_cbioffice");
                break;
            case "anteroom":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_anteroom");
                break;
            case "accreroom":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_accreditationroom");
                break;
            case "suiteroom":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_suiteroom");
                break;
            case "lobby2":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_lobby2");
                break;
                //

            case "c-219":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c219");
                break;
            case "c-217":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c217");
                break;
            case "c-215":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c215");
                break;
            case "hot kitchen":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_hk");
                break;
            case "cafe trattoria":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_ct");
                break;
            case "c-209":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c209");
                break;
            case "c-221":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c221");
                break;
            case "c-220":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c220");
                break;
            case "c-218":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c218");
                break;
            case "c-216":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c216");
                break;
            case "c-214":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c214");
                break;
            case "c-202":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c202");
                break;
            case "c-204":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c204");
                break;
            case "c-206":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c206");
                break;
            case "c-208":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c208");
                break;
            case "c-210":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c210");
                break;
            case "c-211":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c211");
                break;
            //
            case "comlab5":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_comlab5");
                break;
            case "drawlab3":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_drawinglab3");
                break;
            case "ielab":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_ielab");
                break;
            case "cpelab":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_cpelab");
                break;
            case "c-303":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_c303");
                break;
            case "c-305":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_c305");
                break;
            case "c-307":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_c307");
                break;
            case "c-309":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_c309");
                break;
            case "engtoolroom":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_engtoolroom");
                break;
            case "drawlab5":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_drawinglab5");
                break;
            case "drawlab4":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_drawinglab4");
                break;
            case "stdrmarch":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_stdrmarch");
                break;
            case "c-302":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_c302");
                break;
            case "c-304":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_c304");
                break;
            case "c-306":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_c306");
                break;
            case "c-308":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_c308");
                break;
            case "c-310":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_c310");
                break;
            case "c-311":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_c311");
                break;
            case "mph":
                loadFloorLayout(R.layout.building_c_4th_floor);
                highlightLabel("label_room_MPH");
                break;
            case "tlh":
                loadFloorLayout(R.layout.building_c_4th_floor);
                highlightLabel("label_room_tlh");
                break;
            case "ctrlrm":
                loadFloorLayout(R.layout.building_c_4th_floor);
                highlightLabel("label_room_cntrlrm");
                break;
            case "lobbyc":
                loadFloorLayout(R.layout.building_c_4th_floor);
                highlightLabel("label_room_lobbyc");
                break;

            default:
                Toast.makeText(getContext(), "Room not found", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    private void highlightLabel(String labelId) {
        View floorView = floorContainer.getChildAt(0); // Assuming only one floor layout is loaded
        if (floorView != null) {
            int resID = getResources().getIdentifier(labelId, "id", getContext().getPackageName());
            TextView roomLabel = floorView.findViewById(resID);
            if (roomLabel != null) {
                roomLabel.setTextColor(getResources().getColor(android.R.color.holo_red_dark));
            } else {
                Log.e("HighlightLabel", "Room label not found: " + labelId);
            }
        }
    }
}