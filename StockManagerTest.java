public class StockManagerTest {
    public static void main(String[] args) {
        System.out.println("=== STOCK MANAGER SİSTEM TESTLERİ ===");
        Inventory inv = new Inventory();
        StockManager sm = new StockManager(inv, "Test Lojistik");

        inv.addProduct(new Product("M1", "Yönetici Test", 50, 10.0));

        try {
            // Başarılı Güncelleme
            sm.manageStockUpdate("Yönetici Test", 20);
            boolean upCheck = inv.findProductByName("Yönetici Test").getStockLevel() == 70;
            System.out.println(upCheck ? "[BASARILI] Stok Artisi" : "[HATA] Artis");

            // Hata Yakalama Testi
            sm.manageStockUpdate("Yönetici Test", -100); 
        } catch (InsufficientStockException e) {
            System.out.println("[BASARILI] Yetersiz Stok Hatasi Yakalandi");
        }
    }
}