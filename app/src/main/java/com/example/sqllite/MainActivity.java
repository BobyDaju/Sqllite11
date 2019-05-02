package com.example.sqllite;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import helper.Myhelper;

public class MainActivity extends AppCompatActivity {
    EditText txtword,txtmeaning;
    Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtword=findViewById(R.id.txtword);
        txtmeaning=findViewById(R.id.txtmeaning);
        btnadd=findViewById(R.id.btnadd);

        final Myhelper myhelper= new Myhelper(this);
        final SQLiteDatabase sqLiteDatabase= myhelper.getWritableDatabase();


        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                long id =myhelper.InsertData(txtword.getText().toString(), txtmeaning.getText().toString(),sqLiteDatabase);
                if (id > 0) {
                    Toast.makeText(MainActivity.this, "succesful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
