# QuickChat Java Console Application

## Project Overview

QuickChat is a Java console-based chat application developed for the PROG5121 PoE. The project demonstrates the use of object-oriented programming, validation, arrays, loops, file handling, unit testing, and Continuous Integration using GitHub Actions.

The application allows users to register, login, send messages, store messages, search messages, generate reports, and manage sent messages.

---

# Features

## User Registration

- Username validation
- Password complexity validation
- South African cellphone number validation

## User Login

- Login using registered credentials
- Welcome message after successful login

## Messaging

- Send messages
- Disregard messages
- Store messages for later
- Auto-generate Message IDs
- Auto-generate Message Hashes
- Validate recipient numbers
- Validate message length

## Reports

- Display all sent messages
- Display longest message
- Search messages by Message ID
- Search messages by recipient
- Delete messages using Message Hash
- Display full message report

## Storage

- Save stored messages to JSON

## Testing

- JUnit Unit Tests

## Continuous Integration

- GitHub Actions Pipeline

---

# Dummy User Credentials

## Registration Details

```text
First Name: Kyle
Last Name: Smith
Username: kyl_1
Password: Password1!
Cell Number: +27838968976
```

## Login Details

```text
Username: kyl_1
Password: Password1!
```

---

# Example Recipient Number

Valid recipient:

```text
+27838884567
```

Invalid recipient:

```text
0838884567
```

---

# Project Structure

```text
QuickChat
│
├── src
│   ├── QuickChat.java
│   ├── Login.java
│   ├── Message.java
│   └── MessageManager.java
│
├── test
│   ├── LoginTest.java
│   ├── MessageTest.java
│   └── MessageManagerTest.java
│
├── storedMessages.json
├── README.md
│
└── .github
    └── workflows
        └── java-ci.yml
```

---

# How To Compile

Open the project folder in VS Code and run:

```bash
javac src/*.java
```

---

# How To Run

Run the application:

```bash
java -cp src QuickChat
```

---

# Main Menu

After login, the following menu is displayed:

```text
1) Send Messages
2) Show recently sent messages
3) Quit
```

---

# Sending Messages

The user enters:

- Recipient number
- Message text

Then chooses one of the following:

```text
1) Send Message
2) Disregard Message
3) Store Message To Send Later
```

### Send Message

Returns:

```text
Message successfully sent.
```

### Disregard Message

Returns:

```text
Press 0 to delete the message.
```

### Store Message

Returns:

```text
Message successfully stored.
```

---

# Part 3 Report Menu

```text
1) Display sender and recipient of all sent messages
2) Display the longest sent message
3) Search by Message ID
4) Search by Recipient
5) Delete message by Message Hash
6) Display full sent message report
7) Back to main menu
```

---

# Message Validation

## Recipient Validation

Valid:

```text
+27838884567
```

Returns:

```text
Cell phone number successfully captured.
```

Invalid:

```text
0838884567
```

Returns:

```text
Cell phone number is incorrectly formatted or does not contain an international code.
```

---

## Message Length Validation

Messages must not exceed 250 characters.

Success:

```text
Message ready to send.
```

Failure:

```text
Message exceeds 250 characters by X, please reduce size.
```

---

# Message Hash Format

Message hashes are generated automatically.

Format:

```text
FirstTwoDigitsOfMessageID:MessageNumber:FIRSTWORDLASTWORD
```

Example:

```text
12:1:HITONIGHT
```

---

# JSON Storage

Messages selected to be stored are written to:

```text
storedMessages.json
```

---

# Unit Tests

The project contains JUnit tests for:

- Login validation
- Username validation
- Password validation
- Cellphone number validation
- Message length validation
- Recipient validation
- Message sending
- Longest message detection
- Search by recipient
- Search by Message ID
- Delete by Message Hash
- Message reports

Test classes:

```text
LoginTest.java
MessageTest.java
MessageManagerTest.java
```

---

# Continuous Integration

This project uses GitHub Actions.

The pipeline automatically:

1. Checks out the repository.
2. Sets up Java.
3. Compiles the source files.
4. Compiles the test files.
5. Runs JUnit tests.

Workflow file:

```text
.github/workflows/java-ci.yml
```

---

# Technologies Used

- Java
- VS Code
- JUnit
- JSON
- Git
- GitHub
- GitHub Actions

---

# Notes

- This application is a console application.
- No GUI components are used.
- No JOptionPane is used.
- The application demonstrates Object-Oriented Programming principles.
- Unit tests are included.
- Continuous Integration is implemented using GitHub Actions.
- The project was developed as part of the PROG5121 Practical Assessment.