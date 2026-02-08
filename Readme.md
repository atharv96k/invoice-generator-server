# Invoice Generator API – Backend

This module implements the foundational backend API required to **store and retrieve invoice details**.
It follows a clean, layered architecture using **Spring Boot** and **MongoDB**, covering entity modeling, persistence, service logic, and REST controller exposure.

---

## ✅ What Is Covered in This Module

✔ Create backend Spring Boot project and add dependencies
✔ Create Invoice entity
✔ Create MongoDB repository
✔ Create service layer
✔ Create REST controller
✔ Create POST API to store invoices
✔ Create GET API to fetch all invoices

---

## 🛠️ Tech Stack

* **Java**
* **Spring Boot**
* **Spring Web**
* **Spring Data MongoDB**
* **MongoDB**
* **Lombok**

---

## 📂 Project Structure

```
com.master.invoicegeneratorapi
│
├── controller
│   └── InvoiceController
│
├── service
│   └── InvoiceService
│
├── repository
│   └── InvoiceRepository
│
└── enitity
    └── Invoice
```

---

## 📄 Invoice Entity

The `Invoice` class represents the primary MongoDB document stored in the `invoices` collection.

### Annotations Used

* `@Document(collection = "invoices")`
* `@Id`
* `@CreatedDate`
* `@LastModifiedDate`
* `@Data`

### Fields Overview

| Field          | Description                 |
| -------------- | --------------------------- |
| `id`           | Unique invoice ID           |
| `company`      | Company issuing the invoice |
| `billing`      | Billing details             |
| `shipping`     | Shipping details            |
| `invoice`      | Invoice metadata            |
| `items`        | List of invoice items       |
| `notes`        | Additional notes            |
| `logo`         | Logo reference              |
| `tax`          | Tax value                   |
| `title`        | Invoice title               |
| `template`     | Invoice template            |
| `thumbnailUrl` | Invoice preview             |
| `createdAt`    | Creation timestamp          |
| `updatedAt`    | Last updated timestamp      |

### Embedded Models

* **Company** → name, phone, address
* **Billing** → name, phone, address
* **Shipping** → name, phone, address
* **InvoiceDetails** → invoice number, date, due date
* **Item** → name, quantity, amount, total, description

---

## 🗄️ Repository Layer

### InvoiceRepository

Handles database operations for invoices.

```java
public interface InvoiceRepository 
        extends MongoRepository<Invoice, String> {
}
```

* Uses Spring Data MongoDB
* Provides standard CRUD operations
* No custom queries in Part 1

---

## 🧠 Service Layer

### InvoiceService

Encapsulates business logic for invoice operations.

#### Available Methods

* `saveInvoice(Invoice invoice)`

  * Saves invoice data to MongoDB
  * Returns the persisted invoice

* `fetchInvoice()`

  * Fetches all stored invoices
  * Returns a list of invoices

This layer ensures proper separation of concerns between the controller and repository.

---

## 🌐 Controller Layer

### InvoiceController

Exposes REST endpoints for invoice operations.

#### Base URL

```
/api/invoices
```

---

### ➕ Create Invoice

| Property    | Value           |
| ----------- | --------------- |
| HTTP Method | POST            |
| Endpoint    | `/api/invoices` |
| Request     | Invoice JSON    |
| Response    | Saved Invoice   |

```java
@PostMapping
public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice)
```

---

### 📄 Fetch All Invoices

| Property    | Value            |
| ----------- | ---------------- |
| HTTP Method | GET              |
| Endpoint    | `/api/invoices`  |
| Response    | List of invoices |

```java
@GetMapping
public ResponseEntity<List<Invoice>> fetchInvoice()
```

---

### Configuration

* `@RestController`
* `@RequiredArgsConstructor`
* `@RequestMapping("/api/invoices")`
* `@CrossOrigin("*")` (Allows all origins)

---

## 📌 Current Status

✔ Invoice storage API implemented
✔ Invoice fetch API implemented
✔ MongoDB integration completed
✔ Clean layered architecture
✔  API testing

---

## 🔜 Next Steps (Upcoming Parts)

* Add UPDATE and DELETE endpoints
* Pagination & sorting
* DTOs and validation
* PDF generation
* Invoice templates
* Authentication & authorization

