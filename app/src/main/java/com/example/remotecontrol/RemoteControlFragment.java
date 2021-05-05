package com.example.remotecontrol;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RemoteControlFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RemoteControlFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private TextView mCurrent;
    private int counter = 0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public RemoteControlFragment() {
        // Required empty public constructor
    }

    public void plusCounter() {
        counter++;
        mCurrent.setText(Integer.toString(counter));
    }

    public void minusCounter() {
        counter--;
        if(counter<=0){initCounter();}
        mCurrent.setText(Integer.toString(counter));
    }

    public void initCounter() {
        counter = 0;
        mCurrent.setText(Integer.toString(counter));
    }


    public static RemoteControlFragment newInstance() {
        RemoteControlFragment fragment = new RemoteControlFragment();
        Bundle args = new Bundle();

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
        View v = inflater.inflate(R.layout.fragment_remote_control, container, false);

        mCurrent = v.findViewById(R.id.fragment_remote_control_current);

        Button plusButton = v.findViewById(R.id.fragment_remote_control_plus);
        plusButton.setOnClickListener(clickListener);

        Button minusButton = v.findViewById(R.id.fragment_remote_control_minus);
        minusButton.setOnClickListener(clickListener);

        Button setZero = v.findViewById(R.id.fragment_remote_control_zero);
        setZero.setOnClickListener(clickListener);

        initCounter();

        return v;
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.fragment_remote_control_plus:
                    plusCounter();
                    break;
                case R.id.fragment_remote_control_minus:
                    minusCounter();
                    break;
                case R.id.fragment_remote_control_zero:
                    initCounter();
                    break;
            }


        }
    };


}