package ru.samsung.itschool.mdev.myapplication;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class Fragment1 extends Fragment {

    private String mParam1;
    private TextView tv1;
    private Button btn3;
    public OnFragment1DataListener frListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof OnFragment1DataListener) {
            frListener = (OnFragment1DataListener) context; // контекст = текущая активность,которая сделала имплементацию 
        } else {
            Log.d("AAA","Exception!");
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("FFFF","onCreate()");
        if (getArguments() != null) {
            mParam1 = getArguments().getString(MainActivity.KEY);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("FFFF","onCreateView()");
        View view = inflater.inflate(R.layout.fragment_1, container, false);
        tv1 = view.findViewById(R.id.textView);
        btn3 = view.findViewById(R.id.button3);
        tv1.setText(mParam1);
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frListener.onFragment1DataListener("Текст из фрагмента в активность!");
            }
        });

        return view;
    }

    public interface OnFragment1DataListener {
        void onFragment1DataListener(String str);
    }
}