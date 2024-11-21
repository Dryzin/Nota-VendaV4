package model;

public class SaleManager {

    private Sale sale;
    private Storage storage;

    public SaleManager(Storage storage) {
        this.sale = new Sale();
        this.storage = storage;
    }

    // Adiciona um item à venda
    public void addItemToSale(String code, int quantity) {
        // Verifica se o estoque tem a quantidade suficiente
        if (!storage.isAvailable(code, quantity)) {
            throw new IllegalArgumentException("Insufficient storage for product: " + code);
        }

        // Adiciona o item à venda
        sale.createSaleItem(code, quantity);
        storage.reduceQuantity(code, quantity); // Atualiza o estoque
    }

    // Define a forma de pagamento
    public void setPaymentMethod(String payment) {
        sale.setPaymentMethod(payment);
    }

    // Finaliza a venda e imprime os resultados
    public void finalizeSale() {
        for (String item : sale.getItems()) {
            System.out.println(item);
        }

        System.out.println(String.format("Total: %.2f", sale.getTotal()));
        System.out.println(String.format("Forma de pagamento: '%s'", sale.getPaymentMethod()));
        System.out.println(String.format("Valor a ser pago: R$%.2f", sale.getFinalPrice()));
    }
}
