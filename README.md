# 📘 Quantum Book Store

## 📖 Overview
The **Quantum Book Store** is a Java console-based system for managing an inventory of multiple types of books and processing user purchases.

---

## 🧱 Features
- Add books to inventory:
  - `PaperBook` – physical books with stock & shipping
  - `EBook` – digital books with file types & email delivery
  - `ShowcaseBook` – non-sellable demo/display books
- Remove books older than a specified number of years
- Purchase books by ISBN
- Simulated shipping & email delivery
- Clear console output prefixed with `Quantum book store`

---

## 🧩 Project Structure
- `Book` (abstract class)
- `PaperBook`, `EBook`, `ShowcaseBook` (subclasses)
- `InventoryManagment` – handles inventory operations
- `QuantumBookstoreFullTest` – runs test scenarios
- `App` – entry point

---


![Screenshot 2025-07-09 034157](https://github.com/user-attachments/assets/071e8f9e-ef00-49b2-bb43-a964dfff2a41)
