package com.example.blooddonation;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Calendar;


public class CheckAvail extends AppCompatActivity  {

    TextView anim;
    Button check, call, book;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_avail);

        check=findViewById(R.id.button16);
        call=findViewById(R.id.button17);
        book=findViewById(R.id.button18);


        anim=findViewById(R.id.textView4);
        anim.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        anim.setSelected(true);
        anim.setSingleLine(true);

        Spinner bloodtypes=findViewById(R.id.spinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this, R.array.bloodtypes, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        bloodtypes.setAdapter(adapter);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:104"));
                startActivity(intent);
            }
        });

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(CheckAvail.this, BookAppointment.class);
                startActivity(a);
            }
        });

    }
}