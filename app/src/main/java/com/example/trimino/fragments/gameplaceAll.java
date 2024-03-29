package com.example.trimino.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.trimino.Arajin;
import com.example.trimino.First;
import com.example.trimino.R;
public class gameplaceAll extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_gameplace_all, container, false);

        Button button = view.findViewById(R.id.selected);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Arajin.class);
                startActivity(intent);
            }
        });
        return view;
    }


}