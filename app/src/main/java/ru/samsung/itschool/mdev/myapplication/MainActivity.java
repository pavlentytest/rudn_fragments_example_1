package ru.samsung.itschool.mdev.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, Fragment1.OnFragment1DataListener {

    private Button btn1, btn2;
    public static final String KEY = "key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1 = findViewById(R.id.button);
        btn2 = findViewById(R.id.button2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.button) {
            loadFragment(new Fragment1());
        } else {
            loadFragment(new Fragment2());
        }
    }

    public void loadFragment(Fragment f) {
        // Контролирует работу с фрагментами
        FragmentManager fm = getSupportFragmentManager();

        Bundle arg = new Bundle();
        arg.putString(KEY,getString(R.string.hello2));
        f.setArguments(arg);

        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frBody,f);
        ft.addToBackStack(null); // необязательно
        ft.commit();
    }


   @Override
    public void onFragment1DataListener(String str) {
        Snackbar.make(findViewById(R.id.root),str,Snackbar.LENGTH_LONG).show();
    }
}