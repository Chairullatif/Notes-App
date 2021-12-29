package com.khoirullatif.notes.helper

import android.database.Cursor
import com.khoirullatif.notes.database.DatabaseContract
import com.khoirullatif.notes.entity.Note

object MappingHelper {
    //kelas untuk mengubah type Object Cursor menjadi type ArrayList

    fun mapCursorToArrayList(notesCursor: Cursor?): ArrayList<Note>{
        val noteList = ArrayList<Note>()

        // apply digunakan untuk menyingkat kode berulang
        // tanpa apply getInt harus ditulis notesCursor.getInt; dan getColumnInde... harus ditulis
        // notesCursor.getColumnInde...
        notesCursor?.apply {
            while (moveToNext()) {
                val id = getInt(getColumnIndexOrThrow(DatabaseContract.NoteColumns._ID))
                val title = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.TITLE))
                val description = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DESCRIPTION))
                val date = getString(getColumnIndexOrThrow(DatabaseContract.NoteColumns.DATE))
                noteList.add(Note(id, title, description, date))
            }
        }

        return noteList
    }
}