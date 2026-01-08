import java.util.ArrayList;
import java.util.List;

/**
 * Inventory sınıfı, ürünlerin toplu yönetimini sağlar.
 * Composition prensibi gereği içinde bir Ürün listesi (List<Product>) tutar.
 */
public class Inventory {
    private List<Product> products;

    public Inventory() {
        // Composition örneği: Inventory sınıfı Product nesnelerini içeren bir listeye sahiptir.
        this.products = new ArrayList<>();
    }

    // Ürün ekleme (Gereksinim: Minimum Özellikler - Ürün ekleme)
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Sisteme eklendi: " + product.getName());
    }

    // Ürün arama (Gereksinim: Minimum Özellikler - Ürün arama)
    public Product findProductByName(String name) {
        for (Product p : products) {
            if (p.getName().equalsIgnoreCase(name)) {
                return p;
            }
        }
        return null;
    }

    // Az stok uyarısı (Gereksinim: Minimum Özellikler - Az stok uyarısı)
    public void checkLowStockAlerts() {
        for (Product p : products) {
            if (p.isLowStock()) {
                System.out.println("KRITIK STOK UYARISI: " + p.getName() + " (Mevcut: " + p.getStockLevel() + ")");
            }
        }
    }

    public List<Product> getAllProducts() {
        return products;
    }

    // Ürün silme özelliği (Ürün çıkarma işlemi)
public boolean removeProduct(String id) {
    return products.removeIf(p -> p.getId().equals(id));
    }
}