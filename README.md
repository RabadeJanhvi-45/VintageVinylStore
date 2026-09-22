# Vintage Vinyl Store Management System

## 1. Project Overview

The Vintage Vinyl Store Management System is a Java-based application designed to manage the core operational workflows of a vintage vinyl record store.

The system covers catalogue management, inventory operations, customer wantlists, trade-in valuation, consignment, point-of-sale operations, reservations, receipt processing, and centralized exception handling.

The project was developed incrementally using a feature-based development approach. Each feature was implemented and validated against dedicated acceptance tests.

The first sprint of development covers Features 01 through 10.

---

# 2. Problem Statement

A vintage vinyl store needs to manage multiple interconnected business processes such as maintaining its catalogue, tracking inventory, handling customer requests, processing trade-ins and consignments, completing sales, managing reservations, and generating transaction receipts.

Without a structured application, these operations can become difficult to maintain and can lead to:

- Duplicate catalogue records
- Incorrect inventory information
- Inconsistent trade-in valuations
- Poor handling of customer wantlists
- Invalid or incomplete transactions
- Reservation conflicts
- Receipt generation and storage failures
- Inconsistent error handling across modules

The objective of this project is to build a modular Java application that encapsulates these business rules and provides reliable, testable components for each major store operation.

---

# 3. Project Objectives

The main objectives of the project are:

1. Build a modular Java application for vinyl store operations.
2. Separate business logic from data-access responsibilities.
3. Implement domain-specific business rules.
4. Provide reusable services and repositories.
5. Implement structured exception handling.
6. Validate functionality using acceptance tests.
7. Handle file and receipt operations reliably.
8. Maintain source code using Git feature branches.
9. Ensure new features can be integrated without breaking existing functionality.

---

# 4. Functional Scope

The system currently covers the following functional areas:

| Feature | Module | Purpose |
|---------|--------|---------|
| Feature 01 | Catalogue | Manage vinyl catalogue records |
| Feature 02 | Search & Validation | Search and validate catalogue information |
| Feature 03 | Inventory | Manage stock and availability |
| Feature 04 | Wantlist | Manage customer wanted records |
| Feature 05 | Trade-In | Calculate and validate trade-in valuations |
| Feature 06 | Consignment | Manage consigned vinyl records |
| Feature 07 | POS | Process store sales and payments |
| Feature 08 | Reservation | Manage customer reservations |
| Feature 09 | Receipt Processing | Generate, store and audit receipts |
| Feature 10 | Exception Handling | Centralize application error handling |

---

# 5. System Architecture

The application follows a layered architecture that separates responsibilities between different components.

```text
                    ┌──────────────────────┐
                    │      Main / Tests    │
                    └──────────┬───────────┘
                               │
                               ▼
                    ┌──────────────────────┐
                    │      Service Layer   │
                    │   Business Logic     │
                    └──────────┬───────────┘
                               │
                ┌──────────────┴──────────────┐
                ▼                             ▼
      ┌──────────────────┐          ┌──────────────────┐
      │ Repository Layer │          │  Exception Layer │
      │ Data Access      │          │ Error Handling   │
      └────────┬─────────┘          └──────────────────┘
               │
               ▼
      ┌──────────────────┐
      │    Model Layer   │
      │ Domain Objects   │
      └──────────────────┘
