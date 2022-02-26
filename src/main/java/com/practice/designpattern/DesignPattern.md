## Table of Contents
1. [Strategy Pattern](#strategy-pattern)

<a name="strategy-pattern"></a>
##Strategy pattern 
external link: [Detailed info](https://refactoring.guru/design-patterns/strategy)
* The Strategy pattern suggests that you take a class that does something specific in a lot of different ways and extract all of these algorithms into separate classes called strategies.
* The original class, called context, must have a field for storing a reference to one of the strategies. The context delegates the work to a linked strategy object instead of executing it on its own.
* The context isn’t responsible for selecting an appropriate algorithm for the job. Instead, the client passes the desired strategy to the context. In fact, the context doesn’t know much about strategies. It works with all strategies through the same generic interface, which only exposes a single method for triggering the algorithm encapsulated within the selected strategy.

![Real-World Analogy for Strategy Pattern](https://refactoring.guru/images/patterns/content/strategy/strategy-comic-1-en-2x.png?id=7eb14bd7920ad630c1ec)


