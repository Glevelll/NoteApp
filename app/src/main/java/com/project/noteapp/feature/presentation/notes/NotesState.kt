package com.project.noteapp.feature.presentation.notes

import com.project.noteapp.feature.domain.model.Note
import com.project.noteapp.feature.domain.util.NoteOrder
import com.project.noteapp.feature.domain.util.OrderType

data class NotesState(
    val notes: List<Note> = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible: Boolean = false
)
