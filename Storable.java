/**
 * Storable arayüzü, envanter sistemindeki nesnelerin 
 * temel stok davranışlarını ve hata yönetimini tanımlar.
 */
public interface Storable {
    // Stok miktarını günceller, yetersiz stok durumunda hata fırlatır
    void updateStock(int quantity) throws InsufficientStockException;
    
    // Mevcut stok miktarını döndürür
    int getStockLevel();
    
    // Stok kritik seviyenin altındaysa uyarı verir
    boolean isLowStock();
}