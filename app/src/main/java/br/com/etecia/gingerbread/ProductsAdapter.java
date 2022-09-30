package br.com.etecia.gingerbread;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import me.zhanghai.android.materialratingbar.MaterialRatingBar;

public class ProductsAdapter extends RecyclerView.Adapter<ProductsAdapter.ViewHolder> {

    private int i;
    private Context context;
    private List<Products> productLista;

    public ProductsAdapter(Context context, List<Products> productLista, int i) {
        this.context = context;
        this.productLista = productLista;
        this.i = i;
    }

    @NonNull
    @Override
    public ProductsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        view = inflater.inflate(R.layout.modelo_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductsAdapter.ViewHolder holder, int position) {
        holder.nomeProduto.setText(productLista.get(position).getnomeProduct());
        holder.fotoProduto.setImageResource(productLista.get(position).getImagemProduct());
        holder.descricaoProduto.setText(productLista.get(position).getDescricaoProduct());
        holder.notaProduto.setNumStars(productLista.get(position).getRatingProduct());
        holder.favProduto.setImageResource(productLista.get(position).getFavorite());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RecyclerHorizontal.class);
                //new RecyclerHorizontal(2);
                intent.putExtra("Posicao", holder.getAdapterPosition());
                intent.putExtra("Produto", i);
                context.startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK));
            }
        });
    }

    @Override
    public int getItemCount() {
        return productLista.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView nomeProduto;
        ImageView fotoProduto;
        TextView descricaoProduto;
        MaterialRatingBar notaProduto;
        ImageView favProduto;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nomeProduto = itemView.findViewById(R.id.txtNome);
            fotoProduto = itemView.findViewById(R.id.imgFood);
            descricaoProduto = itemView.findViewById(R.id.txtDescricao);
            notaProduto = itemView.findViewById(R.id.RatingBar);
            favProduto= itemView.findViewById(R.id.imgFavorite);
            cardView = itemView.findViewById(R.id.idModelo);
        }
    }
}
