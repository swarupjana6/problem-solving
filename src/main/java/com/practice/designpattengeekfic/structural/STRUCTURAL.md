# Structural Pattern
> How INHERITANCE and COMPOSITION can be used to provide extra functionality

> 
### Proxy
* Means Filtering
* Control the deleted query in DB only for "admin"

---

### Facade
* Multiple interfaces for similar kind of jobs then we add Facade interface
* Acting as a Route to various interface
* Implementation: Facade helper class that will route to method related specific class 
* Ex: Drivers, Database

---
### Composite

* Mixing of multiple classes and provide functionality
* Participants: Component, Leaf, Composite, Client.

---
### Decorator

* Modify the object at Runtime

---
### FlyWeight

> Lets you fit more objects available in the RAM by sharing common parts of the state between multiple objects,
> instead of storing them individually

```
- Intrinsic Immutable state

- Extrinsic Mutable state
```

* When you are creating too many objects
* When you want to reduce the creation of objects
