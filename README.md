# WhatsApp Chatbot Backend (Spring Boot + AI)

## Overview

This project is a simple chatbot backend built using Java and Spring Boot.
It receives messages via API and responds using both rule-based logic and AI.

---

## Features

* REST API: `/api/webhook`
* Accepts JSON input
* Rule-based replies:

  * Hi → Hello 👋
  * Bye → Goodbye 👋
* AI responses for other messages
* Clean project structure

---

## Tech Stack

* Java
* Spring Boot
* REST API
* Postman
* GitHub

---

## How to Run

1. Clone the repo

```
git clone https://github.com/syedshuaib18/ChatbotDemo.git
cd ChatbotDemo
```

2. Run the project

```
mvn spring-boot:run
```

---

## API Usage

POST request:

```
http://localhost:8080/api/webhook
```

Request:

```
{
  "message": "Hi"
}
```

Response:

```
Hello 👋
```

---

## AI Example

Request:

```
{
  "message": "Explain Java"
}
```

Response:

```
AI-generated response
```

---

## How It Works

* Controller receives request
* DTO maps JSON
* Service processes message
* ChatService handles simple replies
* AIService handles complex queries

---

## Author

Syed Shuaib T
https://github.com/syedshuaib18
