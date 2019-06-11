package com.example.shp;

import android.content.Intent;
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

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignupActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
    EditText name,email,password;
    Button signup;
    DatabaseReference ref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        getSupportActionBar().setTitle("SHP Register");

        name = (EditText) findViewById(R.id.input_name);
        email = (EditText) findViewById(R.id.input_email);
        password = (EditText) findViewById(R.id.input_password);

        radioGroup = findViewById(R.id.radio_group);

        textView = findViewById(R.id.link_login);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(intent);

            }
        });

        signup = (Button) findViewById(R.id.btn_signup);

        ref = FirebaseDatabase.getInstance().getReference().child("User");
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if( TextUtils.isEmpty(name.getText())){
                    name.setError( "Username is required!" );

                }
                else if(TextUtils.isEmpty(password.getText())){
                    password.setError( "Password is required!" );

                }
                else{

                    String nm = name.getText().toString().trim();
                    String em = email.getText().toString().trim();
                    String pas = password.getText().toString().trim();

                    ref.child(nm).setValue(name.toString());
                    ref.child(nm).child("Name").setValue(nm);
                    ref.child(nm).child("Email-ID").setValue(em);
                    ref.child(nm).child("Password").setValue(pas);

                    Toast.makeText(SignupActivity.this, " Registered successfully ", Toast.LENGTH_SHORT).show();
                }
            }
        });

      /*  Button btnsignup = findViewById(R.id.btn_signup);
        btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int radioId = radioGroup.getCheckedRadioButtonId();

                radioButton = findViewById(radioId);

                textView.setText("Your Choice: " + radioButton.getText());
            }
        });*/

     /*   btnsignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checklogin();

            }
        });*/
    }

  /*  public void checklogin(){   */
        /*int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);

        Toast.makeText(this,"selected :"+ radioButton.getText(),Toast.LENGTH_SHORT).show();*/

    /*    Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
    }*/

}
