public class InventoryTest {
    public static void main(String[] args) {
        System.out.println("=== INVENTORY SİSTEM TESTLERİ ===");
        Inventory inv = new Inventory();
        
        // 10 Ürün Ekleme Testi
        for(int i=1; i<=10; i++) {
            inv.addProduct(new Product("T"+i, "Test Ürünü "+i, 10, 5.0));
        }
        
        boolean countCheck = inv.getAllProducts().size() == 10;
        System.out.println(countCheck ? "[BAŞARILI] 10 Ürün Ekleme" : "[HATA] Liste Boyutu");

        // Arama Testi
        boolean searchCheck = inv.findProductByName("Test Ürünü 5") != null;
        System.out.println(searchCheck ? "[BAŞARILI] Ürün Arama" : "[HATA] Arama");

        // Olmayan Ürün Testi
        boolean nullCheck = inv.findProductByName("Hayali") == null;
        System.out.println(nullCheck ? "[BAŞARILI] Null Kontrolü" : "[HATA] Yanlış Arama");
    }
}