package com.example.shp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class AppointmentFragment extends AppCompatActivity {
    EditText name,address,age,bloodgroup,mobileno,time;

    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_appointment);
        getSupportActionBar().setTitle("SHP Patient");

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        reff = FirebaseDatabase.getInstance().getReference().child("Appointment");

        Button b =(Button)findViewById(R.id.btnappointment);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = (EditText) findViewById(R.id.name);
                address= (EditText) findViewById(R.id.address);
                bloodgroup = (EditText) findViewById(R.id.bloodgroup);
                age = (EditText) findViewById(R.id.age);
                mobileno= (EditText) findViewById(R.id.mob_no);
                time = (EditText) findViewById(R.id.time);

                if( TextUtils.isEmpty(name.getText())){
                    name.setError( "Patient Name is required!" );

                }
                else if( TextUtils.isEmpty(address.getText())){
                    address.setError( "Address is required!" );

                }
                else if( TextUtils.isEmpty(bloodgroup.getText())){
                    bloodgroup.setError( "BloodGroup is required!" );

                }
                else if( TextUtils.isEmpty(mobileno.getText())){
                    mobileno.setError( "Mobile no. is required!" );

                }
                else if( TextUtils.isEmpty(time.getText())){
                    time.setError( "Time is required!" );

                }
                else {

                    String nm = name.getText().toString().trim();
                    String ad = address.getText().toString().trim();
                    String bg = bloodgroup.getText().toString().trim();
                    String ag = age.getText().toString().trim();
                    String mn = mobileno.getText().toString().trim();
                    String tm = time.getText().toString().trim();

                    reff.child(nm).setValue(name.toString());
                    reff.child(nm).child("name").setValue(nm);
                    reff.child(nm).child("age").setValue(ag);
                    reff.child(nm).child("address").setValue(ad);
                    reff.child(nm).child("bloodgroup").setValue(bg);
                    reff.child(nm).child("mobileno").setValue(mn);
                    reff.child(nm).child("time").setValue(tm);

                    Toast.makeText(getApplicationContext(), " Appointment booked successfully ", Toast.LENGTH_SHORT).show();

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
