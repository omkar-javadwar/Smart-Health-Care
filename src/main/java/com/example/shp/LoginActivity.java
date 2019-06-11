package com.example.shp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class LoginActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton Rd1, Rd2;
    TextView textView;

    EditText Name;
    EditText Password;
    String uname,pass;

    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setTitle("SHP Login");

        radioGroup = findViewById(R.id.radio_group);
        Rd1 = (RadioButton)findViewById(R.id.radio_patient);
        Rd2 = (RadioButton)findViewById(R.id.radio_doctor);

        textView = findViewById(R.id.link_signup);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(LoginActivity.this,SignupActivity.class);
                startActivity(intent);

            }
        });

        Name = (EditText)findViewById(R.id.new_user);
        Password = (EditText) findViewById(R.id.password);

        Button btnlogin = findViewById(R.id.btn_login);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( TextUtils.isEmpty(Name.getText())){
                    Name.setError( "Username is required!" );

                }
                else if(TextUtils.isEmpty(Password.getText())){
                    Password.setError( "Password is required!" );

                }
                else{
                pass = Password.getText().toString();
                uname = Name.getText().toString();
                reference = FirebaseDatabase.getInstance().getReference().child("User");
                reference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        String passw = Objects.requireNonNull(dataSnapshot.child(uname).child("Password").getValue()).toString();

                        if ((pass.equals(passw))) {

                            if (Rd1.isChecked()) {

                                Toast.makeText(getApplicationContext(), uname + " : You have logged in as Patient ", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getApplicationContext(), NavigationActivityPatient.class);
                                startActivity(intent);
                            }


                            if (Rd2.isChecked()) {

                                Toast.makeText(getApplicationContext(), uname + " : You have logged in as Doctor", Toast.LENGTH_SHORT).show();

                                Intent intent = new Intent(getApplicationContext(), NavigationActivityDoctor.class);
                                startActivity(intent);
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Invalid Credentials", Toast.LENGTH_SHORT).show();

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(),databaseError.getMessage(),Toast.LENGTH_SHORT).show();

                    }

                });
            }
            }
        });
    }
}

