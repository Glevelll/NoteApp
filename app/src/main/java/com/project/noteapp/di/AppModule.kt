package com.project.noteapp.di

import android.app.Application
import androidx.room.Room
import com.project.noteapp.feature.data.repository.NoteRepositoryImpl
import com.project.noteapp.feature.data.source.NoteDatabase
import com.project.noteapp.feature.domain.repository.NoteRepository
import com.project.noteapp.feature.domain.use_case.AddNote
import com.project.noteapp.feature.domain.use_case.DeleteNote
import com.project.noteapp.feature.domain.use_case.GetNote
import com.project.noteapp.feature.domain.use_case.GetNotes
import com.project.noteapp.feature.domain.use_case.NoteUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDatabase(app: Application): NoteDatabase {
        return Room.databaseBuilder(
            app,
            NoteDatabase::class.java,
            NoteDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideNoteRepository(db: NoteDatabase): NoteRepository {
        return NoteRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun providesNoteUseCases(repository: NoteRepository): NoteUseCases {
        return NoteUseCases(
            getNotes = GetNotes(repository),
            deleteNote = DeleteNote(repository),
            addNote = AddNote(repository),
            getNote = GetNote(repository)
        )
    }
}