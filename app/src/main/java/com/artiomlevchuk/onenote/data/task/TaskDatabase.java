package com.artiomlevchuk.onenote.data.task;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = TaskDatabase.NAME, version = TaskDatabase.VERSION)
public class TaskDatabase {

    public static final String NAME = "TaskDatabase";

    public static final int VERSION = 1;
}