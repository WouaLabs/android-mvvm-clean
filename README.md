#Android MVVM + Clean Architecture
 
This repository contains a sample app skeleton that implements **MVVM + Clean architecture in Kotlin** along with **Dagger, Room, RxJava2 and Retrofit**.
 
Using this combination of MVVM + Clean architecture enhances the separation of concerns with modular approach.
 
**Plug and play this skeleton to build great apps in Kotlin ;)**

##Architecture Block diagram


##Project structure

The project is simple containing Contacts API client, storing the response in Room and observing the Live data in the View.
The app has following modules
1. Cache – Persistent database layer using Room
2. Data – A single point of contact for data accessing from a data source (cache/remote)
3. Domain – Use cases (Please explain this)
4. Remote – Network layer using Retrofit

##Library references
1.    Retrofit
2.    Dagger2
3.    Room
4.    RxJava
5.    KotlinDSL
