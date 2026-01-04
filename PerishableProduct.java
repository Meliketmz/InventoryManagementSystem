/**
 * PerishableProduct (Bozulabilir Ürün), Product sınıfından türetilmiştir.
 * Bu sınıf Java'daki Inheritance (Kalıtım) özelliğini temsil eder.
 */
public class PerishableProduct extends Product {
    private String expiryDate; // Son kullanma tarihi

    public PerishableProduct(String id, String name, int stockQuantity, double price, String expiryDate) {
        // 'super' anahtar kelimesi ile üst sınıfın (Product) yapıcısını çağırıyoruz
        super(id, name, stockQuantity, price);
        this.expiryDate = expiryDate;
    }

    // Bozulabilir ürüne has ek bir özellik (Getter/Setter)
    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
