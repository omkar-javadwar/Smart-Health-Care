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

public class AddDoctorFragment extends AppCompatActivity {

    EditText dname,dgen,dspe,dadd,dyoe,dph,demail;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_doctor);
        getSupportActionBar().setTitle("SHP Doctor");

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        ref = FirebaseDatabase.getInstance().getReference().child("Doctor");

        Button button= (Button)findViewById(R.id.btnaddoc);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dname = (EditText) findViewById(R.id.docname);
                dgen = (EditText) findViewById(R.id.docgender);
                dspe = (EditText) findViewById(R.id.docspeciality);
                dadd = (EditText) findViewById(R.id.docaddress);
                dyoe = (EditText) findViewById(R.id.docyear);
                dph = (EditText) findViewById(R.id.docmno);
                demail = (EditText) findViewById(R.id.docemail);

                if( TextUtils.isEmpty(dname.getText())){
                    dname.setError( "Doctor name is required!" );

                }
                else if( TextUtils.isEmpty(dgen.getText())){
                    dgen.setError( "Gender is required!" );

                }
                else if( TextUtils.isEmpty(dspe.getText())){
                    dspe.setError( "Speciality of that Clinic is required!" );

                }
                else if( TextUtils.isEmpty(dadd.getText())){
                    dadd.setError( "Address is required!" );

                }
                else if( TextUtils.isEmpty(dph.getText())){
                    dph.setError( "Mobile no. is required!" );

                }
                else if( TextUtils.isEmpty(demail.getText())){
                    demail.setError( "Email is required!" );

                }
                else {
                    String dnm = dname.getText().toString().trim();
                    String dg = dgen.getText().toString().trim();
                    String dsp = dspe.getText().toString().trim();
                    String dad = dadd.getText().toString().trim();
                    String dy = dyoe.getText().toString().trim();
                    String dmno = dph.getText().toString().trim();
                    String dem = demail.getText().toString().trim();

                    ref.child(dnm).setValue(dname.toString());
                    ref.child(dnm).child("name").setValue(dnm);
                    ref.child(dnm).child("gender").setValue(dg);
                    ref.child(dnm).child("speciality").setValue(dsp);
                    ref.child(dnm).child("address").setValue(dad);
                    ref.child(dnm).child("year").setValue(dy);
                    ref.child(dnm).child("phone").setValue(dmno);
                    ref.child(dnm).child("email").setValue(dem);

                    Toast.makeText(getApplicationContext(), " Doctor Added successfully ", Toast.LENGTH_SHORT).show();
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
