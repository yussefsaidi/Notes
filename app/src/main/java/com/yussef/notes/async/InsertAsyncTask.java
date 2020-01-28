package com.yussef.notes.async;
import android.os.AsyncTask;
import com.yussef.notes.models.Note;
import com.yussef.notes.persistence.NoteDao;

public class InsertAsyncTask extends AsyncTask<Note, Void, Void> {

    private NoteDao mNoteDao;

    public InsertAsyncTask(NoteDao dao){
        mNoteDao = dao;
    }

    @Override
    protected Void doInBackground(Note... notes) {
        mNoteDao.insertNotes(notes);
        return null;
    }
}
