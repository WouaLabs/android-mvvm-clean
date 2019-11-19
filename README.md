# Android MVVM + Clean Architecture + Kotlin
 
This repository contains a sample app skeleton that implements **MVVM + Clean architecture in Kotlin** along with **Dagger, Room, RxJava2 and Retrofit**.
 
Using this combination of MVVM + Clean architecture enhances the separation of concerns with modular approach.
 
**Plug and play this skeleton to build great apps in Kotlin ;)**

## Architecture Block diagram ##
![alt text](architecture_diagram.png?raw=true "Architecture diagram")


## Project structure ##

The project is simple containing Contacts API client, storing the response in Room and observing the Live data in the View.
The app has following modules
1. Cache – Persistent database layer using Room
2. Data – A single point of contact for data accessing from a data source (cache/remote)
3. Domain – Use cases (Please explain this)
4. Remote – Network layer using Retrofit

## Library references ##
1.    Retrofit
2.    Dagger2
3.    Room
4.    RxJava
5.    KotlinDSL

### License
```
Copyright (C) 2019 WouaLabs

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
