package com.sasoftgroups.blooddonorlk;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import com.firebase.client.Firebase;

public class RequestBlood extends AppCompatActivity {
    private Firebase mref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_blood);
        loadSpinner();
        Firebase.setAndroidContext(this);
        mref = new Firebase("https://srilankablood-cad8d.firebaseio.com/blood/");
    }

    public void sendRequest(View view) {
        String blood = ((Spinner)findViewById(R.id.blood_spinner)).getSelectedItem().toString();
        String Name = ((EditText)findViewById(R.id.txtName)).getText().toString();
        String NumberOne = ((EditText)findViewById(R.id.txtContactNo1)).getText().toString();
        String NumberTwo = ((EditText)findViewById(R.id.txtContactNoTwo)).getText().toString();
       // String Description = ((EditText)findViewById(R.id.txtDescription)).getText().toString();

        try {
            Firebase mRefChild = mref.push();
            mRefChild.child("blood").setValue(blood);
            mRefChild.child("Name").setValue(Name);
            mRefChild.child("ContactOne").setValue(NumberOne);
            mRefChild.child("ContactTwo").setValue(NumberTwo);

            AlertDialog alertDialog = new AlertDialog.Builder(RequestBlood.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Your Blood Request Successfully Added to the App");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Thnaks",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                            Intent intent = new Intent(RequestBlood.this, HomePage.class);
                            startActivity(intent);
                        }
                    });
            alertDialog.show();

        } catch (Exception e) {
            AlertDialog alertDialog = new AlertDialog.Builder(RequestBlood.this).create();
            alertDialog.setTitle("Alert");
            alertDialog.setMessage("Error, Please try again latter");
            alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.dismiss();
                        }
                    });
            alertDialog.show();
        }
    }

    public void loadSpinner(){
        Spinner spinner = (Spinner) findViewById(R.id.blood_spinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.blood_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }
}
