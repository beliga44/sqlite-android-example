package com.example.sqlite.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlite.R;
import com.example.sqlite.database.SQLiteDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonListTodo, buttonCreateTodo, buttonUpdateTodo;
    private EditText editTextTodoName, editTextTodoUpdateName;
    private SQLiteDatabase sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sqLiteDatabase = new SQLiteDatabase(this);

        buttonListTodo = findViewById(R.id.buttonListTodo);
        buttonCreateTodo = findViewById(R.id.buttonCreateTodo);
        buttonUpdateTodo = findViewById(R.id.buttonUpdateTodo);
        editTextTodoName = findViewById(R.id.editTextTodoName);
        editTextTodoUpdateName = findViewById(R.id.editTextTodoUpdateName);

        buttonListTodo.setOnClickListener(this);
        buttonCreateTodo.setOnClickListener(this);
        buttonUpdateTodo.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent i;
        if (view == buttonListTodo) {
            i = new Intent(this, ViewTodo.class);
            startActivity(i);
        } else if (view == buttonCreateTodo) {
            String todoName = editTextTodoName.getText().toString();
            if (sqLiteDatabase.insertTodo(todoName)) {
                Toast.makeText(this, "Todo: " + todoName + " Inserted", Toast.LENGTH_SHORT).show();
            }
        } else if (view == buttonUpdateTodo) {
            String currentName = editTextTodoName.getText().toString();
            String updateName = editTextTodoUpdateName.getText().toString();
            if (sqLiteDatabase.updateTodo(currentName, updateName)) {
                Toast.makeText(this, "Todo: " + currentName + " Updated to: " + updateName, Toast.LENGTH_SHORT).show();
            }
        }
    }
}
