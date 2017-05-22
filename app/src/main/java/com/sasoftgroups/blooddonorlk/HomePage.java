package com.sasoftgroups.blooddonorlk;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class HomePage extends AppCompatActivity {

    ListView BloodRequestList;

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

        ArrayList<String> phoneNumbers = new ArrayList<>();
        ArrayList<String> BloodType = new ArrayList<>();

        //iterate through each user, ignoring their UID

        for (Map.Entry<String, Object> entry : users.entrySet()){

            //Get user map
            Map singleUser = (Map) entry.getValue();
            //Get phone field and append to list
            phoneNumbers.add((String) singleUser.get("Name") + " looking "  + (String)singleUser.get("blood") + " blood" + " Contact Numbers " + (String)singleUser.get("ContactOne") + " / " + (String)singleUser.get("ContactTwo"));

        }


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, phoneNumbers);
        BloodRequestList.setAdapter(adapter);
        findViewById(R.id.loadingPanel).setVisibility(View.GONE);

       // System.out.println(phoneNumbers.toString());
       // System.out.println(BloodType.toString());


    }
}
