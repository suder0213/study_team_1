


# 온라인 쇼핑몰

1. ERD
2. RestAPI
    1. Customer
    2. Order
    3. Item
    4. OrderItem

## 1. ERD 작성

가장 간단한 온라인 쇼핑몰은 어떤 요소가 있을까? 소비자와 상품, 또 주문 내역은 무조건 필요할 것이다. 이를 토대로 각 엔티티가 가지고 있을 만한 요소를 정리 해보면 다음과 같다.

<img width="637" alt="Image" src="https://github.com/user-attachments/assets/3cfed8cb-a8c8-44ba-b47c-1299e4c69a4c" />

위 개념적 데이터 관계를 논리적으로 바꿔보면,


<img width="632" alt="Image" src="https://github.com/user-attachments/assets/a4b892c3-048b-4c90-91b5-eed7fa08c519" />

```java
// Use DBML to define your database structure
// Docs: https://dbml.dbdiagram.io/docs

Table Customer {
  id integer [primary key, unique]
  name varchar [unique]
  orderIDs integer 
}

Table Order {
  id integer [primary key, unique]
  totalPrice integer
  delivered bool
  orderedUserID integer
}

Table OrderItem{
  orderID integer 
  itemID integer 
}

Table Item {
  id integer [primary key, unique]
  amount integer
  price integer
}

Ref: Customer.orderIDs < Order.id
Ref: Order.orderedUserID - Customer.id
Ref: OrderItem.orderID > Order.id
Ref: OrderItem.itemID > Item.id

```

위와 같은 모습으로 작성 할 수 있다. N:M 관계인 Order과 Item을 연결 해주기 위해 OrderItem 이라는 중간 단계 테이블이 생겼다.

## 2. RestAPI 작성

### 1️⃣ **Customer API**

| API | URL | 메서드 | 요청 바디 |
| --- | --- | --- | --- |
| 고객 목록 조회 | `/customers` | GET | 없음 |
| 고객 상세 조회 | `/customers/{id}` | GET | 없음 |
| 고객 생성 | `/customers` | POST | `{ "name": "홍길동" }` |
| 고객 수정 | `/customers/{id}` | PUT | `{ "name": "김철수" }` |
| 고객 삭제 | `/customers/{id}` | DELETE | 없음 |
| 고객의 주문 조회 | `/customers/{id}/orders` | GET | 없음 |

### 2️⃣ **Orders API**

| API | URL | 메서드 | 요청 바디 |
| --- | --- | --- | --- |
| 주문 목록 조회 | `/orders` | GET | 없음 |
| 주문 상세 조회 | `/orders/{id}` | GET | 없음 |
| 주문 생성 | `/orders` | POST | `{ "totalPrice": 15000, "delivered": false, "orderedUserID": 1 }` |
| 주문 수정 | `/orders/{id}` | PUT | `{ "totalPrice": 20000, "delivered": true }` |
| 주문 삭제 | `/orders/{id}` | DELETE | 없음 |
| 주문의 아이템 목록 | `/orders/{id}/items` | GET | 없음 |
| 주문에 아이템 추가 | `/orders/{id}/items` | POST | `{ "itemID": 5 }` |

### 3️⃣ **Item API**

| API | URL | 메서드 | 요청 바디 |
| --- | --- | --- | --- |
| 아이템 목록 조회 | `/items` | GET | 없음 |
| 아이템 상세 조회 | `/items/{id}` | GET | 없음 |
| 아이템 생성 | `/items` | POST | `{ "amount": 10, "price": 3000 }` |
| 아이템 수정 | `/items/{id}` | PUT | `{ "amount": 20, "price": 2500 }` |
| 아이템 삭제 | `/items/{id}` | DELETE | 없음 |

### 4️⃣ **OrderItem API (중간 테이블)**

| API | URL | 메서드 | 요청 바디 |
| --- | --- | --- | --- |
| 주문에 아이템 추가 | `/order-items` | POST | `{ "orderID": 101, "itemID": 5 }` |
| 주문에서 아이템 제거 | `/order-items` | DELETE | `{ "orderID": 101, "itemID": 5 }` |
| 주문의 아이템 목록 조회 | `/order-items?orderID=101` | GET | 없음 |

