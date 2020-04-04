package com.example.gettucked;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link KamloopsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class KamloopsFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    String s1[], s2[];
    RecyclerView recyclerView;
    int images[] = {R.drawable.sandman, R.drawable.holiday, R.drawable.ramada};


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public KamloopsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment KamloopsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static KamloopsFragment newInstance(String param1, String param2) {
        KamloopsFragment fragment = new KamloopsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_kamloops, container, false);

        TextView ramada = (TextView) view.findViewById(R.id.textView_ramada);
        TextView holiday = (TextView) view.findViewById(R.id.textView_holiday);
        TextView sandman = (TextView) view.findViewById(R.id.textView_sandman);
        TextView hampton = (TextView) view.findViewById(R.id.textView_hampton);
        TextView plaza = (TextView) view.findViewById(R.id.textView_plaza);

        ramada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new RamadaFragment());
                fragmentTransaction.commit();
            }
        });

        holiday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new HolidayFragment());
                fragmentTransaction.commit();
            }
        });

        sandman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new SandmanFragment());
                fragmentTransaction.commit();
            }
        });

        hampton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new HamptonFragment());
                fragmentTransaction.commit();
            }
        });

        plaza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, new PlazaFragment());
                fragmentTransaction.commit();
            }
        });


        return view;
    }


}
