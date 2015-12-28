package com.example.home.sqlitedatabasetext;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button add,remove,view,upgrade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add=(Button)findViewById(R.id.button);
        remove=(Button)findViewById(R.id.button2);
        view=(Button)findViewById(R.id.button3);
        upgrade=(Button)findViewById(R.id.button5);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Main2Activity.class);
                startActivityForResult(i, 2);
            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Main4Activity.class);
                startActivityForResult(i, 3);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main3Activity.class);
                startActivityForResult(i, 4);
            }
        });
        upgrade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Main5Activity.class);
                startActivityForResult(i, 5);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==2)
        {
            Toast.makeText(getApplicationContext(),"Contact Added",Toast.LENGTH_SHORT).show();
        }
        if(requestCode==3&&resultCode==RESULT_OK)
        {
            Toast.makeText(getApplicationContext(),"Contact Removed",Toast.LENGTH_SHORT).show();
        }
        if(requestCode==5)
        {
            Toast.makeText(getApplicationContext(),"Contact Updated",Toast.LENGTH_SHORT).show();
        }

    }
}
