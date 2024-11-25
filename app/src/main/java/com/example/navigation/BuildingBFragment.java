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

public class BuildingBFragment extends Fragment {

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
        View view = inflater.inflate(R.layout.fragment_building_b2, container, false);
        floorContainer = view.findViewById(R.id.floor_container);
        searchBar = view.findViewById(R.id.search_bar);

        view.findViewById(R.id.btn_switch_floor_b1).setOnClickListener(v -> loadFloorLayout(R.layout.building_b_1st_floor));
        view.findViewById(R.id.btn_switch_floor_b2).setOnClickListener(v -> loadFloorLayout(R.layout.building_b_2nd_floor));
        view.findViewById(R.id.btn_switch_floor_b3).setOnClickListener(v -> loadFloorLayout(R.layout.building_b_3rd_floor));

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
            case "library":
                loadFloorLayout(R.layout.building_b_1st_floor);
                highlightLabel("label_room_library");
                break;
            case "b-101":
                loadFloorLayout(R.layout.building_b_1st_floor);
                highlightLabel("label_room_b101");
                break;
            case "b-103":
                loadFloorLayout(R.layout.building_b_1st_floor);
                highlightLabel("label_room_b103");
                break;
            case "corpcom":
                loadFloorLayout(R.layout.building_b_1st_floor);
                highlightLabel("label_room_corpcom");
                break;
            case "homeeconomics":
                loadFloorLayout(R.layout.building_b_1st_floor);
                highlightLabel("label_room_homeeconomics");
                break;
            case "b-102":
                loadFloorLayout(R.layout.building_b_1st_floor);
                highlightLabel("label_room_b102");
                break;
            case "saep":
                loadFloorLayout(R.layout.building_b_1st_floor);
                highlightLabel("label_room_saep");
                break;
            case "clinic":
                loadFloorLayout(R.layout.building_b_1st_floor);
                highlightLabel("label_room_clinic");
                break;
            case "b-110":
                loadFloorLayout(R.layout.building_b_1st_floor);
                highlightLabel("label_room_b110");
                break;

            //2nd Floor
            case "b-218":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b218");
                break;
            case "b-216":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b216");
                break;
            case "b-214":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b214");
                break;
            case "b-212":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b212");
                break;
            case "jhsfacultyoffice":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_jhsfacultyoffice");
                break;
            case "b-203":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b203");
                break;
            case "b-205":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b205");
                break;
            case "b-207":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b207");
                break;
            case "b-221":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b221");
                break;
            case "b-219":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b219");
                break;
            case "b-217":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b217");
                break;
            case "b-215":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b215");
                break;
            case "b-213":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b213");
                break;
            case "b-211":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b211");
                break;
            case "hsprincipaloffice":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_hsprincipaloffice");
                break;
            case "b-204":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b204");
                break;
            case "b-206":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b206");
                break;
            case "b-208":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b208");
                break;
            case "b-210":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b210");
                break;

                //3rd
            case "drawinglab1":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_drawinglab1");
                break;
            case "b-314":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b314");
                break;
            case "b-312":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b312");
                break;
            case "shsfo":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_shsfo");
                break;
            case "b-303":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b303");
                break;
            case "b-305":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b305");
                break;
            case "b-307":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b307");
                break;
            case "crb3r":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_crb3r");
                break;
            case "drawinglab2":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_drawinglab2");
                break;
            case "b-317":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b317");
                break;
            case "b-315":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b315");
                break;
            case "b-313":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b313");
                break;
            case "b-311":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b311");
                break;
            case "b-302":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b302");
                break;
            case "b-304":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b304");
                break;
            case "b-306":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b306");
                break;
            case "b-308":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b308");
                break;
            case "b-310":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b310");
                break;
            case "tbj":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_tbj");
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