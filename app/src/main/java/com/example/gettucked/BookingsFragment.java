package com.example.gettucked;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class BookingsFragment extends Fragment {
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setRetainInstance(true);
        View view = inflater.inflate(R.layout.fragment_bookings, container, false);
        TextView title1 = (TextView) view.findViewById(R.id.textView_title1);
        TextView title2 = (TextView) view.findViewById(R.id.textView_title2);
        TextView price1 = (TextView) view.findViewById(R.id.textView_price1);
        TextView price2 = (TextView) view.findViewById(R.id.textView_price2);
        TextView checkin1 = (TextView) view.findViewById(R.id.textView_checkin1);
        TextView checkin2 = (TextView) view.findViewById(R.id.textView_checkin2);
        TextView checkout1 = (TextView) view.findViewById(R.id.textView_checkout1);
        TextView checkout2 = (TextView) view.findViewById(R.id.textView_checkout2);
        Bundle bundle = this.getArguments();

        if((bundle != null) && (title1.getText().toString().matches(""))) {

            String data = bundle.getString("title");
            String data2 = bundle.getString("price");
            String data3 = bundle.getString("checkin");
            String data4 = bundle.getString("checkout");

            title1.setText(data);
            price1.setText(data2);
            checkin1.setText(data3);
            checkout1.setText(data4);
        }else if((!title1.getText().toString().matches(""))){
            String data = bundle.getString("title");
            String data2 = bundle.getString("price");
            String data3 = bundle.getString("checkin");
            String data4 = bundle.getString("checkout");

            title2.setText(data);
            price2.setText(data2);
            checkin2.setText(data3);
            checkout2.setText(data4);
        }






        return view;
    }

}
