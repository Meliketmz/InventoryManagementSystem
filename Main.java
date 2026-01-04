public class Main {
    public static void main(String[] args) {
        // 1. Envanter Nesnesi Oluşturma
        Inventory myInventory = new Inventory();

        // 2. StockManager Oluşturma (Tedarikçi ismiyle)
        StockManager manager = new StockManager(myInventory, "Global Lojistik");

        // 3. Ürünler Oluşturma (Polymorphism örneği olarak Product referansı kullanıyoruz)
        Product elma = new Product("P001", "Elma", 50, 15.5);
        Product sut = new PerishableProduct("P002", "Süt", 3, 25.0, "2024-12-31");

        // 4. Ürünleri Envantere Ekleme
        myInventory.addProduct(elma);
        myInventory.addProduct(sut);

        System.out.println("\n--- Mevcut Durum ---");
        manager.displayInventoryStatus();

        // 5. Stok Güncelleme İşlemi
        System.out.println("\n--- İşlem: Stok Güncelleme ---");
        manager.manageStockUpdate("Elma", -10); // 10 tane satıldı
        manager.manageStockUpdate("Süt", 5);   // 5 tane yeni geldi

        // 6. Son Durum ve Kritik Stok Kontrolü
        System.out.println("\n--- Final Durum ---");
        manager.displayInventoryStatus();
    }
}