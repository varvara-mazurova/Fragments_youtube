package com.example.fragments_youtube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fragments_youtube.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Button button_A, button_B, button_C, button_D, button_settings, button_profile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*      button_A = findViewById(R.id.button_A);
        button_B = findViewById(R.id.button_B);
        button_C = findViewById(R.id.button_C);
        button_D = findViewById(R.id.button_D);
        button_settings = findViewById(R.id.button_settings);
        button_profile = findViewById(R.id.button_profile);*/

        MainFragment mainFragment = new MainFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frame_layout, mainFragment);
        ft.addToBackStack(null);
        ft.commit();



        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.buttonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new SettingsFragment());
            }
        });
        binding.buttonA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadFragment(new MainFragment());
            }
        });


    }
    public void loadFragment(Fragment fr)
    {
        //логика переключений
        FragmentManager fm = getSupportFragmentManager();

        Bundle bundle = new Bundle();

        fr.setArguments(bundle);



        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frame_layout, fr);
        ft.addToBackStack(null);
        ft.commit();

    }

}