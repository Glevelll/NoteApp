package com.project.noteapp.feature.domain.use_case

import com.project.noteapp.feature.domain.model.InvalidNoteException
import com.project.noteapp.feature.domain.model.Note
import com.project.noteapp.feature.domain.repository.NoteRepository

class AddNote(
    private val repository: NoteRepository
) {

    @Throws(InvalidNoteException::class)
    suspend operator fun invoke(note: Note) {
        if (note.title.isBlank()) {
            throw InvalidNoteException("Title is empty")
        }
        if (note.content.isBlank()) {
            throw InvalidNoteException("Content is empty")
        }
        repository.insertNote(note)
    }
}