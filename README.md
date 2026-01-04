# Envanter Yonetim Sistemi

Bu proje, nesne yönelimli programlama (OOP) prensipleri kullanılarak geliştirilmiş, esnek ve modüler bir **Envanter Yönetim Sistemi**dir. Sistem, ürünlerin takibini, stok güncellemelerini, kritik stok uyarılarını ve verilerin kalıcı olarak saklanmasını sağlar.

## Temel Özellikler

- **OOP Prensipleri:** Kalıtım (Inheritance), Polimorfizm, Kapsülleme (Encapsulation) ve Arayüz (Interface) kullanımı.
- **Hata Yönetimi (Exception Handling):** Yetersiz stok durumları için özel `InsufficientStockException` sınıfı ile güvenli işlem takibi.
- **Birim Testleri:** Sistemin kararlılığını ölçen 10 farklı senaryoyu kapsayan kapsamlı test modülü.
- **Dosya İşlemleri (File I/O):** Envanter verilerinin `inventory.txt` dosyasına otomatik kaydedilmesi.
- **Kritik Stok Takibi:** Stok seviyesi 5'in altına düşen ürünler için otomatik uyarı sistemi.

## Kullanılan Teknolojiler

- **Dil:** Java
- **Sürüm Kontrolü:** Git & GitHub
- **Geliştirme Ortamı:** VS Code

## Proje Yapısı

- `Storable.java`: Temel stok davranışlarını tanımlayan arayüz.
- `Product.java`: Temel ürün sınıfı (Base Class).
- `PerishableProduct.java`: Son kullanma tarihli ürünler için türetilmiş sınıf (Inheritance).
- `Inventory.java`: Ürün listesini yöneten merkezi sınıf (Composition).
- `StockManager.java`: Envanter operasyonlarını koordine eden yönetici sınıf.
- `InventoryFileManager.java`: Veri kaydetme ve yükleme işlemlerinden sorumlu sınıf.
- `ProductTest.java`: Birim testlerin bulunduğu sınıf.

## Kurulum ve Çalıştırma

1. Projeyi bilgisayarınıza indirin veya klonlayın.
2. Terminali proje klasöründe açın.
3. Tüm dosyaları derleyin:
   ```bash
   javac *.java
   ```

# Önce her şeyi derleriz

javac \*.java

# Ana programı çalıştırırız (Dosya kaydı yapacak mı bakılır)

java Main

# Testleri çalıştırırız (10/10 veriyor mu bakılır)

java ProductTest
