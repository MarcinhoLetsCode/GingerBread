package br.com.etecia.gingerbread;

public class Products {
    String nomeProduct;
    int imagemProduct;
    String descricaoProduct;
    int ratingProduct;
    int favorite;
    double preco;

    public Products() {
    }

    public Products(String nomeProduct, int imagemProduct, String descricaoProduct, int ratingProduct, int favorite, double preco) {
        this.nomeProduct = nomeProduct;
        this.imagemProduct = imagemProduct;
        this.descricaoProduct = descricaoProduct;
        this.ratingProduct = ratingProduct;
        this.favorite = favorite;
        this.preco = preco;
    }

    public String getnomeProduct() {
        return nomeProduct;
    }

    public void setnomeProduct(String nomeProduct) {
        this.nomeProduct = nomeProduct;
    }

    public int getImagemProduct() {
        return imagemProduct;
    }

    public void setImagemProduct(int imagemProduct) {
        this.imagemProduct = imagemProduct;
    }

    public String getDescricaoProduct() {
        return descricaoProduct;
    }

    public void setDescricaoProduct(String descricaoProduct) {
        this.descricaoProduct = descricaoProduct;
    }

    public int getRatingProduct() {
        return ratingProduct;
    }

    public void setRatingProduct(int ratingProduct) {
        this.ratingProduct = ratingProduct;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
