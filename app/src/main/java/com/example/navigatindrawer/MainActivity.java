package com.example.navigatindrawer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    NavigationView navigationView;
    AppBarLayout appBarLayout;
    Toolbar toolbar;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawer);
        appBarLayout=findViewById(R.id.appBar);
        toolbar=findViewById(R.id.toolBar);
        navigationView=findViewById(R.id.navView);

        setSupportActionBar(toolbar);
        ActionBarDrawerToggle toggle;
        toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open_drawer,R.string.close_drawer);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId()==R.id.home)
                {
                    addFragment(new HomeFragment());
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                if(item.getItemId()==R.id.settings)
                {
                    Toast.makeText(MainActivity.this, "Settings Fragment", Toast.LENGTH_LONG).show();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }
                if(item.getItemId()==R.id.logout)
                {
                    Toast.makeText(MainActivity.this, "LogOut Fragment", Toast.LENGTH_LONG).show();
                    drawerLayout.closeDrawer(Gravity.LEFT);
                }

                return true;
            }
        });


    }

    private void addFragment(HomeFragment fragment) {
        FragmentManager manager=getSupportFragmentManager();
        FragmentTransaction transaction=manager.beginTransaction();
        transaction.add(R.id.frame,fragment);
        transaction.commit();
    }
}