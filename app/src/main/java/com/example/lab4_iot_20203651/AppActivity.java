package com.example.lab4_iot_20203651;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.lab4_iot_20203651.databinding.VistaApiBinding;

public class AppActivity extends AppCompatActivity {


    VistaApiBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = VistaApiBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        replaceFragment(new geolocalizacionFragment());

        binding.bottomNavigation.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.geo_menu) {
                replaceFragment(new geolocalizacionFragment());
                return true;
            } else if (item.getItemId() == R.id.clima_menu) {
                replaceFragment(new ClimaFragment());
                return true;
            }
            return true;
        });
    }

    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout,fragment);
        fragmentTransaction.commit();
    }
}