package com.example.gettucked;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        EditText name = view.findViewById(R.id.editTextName);
        EditText lastName = view.findViewById(R.id.editTextLastName);
        EditText email = view.findViewById(R.id.editText_email);
        name.setText(getArguments().getString("name"));
        lastName.setText(getArguments().getString("lastName"));
        email.setText(getArguments().getString("email"));

        return view;
    }
}
