package com.upf.projetos.model;

public class PedidoItem {
    private Item item;
    private Integer quantity;

    public PedidoItem() {}
    
    public PedidoItem(Item item, Integer quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}