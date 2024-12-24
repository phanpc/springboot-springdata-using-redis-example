## Ví dụ sử dụng Redis cache làm In-memory Database trong microservice sử dụng Spring Boot framewor.

## Hướng dẫn test:
1. File config: config/application.properties
2. Sửa các tham số kết nối tới redis server trong file config.
3. Chạy project: mvn spring-boot:run
4. Vào giao diện web trên browser (Chrome, Edge) gõ url: http://127.0.0.1:9902/
5. Test các chức năng add/edit/delete/list trên giao diện web đi kèm.
(Có thể sử dụng Postman để test các API do service cung cấp, xem APIs trong WebController.java)