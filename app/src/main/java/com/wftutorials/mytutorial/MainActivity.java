package com.wftutorials.mytutorial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    Button btn, btn1;
    EditText ed;
    ImageView iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.textview);
        btn = findViewById(R.id.button);
        btn1 = findViewById(R.id.button1);
        ed = findViewById(R.id.editText);
        iv = findViewById(R.id.imageView);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv.setImageDrawable(getResources().getDrawable(R.drawable.cover));
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "User clicked textview", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            finish();
        }

        if( id == R.id.action_one){
            Toast.makeText(MainActivity.this,"Clicked action one", Toast.LENGTH_LONG).show();
        }

        if( id == R.id.action_two){
            showDialog();
        }

        if( id == R.id.action_three){

        }
        return super.onOptionsItemSelected(item);
    }

    public void showDialog(){
        LayoutInflater inflater=(LayoutInflater)MainActivity.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =inflater.inflate(R.layout.dialog_layout,null);
        Button btn = view.findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"Button clicked", Toast.LENGTH_LONG).show();
            }
        });
        final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
        alertDialog.setTitle("Hello World Dialog");
        alertDialog.setView(view);
        //alertDialog.setMessage("This is an alert Dialog");
        alertDialog.show();
    }

}
