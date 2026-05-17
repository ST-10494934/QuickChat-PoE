# Lorenza Richard - ST 10494934

# QuickChat - Part 1 (Registration & Login)

## Project Overview
This is **Part 1** of the QuickChat console application developed for **PROG5121**. 

The application allows users to:
- Register an account with username, password, South African cell number, first name, and last name
- Validate all inputs according to the specified rules
- Login using the registered credentials
- Display appropriate success and error messages

## Features Implemented
- Username validation (must contain `_` and be ≤ 5 characters)
- Password complexity validation (≥8 characters, uppercase, number, special character)
- South African cell phone number validation using regex (`+27xxxxxxxxx`)
- First name and last name collection (to match rubric welcome message)
- Secure login with correct success/failure messages
- Clean console interface with ASCII banner
- Comprehensive unit tests using JUnit 5

## Technologies Used
- Java (Maven Project)
- Apache NetBeans 
- JUnit 5 for unit testing

## How to Run
1. Open the project in NetBeans
2. Run the `QuickChatApp.java` file
3. Follow the on-screen prompts to register and login

## Project Structure
- `src/main/java/com/mycompany/quickchat/Login.java` - Core logic and validation
- `src/main/java/com/mycompany/quickchat/QuickChatApp.java` - Main application interface
- `src/test/java/com/mycompany/quickchat/LoginTest.java` - Unit tests

## Unit Tests
All unit tests are passing and cover:
- Username validation
- Password complexity
- Cell phone number validation
- Login success and failure cases

## References
Oracle (n.d.) Scanner (Java Platform SE 8). Available at: https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html
 (Accessed: 02 April 2026).
JUnit (n.d.) JUnit 5 User Guide. Available at: https://junit.org/junit5/docs/current/user-guide/
 (Accessed: 02 April 2026).
Janko Sokolović (2017) Classes and Objects (The Java™ Tutorials). Available at: https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html
 (Accessed: 01 April 2026).
CloudBoost (n.d.) Simple Chat App with React and Java. Available at: https://blog.cloudboost.io/simple-chat-react-java-6923b54d65a0
 (Accessed: 8 April 2026).
Durga Software Solutions (2026) Java Chat Application Tutorial. Available at: https://www.youtube.com/watch?v=NPdyfLwBEbk
 (Accessed: 03 April 2026).
Code Crush (2025) Java Tutorial Video. Available at: https://www.youtube.com/watch?v=B-oJkLavrPE
 (Accessed: 03 April 2026).
Coding with John (2022) Java Tutorial Video. Available at: https://www.youtube.com/watch?v=vZm0lHciFsQ
 (Accessed: 05 April 2026).
Joyce Farrell (2019) Java Programming. 10th edn. Boston: Cengage Learning. (Accessed: 01 April 2026) 

---

# Part 2 - Sending Messages

### Features Implemented
| Feature | Description |
|---------|-------------|
| Login Gate | Users can only send messages after successfully logging in |
| Welcome Message | Displays "Welcome to QuickChat" after login |
| Numeric Menu | Three options — Send Messages, Coming Soon, Quit |
| While Loop | Keeps application running until user selects Quit |
| Message Limit | User defines how many messages to send per session |
| For Loop | Runs exactly the number of times the user specified |
| Recipient Validation | Cell number validated using regex |
| Message Validation | Maximum 250 characters |
| Message ID | Auto-generated random 10 digit number |
| Message Hash | Auto-generated from ID, message number, first and last words in uppercase |
| Message Options | User can send, disregard or store each message |
| JSON Storage | Stored messages saved to JSON file using Gson by Google |
| Message Display | Full details shown after sending — ID, hash, recipient and message |

## Part 2 - Unit Tests
All unit tests are passing and cover:
- Message length validation for success (assertEquals)
- Message length validation for failure (assertEquals)
- Recipient cell number correct (assertEquals)
- Recipient cell number incorrect (assertEquals)
- Message hash format verification (assertTrue)
- Message ID length verification (assertTrue)
- Send status message (assertEquals)
- Disregard status message (assertEquals)
- Store status message (assertEquals)

---

