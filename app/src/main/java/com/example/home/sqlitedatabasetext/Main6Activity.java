package com.example.home.sqlitedatabasetext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Main6Activity extends AppCompatActivity {

    Button delete;
    TextView name,city,phone;
    DatabaseHandler dh;
    long id1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);
        dh=new DatabaseHandler(this);
        try {
            dh.open();
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "error sql exception", Toast.LENGTH_SHORT).show();

        }
        delete=(Button)findViewById(R.id.button6);
        name=(TextView)findViewById(R.id.textView9);
        phone=(TextView)findViewById(R.id.textView10);
        city=(TextView)findViewById(R.id.textView11);
        Bundle b=getIntent().getExtras();
        String n=b.getString("name").toString();
        String p=b.getString("phone").toString();
        String c=b.getString("city").toString();
        String id=b.getString("id").toString();
        name.setText(n);
        phone.setText(p);
        city.setText(c);
         id1=Long.parseLong(id);
        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dh.delete(id1);
                setResult(RESULT_OK);
                finish();
            }
        });

    }


}
