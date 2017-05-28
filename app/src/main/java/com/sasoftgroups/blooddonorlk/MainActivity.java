package com.sasoftgroups.blooddonorlk;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.Home:
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.donateList:
                Intent intents = new Intent(MainActivity.this, HomePage.class);
                startActivity(intents);
                return true;
            case R.id.requestBlood:
                Intent intentss = new Intent(MainActivity.this, HomePage.class);
                startActivity(intentss);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Click_DonateList(View view) {
        Intent intent = new Intent(MainActivity.this, HomePage.class);
        startActivity(intent);
    }

    public void Click_MyProfile(View view) {
        Intent intent = new Intent(MainActivity.this, MyProfile.class);
        startActivity(intent);
    }

    public void Click_NewDonate(View view) {
        Intent intent = new Intent(MainActivity.this, RequestBlood.class);
        startActivity(intent);
    }

    public void Click_Contacts(View view) {
        Intent intent = new Intent(MainActivity.this, Contacts.class);
        startActivity(intent);
    }
}
