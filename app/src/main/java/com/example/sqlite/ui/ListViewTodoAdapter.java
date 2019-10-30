package com.example.sqlite.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sqlite.R;
import com.example.sqlite.model.Todo;

import java.util.ArrayList;

public class ListViewTodoAdapter extends BaseAdapter {

    private Context ctx;
    private ArrayList<Todo> todos;

    public ListViewTodoAdapter(Context context, ArrayList<Todo> todoArrayList) {
        this.ctx = context;
        this.todos = todoArrayList;
    }

    @Override
    public int getCount() {
        return this.todos.size();
    }

    @Override
    public Object getItem(int i) {
        return this.todos.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(this.ctx).inflate(R.layout.layout_view_todo, viewGroup, false);
        }

        Todo selectedTodo = (Todo) getItem(position);

        TextView textViewTodoName = view.findViewById(R.id.textViewTodoName);
        textViewTodoName.setText(selectedTodo.getName());

        return view;
    }
}
