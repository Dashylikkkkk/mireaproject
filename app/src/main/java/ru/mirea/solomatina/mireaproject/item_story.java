package ru.mirea.solomatina.mireaproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class item_story extends RecyclerView.Adapter<item_story.StoryHolder> {
    List<story_bd> stories;

    public item_story(List<story_bd> stories) {
        this.stories = stories;
    }

    @Override
    public StoryHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.story_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutId, parent, false);
        StoryHolder storyHolder = new StoryHolder(view);
        return storyHolder;
    }

    @Override
    public int getItemCount() {
        return stories.size();
    }

    class StoryHolder extends RecyclerView.ViewHolder {
        TextView storyId;
        TextView storyText;

        public StoryHolder(View itemView) {
            super(itemView);

            storyId = itemView.findViewById(R.id.text_id1);
            storyText = itemView.findViewById(R.id.text_id2);
        }

        void bind(int listIndex) {
            story_bd storybd = stories.get(listIndex);
            storyId.setText(String.valueOf(storybd.id));
            storyText.setText(storybd.text);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull StoryHolder holder, int position) {
        holder.bind(position);
    }


}