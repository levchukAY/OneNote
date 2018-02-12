package com.artiomlevchuk.onenote;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.artiomlevchuk.onenote.data.Task;
import com.artiomlevchuk.onenote.data.Task_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.Calendar;
import java.util.Date;

public class TaskDetailsActivity extends AppCompatActivity {

    private EditText titleEditText;
    private EditText bodyEditText;
    private TextView backTextView;

    private Task task;

    private int id;

    private String title;
    private String body;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_details);

        titleEditText = findViewById(R.id.title_edit_text);
        bodyEditText = findViewById(R.id.body_edit_text);
        backTextView = findViewById(R.id.back_text_view);

        backTextView.setOnClickListener((view) -> onBackPressed());

        id = getIntent().getIntExtra("EXTRA_TASK_ID", -1);
        if (id != -1) {
            task = SQLite.select().from(Task.class).where(Task_Table.id.is(id)).queryList().get(0);
            titleEditText.setText(task.getTitle());
            bodyEditText.setText(task.getBody());
        } else {
            task = new Task();
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        title = titleEditText.getText().toString();
        body = bodyEditText.getText().toString();

        if (!title.isEmpty() || !body.isEmpty()) {
            task.setTitle(title);
            task.setBody(body);
            task.setType(0);
            if (id == -1) {
                task.setDate(Calendar.getInstance().getTime());
            }
            task.save();
            Log.d("QWER save", SQLite.select().from(Task.class).queryList().toString());
        }
    }
}
