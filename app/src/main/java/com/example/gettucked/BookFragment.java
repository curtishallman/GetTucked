package com.example.gettucked;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BookFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BookFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    public int count;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BookFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BookFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BookFragment newInstance(String param1, String param2) {
        BookFragment fragment = new BookFragment();
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book, container, false);
        MainActivity xxx = (MainActivity) getActivity();

        final TextView title = view.findViewById(R.id.textView_title);
        final TextView price = view.findViewById(R.id.textView_price);
        final EditText checkin = view.findViewById(R.id.editText_checkin);
        final EditText checkout = view.findViewById(R.id.editText_checkout);
        Button confirm = view.findViewById(R.id.button_confirm);
        Bundle bundle = this.getArguments();
        String data = bundle.getString("key");
        String data2 = bundle.getString("key2");
        title.setText(data);
        price.setText(data2);

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putString("title", title.getText().toString());
                bundle.putString("price", price.getText().toString());
                bundle.putString("checkin", checkin.getText().toString());
                bundle.putString("checkout", checkout.getText().toString());


                MainActivity.bookingsFragment.setArguments(bundle);


                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, MainActivity.bookingsFragment).addToBackStack(null);
                fragmentTransaction.commit();
            }
        });
        return view;
    }
}

