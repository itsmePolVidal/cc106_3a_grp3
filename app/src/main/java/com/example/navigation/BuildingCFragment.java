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

        view.findViewById(R.id.btn_switch_floor_c1).setOnClickListener(v -> loadFloorLayout(R.layout.building_b_1st_floor));
        view.findViewById(R.id.btn_switch_floor_c2).setOnClickListener(v -> loadFloorLayout(R.layout.building_b_2nd_floor));
        view.findViewById(R.id.btn_switch_floor_c3).setOnClickListener(v -> loadFloorLayout(R.layout.building_b_3rd_floor));

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
            case "c-1":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_c1");
                break;
            case "c-2":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_c2");
                break;
            case "c-3":
                loadFloorLayout(R.layout.building_c_1st_floor);
                highlightLabel("label_room_c3");
                break;
            case "c-21":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c21");
                break;
            case "c-22":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c22");
                break;
            case "c-23":
                loadFloorLayout(R.layout.building_c_2nd_floor);
                highlightLabel("label_room_c23");
                break;
            case "c-31":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_c31");
                break;
            case "c-32":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_c32");
                break;
            case "c-33":
                loadFloorLayout(R.layout.building_c_3rd_floor);
                highlightLabel("label_room_c33");
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