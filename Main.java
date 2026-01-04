public class Main {
    public static void main(String[] args) {
        Inventory myInventory = new Inventory();
        StockManager manager = new StockManager(myInventory, "Global Lojistik");

        // --- 20 FARKLI ÜRÜN VERİ SETİ ---
        
        // Standart Ürünler (Temel Gıda & Temizlik)
        myInventory.addProduct(new Product("P001", "Elma", 100, 15.0));
        myInventory.addProduct(new Product("P002", "Ekmek", 50, 10.0));
        myInventory.addProduct(new Product("P003", "Pirinç (1kg)", 40, 45.0));
        myInventory.addProduct(new Product("P004", "Makarna", 60, 15.0));
        myInventory.addProduct(new Product("P005", "Zeytinyağı", 20, 250.0));
        myInventory.addProduct(new Product("P006", "Çay (500g)", 30, 80.0));
        myInventory.addProduct(new Product("P007", "Şeker (1kg)", 25, 35.0));
        myInventory.addProduct(new Product("P008", "Su (5L)", 100, 20.0));
        myInventory.addProduct(new Product("P009", "Sabun", 45, 12.0));
        myInventory.addProduct(new Product("P010", "Deterjan", 15, 180.0));
        
        // Elektronik & Ev Gereçleri (Standart Ürün devamı)
        myInventory.addProduct(new Product("P011", "USB Bellek", 50, 200.0));
        myInventory.addProduct(new Product("P012", "Mouse", 15, 350.0));
        myInventory.addProduct(new Product("P013", "Klavye", 10, 600.0));
        myInventory.addProduct(new Product("P014", "Ampul LED", 80, 45.0));
        myInventory.addProduct(new Product("P015", "Pil (AA 4lu)", 120, 75.0));

        // Dayanıksız Ürünler (Son Kullanma Tarihli - PerishableProduct)
        myInventory.addProduct(new PerishableProduct("P016", "Süt", 10, 30.0, "2025-02-10"));
        myInventory.addProduct(new PerishableProduct("P017", "Yoğurt", 8, 45.0, "2025-01-20"));
        myInventory.addProduct(new PerishableProduct("P018", "Peynir", 12, 120.0, "2025-03-15"));
        myInventory.addProduct(new PerishableProduct("P019", "Tavuk", 5, 150.0, "2025-01-10"));
        myInventory.addProduct(new PerishableProduct("P020", "Yumurta (30lu)", 20, 90.0, "2025-02-05"));

        // --- İŞLEM TESTLERİ ---
        System.out.println("\n--- TEST 1: Ürün Silme (ID: P001 - Elma) ---");
        manager.removeProductFromInventory("P001");

        System.out.println("\n--- TEST 2: Hata Yönetimi (P019 - Tavuk Stoku) ---");
        try {
            manager.manageStockUpdate("Tavuk", -10); 
        } catch (InsufficientStockException e) {
            System.out.println("Yakalanan Hata: " + e.getMessage());
        }

        // --- DOSYA KAYDI ---
        InventoryFileManager fileManager = new InventoryFileManager("inventory.txt");
        fileManager.saveInventory(myInventory.getAllProducts());

        System.out.println("\n--- GÜNCEL ENVANTER RAPORU (19 Ürün Listeleniyor) ---");
        manager.displayInventoryStatus();
    }
}