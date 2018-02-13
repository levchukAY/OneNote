package com.artiomlevchuk.onenote.data.note;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = NoteDatabase.NAME, version = NoteDatabase.VERSION)
public class NoteDatabase {

    public static final String NAME = "NoteDatabase";

    public static final int VERSION = 1;
}