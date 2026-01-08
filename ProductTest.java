/**
 * Kapsamlı Birim Test Sınıfı (10 Farklı Senaryo)
 * Bu sınıf; OOP prensiplerini, hata yönetimini ve veri tutarlılığını test eder.
 */
public class ProductTest {
    public static void main(String[] args) {
        System.out.println("========== ENVANTER SİSTEMİ: 10 KADEMELİ BİRİM TESTLERİ ==========");
        
        int passCount = 0;
        try {
            if (testPositiveStockIncrease()) passCount++;   // 1
            if (testPositiveStockDecrease()) passCount++;   // 2
            if (testInsufficientStockException()) passCount++; // 3
            if (testProductRemoval()) passCount++;          // 4
            if (testNonExistingProductSearch()) passCount++; // 5
            if (testLowStockAlertTrue()) passCount++;       // 6
            if (testLowStockAlertFalse()) passCount++;      // 7
            if (testPerishableProductInheritance()) passCount++; // 8
            if (testPriceValidation()) passCount++;         // 9
            if (testInventoryAddIntegrity()) passCount++;   // 10

            System.out.println("\n====================================================");
            System.out.println("ÖZET: 10 testten " + passCount + " tanesi başariyla geçti.");
            
            if (passCount == 10) {
                System.out.println("DURUM: MÜKEMMEL - Sistem tüm senaryolarda kararli!");
            }
        } catch (Exception e) {
            System.out.println("Test sirasinda kritik sistem hatasi: " + e.getMessage());
        }
    }

    // 1. Pozitif Stok Artışı
    public static boolean testPositiveStockIncrease() throws InsufficientStockException {
        Product p = new Product("T1", "Elma", 10, 5.0);
        p.updateStock(20);
        boolean res = p.getStockLevel() == 30;
        printResult("1. Pozitif Stok Artisi", res);
        return res;
    }

    // 2. Pozitif Stok Azalışı
    public static boolean testPositiveStockDecrease() throws InsufficientStockException {
        Product p = new Product("T2", "Armut", 50, 5.0);
        p.updateStock(-20);
        boolean res = p.getStockLevel() == 30;
        printResult("2. Pozitif Stok Azalisi", res);
        return res;
    }

    // 3. Exception (Hata) Kontrolü
    public static boolean testInsufficientStockException() {
        try {
            Product p = new Product("T3", "Hata", 5, 5.0);
            p.updateStock(-10); // Hata fırlatmalı
            return false;
        } catch (InsufficientStockException e) {
            printResult("3. Yetersiz Stok Hata Firlatma", true);
            return true;
        }
    }

    // 4. Ürün Silme Kontrolü
    public static boolean testProductRemoval() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product("T4", "Sil", 10, 5.0));
        inv.removeProduct("T4");
        boolean res = inv.getAllProducts().size() == 0;
        printResult("4. Envanterden Ürün Silme", res);
        return res;
    }

    // 5. Olmayan Ürün Arama (Null Kontrolü)
    public static boolean testNonExistingProductSearch() {
        Inventory inv = new Inventory();
        boolean res = inv.findProductByName("Hayali") == null;
        printResult("5. Olmayan Ürün Arama (Null)", res);
        return res;
    }

    // 6. Kritik Stok Uyarısı (Düşük Stok)
    public static boolean testLowStockAlertTrue() {
        Product p = new Product("T6", "Kritik", 3, 5.0); // 3 < 5
        boolean res = p.isLowStock();
        printResult("6. Kritik Stok Uyari (True)", res);
        return res;
    }

    // 7. Normal Stok Durumu (Uyarı Yok)
    public static boolean testLowStockAlertFalse() {
        Product p = new Product("T7", "Normal", 10, 5.0); // 10 > 5
        boolean res = !p.isLowStock();
        printResult("7. Normal Stok Durumu (False)", res);
        return res;
    }

    // 8. Kalıtım (Inheritance) Kontrolü
    public static boolean testPerishableProductInheritance() {
        PerishableProduct pp = new PerishableProduct("T8", "Süt", 10, 20.0, "2025-01-01");
        boolean res = pp instanceof Product && pp.getName().equals("Süt");
        printResult("8. Kalitim ve Polimorfizm", res);
        return res;
    }

    // 9. Fiyat Bilgisi Doğruluğu (Encapsulation)
    public static boolean testPriceValidation() {
        Product p = new Product("T9", "Ürün", 10, 99.99);
        boolean res = p.getPrice() == 99.99;
        printResult("9. Fiyat Veri Korumasi", res);
        return res;
    }

    // 10. Çoklu Ürün Ekleme ve Liste Bütünlüğü
    public static boolean testInventoryAddIntegrity() {
        Inventory inv = new Inventory();
        inv.addProduct(new Product("A1", "A", 1, 1.0));
        inv.addProduct(new Product("A2", "B", 1, 1.0));
        boolean res = inv.getAllProducts().size() == 2;
        printResult("10. Envanter Liste Bütünlüğü", res);
        return res;
    }

    private static void printResult(String name, boolean success) {
        System.out.println((success ? "[BASARILI] " : "[HATA]     ") + name);
    }
}