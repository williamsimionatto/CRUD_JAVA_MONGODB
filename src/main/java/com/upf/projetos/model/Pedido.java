package com.upf.projetos.model;

import java.util.Date;
import java.util.List;

import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;

/**
 * @author William
*/
@Entity(value = "pedido", noClassnameStored = true)
public class Pedido {
    @Id
    private Integer id;

    @Embedded
    private List<PedidoItem> itens;
    private String payamentOptions;
    private Date date;

    @Embedded
    private Cliente cliente;

    public Pedido() {}

    public Pedido(Integer id, List<PedidoItem> itens, String payamentOptions, Date date, Cliente cliente) {
        this.id = id;
        this.itens = itens;
        this.payamentOptions = payamentOptions;
        this.date = date;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<PedidoItem> getItens() {
        return itens;
    }

    public void setItens(List<PedidoItem> itens) {
        this.itens = itens;
    }

    public String getPayamentOptions() {
        return payamentOptions;
    }

    public void setPayamentOptions(String payamentOptions) {
        this.payamentOptions = payamentOptions;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}