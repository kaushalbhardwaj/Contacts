package com.example.home.sqlitedatabasetext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.home.sqlitedatabasetext.Database.Contact;

import java.util.List;

public class Main3Activity extends AppCompatActivity {

    ListView lv1;
    DatabaseHandler dh;
    List<Contact> li;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        dh=new DatabaseHandler(this);
        lv1=(ListView)findViewById(R.id.listView1);
        try {
            dh.open();
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "error sql exception", Toast.LENGTH_SHORT).show();

        }
        li=dh.getData();
        ArrayAdapter<Contact> adap =new ArrayAdapter<Contact>(Main3Activity.this,android.R.layout.simple_selectable_list_item,li);
        lv1.setAdapter(adap);
    }

}
