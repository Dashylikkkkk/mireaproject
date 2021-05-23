package ru.mirea.solomatina.mireaproject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class story_bd {
    @PrimaryKey(autoGenerate = true)
    public long id;
    public String text;
}
