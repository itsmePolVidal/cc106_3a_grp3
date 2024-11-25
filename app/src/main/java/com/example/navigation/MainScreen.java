package com.example.navigation;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.TextView;
import java.time.LocalDate;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;

public class MainScreen extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    FloatingActionButton fab;
    DrawerLayout drawerLayout;
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    private TextView monthYearText;
    private RecyclerView calendarRecyclerView;
    private LocalDate selectedDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        // Toolbar setup
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Drawer setup
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // Toggle for the navigation drawer
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open_nav, R.string.close_nav);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Bottom navigation setup
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        fab = findViewById(R.id.fab);

        // Set initial fragment if there's no saved state
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fra_layout,new Fragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }

        // Bottom Navigation item selection handling
        bottomNavigationView.setBackground(null);
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int id = item.getItemId();

            if (id == R.id.home) {
                replaceFragment(new HomeFragment());
            } else if (id == R.id.gallery) {
                replaceFragment(new GalleryFragment());
            } else if (id == R.id.schedule) {
                replaceFragment(new ScheduleFragment());
            } else if (id == R.id.calendar) {
                replaceFragment(new CalendarFragment());
            }

            return true;
        });

        // FAB click event
        fab.setOnClickListener(view -> showBottomDialog());



        // Handle window insets for proper layout padding
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
                    drawerLayout.closeDrawer(GravityCompat.START); // Close the drawer if open
                } else {
                    // Do nothing to avoid navigating back
                }
            }
        });

    }

    private void replaceFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fra_layout, fragment);
        fragmentTransaction.commit();
    }

    private void showBottomDialog() {
        final Dialog dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.bottomlayout);

        LinearLayout buildingALayout = dialog.findViewById(R.id.layoutphoto); // Reuse layout for Building A
        LinearLayout buildingBLayout = dialog.findViewById(R.id.layoutfave);  // Reuse layout for Building B
        LinearLayout buildingCLayout = dialog.findViewById(R.id.layoutreminder); // Reuse layout for Building C
        ImageView cancelButton = dialog.findViewById(R.id.cancelButton);

        // Building A
        buildingALayout.setOnClickListener(v -> {
            dialog.dismiss();
            showImageDialog(R.drawable.af, "Building A Dictionary");
        });

        // Building B
        buildingBLayout.setOnClickListener(v -> {
            dialog.dismiss();
            showImageDialog(R.drawable.bf, "Building B Dictionary");
        });

        // Building C
        buildingCLayout.setOnClickListener(v -> {
            dialog.dismiss();
            showImageDialog(R.drawable.cf, "Building C Dictionary");
        });

        // Cancel button
        cancelButton.setOnClickListener(view -> dialog.dismiss());

        dialog.show();
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation;
        dialog.getWindow().setGravity(Gravity.BOTTOM);
    }

    private void showImageDialog(int imageResource, String title) {
        final Dialog imageDialog = new Dialog(this);
        imageDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        imageDialog.setContentView(R.layout.image_dialog);

        ImageView imageView = imageDialog.findViewById(R.id.dialogImageView);
        TextView titleView = imageDialog.findViewById(R.id.dialogTitle);

        imageView.setImageResource(imageResource);
        titleView.setText(title);

        imageDialog.show();
        imageDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        imageDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.nav_home) {
            replaceFragment(new HomeFragment());
        } else if (itemId == R.id.nav_buildingA) {
            replaceFragment(new BuildingAFragment());
        } else if (itemId == R.id.nav_buildingB) {
            replaceFragment(new BuildingBFragment());
        } else if (itemId == R.id.nav_buildingC) {
            replaceFragment(new BuildingCFragment());
        } else if (itemId == R.id.nav_about_us) {
            replaceFragment(new AboutUsFragment());
        } else if (itemId == R.id.nav_logout) {
            Toast.makeText(this, "Logout!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainScreen.this, Login.class);
            startActivity(intent);
        }

        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    private void initWidgets()
    {
        calendarRecyclerView = findViewById(R.id.calendarRecyclerView);
        monthYearText = findViewById(R.id.monthYearTV);
    }

}
