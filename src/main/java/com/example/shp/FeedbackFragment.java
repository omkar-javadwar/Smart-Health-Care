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

public class FeedbackFragment extends AppCompatActivity {

    EditText fd,fn,ft,fad,fph,femail,frel,fan,fco;

    DatabaseReference reff;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_feedback);
        getSupportActionBar().setTitle("SHP Patient");

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        reff = FirebaseDatabase.getInstance().getReference().child("Feedback");

        Button b =(Button)findViewById(R.id.btnfeedback);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                fd = (EditText) findViewById(R.id.formdate);
                ft = (EditText) findViewById(R.id.formtype);
                fn = (EditText) findViewById(R.id.formname);
                fad = (EditText) findViewById(R.id.formadd);
                fph = (EditText) findViewById(R.id.formpno);
                femail = (EditText) findViewById(R.id.formemail);
                frel = (EditText) findViewById(R.id.formrel);
                fco = (EditText) findViewById(R.id.compliment);
                fan = (EditText) findViewById(R.id.formcom);

                if( TextUtils.isEmpty(fd.getText())){
                    fd.setError( "Date is required!" );

                }
                else if( TextUtils.isEmpty(fn.getText())){
                    fn.setError( "Name is required!" );

                }
                else if( TextUtils.isEmpty(fad.getText())){
                    fad.setError( "Address is required!" );

                }
                else if( TextUtils.isEmpty(fph.getText())){
                    fph.setError( "Mobile no. is required!" );

                }
                else if( TextUtils.isEmpty(femail.getText())){
                    femail.setError( "Email is required!" );

                }
                else if( TextUtils.isEmpty(fco.getText())){
                    fco.setError( "required!" );

                }
                else if( TextUtils.isEmpty(fan.getText())){
                    fan.setError( "required!" );

                }
                else {
                    String ud = fd.getText().toString().trim();
                    String ut = ft.getText().toString().trim();
                    String un = fn.getText().toString().trim();
                    String uad = fad.getText().toString().trim();
                    String uph = fph.getText().toString().trim();
                    String uem = femail.getText().toString().trim();
                    String urel = frel.getText().toString().trim();
                    String uco = fco.getText().toString().trim();
                    String uan = fan.getText().toString().trim();

                    reff.child(un).setValue(fn.toString());
                    reff.child(un).child("name").setValue(un);
                    reff.child(un).child("date").setValue(ud);
                    reff.child(un).child("type of feedback").setValue(ut);
                    reff.child(un).child("address").setValue(uad);
                    reff.child(un).child("phone").setValue(uph);
                    reff.child(un).child("email").setValue(uem);
                    reff.child(un).child("relation").setValue(urel);
                    reff.child(un).child("compliment").setValue(uco);
                    reff.child(un).child("complaint").setValue(uan);

                    Toast.makeText(getApplicationContext(), " Feedback Submitted successfully ", Toast.LENGTH_SHORT).show();

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
