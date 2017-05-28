package com.sasoftgroups.blooddonorlk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MyProfile extends AppCompatActivity {

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
                Intent intent = new Intent(MyProfile.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.donateList:
                Intent intents = new Intent(MyProfile.this, HomePage.class);
                startActivity(intents);
                return true;
            case R.id.requestBlood:
                Intent intentss = new Intent(MyProfile.this, HomePage.class);
                startActivity(intentss);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
    }
}
