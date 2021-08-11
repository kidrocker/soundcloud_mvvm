# Design patterns and considerations

Below are the design decisions and considerations take on this project:

* **Architecture** - MVVM was the choosen architecture. The reasons are MVVM excels at testing, readability, scalability and support in android. In addition to MVVM, I borrowed to features state subscribers from MVI which is a different architecture. With state subscribtion the UI is not dependent on the data source but instead subscribes to changes on the data store. This means that the data store cannot block the UI.

    In addition to MVVM I employed the use of clean architecture which allows separation os concerns and adheres to the **SOLID** principles. The only major downside to MVVM + Clean Architecture is the steep learning curve assiciated with MVVM and clean architecture. However the tradeoffs are worth it in the long run.

* **Dependency Injection** - I chose hilt android which is a for dependency injection. Hilt is simpler, modern and still as powerful as dagger, which it is built on top of. Picking hilt felt like a no brainer.


# Trade offs

* A lot of boilerplate code was needed to set up the project. However, in the long term development of the project, the code will simplify code.


# What can be improved
* Separating network and domain  data classes which would allow us to add multiple datasources.

* Store the *client_id* and *client_secret* in a more secure manner eg datastore or sharedpreferences.

* Add a local cache which allows the application to work offline.

* Add translation to different languages