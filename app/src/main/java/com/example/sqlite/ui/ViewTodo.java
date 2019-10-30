package com.example.sqlite.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.sqlite.R;
import com.example.sqlite.database.SQLiteDatabase;
import com.example.sqlite.model.Todo;

import java.util.ArrayList;

public class ViewTodo extends AppCompatActivity {

    private ListViewTodoAdapter adapter;
    private ListView listViewTodo;

    private SQLiteDatabase sqLiteDatabase;
    private ArrayList<Todo> todos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_todo);
        listViewTodo = findViewById(R.id.listViewTodo);

        sqLiteDatabase = new SQLiteDatabase(this);
        todos = new ArrayList<>();

        this.getAllTodosInDB();

        listViewTodo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Todo selectedTodo = (Todo) adapterView.getItemAtPosition(i);
                Toast.makeText(getBaseContext(), "Deleted Todo : " + selectedTodo.getName(), Toast.LENGTH_SHORT).show();
                sqLiteDatabase.deleteTodo(selectedTodo.getName());
                todos.remove(selectedTodo);
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void getAllTodosInDB() {
        Cursor cursor = sqLiteDatabase.getAllTodos();

        try {
            while(cursor.moveToNext()) {
                String todoName = cursor.getString(0);
                Todo todo = new Todo(todoName);
                todos.add(todo);
            }
            adapter = new ListViewTodoAdapter(this, todos);
            listViewTodo.setAdapter(adapter);
        } catch (Exception e) {
            Log.wtf("traverse-cursor", e.getMessage());
        } finally {
            cursor.close();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.sqLiteDatabase.close();
    }
}
