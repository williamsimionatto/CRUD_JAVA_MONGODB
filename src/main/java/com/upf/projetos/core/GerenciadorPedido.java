package com.upf.projetos.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.upf.projetos.controller.AvaliacaoController;
import com.upf.projetos.controller.ClienteController;
import com.upf.projetos.controller.ItemController;
import com.upf.projetos.controller.PedidoController;
import com.upf.projetos.controller.RestauranteController;
import com.upf.projetos.model.Avaliacao;
import com.upf.projetos.model.Cliente;
import com.upf.projetos.model.Item;
import com.upf.projetos.model.Pedido;
import com.upf.projetos.model.PedidoItem;
import com.upf.projetos.model.Restaurante;

import org.bson.types.ObjectId;

public class GerenciadorPedido {
    RestauranteController controllerRestaurante = new RestauranteController();
    ItemController controllerItem = new ItemController();
    ClienteController controllerCliente = new ClienteController();
    PedidoController pedidoController = new PedidoController();
    AvaliacaoController avaliacaoController = new AvaliacaoController();

    public GerenciadorPedido() {}

    public void incluirRestaurantes() {
        System.out.println("Incluindo restaurantes");

        controllerRestaurante.deleteAll();
        controllerRestaurante.incluir(new Restaurante(new ObjectId(), "Bread & Bakery", "Padaria", "25m", 4.9, "A Bread & Brakery tem 40 anos de mercado. Fazemos os melhores doces e pães. Compre e confira.", "Funciona de segunda à sexta, de 8h às 23h"));
        controllerRestaurante.incluir(new Restaurante(new ObjectId(), "Burger House", "Hamburgers", "100m", 3.5, "40 anos se especializando em trash food.", "Funciona todos os dias, de 10h às 22h"));
        controllerRestaurante.incluir(new Restaurante(new ObjectId(), "Coffee Corner", "Cafeteria", "30-40m", 4.8, "A Coffe Corner foi eleita a melhor cafeteria da cidade.", "Funciona de segunda à sábado, de 6h às 22h"));
        controllerRestaurante.incluir(new Restaurante(new ObjectId(), "Green Food", "Saudável", "75m", 4.1, "Comida saudável é no Green Food. Compramos barato, vendemos caro.", "Somente em horário de almoço, das 11h às 15h"));
        controllerRestaurante.incluir(new Restaurante(new ObjectId(), "Ice Cream", "Sorvetes", "40-65m", 4.5 , "A Ice Cream é uma sorveteria inovadora.", "Funciona todos os dias, de 10h às 1h"));
        controllerRestaurante.incluir(new Restaurante(new ObjectId(), "Tasty Treats", "Doces", "20m", 4.4, "A doceria com mais tradição da cidade", "Funciona de segunda à sábado, de 8h às 23h"));

        System.out.println("Restaurantes incluidos com sucesso");
    }

    public void incluirRestaurante(Restaurante r) {
        System.out.println("Incluindo restaurante");
        controllerRestaurante.incluir(r);
        System.out.println("Restaurante incluido com sucesso");
    }

