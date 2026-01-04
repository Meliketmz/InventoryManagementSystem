import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Opsiyonel Özellik: Dosya İşlemleri
 * Ürünleri dosyaya kaydeder ve dosyadan geri yükler.
 */
public class InventoryFileManager {
    private String fileName;

    public InventoryFileManager(String fileName) {
        this.fileName = fileName;
    }

    // Envanteri dosyaya kaydetme
    public void saveInventory(List<Product> products) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Product p : products) {
                // Verileri: ID,İsim,Stok,Fiyat formatında kaydediyoruz
                writer.println(p.getId() + "," + p.getName() + "," + p.getStockLevel() + "," + p.getPrice());
            }
            System.out.println("Sistem: Envanter başarıyla '" + fileName + "' dosyasına kaydedildi.");
        } catch (IOException e) {
            System.out.println("Dosya yazma hatası: " + e.getMessage());
        }
    }

    // Dosyadan envanteri yükleme
    public void loadInventory(Inventory inventory) {
        File file = new File(fileName);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    Product p = new Product(data[0], data[1], Integer.parseInt(data[2]), Double.parseDouble(data[3]));
                    inventory.addProduct(p);
                }
            }
            System.out.println("Sistem: Veriler dosyadan başarıyla yüklendi.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Dosya okuma hatası: " + e.getMessage());
        }
    }
}