## Technologies Used
| Technology | Purpose |
|------------|---------|
| Java (Maven Project) | Core programming language |
| Apache NetBeans | IDE |
| JUnit 5 | Unit testing |
| Google Gson 2.10.1 | JSON file storage |
| GitHub | Version control |

---

## How to Run
1. Clone the repository from GitHub
2. Open the project in NetBeans
3. Right-click the project and select **Clean and Build**
4. Run `QuickChatApp.java`
5. Follow the on-screen prompts to register and login
6. Choose from the menu to send messages, view coming soon or quit

---

## Project Structure
- `src/main/java/com/mycompany/quickchat/Login.java` - Registration and login logic
- `src/main/java/com/mycompany/quickchat/Message.java` - Message creation, validation, hashing and storage
- `src/main/java/com/mycompany/quickchat/QuickChatApp.java` - Main application interface and menu
- `src/test/java/com/mycompany/quickchat/LoginTest.java` - Unit tests for Login class
- `src/test/java/com/mycompany/quickchat/MessageTest.java` - Unit tests for Message class
- `stored_messages.json` - JSON file for stored messages
- `pom.xml` - Maven dependencies

---
## Changes & Corrections from Part 1

The following changes were made to Part 1 based on feedback received:

- **`registerUser()` method** — Fixed the logic to collect all validation 
  error messages at once instead of stopping at the first failure. 
  Used a StringBuilder to accumulate all errors before returning.

- **`returnLoginStatus()` method** — Fixed the if condition to only check 
  the loggedIn boolean parameter instead of also checking if first name 
  and last name fields were not null.

- **`LoginTest.java`** — Added assertEquals unit tests to verify the exact 
  string messages returned by registerUser() and returnLoginStatus() for 
  valid and invalid username, password and cell phone inputs.

- **String mismatches** — Fixed expected strings in LoginTest to use 
  "Cell phone number" instead of "Cell number" to match exactly what 
  registerUser() returns.

---  

## References
Oracle (n.d.) *Scanner (Java Platform SE 8)*. Available at: https://docs.oracle.com/javase/8/docs/api/java/util/Scanner.html 
(Accessed: 02 May 2026).

Oracle (n.d.) *Random (Java Platform SE 8)*. Available at: https://docs.oracle.com/javase/8/docs/api/java/util/Random.html 
(Accessed: 10 May 2026).

Oracle (n.d.) *FileWriter (Java Platform SE 8)*. Available at: https://docs.oracle.com/javase/8/docs/api/java/io/FileWriter.html 
(Accessed: 10 May 2026).

Google (n.d.) *Gson User Guide*. Available at: https://github.com/google/gson 
(Accessed: 10 May 2026).

JUnit (n.d.) *JUnit 5 User Guide*. Available at: https://junit.org/junit5/docs/current/user-guide/ 
(Accessed: 02 May 2026).

Oracle (2017) *Classes and Objects (The Java™ Tutorials)*. Available at: https://docs.oracle.com/javase/tutorial/java/javaOO/classes.html 
(Accessed: 01 May 2026).

CloudBoost (n.d.) *Simple Chat App with React and Java*. Available at: https://blog.cloudboost.io/simple-chat-react-java-6923b54d65a0 
(Accessed: 08 May 2026).

Durga Software Solutions (2026) *Java Chat Application Tutorial*. Available at: https://www.youtube.com/watch?v=NPdyfLwBEbk 
(Accessed: 03 May 2026).

Code Crush (2025) *Java Tutorial Video*. Available at: https://www.youtube.com/watch?v=B-oJkLavrPE 
(Accessed: 03 May 2026).

Coding with John (2022) *Java Tutorial Video*. Available at: https://www.youtube.com/watch?v=vZm0lHciFsQ 
(Accessed: 05 May 2026).

Farrell, J. (2019) *Java Programming*. 10th edn. Boston: Cengage Learning. 
(Accessed: 01 May 2026).

QuickBlox (n.d.) *Beginners Guide to Chat App Architecture*. Available at: https://quickblox.com/blog/beginners-guide-to-chat-app-architecture/ 
(Accessed: 10 May 2026).

