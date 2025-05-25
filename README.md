# 🎬 Movie Review Site
<img width="831" alt="image" src="https://github.com/user-attachments/assets/2f0fd9ca-0caa-4053-996b-e595f747e822" />

Spring Boot 기반의 영화 리뷰 사이트입니다.

사용자는 **영화 정보를 조회하고, 리뷰를 작성하고, 조회/수정/삭제** 를 할 수 있습니다.

---

## 📌 프로젝트 개요

- 백엔드: Spring Boot, Spring Data JPA
- DB: MySQL (Docker 사용)
- DB 시각화: DBeaver
- API 테스트: Postman
- 협업: Git + GitHub (branch: `jiwon`)

---

## 📚 ERD(Entity Relationship Diagram)
![Untitled](https://github.com/user-attachments/assets/0cd465b2-623c-4c3f-8225-eae547b3907c)

```
User (user_id PK)
 └── Review (review_id PK, FK → user_id)
Movie (movie_id PK)
 └── Review (review_id PK, FK → movie_id)
```

---

## 📡 API 명세

### ✅ User API

| 메서드 | URL              | 설명              |
|--------|------------------|-------------------|
| POST   | `/api/users`     | 사용자 생성       |
| GET    | `/api/users`     | 모든 사용자 조회  |
| GET    | `/api/users/{id}`| 특정 사용자 조회  |
| PUT    | `/api/users/{id}`| 사용자 수정       |
| DELETE | `/api/users/{id}`| 사용자 삭제       |

---

### ✅ Movie API

| 메서드 | URL               | 설명               |
|--------|-------------------|--------------------|
| POST   | `/api/movies`     | 영화 등록          |
| GET    | `/api/movies`     | 영화 전체 조회     |
| GET    | `/api/movies/{id}`| 특정 영화 조회     |
| PUT    | `/api/movies/{id}`| 영화 수정          |
| DELETE | `/api/movies/{id}`| 영화 삭제          |

---

### ✅ Review API

| 메서드 | URL                      | 설명                       |
|--------|--------------------------|----------------------------|
| POST   | `/api/reviews`           | 리뷰 작성                  |
| GET    | `/api/reviews`           | 리뷰 전체 조회             |
| GET    | `/api/reviews/{id}`      | 특정 리뷰 조회             |
| GET    | `/api/reviews/user/{id}` | 특정 사용자의 리뷰 조회    |
| GET    | `/api/reviews/movie/{id}`| 특정 영화의 리뷰 조회      |
| PUT    | `/api/reviews/{id}`      | 리뷰 수정                  |
| DELETE | `/api/reviews/{id}`      | 리뷰 삭제                  |
