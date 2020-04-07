package com.example.gettucked;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.Calendar;
import java.util.Date;


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
    private DatePickerDialog.OnDateSetListener onDateSetListener;
    private DatePickerDialog.OnDateSetListener onDateSetListener2;


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
        final MainActivity xxx = (MainActivity) getActivity();

        final TextView title = view.findViewById(R.id.textView_title);
        final TextView price = view.findViewById(R.id.textView_price);
        final TextView checkin = view.findViewById(R.id.editText_checkin);
        final TextView checkout = view.findViewById(R.id.editText_checkout);
        Button confirm = view.findViewById(R.id.button_confirm);

       checkin.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);

               DatePickerDialog dialog = new DatePickerDialog(xxx,onDateSetListener, year, month, day);
               dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.GRAY));
               dialog.show();
           }
       });
       checkout.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Calendar cal = Calendar.getInstance();
               int year = cal.get(Calendar.YEAR);
               int month = cal.get(Calendar.MONTH);
               int day = cal.get(Calendar.DAY_OF_MONTH);

               DatePickerDialog dialog2 = new DatePickerDialog(xxx,onDateSetListener2, year, month, day);
               dialog2.getWindow().setBackgroundDrawable(new ColorDrawable(Color.GRAY));
               dialog2.show();
           }
       });
       onDateSetListener = new DatePickerDialog.OnDateSetListener() {
           @Override
           public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
             month = month + 1;
             String date = month + "/" + dayOfMonth + "/" + year;
             checkin.setText(date);
           }
       };
        onDateSetListener2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month + 1;
                String date = month + "/" + dayOfMonth + "/" + year;
                checkout.setText(date);
            }
        };


        Bundle bundle = this.getArguments();
        String data = bundle.getString("key");
        String data2 = bundle.getString("key2");
        title.setText(data);
        price.setText(data2);


        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                Boolean options = false;
                final String checkIn = checkin.getText().toString();
                final String checkOut = checkout.getText().toString();
                bundle.putString("title", title.getText().toString());
                bundle.putString("price", price.getText().toString());
                bundle.putString("checkin", checkin.getText().toString());
                bundle.putString("checkout", checkout.getText().toString());

                if (checkIn.isEmpty()) {
                    checkin.setError("Please select a date!");
                }
                if (checkOut.isEmpty()) {
                    checkout.setError("Please select a date!");
                }
                if (!checkOut.isEmpty() && !checkIn.isEmpty()) {
                    MainActivity.bookingsFragment.setArguments(bundle);
                    FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.fragment_container, MainActivity.bookingsFragment).addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });
        return view;
    }
}

