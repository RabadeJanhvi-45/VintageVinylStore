'<div align="center">

# Vintage Vinyl Store Management System

**A modular Java console application for managing the core workflows of a vintage vinyl record store.**

![Java](https://img.shields.io/badge/Java-Application-ED8B00?style=flat-square&logo=openjdk&logoColor=white)
![Testing](https://img.shields.io/badge/Testing-Acceptance%20Tests-2E8B57?style=flat-square)
![Architecture](https://img.shields.io/badge/Architecture-Layered-6366F1?style=flat-square)

</div>

---

## Overview

The **Vintage Vinyl Store Management System** is a Java-based application designed to organize the operational workflows of a vintage vinyl record store. It brings together catalogue management, inventory, customer wantlists, trade-ins, consignment, point-of-sale operations, reservations, receipt processing, and centralized exception handling.

The project is developed incrementally using a feature-based approach. The repository documentation identifies the first development sprint as covering **Features 01–10**, with functionality validated through dedicated acceptance tests.

## Problem Statement

A vinyl store needs to keep catalogue records, stock availability, customer requests, trade-ins, consignment records, sales, reservations, and receipts consistent. Without a structured system, these workflows can lead to duplicate records, inaccurate inventory, invalid transactions, reservation conflicts, and inconsistent error handling.

This project aims to represent these workflows in a modular Java application with distinct responsibilities and testable business logic.

## Functional Scope

| Feature | Module | Purpose |
|---|---|---|
| 01 | Catalogue | Manage vinyl catalogue records |
| 02 | Search & Validation | Search and validate catalogue information |
| 03 | Inventory | Manage stock and availability |
| 04 | Wantlist | Manage customer wanted records |
| 05 | Trade-In | Calculate and validate trade-in valuations |
| 06 | Consignment | Manage consigned vinyl records |
| 07 | Point of Sale (POS) | Process store sales and payments |
| 08 | Reservation | Manage customer reservations |
| 09 | Receipt Processing | Generate, store, and audit receipts |
| 10 | Exception Handling | Centralize application error handling |

## System Architecture

The application uses a **layered architecture** to separate business logic, data access, domain objects, and error handling.

```text
                  ┌──────────────────────┐
                  │      Main / Tests    │
                  └──────────┬───────────┘
                             │
                             ▼
                  ┌──────────────────────┐
                  │     Service Layer    │
                  │    Business Logic    │
                  └──────────┬───────────┘
                             │
                ┌────────────┴────────────┐
                ▼                         ▼
      ┌──────────────────┐      ┌──────────────────┐
      │ Repository Layer │      │ Exception Layer  │
      │    Data Access   │      │  Error Handling  │
      └────────┬─────────┘      └──────────────────┘
               │
               ▼
      ┌──────────────────┐
      │    Model Layer   │
      │  Domain Objects  │
      └──────────────────┘
```

### Layer Responsibilities

- **Service layer:** Coordinates business rules and application workflows.
- **Repository layer:** Encapsulates data-access responsibilities.
- **Model layer:** Represents the domain objects used by the application.
- **Exception layer:** Provides structured handling for application errors.
- **Main and tests:** Provide application entry points and validation of behavior.

## Project Structure

```text
VintageVinylStore/
├── resources/        # Project resources
├── src/              # Java source code
├── test/             # Test and acceptance-test code
├── .gitignore
└── README.md
```

The exact packages and files are organized within the `src` and `test` directories.

## Getting Started

### Prerequisites

- A Java Development Kit (JDK) compatible with the project configuration
- Git
- The build or test tooling configured in the repository

### 1. Clone the repository

```bash
git clone https://github.com/RabadeJanhvi-45/VintageVinylStore.git
cd VintageVinylStore
```

### 2. Open the project

Open the folder in IntelliJ IDEA or VS Code with Java support. Explore `src` for application code, `test` for tests, and `resources` for supporting files.

### 3. Build and test

Check the repository files and project configuration to identify the configured build tool and test commands. Run the available tests before making changes to verify the current behavior.

> **Note:** The repository overview provided does not establish the exact build tool, JDK version, or test command. These should be confirmed from the project configuration before adding copy-paste build instructions.

## Engineering Practices

The documented project approach includes:

- **Feature-based development:** Implementing functionality incrementally.
- **Modular design:** Separating responsibilities across application layers.
- **Business-rule validation:** Applying rules specific to store operations.
- **Acceptance testing:** Validating features against dedicated tests.
- **Centralized exception handling:** Organizing error handling across modules.
- **Version control:** Using Git feature branches to support incremental changes.

## Potential Next Steps

- Add a documented build and test command.
- Include sample console workflows or screenshots, if available.
- Document the domain models and key business rules.
- Add a feature-by-feature test summary.
- Provide example input and output for catalogue, inventory, sales, and reservations.
