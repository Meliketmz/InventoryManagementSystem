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
        System.out.println(productName + " stok guncellendi. Yeni miktar: " + p.getStockLevel());
    } else {
        System.out.println("Hata: Urun bulunamadi!");
    }
    }

    // Tedarikçi ve envanter durumunu raporlar
    public void displayInventoryStatus() {
        System.out.println("--- " + supplierName + " Tedarikcisi Envanter Raporu ---");
        for (Product p : inventory.getAllProducts()) {
            System.out.println("Urun: " + p.getName() + " | Stok: " + p.getStockLevel());
        }
        inventory.checkLowStockAlerts();
    }

    public void removeProductFromInventory(String id) {
    if (inventory.removeProduct(id)) {
        System.out.println("ID'si " + id + " olan urun basariyla silindi.");
    } else {
        System.out.println("Hata: Silinmek istenen urun bulunamadi!");
    }
    }
}