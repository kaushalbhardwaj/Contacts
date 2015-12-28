package com.example.home.sqlitedatabasetext;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home.sqlitedatabasetext.Database.Contact;

public class Main7Activity extends AppCompatActivity {

    Button update;
    long id1;
    DatabaseHandler dh;
    EditText name,city,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);
        dh=new DatabaseHandler(this);
        try {
            dh.open();
        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(), "error sql exception", Toast.LENGTH_SHORT).show();

        }
        name=(EditText)findViewById(R.id.editText4);
        phone=(EditText)findViewById(R.id.editText5);
        city=(EditText)findViewById(R.id.editText6);
        update=(Button)findViewById(R.id.button7);

        Bundle b=getIntent().getExtras();
        String n=b.getString("name").toString();
        String p=b.getString("phone").toString();
        String c=b.getString("city").toString();
        String id=b.getString("id").toString();
        name.setText(n);
        phone.setText(p);
        city.setText(c);
        id1=Long.parseLong(id);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Contact c=new Contact();
                c.setId(id1);
                c.setName(name.getText().toString());
                c.setPhone(phone.getText().toString());
                c.setCity(city.getText().toString());
                dh.update(c);
                setResult(RESULT_OK);
                finish();
            }
        });
    }


}
