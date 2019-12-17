package com.example.wyyproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wyyproject.R;

import androidx.fragment.app.Fragment;


public class MeFragment extends Fragment {


    public MeFragment() {
    }


    public static MeFragment newInstance() {
        MeFragment fragment = new MeFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_me,container,false);
        return view;
    }


}
