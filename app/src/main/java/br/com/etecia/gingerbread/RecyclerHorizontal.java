package br.com.etecia.gingerbread;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class RecyclerHorizontal extends AppCompatActivity {

    RecyclerView recyclerView;
    private List<Products> produtoLista;


    public RecyclerHorizontal() {}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_horizontal);

        recyclerView = findViewById(R.id.rvBigCoffe);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));
        recyclerView.hasFixedSize();

        Intent intent = getIntent();
        int produto, posicao;
        produto = intent.getIntExtra("Produto", 0);
        posicao = intent.getIntExtra("Posicao", 0);

        recyclerView.scrollToPosition(posicao);

        switch (produto) {
            case 0:
                produtoLista = new ArrayList<>();
                produtoLista.add(new Products("Café Preto",
                        R.drawable.cafepreto,
                        "Café",
                        2,
                        R.drawable.ic_baseline_favorite,
                        1.10));
                produtoLista.add(new Products("Café com Leite", R.drawable.coffee, "Café", 3, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Capuccino", R.drawable.cappucino, "Café", 5, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Frapuccino ", R.drawable.frappucino, "Café", 5, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Café com Nutella", R.drawable.cafecnutella, "Café", 5, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Café Expresso", R.drawable.cafeexpresso, "Café", 5, R.drawable.ic_baseline_favorite, 1.10));
                break;
            case 1:
                produtoLista = new ArrayList<>();
                produtoLista.add(new Products("Muffin de Laranja",
                        R.drawable.muffinlaranja,
                        "Muffin",
                        2,
                        R.drawable.ic_baseline_favorite,
                        1.10));
                produtoLista.add(new Products("Muffin Tradicional", R.drawable.muffintradicional, "Muffin", 3, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Muffin de Morango", R.drawable.muffinmorango, "Muffin", 5, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Muffin de Chocolate", R.drawable.muffinchocolate, "Muffin", 5, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Muffin de Maçã", R.drawable.muffinmaca, "Muffin", 5, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Muffin de Aveia", R.drawable.muffinaveia, "Muffin", 5, R.drawable.ic_baseline_favorite, 1.10));
                break;
            case 2:
                produtoLista = new ArrayList<>();
                produtoLista.add(new Products("Chá de Limão", R.drawable.chalimao, "Chá", 2, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Chá Preto", R.drawable.chapreto, "Chá", 3, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Chá de Erva Doce", R.drawable.chaervadoce, "Chá", 5, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Chá de Camomila", R.drawable.chacamomila, "Chá", 5, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Chá de Erva Sidreira", R.drawable.chaervasidreira, "Chá", 5, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Chá de Hibisco", R.drawable.chahibisco, "Chá", 5, R.drawable.ic_baseline_favorite, 1.10));
                break;
            case 3:
                produtoLista = new ArrayList<>();
                produtoLista.add(new Products("Donuts de Oreo", R.drawable.donutsoreo, "Donuts", 2, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Donuts de Bacon", R.drawable.donutsbacon, "Donuts", 3, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Donuts de Kinder Joy", R.drawable.donutskinder, "Donuts", 5, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Donuts Brigadeiro", R.drawable.donutsbrigadeiro, "Donuts", 5, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Donuts de Nutella", R.drawable.donutsnutella, "Donuts", 5, R.drawable.ic_baseline_favorite, 1.10));
                produtoLista.add(new Products("Donuts de Morango", R.drawable.donutsmorango, "Donuts", 5, R.drawable.ic_baseline_favorite, 1.10));
            default:
                break;

        }

        Adapter coffeAdapter = new Adapter(this, produtoLista);
        recyclerView.setAdapter(coffeAdapter);

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
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

    public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

        Button menos;
        Button mais;
        TextView Qtde;
        int x = 1;
        FloatingActionButton floatingActionButton;
        private Context context;
        private List<Products> produtoLista;

        public Adapter(Context context, List<Products> produtoLista) {
            this.context = context;
            this.produtoLista = produtoLista;
        }

        @NonNull
        @Override
        public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view;
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            view = inflater.inflate(R.layout.activity_modelo, parent, false);
            floatingActionButton = findViewById(R.id.fabAdd);
            menos = findViewById(R.id.btMenos);
            Qtde = findViewById(R.id.tvQtde);
            Qtde.setText(Integer.toString(x));
            mais = findViewById(R.id.btMais);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
            holder.nomeProduto.setText(produtoLista.get(position).getnomeProduct());
            holder.fotoProduto.setImageResource(produtoLista.get(position).getImagemProduct());
            holder.descricaoProduto.setText(produtoLista.get(position).getDescricaoProduct());
            holder.notaProduto.setNumStars(produtoLista.get(position).getRatingProduct());
            holder.favProduto.setImageResource(produtoLista.get(position).getFavorite());
            holder.precoProduto.setText(Double.toString(produtoLista.get(position).getPreco()));

            menos.setOnClickListener(v -> {
                if (x > 1){
                    x--;
                }
                AlteraQtde();
                AlteraPreco(holder, position);
            });

            floatingActionButton.setOnClickListener(v -> {
                Toast.makeText(getApplicationContext(),
                        x + " Item(ns) " + produtoLista.get(position).getnomeProduct() + " Added!",
                        Toast.LENGTH_LONG).show();
                x = 1;
                AlteraQtde();
                AlteraPreco(holder, position);
            });

            mais.setOnClickListener(v -> {
                if (x < 5){
                    x++;
                } else {
                    Toast.makeText(getApplicationContext(),"Não Há Mais Unidades Disponíveis", Toast.LENGTH_SHORT).show();
                }

                AlteraQtde();
                //Integer.toString(i) or String.valueOf(i)
                //String.format("%.2f", "variavel");
                AlteraPreco(holder, position);
            });
        }

        private void AlteraQtde() {
            Qtde.setText(Integer.toString(x));
        }

        private void AlteraPreco(ViewHolder holder, int position) {
            holder.precoProduto.setText(Double.toString(
                    Double.parseDouble(String.format("%.03f",
                            produtoLista.get(position).getPreco() * x))));
        }

        @Override
        public int getItemCount() {
            return produtoLista.size();
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            TextView nomeProduto;
            ImageView fotoProduto;
            TextView descricaoProduto;
            MaterialRatingBar notaProduto;
            ImageView favProduto;
            TextView precoProduto;

            public ViewHolder(@NonNull View itemView) {
                super(itemView);
                nomeProduto = itemView.findViewById(R.id.nomeCafe);
                fotoProduto = itemView.findViewById(R.id.fotoCafe);
                descricaoProduto = itemView.findViewById(R.id.descricaoCafe);
                notaProduto = itemView.findViewById(R.id.getBar);
                favProduto = itemView.findViewById(R.id.getFavorite);
                precoProduto = itemView.findViewById(R.id.precoCafe);
            }
        }
    }
}