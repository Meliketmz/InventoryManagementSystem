/**
 * Storable arayüzü, envanter sistemindeki nesnelerin 
 * sahip olması gereken temel stok davranışlarını tanımlar.
 */
public interface Storable {
    // Stok miktarını artırmak veya azaltmak için kullanılır
    void updateStock(int quantity);
    
    // Mevcut stok miktarını döndürür
    int getStockLevel();
    
    // Stok kritik seviyenin altındaysa uyarı verir
    boolean isLowStock();
}