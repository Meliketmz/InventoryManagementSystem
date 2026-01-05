# Envanter Yönetim Sistemi

Bu proje, nesne yönelimli programlama (OOP) prensipleri kullanılarak geliştirilmiş, esnek ve modüler bir **Envanter Yönetim Sistemi**dir. Sistem, ürünlerin takibini, stok güncellemelerini, kritik stok uyarılarını ve verilerin kalıcı olarak saklanmasını sağlar.

## Temel Özellikler

- **OOP Prensipleri:** Kalıtım (Inheritance), Polimorfizm, Kapsülleme (Encapsulation) ve Arayüz (Interface) kullanımı.
- **Hata Yönetimi (Exception Handling):** Yetersiz stok durumları için özel `InsufficientStockException` sınıfı ile güvenli işlem takibi.
- **Kapsamlı Birim Testleri:** Tüm sistem bileşenlerini (Inventory, Manager, File System) denetleyen modüler test yapısı.
- **Otomatik Test Raporlama:** `SystemTestRunner` ile tüm testlerin tek komutla çalıştırılması ve `test_log.txt` dosyasına raporlanması.
- **Dosya İşlemleri (File I/O):** Envanter verilerinin `inventory.txt` dosyasına otomatik kaydedilmesi.
- **Kritik Stok Takibi:** Stok seviyesi 5'in altına düşen ürünler için otomatik uyarı sistemi.

## Kullanılan Teknolojiler

- **Dil:** Java
- **Sürüm Kontrolü:** Git & GitHub
- **Geliştirme Ortamı:** VS Code

## Proje Yapısı

- `Storable.java`: Temel stok davranışlarını tanımlayan arayüz.
- `Product.java`: Temel ürün sınıfı (Base Class).
- `PerishableProduct.java`: Son kullanma tarihli ürünler için türetilmiş sınıf.
- `Inventory.java`: Ürün listesini yöneten merkezi sınıf.
- `StockManager.java`: Envanter operasyonlarını koordine eden yönetici sınıf.
- `InventoryFileManager.java`: Veri kaydetme ve yükleme işlemlerinden sorumlu sınıf.
- `SystemTestRunner.java`: Tüm testleri yöneten ve raporlayan merkezi test motoru.

## Test Modülleri

Sistem güvenilirliği aşağıdaki bağımsız test sınıfları ile sağlanmaktadır:

- **ProductTest:** Temel ürün fonksiyonlarının doğrulanması.
- **InventoryTest:** Liste yönetimi ve ürün arama fonksiyonlarının testi.
- **StockManagerTest:** Stok güncelleme ve hata fırlatma mekanizmalarının kontrolü.
- **InventoryFileManagerTest:** Dosya okuma/yazma erişim testleri.

## Kurulum ve Çalıştırma

1. Projeyi bilgisayarınıza indirin veya klonlayın.
2. Terminali proje klasöründe açın.
3. Tüm dosyaları derleyin:
   ```bash
   javac *.java
   ```

Ana programı çalıştırın (20 ürünlük envanteri işler ve kaydeder):
-> java Main

Tüm sistem testlerini çalıştırın ve raporu görün:
-> java SystemTestRunner
