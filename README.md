# Hotel Reservation System
##  Overview

This project simulates a basic hotel reservation system where users can:

* Register clients
* Reserve rooms
* Validate room availability
* Enter check-in and check-out dates
* Automatically calculate total payment

The system uses modern Java features like `LocalDate` and `BigDecimal` to ensure accuracy and good design practices.
---
##  Features

*  Create reservations
*  Validate room availability
*  Prevent invalid room numbers
*  Input and validate dates (check-in / check-out)
*  Automatic calculation of stay duration
*  Payment calculation based on:
  * Entry fee: $50.00
  * Daily rate: $100.00 per day
---
##  Technologies Used

* Java
* Object-Oriented Programming (OOP)
* `LocalDate` (Java Time API)
* `DateTimeFormatter`
* `BigDecimal` (for monetary calculations)
---
##  How to Run

1. Clone this repository:

```
git clone <your-repo-link>
```
2. Compile the project:
```
javac Main.java
```
3. Run the application:
```
java Main
```
---
##  Example Usage
```
Name: John
Email: john@email.com
Room: 1
Check-in: 25/03/2026
Check-out: 28/03/2026

Reservation created!

Room 1 | John | 25/03/2026 → 28/03/2026 | $350.00
```
---
##  Concepts Applied
* Encapsulation
* Composition (Reservation → Client, StayPeriod)
* Input validation
* Separation of concerns
* Clean code structure
---
##  Future Improvements

* Prevent overlapping reservations
* Add persistent storage (file or database)
* Improve user interface
* Add search by client/email
* Implement reservation editing

---
## Author
Developed by Diogo Yudi as a practical Java backend project focused on object-oriented design and clean code practices.

---
##  License

This project is open-source and available for learning purposes.
