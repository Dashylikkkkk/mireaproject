package ru.mirea.solomatina.mireaproject;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;


public class fragm_stori extends Fragment {
    private RecyclerView stories;
    private item_story itemStory;
    List<story_bd> listStories;

    public fragm_stori() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stories, container, false);
        AppDatabase db = App.getInstance().getDatabase();
        int_stories intstories = db.storyDao();
        stories = view.findViewById(R.id.stories);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        stories.setLayoutManager(layoutManager);
        stories.setHasFixedSize(true);
        listStories = intstories.getAll();
        itemStory = new item_story(listStories);
        stories.setAdapter(itemStory);
        return view;
    }
}