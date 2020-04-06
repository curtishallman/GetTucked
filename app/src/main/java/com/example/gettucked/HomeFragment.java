package com.example.gettucked;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class HomeFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        TextView kamloops = (TextView)view.findViewById(R.id.textView_kamloops);
        TextView vancouver = (TextView) view.findViewById(R.id.textView_vancouver);
        TextView kelowna = (TextView) view.findViewById(R.id.textView_kelowna);



        kamloops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new KamloopsFragment()).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        vancouver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new VancouverFragment()).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        kelowna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new KelownaFragment()).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });

        return view;
    }
}
