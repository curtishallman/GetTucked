package com.example.gettucked;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RoyalKelownaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RoyalKelownaFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RoyalKelownaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SandmanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static RoyalKelownaFragment newInstance(String param1, String param2) {
        RoyalKelownaFragment fragment = new RoyalKelownaFragment();
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
        View view = inflater.inflate(R.layout.fragment_royalkelowna, container, false);
        TextView book = (TextView) view.findViewById(R.id.textView_book);
        final TextView title = (TextView) view.findViewById(R.id.textView_title);
        final TextView cost = (TextView) view.findViewById(R.id.textView_cost);

        book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               Bundle bundle = new Bundle();
               bundle.putString("key", title.getText().toString());
               bundle.putString("key2", cost.getText().toString());
                BookFragment fragment = new BookFragment();
                fragment.setArguments(bundle);
                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container,fragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });


        // Inflate the layout for this fragment
        return view;
    }
}
