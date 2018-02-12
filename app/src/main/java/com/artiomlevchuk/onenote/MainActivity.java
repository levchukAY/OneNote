package com.artiomlevchuk.onenote;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.artiomlevchuk.onenote.data.Task;
import com.raizlabs.android.dbflow.sql.language.SQLite;

public class MainActivity extends AppCompatActivity implements TaskAdapter.TaskCallback {

    private RecyclerView taskRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        taskRecyclerView = findViewById(R.id.task_recycler_view);
        taskRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        TaskAdapter taskAdapter = new TaskAdapter(this);
        //List<Task> organizationList = SQLite.select().from(Task.class).queryList();
        taskAdapter.setTasks(SQLite.select().from(Task.class).queryList());
        taskRecyclerView.setAdapter(taskAdapter);

        ImageView addNoteImageView = findViewById(R.id.add_note_image_view);
        addNoteImageView.setOnClickListener(view ->
                startActivity(new Intent(MainActivity.this, TaskDetailsActivity.class)));
    }

    @Override
    public void onTaskItemClick(int taskId) {
        Intent TaskDetailsIntent = new Intent(MainActivity.this, TaskDetailsActivity.class);
        TaskDetailsIntent.putExtra("EXTRA_TASK_ID", taskId);
        startActivity(TaskDetailsIntent);
    }
}
