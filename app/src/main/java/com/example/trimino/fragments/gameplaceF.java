package com.example.trimino.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.trimino.First;
import com.example.trimino.R;
public class gameplaceF extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gameplace, container, false);
    }

    public void Game(View v){
        Intent intent = new Intent(getActivity(), First.class);
        startActivity(intent);
    }
}