# Creational Pattern
> Provide more flexibility in how the objects are actually created.

### Singleton

* Only one instance of class should exist
* Uses
  > Cache, Logging, Session, Driver (ex: database)

---

### Factory 

> Looses coupling of a given code by separating product's CONSTRUCTION from the code that USES the product

* Multiple sub-classes of a super class
* Remove the instantiation from the client class

---

### Abstract Factory

> Allows you to PRODUCE families of RELATED OBJECTS WITHOUT specifying their CONCRETE class

---

### Builder 

* When we pass too many arguments in constructor 
  * Order maintaining during creation of object is hassle.
* When we do not have to pass all parameters during object initialization
* Only pass the required parameter

---

### Prototype

> Delegates the object duplication or cloning process to actual objects that are being cloned

* Avoid multiple object creation for the same instance.
  * Instead, clone the object to a new object and modify as per your needs
* To implement override Clonable::clone interface

