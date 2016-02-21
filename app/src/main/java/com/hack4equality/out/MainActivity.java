package com.hack4equality.out;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import module.favorite.Fragment_favorite;
import module.home.Fragment_dialog_msn;
import module.home.Fragment_home;
import module.msn.Fragment_msn;
import module.travel.Fragment_travel;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    Fragment fragment;
    FragmentManager fragmentManager;

    RecyclerView recyclerView;

    String TAG = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("fb","FLOATING BUTTON");
                Fragment_dialog_msn fragment_dialog_msn = new Fragment_dialog_msn();
                fragment_dialog_msn.show(getSupportFragmentManager(), Fragment_dialog_msn.TAG);

            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);
        navigationView.getMenu().performIdentifierAction(R.id.nav_home, 0);

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
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {

            TAG = Fragment_home.TAG;
            Fragment_home fragmentHome = new Fragment_home();

            if (fragmentManager.findFragmentByTag(TAG) != null) {
                fragment = fragmentManager.findFragmentByTag(TAG);
            }else {

                fragment = fragmentHome;
            }

        } else if (id == R.id.nav_favorite) {

            TAG = Fragment_favorite.TAG;
            Fragment_favorite fragmentFavorite = new Fragment_favorite();

            if (fragmentManager.findFragmentByTag(TAG) != null) {
                fragment = fragmentManager.findFragmentByTag(TAG);
            }else {

                fragment = fragmentFavorite;
            }
        } else if (id == R.id.nav_travel) {

            TAG = Fragment_travel.TAG;
            Fragment_travel fragmentTravel= new Fragment_travel();

            if (fragmentManager.findFragmentByTag(TAG) != null) {
                fragment = fragmentManager.findFragmentByTag(TAG);
            }else {

                fragment = fragmentTravel;
            }
        } else if (id == R.id.nav_close) {

            this.finish();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);

        fragmentTransaction.setCustomAnimations(R.anim.slide_from_right, R.anim.shrink_out, R.anim.slide_from_left, R.anim.shrink_out);
        fragmentTransaction.replace(R.id.container_out, fragment, TAG).commit();

        return true;
    }
}
