package com.example.tambahrizki.heathtracker;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tambahrizki.heathtracker.Workout.PlayActivity;

public class MenuActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

        TabLayout tabLayout;
        ViewPager viewPager;
        Context context;
        NavigationView navigationView;
        DbHelper dbHelper = new DbHelper(getBaseContext());
    protected Cursor cursor;


    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = findViewById(R.id.nav_view);
        navigationView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MenuActivity.this, "Kilk", Toast.LENGTH_SHORT).show();
            }
        });
//        profil = findViewById(R.id.profile);
//        profil.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(context, "Aww", Toast.LENGTH_SHORT).show();
//            }
//        });
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        AdapterPage adapter = new AdapterPage(getSupportFragmentManager());
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.calculator);
        tabLayout.getTabAt(1).setIcon(R.drawable.clock);
        tabLayout.getTabAt(2).setIcon(R.drawable.workout);
        tabLayout.getTabAt(3).setIcon(R.drawable.calendar);
        tabLayout.getTabAt(4).setIcon(R.drawable.chart);
        tabLayout.getTabAt(5).setIcon(R.drawable.notebook);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View headerView = navigationView.getHeaderView(0);
        TextView nama = headerView.findViewById(R.id.navbar_nama);
        TextView email = headerView.findViewById(R.id.navbar_email);
        ImageView img = headerView.findViewById(R.id.navbar_imageView);
        int profile [] = {R.drawable.profile, R.drawable.profile_female};

        dbHelper = new DbHelper(getBaseContext());
        SQLiteDatabase dbGet = dbHelper.getReadableDatabase();
        cursor = dbGet.rawQuery("SELECT * FROM biodata;", null);
        cursor.moveToFirst();

        nama.setText(cursor.getString(1));
        email.setText(cursor.getString(0));
        if (cursor.getString(2).equalsIgnoreCase("Laki-laki"))
        {
            img.setImageResource(profile[0]);
        }
        else
        {
            img.setImageResource(profile[1]);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        cursor.moveToFirst();
        if (id == R.id.nav_profile) {
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_about) {
            Intent intent = new Intent(this, TentangActivity.class);
            startActivity(intent);
        } else if (id == R.id.nav_logout){
            Intent intent = new Intent(this, RegisterActivity.class);
            startActivity(intent);
            SQLiteDatabase data = dbHelper.getWritableDatabase();
            String sql = "delete from biodata;";
            String sql2 = "delete from stepWorkout;";
            String sql3 = "delete from beratbadan;";
            data.execSQL(sql);
            data.execSQL(sql2);
            data.execSQL(sql3);
        }
        cursor.close();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
