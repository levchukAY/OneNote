package com.artiomlevchuk.onenote.ui;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.artiomlevchuk.onenote.R;
import com.artiomlevchuk.onenote.data.task.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.ViewHolder> {

    private ArrayList<Task> tasks;

    private TaskCallback taskCallback;

    public TaskAdapter(TaskCallback taskCallback) {
        tasks = new ArrayList<>();
        this.taskCallback = taskCallback;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks.addAll(tasks);
        Log.d("QWER", tasks.toString());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String title = tasks.get(position).getTitle();
        if (title.isEmpty()) {
            title = tasks.get(position).getBody().trim().split("\n")[0];
        }
        holder.titleTextView.setText(title);
        holder.itemView.setOnClickListener((view) ->
                taskCallback.onTaskItemClick(tasks.get(position).getId()));
    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView titleTextView;

        private ViewHolder(View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.title_text_view);
        }
    }

    public interface TaskCallback {

        void onTaskItemClick(int taskId);
    }
}
