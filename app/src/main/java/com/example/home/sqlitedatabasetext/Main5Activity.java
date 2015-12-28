package com.example.home.sqlitedatabasetext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.home.sqlitedatabasetext.Database.Contact;

import java.util.List;

public class Main5Activity extends AppCompatActivity {
    DatabaseHandler dh;
    ListView lv1;
    List<Contact> li;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        lv1=(ListView)findViewById(R.id.listView2);
        dh=new DatabaseHandler(this);
        try {
            dh.open();
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "error sql exception", Toast.LENGTH_SHORT).show();

        }
        show();
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contact c = (Contact) parent.getItemAtPosition(position);
                Intent i = new Intent(Main5Activity.this, Main7Activity.class);
                i.putExtra("name", c.getName());
                i.putExtra("id", "" + c.getId());
                i.putExtra("phone", c.getPhone());
                i.putExtra("city", c.getCity());
                startActivityForResult(i, 7);

            }
        });
    }
    public void show()
    {
        li=dh.getData();
        ArrayAdapter<Contact> adap =new ArrayAdapter<Contact>(Main5Activity.this,android.R.layout.simple_selectable_list_item,li);
        lv1.setAdapter(adap);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==RESULT_OK)
        {
            Toast.makeText(getApplicationContext(),"Contact updated",Toast.LENGTH_SHORT).show();
            show();
        }
    }

}
