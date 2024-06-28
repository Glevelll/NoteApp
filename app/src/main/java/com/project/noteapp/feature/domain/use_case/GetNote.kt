package com.project.noteapp.feature.domain.use_case

import com.project.noteapp.feature.domain.model.Note
import com.project.noteapp.feature.domain.repository.NoteRepository

class GetNote(
    private val repository: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return repository.getNoteById(id)
    }
}