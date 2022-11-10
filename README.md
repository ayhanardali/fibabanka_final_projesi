# fibabanka_final_projesi
This repo includes Fibabanka Speed Bootcamp's final project.

Bu proje basit bir e-ticaret uygulamasının belirli işlemlerini içermektedir. Commerce mikroservisi, Inventory ve Shopping mikroservisleri üzerinden işlemlerini gerçekleştirmektedir. Projede kullanılan veritabanındaki örnek verileri aşağıda bulabilirsiniz.

Product Table:


![image](https://user-images.githubusercontent.com/102681681/201107059-95929cd8-be17-41b9-a643-f727c334eeaf.png)

Category Table:


![image](https://user-images.githubusercontent.com/102681681/201107335-800f3b7f-18f3-4292-ab6b-e6489fa093fb.png)

Cart Table:


![image](https://user-images.githubusercontent.com/102681681/201107446-f68b5abd-a57a-4049-95a1-fc76e39e81fb.png)

CartProduct Table:


![image](https://user-images.githubusercontent.com/102681681/201107563-48e23ba2-3979-4dd0-9ace-3a0594f3015d.png)

Projede Commerce uygulaması 8080 numaralı porttan, Inventory uygulaması 8081 numaralı porttan ve Shopping uygulaması ise 8082 numaralı porttan çalışmaktadır.

Her modülü kendi portları üzerinden MVC Client ile test edebileceğiniz client sınıfları da bulunmaktadır. Şimdi Commerce uygulaması ile bazı veritabanı işlemleri yapalım ve çıktıları görelim.

**GET /commerce/inventory/categories** //Kategorileri getirir.

<img width="1013" alt="image" src="https://user-images.githubusercontent.com/102681681/201108520-cbfa5ba2-2fd0-4bf7-80d9-a623a1ebab51.png">

**GET /commerce/products/{categoryId}** //Kategori numarasına göre ürünleri getirir.

<img width="1225" alt="image" src="https://user-images.githubusercontent.com/102681681/201108840-cbf10d06-03fc-4da8-b906-d168e4b53035.png">

**GET /commerce/product/{productId}** //Ürün numarasına göre ürünü getirir.

<img width="1017" alt="image" src="https://user-images.githubusercontent.com/102681681/201109051-7c14cb7e-12cf-4b48-a217-e5066ec4d20a.png">

**GET /commerce/shopping/cart/find** //Sepetleri getirir.

<img width="1228" alt="image" src="https://user-images.githubusercontent.com/102681681/201109363-d253b10b-659f-40b2-bf15-cba7f4741ec9.png">

**GET /commerce/shopping/checkout/{cartId} //cartId = 9** //Satın alma işlemi tamamlandığında alışveriş sepetinin tamamlandığı ile ilgili sütunu true yapar.

![image](https://user-images.githubusercontent.com/102681681/201110162-24521ad6-af69-42d1-a896-a7122c593f63.png)

**DELETE /commerce/shopping/cart/{cartId}/remove/{productId} //cartId = 11, productId = 5** // 11 numaralı sepetten 5 numaralı ürünü siler.

![image](https://user-images.githubusercontent.com/102681681/201110837-0e84333d-83b8-449e-ae3e-13614cf6bffb.png)

**GET /commerce/shopping/cart/create** //Sepet oluşturur. Rastgele oluşturduğum 5 isimden birini kullanıcı adı olarak verir. Sepet numarasını geri döner.

![image](https://user-images.githubusercontent.com/102681681/201111449-c32243bd-957a-4106-baad-acbc491d1824.png)

**POST /commerce/shopping/cart/add** //Commerce(8080) üzerinden POSTMAN kullanarak POST işlemi gönderirken sıkıntı yaşadım fakat Shopping(8082) üzerinden gönderdiğimde hiçbir sorun yaşamadım. İleride güncellenecektir.

<img width="1015" alt="image" src="https://user-images.githubusercontent.com/102681681/201124356-52df0d96-25d0-4e61-b284-44e94cad0f5b.png">

![image](https://user-images.githubusercontent.com/102681681/201124435-8c8f1798-f60d-4307-b04e-ab0093a6b054.png)



