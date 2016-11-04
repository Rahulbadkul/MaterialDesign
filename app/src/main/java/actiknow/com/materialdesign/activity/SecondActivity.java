package actiknow.com.materialdesign.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import actiknow.com.materialdesign.R;


public class SecondActivity extends AppCompatActivity {
    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_second);

        Toolbar toolbar = (Toolbar) findViewById (R.id.toolbar);
        setSupportActionBar (toolbar);
        getSupportActionBar ().setDisplayHomeAsUpEnabled (true);

        CollapsingToolbarLayout collapsingToolbar = (CollapsingToolbarLayout) findViewById (R.id.collapsing_toolbar);
        collapsingToolbar.setTitle ("Second Activity");
    }
}
