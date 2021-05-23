package ru.mirea.solomatina.mireaproject;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class story_bd {
    @PrimaryKey(autoGenerate = true)
    public String text;
    public long id;
}
