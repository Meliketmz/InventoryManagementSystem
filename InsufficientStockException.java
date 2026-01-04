/**
 * Stok yetersiz olduğunda fırlatılan özel hata sınıfı.
 * Java'da Exception sınıfından türetilmiştir.
 */
public class InsufficientStockException extends Exception {
    public InsufficientStockException(String message) {
        super(message);
    }
}