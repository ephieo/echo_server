# Echo Server

Building an echo sever in Java to learn more about Java, sockets and software delivery.

### How to run app 

- Clone the repo 
- If running in vs code :
  - run `./gradlew build` to build the gradle project.
  - Then run `./gradlew run` to run the project.
- If running in intellij :
  - Open up the gradle project window and execute the build task. 
  - You can also just click the build button. 
  - To run the actual project once built run the application task or enter `./gradlew run` in the terminal. 

###  Overview
Building an echo server to introduce myself to networking fundamentals.

### Functional Requirements
######  A user should be able to interact with the echo server as follows:

- When a client sends a message to the server, the server sends a response back to the client containing the original message.
- A client can send multiple messages to the server and get the echoed response back each time.
- Multiple clients can send messages to server and get back their proper responses.
-
###### Implementation Requirements
- The server should establish a socket connection with the client using a low-level socket library. The goal of this exercise is to work with sockets directly.
- The server should accept and return streams of data rather than raw strings.
- The echo server should be covered by a robust suite of tests.