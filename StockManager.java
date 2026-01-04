/**
 * StockManager sınıfı, envanter yönetimini ve tedarikçi 
 * operasyonlarını koordine eden merkezi sınıftır.
 */
public class StockManager {
    private Inventory inventory;
    private String supplierName;

    public StockManager(Inventory inventory, String supplierName) {
        this.inventory = inventory;
        this.supplierName = supplierName;
    }

   
    // StockManager.java içinde metodun imzasını 'throws' ile güncelleme:
    public void manageStockUpdate(String productName, int amount) throws InsufficientStockException {
    Product p = inventory.findProductByName(productName);
    if (p != null) {
        // Burada updateStock metodu hata fırlatabilir, o yüzden throws ekledik
        p.updateStock(amount);
        System.out.println(productName + " stoku güncellendi. Yeni miktar: " + p.getStockLevel());
    } else {
        System.out.println("Hata: Ürün bulunamadı!");
    }
    }

    // Tedarikçi ve envanter durumunu raporlar
    public void displayInventoryStatus() {
        System.out.println("--- " + supplierName + " Tedarikçisi Envanter Raporu ---");
        for (Product p : inventory.getAllProducts()) {
            System.out.println("Ürün: " + p.getName() + " | Stok: " + p.getStockLevel());
        }
        inventory.checkLowStockAlerts();
    }
}