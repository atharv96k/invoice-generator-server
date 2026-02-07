# Invoice Generator API – Backend

## **Part 1: Create an API to Store Invoice Details**

This module implements the foundational backend API required to **store invoice details**.
It follows a clean, layered architecture using **Spring Boot** and **MongoDB**, covering entity modeling, persistence, service logic, and REST controller exposure.

---

## ✅ What Is Covered in This Module

✔ Create backend Spring Boot project and add dependencies
✔ Create Invoice entity
✔ Create MongoDB repository
✔ Create service layer
✔ Create REST controller
⬜ Test the API (to be covered later)

---

## Tech Stack

* **Java**
* **Spring Boot**
* **Spring Web**
* **Spring Data MongoDB**
* **MongoDB**
* **Lombok**

---

## Project Structure

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

## Invoice Entity

The `Invoice` class represents the primary MongoDB document stored in the `invoices` collection.

### Annotations Used

* `@Document(collection = "invoices")`
* `@Id`
* `@CreatedDate`
* `@LastModifiedBy`
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

## Repository Layer

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

## Service Layer

### InvoiceService

Encapsulates business logic for invoice operations.

#### Available Method

* `saveInvoice(Invoice invoice)`

  * Saves invoice data to MongoDB
  * Returns the persisted invoice

This layer ensures separation of concerns between the controller and database logic.

---

## Controller Layer

### InvoiceController

Exposes REST endpoints for invoice operations.

#### Base URL

```
/api/invoices
```

#### Create Invoice Endpoint

| Property     | Value           |
| ------------ | --------------- |
| HTTP Method  | POST            |
| Endpoint     | `/api/invoices` |
| Request Body | Invoice JSON    |
| Response     | Saved Invoice   |

```java
@PostMapping
public ResponseEntity<Invoice> saveInvoice(Invoice invoice)
```

### Configuration

* `@RestController`
* `@RequiredArgsConstructor`
* `@CrossOrigin("*")` (Allows all origins)

--- 

## Current Status

✔ Invoice storage API implemented
✔ MongoDB integration completed
✔ Clean layered architecture
❌ API testing pending

---

## Next Steps (Upcoming Parts)

* Test the API
* Add GET, UPDATE, DELETE endpoints
* PDF generation
* Invoice templates
* Authentication & authorization

---

## Summary

**Part 1** delivers a complete backend API to **store invoice details**, forming the foundation for all future invoice-related features.

---
 