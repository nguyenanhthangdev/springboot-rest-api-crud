# Spring Boot REST API - Quản lý Sinh viên (CRUD)

## Giới thiệu:

Đây là bài tập REST API cơ bản sử dụng Spring Boot. Ứng dụng thực hiện các thao tác CRUD (Create, Read, Update, Delete) để quản lý thông tin sinh viên. Dữ liệu được lưu trữ trong cơ sở dữ liệu MySQL.

---

## Kiến thức đã áp dụng:

- Spring Boot Framework
- Spring Data JPA (kết nối và thao tác CSDL)
- RESTful API (GET, POST, PUT, DELETE)
- Kết nối MySQL
- Sử dụng Postman để test API
- Xử lý Response trả về với `ResponseEntity`

---

## Cấu trúc chức năng:

| Phương thức | Đường dẫn              | Mô tả                         |
|------------|------------------------|-------------------------------|
| GET        | `/api/students`        | Lấy danh sách sinh viên       |
| GET        | `/api/students/{id}`   | Lấy sinh viên theo ID         |
| POST       | `/api/students`        | Thêm mới sinh viên            |
| PUT        | `/api/students/{id}`   | Cập nhật sinh viên theo ID    |
| DELETE     | `/api/students/{id}`   | Xóa sinh viên theo ID         |

---

## Cấu hình kết nối MySQL:

File `application.properties`:

spring.datasource.url=jdbc:mysql://localhost:3306/demospringrestapi
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
