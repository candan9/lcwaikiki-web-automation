# lcwaikiki-web-automation

![1 f7lT9HSzT2RcVxktn_SeGA](https://user-images.githubusercontent.com/49526501/174499258-8ff63b1a-570a-4f3f-9af5-7e6896e65304.png)

# Projede kullanılan araçlar ve kütüphaneler

Selenium,cucumber,sparkReport,log4j,testng.

# Projenin kapsamı aşağıdaki senaryodur.  

● Bir yeni müşteri kaydı oluşturulacak.  
● Login olduktan sonra  
● Kategoriler-->Kadın-->Giyim-->Bluz bölümüne girip  
● Filtreleme bölümünden renk seçeneği siyah seçilecek.  
● Sonuçlar listele yapılıp ,gelen ürün sonuçlarından biri seçilip ,üstüne tıklanacak.  
● Beden medium seçilecek ,sepete ekle butonuna tıklanacak  
● Sepetim’e gidilecek ,ürünün adı ,adeti ,bedeni kontrol edilecek.  
● Ödeme yap butonuna tıklayıp,ödeme ekranına gidildiği ,doğru ekrana yönlendiği
kontrol edilecek.

# Test Koşması

Testler "resources/testSuites/Chrome.xml" dosyasını çalıştırarak tetiklenir.  
Testler "resources/testSuites/Parallel.xml" dosyasını çalıştırarak tetiklenir.  
Ayrıca ayrı ayrı feature dosyalarından ve test runner üzerinden de çalıştırılabilir.  


Proje paralel koşumu desteklemektedir(Chrome,Firefox).

# Raporlama

Projede Cucumber ve spark report bulunmaktadır.

Raporlar, /Reports/CucumberReport ve /Report/SparkReport klasörleri altında html ve pdf olarak oluşmaktadır.

