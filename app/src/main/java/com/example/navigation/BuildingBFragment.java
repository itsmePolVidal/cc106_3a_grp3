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
        // Lock orientation
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
        // Show the bottom navigation
        requireActivity().findViewById(R.id.bottomNavigationView).setVisibility(View.VISIBLE);
        requireActivity().findViewById(R.id.bottomAppBar).setVisibility(View.GONE);
        requireActivity().findViewById(R.id.fab).setVisibility(View.GONE);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        // Reset orientation
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
            case "b-1":
                loadFloorLayout(R.layout.building_b_1st_floor);
                highlightLabel("label_room_b1");
                break;
            case "b-2":
                loadFloorLayout(R.layout.building_b_1st_floor);
                highlightLabel("label_room_b2");
                break;
            case "b-3":
                loadFloorLayout(R.layout.building_b_1st_floor);
                highlightLabel("label_room_b3");
                break;
            case "b-21":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b21");
                break;
            case "b-22":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b22");
                break;
            case "b-23":
                loadFloorLayout(R.layout.building_b_2nd_floor);
                highlightLabel("label_room_b23");
                break;
            case "b-31":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b31");
                break;
            case "b-32":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b32");
                break;
            case "b-33":
                loadFloorLayout(R.layout.building_b_3rd_floor);
                highlightLabel("label_room_b33");
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