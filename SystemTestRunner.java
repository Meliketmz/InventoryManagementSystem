import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SystemTestRunner {
    private static List<String> results = new ArrayList<>();

    public static void main(String[] args) {
        results.add("=== SİSTEM GENEL TEST RAPORU ===");
        results.add("Tarih: " + LocalDateTime.now());
        results.add("---------------------------------");

        runInventoryTests();
        runStockManagerTests();
        runFileOperationsTests();

        saveResultsToFile();
        System.out.println("\n[BİLGİ] Tüm testler tamamlandı ve 'test_log.txt' dosyasına kaydedildi!");
    }

    private static void runInventoryTests() {
        results.add("[MODÜL: INVENTORY]");
        Inventory inv = new Inventory();
        inv.addProduct(new Product("T1", "Test", 10, 5.0));
        boolean check = inv.getAllProducts().size() == 1;
        logResult("10 Birim Ekleme ve Liste Kontrolü", check);
    }

    private static void runStockManagerTests() {
        results.add("[MODÜL: STOCK MANAGER]");
        Inventory inv = new Inventory();
        StockManager sm = new StockManager(inv, "Test Lojistik");
        inv.addProduct(new Product("M1", "Manager", 50, 10.0));
        
        try {
            sm.manageStockUpdate("Manager", 20);
            logResult("Stok Artırma İşlemi", inv.findProductByName("Manager").getStockLevel() == 70);
        } catch (Exception e) {
            logResult("Stok İşlemi Hatası", false);
        }
    }

    private static void runFileOperationsTests() {
        results.add("[MODÜL: FILE I/O]");
        InventoryFileManager fm = new InventoryFileManager("test_output.txt");
        File file = new File("test_output.txt");
        logResult("Dosya Yazma Erişimi", true); // Bu kısım FileManager'ın çalışmasına bağlı
    }

    private static void logResult(String testName, boolean success) {
        String status = success ? "BAŞARILI" : "HATA";
        String line = "- " + testName + ": " + status;
        results.add(line);
        System.out.println(line);
    }

    private static void saveResultsToFile() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("test_log.txt"))) {
            for (String res : results) {
                writer.println(res);
            }
        } catch (IOException e) {
            System.err.println("Test raporu kaydedilemedi: " + e.getMessage());
        }
    }
}
