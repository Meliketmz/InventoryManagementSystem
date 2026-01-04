/**
 * Product sınıfı, envanterdeki her ürünün sahip olması gereken temel özellikleri içerir.
 * Değişkenler 'private' tutularak Encapsulation (Kapsülleme) ilkesi uygulanmıştır.
 */
public class Product implements Storable {
    private String id;
    private String name;
    private int stockQuantity;
    private double price;

    public Product(String id, String name, int stockQuantity, double price) {
        this.id = id;
        this.name = name;
        this.stockQuantity = stockQuantity;
        this.price = price;
    }

    // Storable arayüzünden gelen metotların uygulanması
    @Override
    public void updateStock(int quantity) throws InsufficientStockException {
    if (this.stockQuantity + quantity < 0) {
        throw new InsufficientStockException("Hata: " + name + " için yetersiz stok! (Mevcut: " + stockQuantity + ")");
    }
    this.stockQuantity += quantity;
    }

    @Override
    public int getStockLevel() {
        return this.stockQuantity;
    }

    @Override
    public boolean isLowStock() {
        // Eğer stok 5'ten az ise düşük stok uyarısı verir
        return this.stockQuantity < 5;
    }

    // Getter ve Setter Metotları (Encapsulation gereği)
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getId() { return id; }
}