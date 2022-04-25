package com.oop.laba2.KAA;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            Objects.requireNonNull(this.getSupportActionBar()).hide();
        } catch (NullPointerException ignored) {
        }
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.navigation_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new Home()).commit();
                    return true;

                case R.id.navigation_news:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new News()).commit();
                    return true;

                case R.id.navigation_collections:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new Collections()).commit();
                    return true;

                case R.id.navigation_profile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainerView, new Profile()).commit();
                    return true;

                default:
                    return false;
            }
        });
    }
}