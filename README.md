# Spring boot Library Application

Bu Spring Boot projesi, kullanıcıların kendi kitaplarını yönetmelerini sağlayan bir Kütüphane uygulamasıdır. 
Kullanıcılar, kitaplarını ekleyebilir, düzenleyebilir ve dilerlerse silebilirler. Ekstra olarak bu kitapların 
yazarlarını da ekleyebilir, düzenleyebilir ve dilerlerse silebilirler.
Ayrıca, tüm kitapları silip yeni kitaplar ekleyebilirler.

## Özellikler

- Kitap kaydedebilme
- Kitap editleyebilme
- Kitap silebilme
- Bütün kitapları getirebilme
- Id'si verilen kitabı getirebilme
- Yazar kaydedebilme
- Yazar editleyebilme
- Yazar silebilme
- Bütün yazarları getirebilme
- Id'si verilen yazarı getirebilme

## Kullanılan Teknolojiler

- Java 17
- Spring Boot
- Spring Data JPA
- Spring MVC
- MySQL
- Gradle
- Docker

```bash
src folder:
- controller
  - BookController
    - AuthorController
- exception
  - BaseException
  - BusinessException
  - DomainNotFoundExcepiton
- model
  - entity
    - Book
    - Author
  - request
    - BookRequest
    - AuthorRequest
- repository
  - BookRepository
    - AuthorRepository
- service
  - BookService
  - AuthorService

```

## Persist Links:

    // Backend URL
    // http://localhost:8080/book
    // http://localhost:8080/book/{id}
    // http://localhost:8080/book/name
    // http://localhost:8080/author
    // http://localhost:8080/author/{id}
    // http://localhost:8080/author/?name={name}&surname={surname}

## Endpoints:

| EndPoint                | Method | Description                       |
|-------------------------|:------:|-----------------------------------|
| /book                   |  POST  | Kitap kaydeder                    |
| /book/id                |  PUT   | Kaydedilen kitabı düzenler        |
| /book                   |  GET   | Bütün kitapları getirir           |
| /book/name              |  GET   | Kitapları isme göre getirir       |
| /author                 |  GET   | Bütün yazarları getirir           |
| /author/?name=&surname= |  GET   | Yazarları isimlerine göre getirir |
| /author                 |  POST  | Yazar kaydeder                    |
| /author/id              |  PUT   | Kaydedilen yazarı düzenler        |
| /book/id                |  DEL   | Id'si verilen kitabı siler        |
| /book                   |  DEL   | Bütün kitapları siler             |
| /author/id              |  DEL   | Id'si verilen yazarı siler        |
| /author                 |  DEL   | Bütün yazarları siler             |



## API Kullanımı
Projeyi klonlayın
```bash
git clone https://github.com/oguzhantuncer/librart-api-enoca
```
Proje Dizinine Gidin
```bash
cd library-api-enoca
```
Bağımlılıkları Yükleyin
```bash
./gradlew clean build -x test
```
Uygulamayı Çalıştırın
```bash
cd build/libs
java -jar library-api-0.0.1-SNAPSHOT.jar
```
