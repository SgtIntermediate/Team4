package com.example.test;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @SuppressLint("ResourceType")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.next_screen);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

        final ArrayList<String> listItems=new ArrayList<String>();

        final EditText text = findViewById(R.id.input_main);
        Button add = findViewById(R.id.action_add_task);
        add.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                String value = text.getText().toString();
                listItems.add(value);
                text.setText("");
            }

        });
        final ArrayAdapter<String> adapter= new ArrayAdapter<String>(this,
                R.layout.content_main,
                listItems);
        final ListView todos = (ListView)findViewById(R.id.list_todo);
        todos.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void closeApplication() {
        finish();
        moveTaskToBack(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            System.out.println("Do something");
            return true;
        }

        if (id == R.id.action_quit) {
            closeApplication();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
