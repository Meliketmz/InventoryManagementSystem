public class Main {
    public static void main(String[] args) {
        Inventory myInventory = new Inventory();
        StockManager manager = new StockManager(myInventory, "Global Lojistik");

        // Ürünleri ekliyoruz
        Product elma = new Product("P001", "Elma", 50, 15.5);
        Product sut = new PerishableProduct("P002", "Süt", 5, 25.0, "2024-12-31");
        myInventory.addProduct(elma);
        myInventory.addProduct(sut);

        System.out.println("\n--- TEST 1: Ürün Silme ---");
        manager.removeProductFromInventory("P001"); // Elma'yı siliyoruz

        System.out.println("\n--- TEST 2: Hata Yönetimi (Eksi Stok) ---");
        try {
            // Süt stoku 5 adet. 10 adet çıkarmaya çalışırsak hata fırlatmalı.
            manager.manageStockUpdate("Süt", -10); 
        } catch (InsufficientStockException e) {
            System.out.println("Yakalanan Hata: " + e.getMessage());
        }

        // --- OPSİYONEL ÖZELLİK TESTİ: Dosya Kaydı ---
        InventoryFileManager fileManager = new InventoryFileManager("inventory.txt");
        fileManager.saveInventory(myInventory.getAllProducts());


        System.out.println("\n--- Final Durum Raporu ---");
        manager.displayInventoryStatus();
    }
}