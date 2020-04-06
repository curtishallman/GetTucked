package com.example.gettucked;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.google.android.material.textfield.TextInputLayout;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SignUpFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SignUpFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SignUpFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SignUpFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SignUpFragment newInstance(String param1, String param2) {
        SignUpFragment fragment = new SignUpFragment();
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

        View view = inflater.inflate(R.layout.fragment_sign_up, container, false);
        final TextInputLayout email = view.findViewById(R.id.textInputEmail);
        final TextInputLayout password = view.findViewById(R.id.textInputPassword);
        final TextInputLayout confirm = view.findViewById(R.id.textInputConfirm);
        Button submit = view.findViewById(R.id.signUpBtn2);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String emailInput = email.getEditText().getText().toString().trim();
                String passInput = password.getEditText().getText().toString().trim();
                String confirmPass = confirm.getEditText().getText().toString().trim();
                Boolean validEmail = false;
                Boolean validPass = false;

                if (emailInput.isEmpty()) {
                    email.setError("Field cant be empty");
                    return;
                } else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
                    email.setError("Please enter a valid email address");
                    return;
                } else {
                    email.setError(null);
                    validEmail = true;
                }
                if(passInput.isEmpty() || confirmPass.isEmpty()){
                    password.setError("Field cannot be empty!");
                    confirm.setError("Field cannot be empty!");

                }else if(!passInput.equals(confirmPass)){
                    confirm.setError("Passwords do not match!");
                }else{
                    validPass = true;
                }
                if(validPass == true && validEmail == true){
                    ((LoginActivity) getActivity()).openMainActivity();
                }


            }
        });
        return view;
    }
}
