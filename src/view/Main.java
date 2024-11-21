package view;

import model.SaleManager;
import model.Storage;

public class Main {
	public static void main(String[] args) {
		// Inicializando o estoque
		Storage storage = new Storage();
		System.out.println("Estoque inicial:");
		System.out.println(storage);

		// Inicializando o gerenciador de vendas
		SaleManager saleManager = new SaleManager(storage);

		saleManager.addItemToSale("at", 2);
		saleManager.addItemToSale("ff", 1);
		saleManager.addItemToSale("msa", 2);

		saleManager.setPaymentMethod("c");

		System.out.println("\nItens da venda:");
		saleManager.finalizeSale();

		// Exibindo estoque atualizado
		System.out.println("\nEstoque atualizado:");
		System.out.println(storage);

	}
}
