package com.example.sqlite.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlite.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonListTodo, buttonCreateTodo, buttonUpdateTodo;
    private EditText editTextTodoName, editTextTodoUpdateName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        if (view == buttonListTodo) {
            Toast.makeText(this, "List Todo Clicked!", Toast.LENGTH_SHORT).show();
        } else if (view == buttonCreateTodo) {
            Toast.makeText(this, "Create Todo Clicked!", Toast.LENGTH_SHORT).show();
        } else if (view == buttonUpdateTodo) {
            Toast.makeText(this, "Update Todo Clicked!", Toast.LENGTH_SHORT).show();
        }
    }
}
