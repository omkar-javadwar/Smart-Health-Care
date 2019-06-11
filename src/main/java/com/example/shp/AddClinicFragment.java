package com.example.shp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AddClinicFragment extends AppCompatActivity {
    EditText hname,htreat,haddress,hyoe,hno,hemail;

    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_clinic);
        getSupportActionBar().setTitle("SHP Doctor");

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        reff = FirebaseDatabase.getInstance().getReference().child("Clinic");

        Button b =(Button)findViewById(R.id.btnaddhos);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                hname = (EditText) findViewById(R.id.hosname);
                htreat = (EditText) findViewById(R.id.hosspeciality);
                haddress= (EditText) findViewById(R.id.hosaddress);
                hyoe = (EditText) findViewById(R.id.hosyear);
                hno = (EditText) findViewById(R.id.hospno);
                hemail = (EditText) findViewById(R.id.hosemail);

                if( TextUtils.isEmpty(hname.getText())){
                    hname.setError( "Clinic name is required!" );

                }
                else if( TextUtils.isEmpty(htreat.getText())){
                    htreat.setError( "Speciality of that Clinic is required!" );

                }
                else if( TextUtils.isEmpty(haddress.getText())){
                    haddress.setError( "Address is required!" );

                }
                else if( TextUtils.isEmpty(hno.getText())){
                    hno.setError( "Mobile no. is required!" );

                }
                else if( TextUtils.isEmpty(hemail.getText())){
                    hemail.setError( "Email is required!" );

                }
                else {

                    String hnm = hname.getText().toString().trim();
                    String ht = htreat.getText().toString().trim();
                    String had = haddress.getText().toString().trim();
                    String hy = hyoe.getText().toString().trim();
                    String hp = hno.getText().toString().trim();
                    String he = hemail.getText().toString().trim();

                    reff.child(hnm).setValue(hname.toString());
                    reff.child(hnm).child("name").setValue(hnm);
                    reff.child(hnm).child("speciality").setValue(ht);
                    reff.child(hnm).child("address").setValue(had);
                    reff.child(hnm).child("year").setValue(hy);
                    reff.child(hnm).child("phone").setValue(hp);
                    reff.child(hnm).child("email").setValue(he);

                    Toast.makeText(getApplicationContext(), " Clinic Added successfully ", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}

