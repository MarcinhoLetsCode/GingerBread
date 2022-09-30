package br.com.etecia.gingerbread;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.Objects;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class Modelo extends AppCompatActivity {
    TextView nomeProduto;
    ImageView imgProduto;
    TextView descricaoProduto;
    MaterialRatingBar notaProduto;
    ImageView favoritoProduto;
    TextView precoProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modelo);
        nomeProduto = findViewById(R.id.nomeCafe);
        imgProduto = findViewById(R.id.fotoCafe);
        descricaoProduto = findViewById(R.id.descricaoCafe);
        notaProduto = findViewById(R.id.getBar);
        favoritoProduto = findViewById(R.id.getFavorite);
        precoProduto = findViewById(R.id.precoCafe);

        Intent intent = getIntent();
        String nome, descricao, preco;
        int foto, favorito, nota;

        nome = intent.getStringExtra("Nome");
        foto = intent.getIntExtra("Foto", 0);
        descricao = intent.getStringExtra("Descrição");
        nota = intent.getIntExtra("Nota", 0);
        favorito = intent.getIntExtra("Favorito", 0);
        preco = intent.getStringExtra("preco");
        nomeProduto.setText(nome);
        imgProduto.setImageResource(foto);
        descricaoProduto.setText(descricao);
        notaProduto.setNumStars(nota);
        favoritoProduto.setImageResource(favorito);
        precoProduto.setText(preco);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}