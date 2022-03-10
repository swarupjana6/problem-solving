# Java Memory Management #

<img src="https://i.imgur.com/Kv9ichJ.gif" alt="JVM Native Memory" width="500"/>

> JVM garbage collectors are generational.
> <br/> Objects in Heap are grouped by their age and cleared at different stages

## Heap Memory ##

* Stores: `Objects` OR `dynamic data`.
* Garbage Collection(`GC`) takes place.
* Flags to control Size --> 
> `Xms`(Initial) 
>
> `Xmx`(Max)
* Divided into `Young` and `Old` generation space.

<u><i>NOTE: Entire heap memory is not committed to the Virtual Machine(VM) as some of it is reserved as virtual space and the heap can grow to use this. </i></u>

<img src="https://i.imgur.com/8uh8SPy.png" alt="JVM Native Memory" width="500"/>

### Young generation ###  
* Managed by `Minor GC` aka `Young GC`
* Eden Space: New objects are `created`. 
* Survivor Space: Objects that `survived` the minor GC are stored. (contains halves, `S0` & `S1`)

### Old generation ###
* Old generation aka `Tenured Space`
* Objects that reached the maximum tenure threshold during minor GC live. 
* Managed by `Major GC`.

## GCs Types ##

### Mark & Sweep - GC ###

* AKA stop the world GCs

> `Marking` Objects in use or reachable from GC roots(Stack pointers) recursively are marked as alive.

> `Sweeping` GC removes any object that is not marked alive.

> `Compacting` Survived objects are moved together

<img src="http://i.imgur.com/AZaR0LP.gif" alt="JVM Native Memory" width="500"/>

### Other GCs available as of JDK 11 ###

|      GCs      |        Flag        |      Cores       | Data Sets |                                                                                   More Detail                                                                                    |
|:-------------:|:------------------:|:----------------:|:---------:|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|
|    Serial     |  -XX:+UseSerialGC  | single-processor |   Small   |                                                                                        -                                                                                         |
|   Parallel    | -XX:+UseParallelGC |  muti-processor  |   large   |                                                             intended for applications with medium to large data sets                                                             |
| Garbage-First |    -XX:+UseG1GC    | mutli-processor  |     -     |                                focus on low pause times and high throughput. Enabled by default on most modern machines and OS with large memory.                                |
|       Z       |    -XX:+UseZGC     |        -         |     -     | Experimental GC introduced in JDK 11 </br> scalable low-latency collector </br> intended for applications that require low latency and/or use a very large heap(multi-terabytes) |

Reference :
https://deepu.tech/memory-management-in-jvm/