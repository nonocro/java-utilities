# Java Utilities Project

A collection of utility classes for array operations, calculations, banking, and shopping cart functionality.

## Table of Contents
- [Classes Overview](#classes-overview)
- [Installation](#installation)

## Classes Overview

### 🔢 `ArrayOperator` (`services` package)
**Array sorting utility**  
*Features:*
- `sort(int[] array, SortDirection sortDirection)`
  - SortDirection: `ASC`, `DESC`

### 🧮 `Calculator` (`services` package)
**Basic arithmetic operations**  
*Methods:*
- `add(double x, double y)`
- `sub(double x, double y)`
- `times(double x, double y)`
- `divide(double x, double y)` (throws `CalculatorException`)

### 💳 `BankAccount` (`models` package)
**Simple banking operations**  
*Features:*
- Constructor: `BankAccount(String owner, double initialBalance)`
- `deposit(double amount)`
- `withdraw(double amount)`
- Getters for balance and owner

### 🛍️ `Product` (`models` package)
**Product representation**  
*Attributes:*
- `String name`
- `double price` (non-negative)

### 🛒 `ShoppingCart` (`models` package)
**Shopping cart management**  
*Methods:*
- `addProduct(Product product)`
- `getTotalPrice()`
- `getItemCount()`
- `clearCart()`

## Installation

1. Clone the repository:
```bash
git clone https://github.com/nonocro/java-utilities.git
