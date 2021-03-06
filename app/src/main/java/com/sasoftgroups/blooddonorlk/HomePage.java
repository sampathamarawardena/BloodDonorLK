package com.sasoftgroups.blooddonorlk;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.Map;

public class HomePage extends AppCompatActivity {

    ListView BloodRequestList;

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
                Intent intent = new Intent(HomePage.this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.donateList:
                Intent intents = new Intent(HomePage.this, HomePage.class);
                startActivity(intents);
                return true;
            case R.id.requestBlood:
                Intent intentss = new Intent(HomePage.this, HomePage.class);
                startActivity(intentss);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        dataGet();
    }



    public void dataGet() {
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference().child("blood");
        ref.addListenerForSingleValueEvent(new ValueEventListener() {
            public void onDataChange(DataSnapshot dataSnapshot) {
                //Get map of users in datasnapshot
                collectPhoneNumbers((Map<String, Object>) dataSnapshot.getValue());
            }

            public void onCancelled(DatabaseError databaseError) {
                //handle databaseError
            }
        });

    }

    private void collectPhoneNumbers(Map<String,Object> users) {
        BloodRequestList = (ListView) findViewById(R.id.ListView_RequestList);

        ArrayList<String> dataList = new ArrayList<>();
        ArrayList<String> BloodType = new ArrayList<>();

        //iterate through each user, ignoring their UID

        for (Map.Entry<String, Object> entry : users.entrySet()){
            Map singleUser = (Map) entry.getValue();
            dataList.add((String) "\" " + singleUser.get("blood") + " \" Blood Need, Contact : "  + (String)singleUser.get("Name") +  " - " + (String)singleUser.get("ContactOne") + " / " + (String)singleUser.get("ContactTwo"));

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, dataList);
        BloodRequestList.setAdapter(adapter);
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);

    }
}
