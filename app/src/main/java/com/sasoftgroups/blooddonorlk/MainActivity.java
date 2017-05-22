package com.sasoftgroups.blooddonorlk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

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
        Intent intent = new Intent(MainActivity.this, HomePage.class);
        startActivity(intent);
    }

    public void Click_NewDonate(View view) {
        Intent intent = new Intent(MainActivity.this, HomePage.class);
        startActivity(intent);
    }

    public void Click_Contacts(View view) {
        Intent intent = new Intent(MainActivity.this, HomePage.class);
        startActivity(intent);
    }
}
