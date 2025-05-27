# 상품정보
카테고리에 대한 상품 정보 제공

## 📁 프로젝트 구조
## ERD

![image.png](attachment:5c7119a7-5be3-4335-8aae-8d5f9211d8c9:image.png)
## API

### ✅ Category API

| 메서드 | URL | 설명 |
| --- | --- | --- |
| POST | `/categories` | 카테고리 등록 |
| GET | `/categories` | 전체 카테고리 조회 |
| PUT | `/categories/{id}` | 카테고리 수정 |
| DELETE | `/categories/{id}` | 카테고리 삭제 |

### ✅ Product API

| 메서드 | URL | 설명 |
| --- | --- | --- |
| POST | `/products` | 상품 등록 |
| GET | `/products` | 상품 전체 조회 |
| PUT | `/products/{id}` | 상품 수정 |
| DELETE | `/products/{id}` | 상품 삭제 |
