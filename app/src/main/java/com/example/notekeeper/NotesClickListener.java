package com.example.notekeeper;

import androidx.cardview.widget.CardView;

import com.example.notekeeper.Models.Notes;

public interface NotesClickListener {
    void onClick(Notes notes);
    void onLongClick(Notes notes, CardView cardview);
}
