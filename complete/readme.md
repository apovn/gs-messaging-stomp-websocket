## Spring Boot: user notifications with web socket ##
Send/Receive message via Spring websocket and channel.

Client send message to channel => Controller process msg => Push msg back to channel => Client receive msg
Trigger message via Restful API  => Controller process msg => Push msg to channel => Client receive msg


### Build and run


#### Prerequisites

- Java 8
- Maven > 3.0

#### From terminal

Go on the project's root folder, then type:

    $ mvn spring-boot:run

#### From Eclipse (Spring Tool Suite)

Import as *Existing Maven Project* and run it as *Spring Boot App*.


### Usage