    public void incluirItens() {
        System.out.println("Incluindo itens");

        controllerCliente.deleteAll();
        controllerItem.incluir(new Item(1, "Cup Cake", "Cup Cake recheado de Doce de Leite", 8.7, controllerRestaurante.getByName("Bread & Bakery")));
        controllerItem.incluir(new Item(2, "Donut", "Coberto com chantilly", 2.5, controllerRestaurante.getByName("Bread & Bakery")));
        controllerItem.incluir(new Item(3, "Pão Artesanal Italiano", "Pão artesanal com queijos italianos", 15.9, controllerRestaurante.getByName("Bread & Bakery")));

        controllerItem.incluir(new Item(4, "Classic Burger", "O clássico. Não tem como errar.", 18.5, controllerRestaurante.getByName("Burger House")));
        controllerItem.incluir(new Item(5, "Batatas Fritas", "Batata Fritas crocantes", 5.5, controllerRestaurante.getByName("Burger House")));
        controllerItem.incluir(new Item(6, "Refrigerante", "O refri mais gelado da cidade", 4.5, controllerRestaurante.getByName("Burger House")));

        controllerItem.incluir(new Item(7, "Cappuccino com Chantilly", "Tradicional cappuccino com chantilly", 9.9, controllerRestaurante.getByName("Coffee Corner")));
        controllerItem.incluir(new Item(8, "Super Espreso", "Café espresso duplo.", 12.5, controllerRestaurante.getByName("Coffee Corner")));
        controllerItem.incluir(new Item(9, "Starbucks Copycat", "O mais pedido da casa. O verdadeiro café americano pura água.", 15.6, controllerRestaurante.getByName("Coffee Corner")));

        controllerItem.incluir(new Item(10, "Lasagna de Zucchini", "Lasagna deliciosa que se salva por causa do queijo", 14.9, controllerRestaurante.getByName("Green Food")));
        controllerItem.incluir(new Item(11, "Sanduíche de Frango", "Frango grelhado e salada", 10.5, controllerRestaurante.getByName("Green Food")));
        controllerItem.incluir(new Item(12, "Salada Ceasar", "Clássica salada ceasar.", 33.9, controllerRestaurante.getByName("Green Food")));

        controllerItem.incluir(new Item(13, "Mega Sunday", "Sunday com várias bolas de sorvete a sua escolha", 21.5, controllerRestaurante.getByName("Ice Cream")));
        controllerItem.incluir(new Item(14, "Picolé de Brigadeiro", "Picolé de brigadeiro recheado com coco.", 8.5, controllerRestaurante.getByName("Ice Cream")));
        controllerItem.incluir(new Item(15, "Sorvete Simples", "Clássico sorvete de rua onde todos os sabores são idênticos.", 1.5, controllerRestaurante.getByName("Ice Cream")));

        controllerItem.incluir(new Item(16, "Cup Cake de Choc. Branco", "Cup Cake de chocolate branco", 5.5, controllerRestaurante.getByName("Tasty Treats")));
        controllerItem.incluir(new Item(17, "Bolo de Morango", "Bolo recheado e coberto com morangos", 40.5, controllerRestaurante.getByName("Tasty Treats")));
        controllerItem.incluir(new Item(18, "Fatia de Bolo", "Fatia de bolo de morango", 5.9, controllerRestaurante.getByName("Tasty Treats")));

        System.out.println("Itens incluido com sucesso");
    }

    public void incluirItem(Item i) {
        System.out.println("Incluindo item");

        controllerItem.incluir(i);

        System.out.println("Item incluido com sucesso");
    }

    public void incluirClientes() {
        System.out.println("Incluindo clientes");

        controllerCliente.deleteAll();
        controllerCliente.incluir(new Cliente(new ObjectId(), "William", "william@gmail.com", "Rua Três", 3186, "Apartamento 202"));
        controllerCliente.incluir(new Cliente(new ObjectId(), "Julia", "julia@gmail.com", "Avenida", 30, null));
        controllerCliente.incluir(new Cliente(new ObjectId(), "Aline", "Aline@gmail", "Rua Dois", 505, "Bloco B"));
        controllerCliente.incluir(new Cliente(new ObjectId(), "Pedro", "pedro123@gmail..com", "Travessa abacate", 12, null));
        controllerCliente.incluir(new Cliente(new ObjectId(), "Ana", "ana@hotmail.com", "rua 21 de abril", 88, null));
        controllerCliente.incluir(new Cliente(new ObjectId(), "Suzana", "suzanaa1@gmail.com", "avenida dom pedro", 20, null));
        controllerCliente.incluir(new Cliente(new ObjectId(), "Amanda", "Amanda_sm1@gmail.com", "avenida dom pedro", 20, null));
        controllerCliente.incluir(new Cliente(new ObjectId(), "Carla", "Carla@hotmail.com", "rua do comércio", 3697, "Apartamento 404"));
        controllerCliente.incluir(new Cliente(new ObjectId(), "Marcelo", "MarceloP@hotmail.com", "rua do comércio", 3697, "Apartamento 404"));

        System.out.println("Clientes incluidos com sucesso");
    }

