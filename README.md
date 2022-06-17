# Unclouded Cloud - Don't let Cloud systems cloud yourself
Minecraft Cloud System to manage minecraft services, but be aware of the danger the Minecraft Cloud Systems 
are coming with: Features. So don´t let Cloud systems cloud yourself!

## Why?
I made this cloud for the purpose of having a lightweight cloud which only has a database for configuration 
purposes and not storing every move the player does. The cloud is only there to balance services in order
to provide the best player load balancing for all the services running. It is all running based on redis
which is why you are easily able to listen to status updates or perform an action everywhere you are, everytime
you want.

## Facts
- The whole communication is based on redis or to be more specific: redisson
- The only purpose of the database is to configure service groups and other non-environmental depending configurations
- The cloud currently runs on Java 17
- This cloud was initially made for the FullDive Network but was always meant to be open source
- I want to have a cloud which is only a cloud, nothing more, nothing less

## Requirements for installation
- A running and reachable [Redis](https://redis.io/) Server
- A linux environment running ``screen`` which also has an internet access
- A running and reachable [PostGreSQL](https://www.postgresql.org/) database
- Yourself, time, patience and fun while making your minecraft server network

## It´s all here, go contribute!
You want to be part of this? No problem! Here is some things you may follow when **creating a PR**!

- Follow the Java Conventions: [Java Conventions](https://www.oracle.com/technetwork/java/codeconventions-150003.pdf)
- Only use ``var`` in a non-global situation
- Only write value in upper case if they are a constant, this also applies to static variables.
- Static variables should only be used to access something without dependency injection or as a constant.