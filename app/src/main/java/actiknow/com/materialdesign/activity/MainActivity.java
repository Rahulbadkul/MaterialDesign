package actiknow.com.materialdesign.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import actiknow.com.materialdesign.R;
import actiknow.com.materialdesign.adapter.DesignDemoPagerAdapter;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById (R.id.drawer_layout);
        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);
        ActionBar actionBar = getSupportActionBar ();
        actionBar.setHomeAsUpIndicator (R.drawable.ic_menu);
        actionBar.setDisplayHomeAsUpEnabled (true);

        NavigationView navigationView = (NavigationView) findViewById (R.id.navigation_view);
        navigationView.setNavigationItemSelectedListener (new NavigationView.OnNavigationItemSelectedListener () {
            @Override
            public boolean onNavigationItemSelected (MenuItem menuItem) {
                menuItem.setChecked (true);
                mDrawerLayout.closeDrawers ();
                if(menuItem.getTitle ().toString ().equalsIgnoreCase (getResources ().getString (R.string.nav_item_attachment).toString ())){
                    Intent intent = new Intent (MainActivity.this, TooltipActivity.class);
                    startActivity (intent);
                }

                Toast.makeText (MainActivity.this, menuItem.getTitle (), Toast.LENGTH_LONG).show ();
                return true;
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById (R.id.fab);
        fab.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick (View v) {
                Snackbar.make (findViewById (R.id.coordinator), "I'm a Snackbar", Snackbar.LENGTH_LONG).setAction ("Action", new View.OnClickListener () {
                    @Override
                    public void onClick (View v) {
                        Toast.makeText (MainActivity.this, "Snackbar Action", Toast.LENGTH_LONG).show ();
                    }
                }).show ();
            }
        });

        DesignDemoPagerAdapter adapter = new DesignDemoPagerAdapter (getSupportFragmentManager ());
        ViewPager viewPager = (ViewPager) findViewById (R.id.viewpager);
        viewPager.setAdapter (adapter);
        TabLayout tabLayout = (TabLayout) findViewById (R.id.tablayout);
        tabLayout.setupWithViewPager (viewPager);

    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId ();

        switch (id) {
            case android.R.id.home:
                mDrawerLayout.openDrawer (GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected (item);
    }
}
