package com.example.shp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class DoctorsFragment extends AppCompatActivity {
    ListView list;
    ArrayList<String> lv_arr = new ArrayList<String>();
    ArrayAdapter adapter;
    FirebaseDatabase database;
    myDoc data;
    Map<String,Object> myDocData=new HashMap<String,Object>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_doctors);
        getSupportActionBar().setTitle("SHP Patient");

        if(getSupportActionBar() != null) {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        list=(ListView)findViewById(R.id.list_doc);
        lv_arr.clear();
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, lv_arr);
        list.setAdapter(adapter);
        database = FirebaseDatabase.getInstance();
        DatabaseReference ref = database.getReference("Doctor");

// Attach a listener to read the data at our posts reference
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                Iterator<DataSnapshot> iterator = children.iterator();
                while(iterator.hasNext()){
                    lv_arr.add(iterator.next().getKey());

                }

                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
       list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(getApplicationContext(), DoctorsList.class);
                intent.putExtra("data", lv_arr.get(position).toString());
                startActivity(intent);
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

class myDoc{
    String Name;
    public myDoc(){

    }
    public myDoc(String n){
        this.Name=n;
    }
    public String getName(){
        return Name;
    }
    public void setValue(String name){
        Name=name;
    }
}

