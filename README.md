# Okey Oyunu Simülasyonu

Bu proje, geleneksel Türk okey oyununun 4 kişilik simülasyonunu Java programlama dili ile gerçekleştiren kapsamlı bir uygulamadır.

## İçindekiler

- [Özellikler](#-özellikler)
- [Kurulum](#-kurulum)
- [Kullanım](#-kullanım)
- [Proje Yapısı](#-proje-yapısı)
- [Oyun Kuralları](#-oyun-kuralları)
- [Algoritma](#-algoritma)
- [Örnek Çıktı](#-örnek-çıktı)

## Özellikler

- **Tam Okey Simülasyonu**: 4 kişilik okey oyunu simülasyonu
- **Akıllı Taş Sistemi**: 0-52 arası sayılarla kodlanmış taş sistemi
- **Otomatik Dağıtım**: Rastgele taş dağıtımı (1 oyuncuya 15, diğerlerine 14 taş)
- **Gelişmiş Analiz**: Hem seri hem çift kombinasyonlarını değerlendiren algoritma
- **Okey Optimizasyonu**: Okey taşlarının optimal kullanımı
- **Modüler Tasarım**: 10 farklı sınıfla organize edilmiş kod yapısı

## Kurulum

### Gereksinimler
- Java 21
- Herhangi bir Java IDE (IntelliJ IDEA, Eclipse, VS Code)

### Adımlar
1. Projeyi klonlayın:
```bash
git clone https://github.com/erdalguzel/okey-simulasyonu.git
cd okey-simulasyonu
```

2. Java dosyalarını derleyin:
```bash
javac *.java
```

3. Uygulamayı çalıştırın:
```bash
java Main
```

## Kullanım

Program çalıştırıldığında:
1. Otomatik olarak 106 taşlık deste oluşturulur
2. Rastgele gösterge taşı seçilir ve okey taşı belirlenir
3. 4 oyuncuya taşlar dağıtılır
4. Her oyuncunun eli analiz edilir
5. En iyi el (bitmeye en yakın) ekranda gösterilir

```bash
java Main
```

## Proje Yapısı

```
src/
├── OkeyOyunu.java           # Ana koordinatör sınıf
├── Tas.java                 # Taş işlemleri ve bilgileri
├── Oyuncu.java              # Oyuncu yönetimi
├── Deste.java               # Deste oluşturma ve karıştırma
├── OkeyKuralları.java       # Oyun kuralları
├── SeriAnalizci.java        # Seri analiz algoritması
├── ElAnalizci.java          # El analiz sistemi
├── OyunSonucAnalizci.java   # Sonuç hesaplama
├── TasDagitici.java         # Taş dağıtım sistemi
└── OyunEkraniYazici.java    # Ekran çıktı yönetimi
```

### Sınıf Sorumlulukları

| Sınıf | Sorumluluk |
|-------|------------|
| `Tile` | Taş bilgilerini yönetir (renk, sayı, ad) |
| `Player` | Oyuncu verilerini ve elini yönetir |
| `Deck` | Taş destesini oluşturur ve karıştırır |
| `OkeyRules` | Okey taşı belirleme kuralları |
| `SerialAnalyzer` | Ardışık taş kombinasyonu analizi |
| `HandAnalyzer` | Oyuncu elinin kapsamlı analizi |
| `ResultAnalyzer` | Sonuçları hesaplar ve karşılaştırır |
| `TileDistributor` | Oyunculara taş dağıtımı yapar |
| `GameScreenAnalyzer` | Konsol çıktılarını formatlar |
| `Main` | Tüm bileşenleri koordine eder |

## Oyun Kuralları

### Taş Sistemi
- **Sarı**: 0-12 (Sarı-1 den Sarı-13'e)
- **Mavi**: 13-25 (Mavi-1 den Mavi-13'e)
- **Siyah**: 26-38 (Siyah-1 den Siyah-13'e)
- **Kırmızı**: 39-51 (Kırmızı-1 den Kırmızı-13'e)
- **Sahte Okey**: 52

### Dağıtım
- Toplam 106 taş (her taştan 2 adet)
- 1 oyuncuya 15 taş, diğer 3 oyuncuya 14'er taş
- Rastgele gösterge taşı seçimi
- Gösterge taşının bir fazlası okey taşı olur

### Kombinasyonlar
- **Çift**: Aynı taştan 2 adet
- **Seri**: Aynı renkte ardışık 3 veya daha fazla taş
- **Okey Kullanımı**: Eksik taşları tamamlamak için

## Algoritma

### El Analizi Süreci
1. **Okey Tespiti**: Normal okey ve sahte okey taşları belirlenir
2. **Çift Oluşturma**: Aynı taşlardan çiftler oluşturulur
3. **Seri Analizi**: Kalan tekli taşlardan seriler oluşturulur
4. **Okey Optimizasyonu**: Okey taşları eksik yerleri tamamlar
5. **Skor Hesaplama**: Kullanılabilir taş sayısı hesaplanır

### Seri Oluşturma Algoritması
```java
// Renklere göre taşları ayır
// Ardışık sayıları tespit et
// Minimum 3 taşlık serileri oluştur
// Okey taşlarıyla eksik yerleri tamamla
```

## Örnek Çıktı

```
=== OKEY OYUNU SİMÜLASYONU ===
Gösterge Taşı: Mavi-7
Okey Taşı: Mavi-8

=== OYUNCU ELLERİ VE ANALİZ ===

Oyuncu 1 (15 taş):
Taşlar: Kırmızı-2, Kırmızı-5, Mavi-8, Sarı-1, Sarı-3, ...
Kullanılabilir taş sayısı: 12
Kalan taş sayısı: 3

Oyuncu 2 (14 taş):
Taşlar: Siyah-4, Siyah-7, Mavi-1, Kırmızı-9, ...
Kullanılabilir taş sayısı: 10
Kalan taş sayısı: 4

=== SONUÇ ===
En iyi el(ler) (bitmeye en yakın):
- Oyuncu 1 (Kullanılabilir taş: 12)
```
