package br.com.etecia.gingerbread;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ProdutoFragment extends Fragment {
    private int i;
    RecyclerView recyclerView;
    List<Products> produtoLista;

    public ProdutoFragment(int i) {
        this.i = i;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_produto, container, false);

        switch (i) {
            case 0:
                produtoLista = new ArrayList<>();
                produtoLista.add(new Products("Café Preto",
                        R.drawable.cafepreto,
                        "Café",
                        2,
                        R.drawable.ic_baseline_favorite,
                        "R$ " + "1.10"));
                produtoLista.add(new Products("Café com Leite", R.drawable.coffee, "Café", 3, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Capuccino", R.drawable.cappucino, "Café", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Frapuccino ", R.drawable.frappucino, "Café", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Café com Nutella", R.drawable.cafecnutella, "Café", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Café Expresso", R.drawable.cafeexpresso, "Café", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                break;
            case 1:
                produtoLista = new ArrayList<>();
                produtoLista.add(new Products("Muffin de Laranja",
                        R.drawable.muffinlaranja,
                        "Muffin",
                        2,
                        R.drawable.ic_baseline_favorite,
                        "R$ " + "1.10"));
                produtoLista.add(new Products("Muffin Tradicional", R.drawable.muffintradicional, "Muffin", 3, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Muffin de Morango", R.drawable.muffinmorango, "Muffin", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Muffin de Chocolate", R.drawable.muffinchocolate, "Muffin", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Muffin de Maçã", R.drawable.muffinmaca, "Muffin", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Muffin de Aveia", R.drawable.muffinaveia, "Muffin", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                break;
            case 2:
                produtoLista = new ArrayList<>();
                produtoLista.add(new Products("Chá de Limão", R.drawable.chalimao, "Chá", 2, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Chá Preto", R.drawable.chapreto, "Chá", 3, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Chá de Erva Doce", R.drawable.chaervadoce, "Chá", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Chá de Camomila", R.drawable.chacamomila, "Chá", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Chá de Erva Sidreira", R.drawable.chaervasidreira, "Chá", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Chá de Hibisco", R.drawable.chahibisco, "Chá", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                break;
            case 3:
                produtoLista = new ArrayList<>();
                produtoLista.add(new Products("Donuts de Oreo", R.drawable.donutsoreo, "Donuts", 2, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Donuts de Bacon", R.drawable.donutsbacon, "Donuts", 3, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Donuts de Kinder Joy", R.drawable.donutskinder, "Donuts", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Donuts Brigadeiro", R.drawable.donutsbrigadeiro, "Donuts", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Donuts de Nutella", R.drawable.donutsnutella, "Donuts", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
                produtoLista.add(new Products("Donuts de Morango", R.drawable.donutsmorango, "Donuts", 5, R.drawable.ic_baseline_favorite, "R$ " + "1.10"));
            default:
                break;
        }

        recyclerView = v.findViewById(R.id.rvProduto);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.hasFixedSize();
        ProductsAdapter productsAdapter = new ProductsAdapter(getContext(), produtoLista, i);
        recyclerView.setAdapter(productsAdapter);

        return v;
    }
}