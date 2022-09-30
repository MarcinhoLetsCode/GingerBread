package br.com.etecia.gingerbread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    MaterialToolbar materialToolbar;
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        materialToolbar = findViewById(R.id.toolBar);
        bottomNavigationView = findViewById(R.id.bnMenu);

        materialToolbar.setTitle("Café");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.container, new ProdutoFragment(0)).
                commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.bnCoffe:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new ProdutoFragment(0)).
                                commit();
                        materialToolbar.setTitle("Café");
                        return true;

                    case R.id.bnMuffin:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new ProdutoFragment(1)).
                                commit();
                        materialToolbar.setTitle("Muffin");
                        return true;

                    case R.id.bnTea:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new ProdutoFragment(2)).
                                commit();
                        materialToolbar.setTitle("Chá");
                        return true;

                    case R.id.bnDonuts:
                        getSupportFragmentManager()
                                .beginTransaction()
                                .replace(R.id.container, new ProdutoFragment(3)).
                                commit();
                        materialToolbar.setTitle("Donuts");
                        return true;
                }
                return true;
            }
        });
    }
}