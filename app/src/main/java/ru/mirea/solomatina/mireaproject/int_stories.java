package ru.mirea.solomatina.mireaproject;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface int_stories {
    @Query("SELECT * FROM story_bd")
    List<story_bd> getAll();
    @Query("SELECT * FROM story_bd WHERE id = :id")
    story_bd getById(long id);
    @Insert
    void insert(story_bd storybd);
    @Update
    void update(story_bd storybd);
    @Delete
    void delete(story_bd storybd);
}
