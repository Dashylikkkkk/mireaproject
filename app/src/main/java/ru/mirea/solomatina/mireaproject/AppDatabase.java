package ru.mirea.solomatina.mireaproject;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {story_bd.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract int_stories storyDao();
}
