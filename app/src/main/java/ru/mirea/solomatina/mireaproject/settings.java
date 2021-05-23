package ru.mirea.solomatina.mireaproject;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Context.MODE_PRIVATE;


public class settings extends Fragment {
    private Button btnSave;
    private SharedPreferences preferences;
    private EditText editName;
    private EditText editUniversity;

    public settings() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_settings, container, false);
        preferences = getActivity().getPreferences(MODE_PRIVATE);
        btnSave = (Button) view.findViewById(R.id.button_save);
        btnSave.setOnClickListener(this::onSave);
        editName = view.findViewById(R.id.edit_name);
        String name = preferences.getString("name", "имя фамилия");
        editName.setText(name);
        editUniversity = view.findViewById(R.id.edit_vuz);
        editUniversity.setText(preferences.getString("university", "вуз"));
        return view;
    }

    public void onSave(View v){
        SharedPreferences.Editor editPref = preferences.edit();
        editPref.putString("name", editName.getText().toString());
        editPref.putString("university", editUniversity.getText().toString());
        editPref.apply();
        Toast.makeText(getContext(), "Настройки сохранены", Toast.LENGTH_SHORT).show();
    }
}