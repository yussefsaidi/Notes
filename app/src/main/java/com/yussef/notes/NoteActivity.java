package com.yussef.notes;

import androidx.appcompat.app.AppCompatActivity;

import android.gesture.Gesture;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.yussef.notes.models.Note;

public class NoteActivity extends AppCompatActivity implements View.OnTouchListener,
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener {

    private static final String TAG = "NoteActivity";

    // ui components
    private LinedEditText mLinedEditText;
    private EditText mEditTitle;
    private TextView mViewTitle;

    // vars
    private boolean mIsNewNote;
    private Note mInitialNote;
    private GestureDetector mGestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        mLinedEditText = findViewById(R.id.note_text);
        mEditTitle = findViewById(R.id.note_edit_title);
        mViewTitle = findViewById(R.id.note_text_title);

        if(getIncomingIntent()){
            // this is a new note => EDIT MODE
            setNewNoteProperties();
        }
        else {
            // this is NOT a new note => VIEW MODE
            setNoteProperties();
        }

        setListeners();
    }

    private void setListeners() {
        mLinedEditText.setOnTouchListener(this);
        mGestureDetector = new GestureDetector(this, this);
    }

    private boolean getIncomingIntent(){
        if(getIntent().hasExtra("selected_note")){
            mInitialNote = getIntent().getParcelableExtra("selected_note");
           // Log.d(TAG, "getIncomingIntent: " + mInitialNote.toString());
            mIsNewNote = false;
            return false;
        }
        mIsNewNote = true;
        return true;
    }

    private void setNewNoteProperties(){
        mViewTitle.setText("Note title");
        mEditTitle.setText("Note title");
    }

    private void setNoteProperties(){
        mViewTitle.setText(mInitialNote.getTitle());
        mEditTitle.setText(mInitialNote.getTitle());
        mLinedEditText.setText(mInitialNote.getContent());

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return mGestureDetector.onTouchEvent(motionEvent);
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent motionEvent) {
        Log.d(TAG, "onDoubleTap: double tapped! ");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }
}
