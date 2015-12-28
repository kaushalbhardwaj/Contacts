package com.example.home.sqlitedatabasetext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.home.sqlitedatabasetext.Database.Contact;

public class Main2Activity extends AppCompatActivity {
    Button add;
    EditText name,phone,city;
    DatabaseHandler dh=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dh=new DatabaseHandler(this);
        add=(Button)findViewById(R.id.button4);
        name=(EditText)findViewById(R.id.editText);
        phone=(EditText)findViewById(R.id.editText2);
        city=(EditText)findViewById(R.id.editText3);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    dh.open();
                }
                catch(Exception e)
                {
                    Toast.makeText(getApplicationContext(), "error sql exception", Toast.LENGTH_SHORT).show();

                }

                Contact con=new Contact();
                con.setName(name.getText().toString());
                con.setPhone(phone.getText().toString());
                con.setCity(city.getText().toString());
                dh.insert(con);
                setResult(RESULT_OK);
                finish();
            }
        });
    }

}
