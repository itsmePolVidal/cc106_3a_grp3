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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class BuildingAFragment extends Fragment {


    public class SecondActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.fragment_building_a2);
        }
    }
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
        View view = inflater.inflate(R.layout.fragment_building_a2, container, false);
        floorContainer = view.findViewById(R.id.floor_container);
        searchBar = view.findViewById(R.id.search_bar);

        view.findViewById(R.id.btn_switch_floor_a1).setOnClickListener(v -> loadFloorLayout(R.layout.building_a_1st_floor));
        view.findViewById(R.id.btn_switch_floor_a2).setOnClickListener(v -> loadFloorLayout(R.layout.building_a_2nd_floor));
        view.findViewById(R.id.btn_switch_floor_a3).setOnClickListener(v -> loadFloorLayout(R.layout.building_a_3rd_floor));

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
            case "rpo":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_rpo");
                break;
            case "comlab2":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_comlab2");
                break;
            case "comlab1":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_comlab1");
                break;
            case "admissions":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_admissions");
                break;
            case "hrdoffice":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_hrdoffice");
                break;
            case "presoffice2":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_presoffice");
                break;
            case "execoffice":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_execoffice");
                break;
            case "boardroom":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_boardroom");
                break;
            //
            case "col":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_col");
                break;
            case "mootcourt":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_mootcourt");
                break;
            case "testingroom":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_testingroom");
                break;
            case "copwell":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_copwell");
                break;
            case "registrar":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_registrar");
                break;
            case "lobby":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_lobby");
                break;
            case "cashier":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_cashier");
                break;
            case "iqaoffice":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_iqaoffice");
                break;
            case "datacenter":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_datacenter");
                break;
            case "chairman":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_chairman");
                break;
            case "presoffice":
                loadFloorLayout(R.layout.building_a_1st_floor);
                highlightLabel("label_room_presoffice");
                break;
            // 2nd floor
            case "chemstg":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_chemstg");
                break;
            case "chemlab":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_chemlab");
                break;
            //
            case "a-216":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_a216");
                break;
            case "physlab":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_physlab");
                break;
            case "biolab":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_biolab");
                break;
            case "crimrm":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_crimrm");
                break;
            case "cra2r":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_cra2r");
                break;
            case "blstcrm":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_blstcrm");
                break;
            case "a-221":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_a221");
                break;
            case "a-219":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_a219");
                break;
            case "a-217":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_a217");
                break;
            case "ceasfac":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_ceasf");
                break;
            case "ceas":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_ceas");
                break;
            case "simrm":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_simrm");
                break;
            case "a-202":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_a202");
                break;
            case "a-204":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_a204");
                break;
            case "ccje":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_ccje");
                break;
            case "crimlab1":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_crimlab1");
                break;
            case "crimlab2":
                loadFloorLayout(R.layout.building_a_2nd_floor);
                highlightLabel("label_room_crimlab2");
                break;
            case "psychlab3":
                loadFloorLayout(R.layout.building_a_3rd_floor);
                highlightLabel("label_room_psychlab3");
                break;

            case "avr":
                loadFloorLayout(R.layout.building_a_3rd_floor);
                highlightLabel("label_room_avr");
                break;
            case "comlab4":
                loadFloorLayout(R.layout.building_a_3rd_floor);
                highlightLabel("label_room_comlab4");
                break;
            case "netlab":
                loadFloorLayout(R.layout.building_a_3rd_floor);
                highlightLabel("label_room_netlab");
                break;
            case "futcomlab":
                loadFloorLayout(R.layout.building_a_3rd_floor);
                highlightLabel("label_room_futcomlab");
                break;
            case "stockrm":
                loadFloorLayout(R.layout.building_a_3rd_floor);
                highlightLabel("label_room_stockrm");
                break;
            case "psychlab1":
                loadFloorLayout(R.layout.building_a_3rd_floor);
                highlightLabel("label_room_psychlab1");
                break;
            case "psychlab2":
                loadFloorLayout(R.layout.building_a_3rd_floor);
                highlightLabel("label_room_psychlab2");
                break;
            case "a-317":
                loadFloorLayout(R.layout.building_a_3rd_floor);
                highlightLabel("label_room_a317");
                break;
            case "a-318":
                loadFloorLayout(R.layout.building_a_3rd_floor);
                highlightLabel("label_room_a318");
                break;
            case "a-315":
                loadFloorLayout(R.layout.building_a_3rd_floor);
                highlightLabel("label_room_a315");
                break;
            case "comlab3":
                loadFloorLayout(R.layout.building_a_3rd_floor);
                highlightLabel("label_room_comlab3");
                break;
            case "nurselab":
                loadFloorLayout(R.layout.building_a_3rd_floor);
                highlightLabel("label_room_nurselab");
                break;
            case "studiorm":
                loadFloorLayout(R.layout.building_a_3rd_floor);
                highlightLabel("label_room_studiorm");
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