    public void incluirCliente(Cliente c) {
        System.out.println("Incluindo clientes");

        controllerCliente.incluir(c);

        System.out.println("Clientes incluidos com sucesso");
    }

    public void incluirPedidos() {
        System.out.println("Incluindo Pedidos");

        pedidoController.deleteAll();
        List<PedidoItem> itens = new ArrayList<PedidoItem>();
        itens.add(new PedidoItem(controllerItem.getByName("Cup Cake"), 1));
        pedidoController.incluir(new Pedido(1, itens, "MON", new Date(), controllerCliente.getByName("Marcelo")));

        itens = new ArrayList<PedidoItem>();
        itens.add(new PedidoItem(controllerItem.getByName("Cup Cake"), 2));
        itens.add(new PedidoItem(controllerItem.getByName("Donut"), 1));

        pedidoController.incluir(new Pedido(2, itens, "REF", new Date(), controllerCliente.getByName("Ana")));

        itens = new ArrayList<PedidoItem>();
        itens.add(new PedidoItem(controllerItem.getByName("Mega Sunday"), 3));
        pedidoController.incluir(new Pedido(3, itens, "MON", new Date(), controllerCliente.getByName("William")));

        System.out.println("Pedidos incluidos com sucesso");
    }

    public void incluirPedido(Pedido p) {
        System.out.println("Incluindo pedido");

        pedidoController.incluir(p);

        System.out.println("Pedido incluido com sucesso");
    }

    public void inculirAvaliacoes() {
        System.out.println("Incluindo Avaliações");

        avaliacaoController.deleteAll();
        avaliacaoController.incluir(new Avaliacao(new ObjectId(), controllerCliente.getByName("William"), controllerRestaurante.getByName("Bread & Bakery"), new Date(), 4.5, "tudo muito bom, entrega no tempo certo"));
        avaliacaoController.incluir(new Avaliacao(new ObjectId(), controllerCliente.getByName("Julia"), controllerRestaurante.getByName("Bread & Bakery"), new Date(), 3.0, "NÃO recomendo. O recheio é só um creme, não tem camarão e nem carne"));
        avaliacaoController.incluir(new Avaliacao(new ObjectId(), controllerCliente.getByName("Ana"), controllerRestaurante.getByName("Bread & Bakery"), new Date(), 2.0, "Não foi muito agradável ao nosso paladar, e eu e meu esposo no outro dia passamos super mal. Pode até ter sido outra coisa, mas..."));
        avaliacaoController.incluir(new Avaliacao(new ObjectId(), controllerCliente.getByName("Aline"), controllerRestaurante.getByName("Bread & Bakery"), new Date(), 5.0, "Nunca deixou na mão, comida sempre deliciosa."));

        avaliacaoController.incluir(new Avaliacao(new ObjectId(), controllerCliente.getByName("Pedro"), controllerRestaurante.getByName("Burger House"), new Date(), 4.0, "Sanduíche muito bom! Já pedi diversas vezes sempre bom!"));
        avaliacaoController.incluir(new Avaliacao(new ObjectId(), controllerCliente.getByName("Aline"), controllerRestaurante.getByName("Burger House"), new Date(), 5.0, "Melhor hambúrguer que já provei. Vai ser difícil voltar para mc e bk"));
        avaliacaoController.incluir(new Avaliacao(new ObjectId(), controllerCliente.getByName("Suzana"), controllerRestaurante.getByName("Burger House"), new Date(), 3.5, "Meu sanduíche chegou frio e todo desmontado"));

        avaliacaoController.incluir(new Avaliacao(new ObjectId(), controllerCliente.getByName("Amanda"), controllerRestaurante.getByName("Coffee Corner"), new Date(), 2.5, "Demorou muito e o café veio gelado."));
        avaliacaoController.incluir(new Avaliacao(new ObjectId(), controllerCliente.getByName("Carla"), controllerRestaurante.getByName("Coffee Corner"), new Date(), 4.8, "Tudo perfeito. Entrega, embalagem, comida. Resultado? Melhor custo beneficio"));

        avaliacaoController.incluir(new Avaliacao(new ObjectId(), controllerCliente.getByName("Marcelo"), controllerRestaurante.getByName("Ice Cream"), new Date(), 2.2, "Não gostei dos sabados que pedi e achei o preço muito alto"));
        avaliacaoController.incluir(new Avaliacao(new ObjectId(), controllerCliente.getByName("Ana"), controllerRestaurante.getByName("Ice Cream"), new Date(), 4.5, "Veio ok!"));

        System.out.println("Avaliações incluidas com sucesso");
    }

