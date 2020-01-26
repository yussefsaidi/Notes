package com.yussef.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.yussef.notes.models.Note;

public class NoteActivity extends AppCompatActivity {

    private static final String TAG = "NoteActivity";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        if(getIntent().hasExtra("selected_note")){
            Note note = getIntent().getParcelableExtra("selected_note");
            Log.d(TAG, "onCreate: " + note.toString());
        }

        //VIEW STATE

        //EDIT STATE
    }
}
