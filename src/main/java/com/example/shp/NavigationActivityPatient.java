package com.example.shp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

public class NavigationActivityPatient extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private DrawerLayout drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_patient);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawer = findViewById(R.id.drawer_layout_patient);
        NavigationView navigationView = findViewById(R.id.nav_view_doctor);
        navigationView.setNavigationItemSelectedListener(this);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
            navigationView.setCheckedItem(R.id.nav_home);
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {

            case R.id.nav_home:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new HomeFragment()).commit();
                break;

            case R.id.nav_doctors:
                Intent intent2 = new Intent(getApplicationContext(), DoctorsFragment.class);
                startActivity(intent2);
                /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new DoctorsFragment()).commit();*/
                break;

            case R.id.nav_appointments:
                Intent intent = new Intent(getApplicationContext(), AppointmentFragment.class);
                startActivity(intent);
                break;

            case R.id.nav_services:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ServicesFragment()).commit();
                break;

            case R.id.nav_clinics:
                Intent intent1 = new Intent(getApplicationContext(), ClinicsFragment.class);
                startActivity(intent1);
                /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ClinicsFragment()).commit();*/
                break;

            case R.id.nav_aboutus:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new AboutusFragment()).commit();
                break;

            case R.id.nav_contact:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new ContactusFragment()).commit();
                break;

            case R.id.nav_setting:
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SettingsFragment()).commit();
                break;

            case R.id.nav_feedback:
                Intent intent3 = new Intent(getApplicationContext(), FeedbackFragment.class);
                startActivity(intent3);
                /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new FeedbackFragment()).commit();*/
                break;

            case R.id.nav_shared:
                /*Intent intent4 = new Intent(getApplicationContext(), SharedFragment.class);
                startActivity(intent4);*/
                Toast.makeText(this,"Received successfully",Toast.LENGTH_SHORT).show();
                /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        new SharedFragment()).commit();*/
                break;

            case R.id.nav_logout:
                System.exit(0);
                break;
        }

        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