    public void inculirAvaliacao(Avaliacao a) {
        System.out.println("Incluindo Avaliação");

        avaliacaoController.incluir(a);

        System.out.println("Avaliação incluida com sucesso");
    }

    public void getPedidosPayamentOptions(String payamentOptions) {
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n\n");
        List<Pedido> pedidos = pedidoController.getPedidosPayamentOptions(payamentOptions);
        System.out.println("Pedidos pago com: " + payamentOptions);

        System.out.println("Cod. | \t Cliente | \t Pagamento | \t | Data ");

        for (Pedido pedido : pedidos) {
            System.out.print(pedido.getId() + " | \t " + pedido.getCliente().getName() + " | \t " + pedido.getPayamentOptions() + " | \t " + pedido.getDate() + " | \t ");

            List<PedidoItem> pedidoItem = pedido.getItens();

            for (PedidoItem itensPedido : pedidoItem) {
                if (itensPedido.getItem() != null) {
                    System.out.print("Item: "+ itensPedido.getItem().getName() + " - Quantidade: " + itensPedido.getQuantity() + ", ");
                }
            }

            System.out.println();
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n\n\n\n");
    }

    public void getItemRestaurante(String name) {
        List<Item> itens = controllerRestaurante.getItemRestaurante(name);
        System.out.println("Itens do restaurante: " + name);
        System.out.println("Cod. | \t Nome | \t Descrição | \t | Preço");

        for (Item item : itens) {
            System.out.println(item.getId() + " | \t" + item.getName() + " | \t" +  item.getDescription() + " | \t" +  item.getPrice());
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n\n\n\n");
    }

    public void getItensMaisCaros(Double price) {
        List<Item> itens = controllerItem.getItensMaisCaros(5.0);
        System.out.println("Itens mais caros que: " + price);
        System.out.println("Cod. | \t Nome | \t Descrição | \t | Preço");

        for (Item item : itens) {
            System.out.println(item.getId() + " | \t" + item.getName() + " | \t" +  item.getDescription() + " | \t" +  item.getPrice());
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n\n\n\n");
    }

    public void getItensSemPedido() {
        List<Pedido> pedidos = pedidoController.getAll();
        List<String> names;
        names = new ArrayList<String>();

        for (Pedido pedido : pedidos) {
            if (pedido != null) {
                List<PedidoItem> pedidoItem = pedido.getItens();

                for (PedidoItem itensPedido : pedidoItem) {
                    if (itensPedido.getItem() != null) {
                        names.add(itensPedido.getItem().getName());
                    }
                }
            }
        }

        List<Item> itens = controllerItem.getItensSemPedido(names);
        System.out.println("Itens sem pedidos");
        System.out.println("Cod. | \t Nome | \t Descrição | \t | Preço");

        for (Item item : itens) {
            System.out.println(item.getId() + " | \t" + item.getName() + " | \t" +  item.getDescription() + " | \t" +  item.getPrice());
        }

        System.out.println("-----------------------------------------------------------------------------------------------------------------------------\n\n\n\n");
    }
}