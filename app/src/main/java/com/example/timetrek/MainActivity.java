package com.example.timetrek;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FragmentManager fragmentManager = getSupportFragmentManager();
    BottomNavigationView bottomNavigationView;

    HomeFragment homeFragment = new HomeFragment();
    SearchFragment searchFragment = new SearchFragment();
    CollectionFragment collectionFragment = new CollectionFragment();
    ProfileFragment profileFragment = new ProfileFragment();
    Fragment currentFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView = findViewById(R.id.bottom_navbar);

        fragmentManager.beginTransaction().add(R.id.page_container, homeFragment).hide(homeFragment).commit();
        fragmentManager.beginTransaction().add(R.id.page_container, searchFragment).hide(searchFragment).commit();
        fragmentManager.beginTransaction().add(R.id.page_container, collectionFragment).hide(collectionFragment).commit();
        fragmentManager.beginTransaction().add(R.id.page_container, profileFragment).hide(profileFragment).commit();

        fragmentManager.beginTransaction().show(homeFragment).commit();
        currentFragment = homeFragment;

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if(item.getItemId() == R.id.home_nav){
                fragmentManager.beginTransaction().hide(currentFragment).show(homeFragment).commit();
                currentFragment = homeFragment;
                return true;
            } else if(item.getItemId() == R.id.collection_nav){
                fragmentManager.beginTransaction().hide(currentFragment).show(collectionFragment).commit();
                currentFragment = collectionFragment;
                return true;
            } else if(item.getItemId() == R.id.search_nav) {
                fragmentManager.beginTransaction().hide(currentFragment).show(searchFragment).commit();
                currentFragment = searchFragment;
                return true;
            } else if(item.getItemId() == R.id.profile_nav){
                fragmentManager.beginTransaction().hide(currentFragment).show(profileFragment).commit();
                currentFragment = profileFragment;
                return true;
            }

            return false;
        });
    }
}