package model;

public class Product {
    private String idProduct;
    private String nameProduct;
    private String inventoryProduct;

    public Product(String idProduct, String nameProduct, String inventoryProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.inventoryProduct = inventoryProduct;
    }

    public Product() {
    }

    public String getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(String idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getInventoryProduct() {
        return inventoryProduct;
    }

    public void setInventoryProduct(String inventoryProduct) {
        this.inventoryProduct = inventoryProduct;
    }
}
