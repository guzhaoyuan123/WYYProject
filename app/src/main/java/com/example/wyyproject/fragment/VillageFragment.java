package com.example.wyyproject.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.wyyproject.R;

import androidx.fragment.app.Fragment;

public class VillageFragment extends Fragment {



    public VillageFragment() {

    }


    public static VillageFragment newInstance() {
        VillageFragment fragment = new VillageFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=LayoutInflater.from(getContext()).inflate(R.layout.fragment_village,container,false);
        return view;
    }

}
