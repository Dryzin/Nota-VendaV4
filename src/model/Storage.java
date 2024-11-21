package model;

import java.util.HashMap;
import java.util.Map;

public class Storage {

    // Estoque de produtos
    private Map<String, StorageItem> storageItems = new HashMap<>();

    public Storage() {
        storageItems.put("at", new StorageItem("Arroz Tatiana", 30.00, 100));
        storageItems.put("ff", new StorageItem("Feijão Fejó", 20.00, 50));
        storageItems.put("msa", new StorageItem("Macarrão Santa Amália", 15.00, 50));
    }

    public boolean isAvailable(String productCode, int quantity) {
        StorageItem item = storageItems.get(productCode);
        return item != null && item.getQuantity() >= quantity;
    }

    // Atualiza o estoque quando um item é vendido
    public void reduceQuantity(String productCode, int quantity) {
        StorageItem item = storageItems.get(productCode);
        if (item != null) {
            item.setQuantity(item.getQuantity() - quantity);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, StorageItem> entry : storageItems.entrySet()) {
            sb.append(String.format("Code: %s, Description: %s, Price: %.2f, Quantity: %d\n",
                    entry.getKey(), entry.getValue().getDescription(), entry.getValue().getPrice(), entry.getValue().getQuantity()));
        }
        return sb.toString();
    }
}
