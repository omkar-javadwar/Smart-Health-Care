package com.example.shp;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DoctorsList extends AppCompatActivity {

    ListView lv;
    DatabaseReference ref;
    String branch;
    ArrayList<String> data;
    Zero zero=new Zero();
    ArrayAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.doctor_list);
        savedInstanceState=getIntent().getExtras();
        if(savedInstanceState!=null){branch=savedInstanceState.getString("data");}
        ref= FirebaseDatabase.getInstance().getReference("Doctor").child(branch);
        lv=(ListView)findViewById(R.id.doclist);
        // Toast.makeText(getApplicationContext(),""+branch,Toast.LENGTH_LONG).show();
        data = new ArrayList<String>();
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, data);
        lv.setAdapter(adapter);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    getChild(snapshot.getKey());
                    // Toast.makeText(getApplicationContext(),""+snapshot.getValue(),Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void getChild(String i)
    {
        DatabaseReference mdata=FirebaseDatabase.getInstance().getReference("Doctor").child(branch).child(i);
        mdata.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                zero = dataSnapshot.getValue(Zero.class);
                data.add("Name :"+zero.getName()+"\nGender : "+zero.getGen()+"\nSpeciality : "+zero.getSpe()+
                        "\nAddress : "+zero.getAdd()+"\nExperience : "+zero.getExp()+
                        "\nPhone : "+zero.getPh()+"\nEmail-id : "+zero.getEmail());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
