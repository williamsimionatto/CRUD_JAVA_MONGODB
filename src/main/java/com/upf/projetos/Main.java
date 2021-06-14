package com.upf.projetos;

import com.upf.projetos.core.GerenciadorPedido;

public class Main {
    private static final GerenciadorPedido gerenciador = new GerenciadorPedido();

    public static void main(String[] args) throws Exception {
        gerenciador.incluirRestaurantes();
        gerenciador.incluirItens();
        gerenciador.incluirClientes();
        gerenciador.incluirPedidos();
        gerenciador.inculirAvaliacoes();

        gerenciador.getPedidosPayamentOptions("MON");
        gerenciador.getPedidosPayamentOptions("REF");

        gerenciador.getItemRestaurante("Bread & Bakery");
        gerenciador.getItemRestaurante("Tasty Treats");

        gerenciador.getItensMaisCaros(5.0);
        gerenciador.getItensSemPedido();

        System.out.println("concluido");
    }
}