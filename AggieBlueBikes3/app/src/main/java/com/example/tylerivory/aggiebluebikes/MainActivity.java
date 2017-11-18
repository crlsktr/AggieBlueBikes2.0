package com.example.tylerivory.aggiebluebikes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OpenFeed() {
        Intent intent = new Intent(this, ABBFeedActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.abb_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId()) {
            case R.id.ABB_menuItem_feed:
                OpenFeed();
                return true;
            case R.id.ABB_menuItem_help:
                //showHelp();
                return true;
            case R.id.ABB_menuItem_checkout:
                OpenCheckout();
                return true;
            case R.id.ABB_menuItem_resourceMap:
                OpenResourceMap();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void OpenResourceMap() {
        Intent intent = new Intent(this, BikeResourceMap.class);
        startActivity(intent);
    }

    private void OpenCheckout() {
        Intent intent = new Intent(this, ABBCheckoutActivity.class);
        startActivity(intent);
    }
}
