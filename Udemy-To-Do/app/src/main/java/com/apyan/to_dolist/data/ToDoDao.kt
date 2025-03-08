package com.apyan.to_dolist.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.apyan.to_dolist.data.models.ToDoTask
import kotlinx.coroutines.flow.Flow

@Dao
interface ToDoDao {

    // Select all from todo_table from ascending order by id
    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllTasks(): Flow<List<ToDoTask>>

    @Query("SELECT * FROM todo_table WHERE id = :taskId")
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    // Unlike the the previous two, Flow is part of the coroutine, hence 'suspend' is not necessary
    @Insert
    suspend fun addTask(toDoTask: ToDoTask)
}