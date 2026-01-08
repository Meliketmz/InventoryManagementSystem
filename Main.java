import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        InventoryFileManager fileManager = new InventoryFileManager("inventory.txt");
        StockManager stockManager = new StockManager(inventory, "Sistem");
        Scanner scanner = new Scanner(System.in);

        // Program başlarken eski verileri dosyadan yükle
        fileManager.loadInventory(inventory);

        System.out.println("=== ENVANTER YONETIM SISTEMI - MANUEL GIRIS ===");

        while (true) {
            System.out.println("\n1- Urun Ekle\n2- Urun Sil\n3- Stok Guncelle\n4- Envanteri Listele\n5- Kaydet ve Cikis");
            System.out.print("Seciminiz: ");
            int secim = scanner.nextInt();
            scanner.nextLine(); // Boşluk temizleme

            if (secim == 5) {
                fileManager.saveInventory(inventory.getAllProducts());
                System.out.println("Veriler kaydedildi. Gorusuruz!");
                break;
            }

            switch (secim) {
                case 1:
                    System.out.print("ID (orn: P025): ");
                    String id = scanner.nextLine();
                    System.out.print("Isim: ");
                    String isim = scanner.nextLine();
                    System.out.print("Stok: ");
                    int stok = scanner.nextInt();
                    System.out.print("Fiyat: ");
                    double fiyat = scanner.nextDouble();
                    
                    inventory.addProduct(new Product(id, isim, stok, fiyat));
                    System.out.println("Urun basariyla eklendi.");
                    break;

                case 2:
                    System.out.print("Silinecek Urun ID: ");
                    String silId = scanner.nextLine();
                    if (inventory.removeProduct(silId)) {
                        System.out.println("Urun silindi.");
                    } else {
                        System.out.println("Urun bulunamadi!");
                    }
                    break;

                case 3:
                    System.out.print("Urun Ismi: ");
                    String guncelIsim = scanner.nextLine();
                    System.out.print("Miktar (+ veya -): ");
                    int miktar = scanner.nextInt();
                    try {
                        stockManager.manageStockUpdate(guncelIsim, miktar);
                    } catch (Exception e) {
                        System.out.println("Hata: " + e.getMessage());
                    }
                    break;

                case 4:
                    stockManager.displayInventoryStatus();
                    break;
            }
        }
        scanner.close();
    }
}