import java.io.File;

public class InventoryFileManagerTest {
    public static void main(String[] args) {
        System.out.println("=== FILE MANAGER SİSTEM TESTLERİ ===");
        Inventory inv = new Inventory();
        InventoryFileManager fm = new InventoryFileManager("test_inventory.txt");

        inv.addProduct(new Product("F1", "Dosya Test", 100, 20.0));
        fm.saveInventory(inv.getAllProducts());

        File file = new File("test_inventory.txt");
        boolean fileExists = file.exists();
        System.out.println(fileExists ? "[BAŞARILI] Dosya Oluşturuldu" : "[HATA] Dosya Yok");

        if(fileExists) file.delete(); // Testten sonra temizlik
    }
}