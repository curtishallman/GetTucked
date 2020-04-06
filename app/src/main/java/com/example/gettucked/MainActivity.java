package com.example.gettucked;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


import com.google.android.material.bottomnavigation.BottomNavigationView;




public class MainActivity extends AppCompatActivity {

    public static HomeFragment homeFragment = new HomeFragment();
    public static BookingsFragment bookingsFragment = new BookingsFragment();
    public static ProfileFragment profileFragment = new ProfileFragment();
    public static Fragment selectedFragment = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);






        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new HomeFragment()).commit();



    }




    public BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {



            switch(item.getItemId()) {
                case R.id.nav_home:
                    selectedFragment = homeFragment;
                    break;
                case R.id.nav_bookings:
                    selectedFragment = bookingsFragment;
                    break;
                case R.id.nav_profile:
                    selectedFragment = profileFragment;
                    break;
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectedFragment).addToBackStack(null).commit();

            return true;
        }
    };




}
