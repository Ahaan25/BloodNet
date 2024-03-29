package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddRecords extends AppCompatActivity {

    Button add;
    EditText dname, rname, eid, ebloodtype, ddate, rdate;
    Intent intent;
    DBHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_records);

        add=findViewById(R.id.button6);
        dname=findViewById(R.id.editTextTextPersonName2);
        rname=findViewById(R.id.editTextTextPersonName8);
        eid=findViewById(R.id.editTextTextPersonName4);
        ebloodtype=findViewById(R.id.editTextTextPersonName5);
        ddate=findViewById(R.id.editTextTextPersonName6);
        rdate=findViewById(R.id.editTextTextPersonName7);

        db=new DBHandler(this);
        dname.requestFocus();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String dononame=dname.getText().toString();
                String recname=rname.getText().toString();
                String id=eid.getText().toString();
                String bloodtype=ebloodtype.getText().toString();
                String donodate=ddate.getText().toString();
                String recdate=rdate.getText().toString();
                Boolean insert=db.insert(dononame, recname, id, bloodtype, donodate, recdate);
                if(insert==true){
                    Toast.makeText(AddRecords.this, "Details inserted successfully",Toast.LENGTH_SHORT).show();
                    intent=new Intent(AddRecords.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    Toast.makeText(AddRecords.this, "Can't add record to table.",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

}
