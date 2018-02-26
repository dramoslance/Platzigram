package com.dramit.platzigram.view;


import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.dramit.platzigram.R;
import com.dramit.platzigram.view.fragment.HomeFragment;
import com.dramit.platzigram.view.fragment.ProfileFragment;
import com.dramit.platzigram.view.fragment.SearchFragment;

public class ContainerActivity extends AppCompatActivity {


    private BottomNavigationView bottomNavigationView;
    private Fragment fragment;
    private FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);


        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                displayView(item.getItemId());
                return true;
            }
        });

        displayView(R.id.action_home);
    }

    public void displayView(int viewId){

        fragment = null;
        String title = getResources().getString(R.string.app_name);

        switch(viewId){

            case R.id.action_home:
                fragment = new HomeFragment();
                title = getResources().getString(R.string.menu_home);
                break;

            case R.id.action_search:
                fragment = new SearchFragment();
                title = getResources().getString(R.string.menu_search);
                break;

            case R.id.action_user:
                fragment = new ProfileFragment();
                title = getResources().getString(R.string.menu_user);
                break;
        }

        if(fragment != null){
            fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.container, fragment);
            fragmentTransaction.commit();
        }

        if(getSupportActionBar() != null){
            getSupportActionBar().setTitle(title);
        }


    }

}
