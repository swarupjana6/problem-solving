<table>
  <tr>
   <td>Deutsche bank
<p>
1st interview - 21/08- 10 AM
   </td>
   <td>Explain current project architecture
<p>
What is the lifecycle of a REST call?
<p>
<a href="https://dzone.com/refcardz/restful-api-lifecycle-management#">https://dzone.com/refcardz/restful-api-lifecycle-management#</a>
<p>
Employee class has zipCode --  Group employees by zipCode in java 
<p>
<a href="https://roytuts.com/how-to-group-objects-by-their-property-using-java-stream/#:~:text=The%20groupingBy()%20method%20of,concurrently%20by%20using%20concurrent%20Collectors">https://roytuts.com/how-to-group-objects-by-their-property-using-java-stream/#:~:text=The%20groupingBy()%20method%20of,concurrently%20by%20using%20concurrent%20Collectors</a>.
<p>

<p>
What is <strong>CORS- Cross origin resource sharing</strong>?
<p>
<strong>Exception handling SpringBoot apis</strong> 
<p>
Advice- Prepare in-detail on things you have worked on 
   </td>
   <td>
<ul>

<li>REST Lifecyle

<li>Exception Handling Spring Boot
</li>
</ul>
   </td>
  </tr>
  <tr>
   <td>Deutsche bank  2nd interview - 21/08- 11.30 AM
   </td>
   <td>Explain current project architecture
<p>
Family -- Children has Children -- Print all children in father hierarchy 
<p>
<strong>Circuit breaker pattern</strong>
<p>
Write a query to get all employees whose salary is greater than avg for department  
   </td>
   <td>
<ul>

<li>Circuit breaker pattern

<li>
</li>
</ul>
   </td>
  </tr>
  <tr>
   <td>Northern Trust- 22/09 2.30 PM- Rejected 
   </td>
   <td>1)<strong>Java streams vs collections</strong>? Do you face any challenge with Streams where you thought collections would be better?- Streams are not persisted DS, if you want to
<p>
store some data over a longer period you need to use collections. caching? 
<p>
e.g. If you want to store some data as a cache in an application, there are frequent writes and continuous reads to this cache. This cache needs to be thread-safe.
<p>
How would you implement this?-- ConcurrentHashmap. But it also needs to be highly scalable then?--- Redis with ConcurrentHashMap
<p>
2)What are the limitations/<strong>disadvantages of @Autowired in Spring</strong>? 
<p>
3)If we have constructor injection + explicit @Autowired for a particular type, Can spring distinguish this ambiguity? 
<p>
4)If spring beans are by default singleton, Is it safe to say all spring beans are thread safe? What are other scopes of spring beans? Are they thread safe? 
<p>
6)How to define a spring boot property with different values for envs?-- Profiles, application.properties and even cooler is Spring cloud config server
<p>
7)How to implement Fault tolerance in Microservices?-- Circuit breaker pattern using Hystrix. Where do you define Hystrix parameters?-- Inside @HystrixCommand? where do you give this 
<p>
annotation on method or on class? 
<p>
8)Pl Sql- Suppose you have a DB table with billions of records and there is frequent insert with millions of records. You want to read and send back few of the records depending on 
<p>
http request? How would you implement this? 
<p>
9)How do you handle exceptions/errors in pl sql procedures? What is the oracle function for handling them? 
<p>
10)Difference between Factory pattern and abstract factory pattern 
   </td>
   <td>
<ul>

<li>Streams vs Collections

<li>Is Spring B
</li>
</ul>
   </td>
  </tr>
  <tr>
   <td><strong>To The NEW </strong>24/09- 10 AM- Rejected 
   </td>
   <td>1)<strong>What is functional programming</strong>? 
<p>
2)I have a UI form(with user details) which can be accessed simultaneously by multiple users. And they can simultaneously update the fields. 
<p>
How would you implement a pop up when the 2nd user is trying to overwrite previous users data? 
<p>
3)I have a batch job running on 3 instances in prod. They read and write the same DB table. How would you implement locking in this case? They should not work with the same records at the same time. 
<p>
as record processing is a costly operation.-- Read lock on table-- But that will lock the whole table, is that efficient?  
<p>
4)Have you monitored your application in Prod?-- Grafana How does data gets feed to these systems?-- Kafka topics But graffana just create dashboards based on some data from some source, what is that source?-- Not sure
<p>
5)Suppose you have an application in prod, where only a few of the pages are running slow.. how would you debug this issue? What could be possible issues? --- 1 MS or instance having issue.--
<p>
Let's say you have JVM out of memory in 1 MS, what would be your approach? -- Heap dump analysis using MAT
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>MasterCard test 27/09 12.45 PM
   </td>
   <td>1)Write a program for ATM dispense mc.
<p>
ATMs can dispense 50, 20 and 10 Rs bills only.
<p>
User should enter a positive integer in multiples of 10 only. 
<p>
 - If non-positive integer, "Error-Inavlid amount"  
<p>
 - If non multiples of 10 amount, "Error- Please enter the amount in multiples of 10 only" 
<p>

<p>
Input: 530
<p>
Output: 10*50 1*20 1*10
<p>
Constraints:
<p>
Time taken: 1 sec for any input
<p>
Memory: 500Kb max 
<p>
Java 8, Streams
<p>
Lambdas, Functional programming
<p>
Asynch rest calls using <strong>CompletableFuture</strong>
<p>
<strong>SOLID, design patterns</strong> 
<p>
Highly scalable, concurrent cache implementation
<p>
How to allow concurrent updates on table using JPA  
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Oracle 29/09 2 PM- Selected 
   </td>
   <td>1)What is the use of the <strong>Spring data module</strong>?
<p>
2)What is JPA? What things should be taken care of in hibernate to ensure you can change the DB for your application in future with minimal impact/changes.-- Avoid vendor specific 
<p>
code/configs-- examples?-- How does hibernate named queries help?   
<p>
3)Do you know about <strong>SQL injection</strong>? How can you prevent it using hibernate? 
<p>
4)What is <strong>lazy loading in Hibernate</strong> and how is it useful? Exactly when an associated entity is loaded in lazy-loading?
<p>
5)What is spring? What are its advantages? What is loose coupling, high cohesion, example?   
<p>
6)What is a <strong>singleton and prototype in Spring</strong>? Can you give an example of each? -- Told Service, controller, DBConfigs for Singleton and VOs, DB entities for prototype. 
<p>
If we have service beans as singletons, how multiple requests are processed concurrently in Spring? -- Told concurrency is handled by Web containers internally, not sure how.       
<p>
7)What is equals and hashcode contract? What will happen if the hash method returns different values at different times for the same key? Can we use different attributes in hashcode than 
<p>
in equals check?--- What will happen if we use different attributes? 
<p>
8)What is REST? What are its advantages?-- How are HTTP and REST related? Can I use REST using some other transport protocol? 
<p>
9)What are <strong>indexes in RDBMS</strong>? Can I use the primary key as an index column? Can I have multiple columns as indexes for tables? What are clustered and non-clustered indexes? 
<p>
10)How are objects created inside instance methods handled in memory?  
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Oracle 2nd round 04/10 2 PM- Rejected
   </td>
   <td>1)Write a program to <strong>reverse the LinkedList</strong>- can only use Array
<p>
2)What is the <strong>difference between map and filter methods of streams</strong>? --Explained.  What do you mean by Function and Predicate here? They are Functional interfaces 
<p>
<strong>Difference between map and flatMap</strong> method 
<p>
3)I have an Employee and Department table with ManyToOne relation. If I want to delete a particular Dept_id, how do I ensure all related employees also get deleted from the Employee table?
<p>
4)I want to traverse through all Departments and do some processing on associated Employees. What is the problem with eager fetching here? -- Multiple DB hits to fetch employees for diff 
<p>
departments --- How would you solve this? -- Using named query on Employee entity
<p>
5)How to handle <strong>transactions spanning multiple microservices</strong>? Told Orchestrator and event driven pattern(SAGA). How would you <strong>send an event back to MS1 from MS2</strong>? -- Told using kafka
<p>
topics. -- What is the difference between partitioning and replication in kafka cluster? Can multiple consumers read from same topic in kafka? -- Told yes 
<p>
6)How to <strong>create a kafka topic</strong>?-- Told using YAML configs 
<p>
7)Do you know about <strong>@Transactional in Spring</strong>? What is the default transaction scope with this annotation and how to change it? What are propagation types? 
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Wolter Kluwer 1st round 8/10/2021 3 PM- selected
   </td>
   <td>1)Why Java? What are the <strong>advantages of using java over other languages</strong>? 
<p>
2)Difference between String, StringBuilder and StringBuffer 
<p>
3)How to make <strong>HashMap thread safe?</strong> What is <strong>ConcurrentHashMap</strong>? How does it help in Multithreaded env? 
<p>
4)What is the <strong>difference between Interface and Abstract class</strong>? Can you give 1 real life example? 
<p>
5)Java 8 new features? 
<p>
6)Java collections? Which ones have you used? 
<p>
7)What are <strong>Indexes in Relational DB?</strong>
<p>
8)What do you mean by <strong>clustered DB</strong>?    
<p>
9)What are views in relational DB? When are they compiled? 
<p>

<p>
SELECT ba.bookId FROM BookAuthor ba JOIN Book b ON ba.bookId = b.id JOIN 
<p>
BookAuthor ba2 ON b.id = ba2.bookId WHERE ba2.authorId = ? GROUP BY ba.bookId HAVING count(ba.authorId) = 1"   
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Dassault 1st round 12/10/2021 10.30 AM- Rejected
   </td>
   <td>1)What is SOLID in OOP? Please explain with an example.
<p>
2)What is the primary advantage of DI?-- Explained loose coupling and runtime polymorphism --- But runtime polymophism is totally different from DI--- I said no.. DI provides RP
<p>
As per him primary advantage is in mocking the unit test framework... I didn't agree and said loose coupling and RP are main advantages 
<p>
3)Write an application to read a text from a file and return a word with max count. Now i have a requirement to read a text from DB or REST. How will you change the design? 
<p>
Now I also need to write a count to file or DB. What will change? 
<p>
4)What all design patterns have you worked on or had in your project? Can you write a code for the Observer design pattern? 
<p>
5)What are streams in Java 8? Please write a program  to sort HashMap by its value using streams. -- Couldn't write it completely-- Rejected 
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Wolter Kluwers- 2ND ROUND 12/10/2021 4 PM
   </td>
   <td>1)If you have a system where user input validations are not finalized yet and they can change frequently, How would you manage such validation rules? 
<p>
2)Most challenging requirement or bug you have worked on in the last 5 years. 
<p>
3)If you think about the system you worked on 5 years back, what improvements would you like to do now? 
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Infosys- 13/10/2021 10 AM
   </td>
   <td>1)Tell me about yourself. How is the typical development lifecycle in your project? 
<p>
2)Explain current project architecture 
<p>
3)Design a IRCTC system with below requirements -
<p>
Create a ER schema and APIs required 
<p>
Different types of coaches - chair class, 2nd class sitting, 2 tier and 3 tier ac 
<p>
3 tier -72 seats
<p>
2 tier -60 seats
<p>
fare depends on type of train 
<p>
fare of the journey depends on kms +type of train
<p>
Fare depends type of coach 
<p>
Fare depends on the type of passenger 
<p>
Ticket can be booked prior to 48 hours or start of journey
<p>
Each train has fixed no of coaches 
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Publicis Sapient assignment
   </td>
   <td>https://github.com/abhijitsavant/Sapient_Test
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Capgemini- 02/11/2021
   </td>
   <td>1)Difference between Streams and Collections? 
<p>
2)When you want to read data from a DB, How would you make sure there are no simultaneous updates on record? 
<p>
3)There's a service which accepts video/large BLOB files. If partial file is transferred due to some s/w or h/w issue, How do I make sure the file is transferred from the halfway through next time
<p>
4)How did you secure your REST service/EP's in your project? 
<p>
5)What are new features in Java 8? What are the advantages and disadvantages of Lambdas? 
<p>
6)Advantages/disadvantages of streams? 
<p>
7)What are annotations for different message formats in REST? 
<p>
8)What is the use of indexes in DBs? Types for Indexes? 
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Publicis Sapient- 13/11 2.30PM
   </td>
   <td>1)Current project architecture and any challenges you faced during design/development
<p>
2)Why do we need a Cassandra DB for notifications retry? Can you use the kafka message re-read feature? (As per him, we can re-read message from topic until acknowledgement is sent back)
<p>
3)Why did you use Cassandra and not other nosql DB in your application?
<p>
4)You have Employee entity and a Manager who is an employee. Employees have name, salaries. Write a program to sort Managers list based on the sum of salaries for their employees.
<p>
(Create a manager and employee streams and concatenate them and sort them)  
<p>
5)Do you know about short-circuit operators? I have a list of strings and want to check if certian string is contained in a list. How can I do it using short-circuit approach? 
<p>
-- Told about streams and list.contains() but he wanted short-circuit approach
<p>
6)Can you implement a LinkedList? 
<p>
7)Write a program to implement an observer pattern using threads. Do you know about blocking queues? And its applications?
<p>
8)Have you done JVM profiling? 
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Zycus - 09/12/2021 6 PM
   </td>
   <td>1)There's a health insurance claim application. Where users can 
<p>
i)Register
<p>
ii)Raise a claim and upload bills as a proof
<p>
iii)There are 3 instances in prod
<p>
We need to move this file storage to the cloud. How would you design such a system? 
<p>
2)There's an Employee and Department table in relational DB and UI which accepts employee names and returns his details(based on partial entry as well). Write SQL/Hibernate query to get details   
<p>
for the given employee name. 
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Sterlit technologies- 15/12/2021 11.45AM
   </td>
   <td>1)Current project architecture.
<p>
2)Docker file content 
<p>
3)Kafka architecture. What are producers configs? What are consumer configs? Do consumers have to provide ips of all the brokers in the cluster? 
<p>
4)How does data get fed to logging and monitoring systems? Time series databases
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Amdocs- 01/12/2021
   </td>
   <td>1)Write a program to return if string is parentheses balanced - Valid- {{}{}}, invalid- {}{}}}
<p>
2)Design a system for student enrollment to a college, university. 1 student enrolls to 1 college, many colleges belong to 1 univ, student has id in college and 1 id in univ. 
<p>
Students can change colleges within the same university or another university. 
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>LTI- 02/12/2021
<p>
LTI- 2nd round 02/12/2021
   </td>
   <td>1)Java 8 new features. What is functional programming? Can you tell how Java 8 uses FP? 
<p>
2)What JVM changes are done in Java 8
<p>
3)Write a program to get the highest 3 salaried employees from the Employee list. Now can you get all employees whose name starts with 'a/A'? 
<p>
4)Which <strong>microservices pattern</strong> did you use in your project? Why?
<p>
5)What is the <strong>circuit breaker pattern</strong>? How to implement it using @HystrixCommand? 
<p>
6)What is the <strong>supplier interface in java 8</strong>? What is its abstract method? 
<p>
7)CICD tools you used in your project? Have you <strong>set up a job in jenkins</strong>? 
<p>
8)Have you used any cloud cluster? What does the docker file typically contain? 
<p>
9)Explain the build and deployment process in your project  
<p>
1)What is the difference between Java Collections and streams
<p>
2)<strong>deployment process in earlier projects</strong>. 
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Northern Trust- 20/12/2021 1st round
   </td>
   <td>1)Introduction and then what all BFSI clients you have worked on
<p>
2)HashMap working in detail. Shall we have a Hashcode implementation to return as unique value as possible for key objects or not? --- Yes, we should, to avoid collisions.  
<p>
Why do we need to override a hashcode method if default implementation always returns a unique value? --- Default is reference memory in jvm, so we cannot use new object to retrieve a 
<p>
existing key. Can we use a mutable field to calculate a hash for an object? No, because that field change will render the key unusable for operation. 
<p>
3)Write a program to return the count of integers in array 
<p>
4)Write a program to sort the map by its values using java 8 and prior. 
<p>
5)How would you implement authorization/authentication for REST web services?-- Explain about<strong> oAuth2 and JWT</strong>
<p>
What are SB annotations to generate/use this token? (I think related to spring security) 
<p>
6)I want to fetch emp name and dept name from emp and dept tables from DB and write this result to file as a blob. Pls implement it using the Azure pipeline. -- Wrote a query and 
<p>
said I will store it in a materialized view and tell the difference <strong>between view and materialized view</strong>.
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Tech Mahindra- 22/12/2021 Saradhi Ejjagani
   </td>
   <td>1)Brief introduction. Then what kind of role you are interested in - Team lead or individual contributor
<p>
2)Are you aware of different Microservices architectures? Can you explain how a monolith is divided into microservices? based on what criterion? 
<p>
3)There's 1 application which calls external service/API and returns error(Error code, error message, http status) to upstream as received from this service. 
<p>
Now we need to override the error message for all error codes. How would you do it in Spring Boot?  
<p>
4)Write a program to identify if a <strong>String is a palindrome</strong>.
<p>
5)Write sample classes for get and post operations for e-commerce order mgmt service.
<p>
6)Have you worked on Jenkins, Kubernetes, Docker? 
<p>
7)Difference between @Controller and @RestController
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>HCL- 23/12/2021
   </td>
   <td>1)Do you know about<strong> java reflection</strong>?
<p>
2)Can you explain how to write and use custom exceptions in Spring Boot? 
<p>
<a href="https://javatechonline.com/how-to-handle-exceptions-errors-in-spring-boot/">https://javatechonline.com/how-to-handle-exceptions-errors-in-spring-boot/</a> 
<p>
3)What are backward compatible features in java 8? 
<p>
4)Difference between Predicate and Function in Java 8.
<p>
5)Write 1 Functional interface and use it in a code.
<p>
6)What will be output of the below code-
<p>
enum Color { BLACK, WHITE };
<p>
Color nothing = null;
<p>
if (nothing == Color.BLACK);    // runs fine
<p>
if (nothing.equals(Color.BLACK));  // throws NullPointerException
<p>
And then 
<p>
enum Color { BLACK, WHITE };
<p>
enum Chiral { LEFT, RIGHT };
<p>
if (Color.BLACK.equals(Chiral.LEFT));   // compiles fine
<p>
if (Color.BLACK == Chiral.LEFT);	// DOESN'T COMPILE!!! Incompatible types
<p>
7)Can you explain the .docker file content? Properties for setting up env for containers
<p>
8)Difference between sleep() and wait() methods
<p>
9)What is idempotent operation in REST? Which 1 is it? 
<p>
10)What is a resource in REST?    
<p>
11)Can we send payload in the Delete operation of REST? 
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Altimetrik- 06/01/2022 2 PM
   </td>
   <td>1)Difference between image and container-- Image is just application jar/war/ear package, Container is runtime for image. Contains JRE, system libraries and application libraries 
<p>
2)What is <strong>cherry picking in git </strong>
<p>
3)<strong>Difference between Put and Patch</strong>
<p>
	<a href="https://rapidapi.com/blog/put-vs-patch/">https://rapidapi.com/blog/put-vs-patch/</a> 
<p>
3)Use of Head and Option methods in REST
<p>
4)Write a program to remove duplicates from integer array using streams
<p>
5)Write a program to remove characters with more than 1 occurrence from String 
<p>
Input- "abbcaddaeeb"
<p>
Output- "acb"
<p>
6)What all CICD tools have you worked on? What are <strong>webhooks in jenkins</strong>? 
<p>
7)How did you do <strong>Exception handling SpringBoot</strong> application? --- Using @ControllerAdvice and @ExceptionHandler   
<p>
8)Query to get employee name and manager name using join 
<p>
Employee 
<p>
id, name, managerId
<p>
1,abc,3
<p>
2,pqr,3
<p>
3,xyz,5
<p>
9)Current project architecture 
<p>
10)Difference between<strong> Functions and procedures in pl sql</strong>.  
<p>
11)What are the different <strong>types of transactions supported by Spring</strong>? Do you know the difference between <strong>declarative and programmatic transactions in spring</strong>? 
<p>
12)What is a <strong>spring boot actuator</strong>?  
<p>
13)What is the SAGA pattern in microservices? 
<p>
14)Do you know about docker files? From where does the image get pulled if the organization does not have a docker repo? -- DockerHub
<p>
15)What is default <strong>DB provided by spring boot</strong>?-- Told derby but its H2 
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>07/01/2022 -- CitiBank 9 AM
   </td>
   <td>1)Why does java have 2 types of Exceptions? What is difference between checked and unchecked exceptions? If both stops the execution of the program, why handle checked exceptions? 
<p>
2)How do you handle FileNotFoundException? 
<p>
3)I have 2 parts in application- 1:to create a file and place it in 1 shared location. 2: To read the file and insert records in DB. How do you manage synchronization between these 
<p>
2 processes? -- Explained below 2 ways
<p>
a)2 threads- 1 creates and puts file @location, 2nd polls file infinitely and processes it when available. How do you pole infinitely with core java? --- Infinite for loop checking
<p>
if(fileExists?) and sleep for 1 min, if not 
<p>
b)Thread synchronization using wait-notify 
<p>
Can you do thread synchronization using callable and future? -- I said yes.. using Future.get()(blocking) 2nd thread can start its work 
<p>
4)Do you know about Concurrency pkg? How do you manage multiple threads using it?
<p>
5)I have a requirement to process data from 100 buckets. How many threads should I create using the executor framework?  --- I said the same thing with no CPU cores. because increasing the no of threads 
<p>
beyond CPU cores do not improve the performance of applications.
<p>
So lets say I created 10 threads now for 10 core CPUs and after 1 month some other process is deployed in that processor which may take 5 cores, what will you do then? Change the application?
<p>
--- I said having higher no of threads is not an issue, it's just that ThreadScheduler will allocate CPU cycles if NoOfThreads>Cpu cores. So no performance improvement as such 
<p>
6)How many threads are created in the background when you use Future or CompletableFuture for asynchronous programming?
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Persistence system- 12/01/2022 2 PM
   </td>
   <td>1)Implement <strong>Stack DS using Queue</strong>
<p>
2)What is <strong>dynamic class loading in Java</strong>? How does it happen? 
<p>
3)Do you know how<strong> ParallelStreams internally works in Java8</strong>?
<p>
4)What are the advantages of java8 lambdas over anonymous subclasses apart from syntactical benefits? Any runtime benefits you know?
<p>
5)Bean A is singleton, Bean B is prototype B is composed inside A. What will be the scope of B?-- I told effectively singleton-- How can we make it prototype? 
<p>
6)Have you worked on reactive programming? --- I told about CompletableFuture(from Java) but he wanted some generic answer  
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>TSYS- 15/01/2022 11 AM
   </td>
   <td>1)If I have an Employee class with 3 fields, can I use it as a key in HashMap?--- No, you should override equals() and hashCode() methods. What if I don't override?-- You add/get elements based on 
<p>
referential equality --- What if I only override equal and not hasCode? What about the other way around?      
<p>
2)How can we create fixed size maps in java? -- Not possible using core API, you need to extend HashMap and implement your own Map.
<p>
3)Can Java 8 interfaces have private methods? If yes, how will they be used? 
<p>
4)What <strong>do you understand about auto-configuration in SpringBoot</strong>? If I have Spring-boot-starter-data-jpa in SB pom.xml, How can I disable DB connection from application? Basically disable JPA? 
<p>
5)I have been running SB application with some EPs and then I added Spring-boot-starter-security dependency. Can I access my application normally after adding spring security? 
<p>
6)What is the use of @Qualifier in Spring? 
<p>
7)If singleton bean A is injected with prototype bean B. What will happen during runtime? How many beans of B will be created? --- B will be injected into A during application-context load,
<p>
but will get NPE if we try to use B after its lifecycle--- Use &lt;aop:scoped-proxy> on injected bean or &lt;lookup-method name="createCommand" bean="command"/> on injecting bean 
<p>
8)Have you worked on Jenkins, kubernetes and docker? How does Jenkins' job for production work? 
<p>
9)Write a program to find the 2nd highest no from an array? 
<p>
10)What will be o/p of the program below? -
<p>
public class ExceptionTest {
<p>
	public static void main(String[] args) {
<p>
		System.out.println(exceptionTest());
<p>
	}
<p>
	public static int exceptionTest() {
<p>
		int i = 6;
<p>
		try {
<p>
			throw new NullPointerException();
<p>
			return i;
<p>
		} catch (Exception e) {
<p>
			i = 10;
<p>
		} finally {
<p>
			System.out.println("In finally block");
<p>
		}
<p>
		return i;
<p>
	}
<p>
}
<p>
-- I said it works fine 1st with "In finally block" and 10 as o/p and then said Compile error because of line 426. Actual: Compiler error because of line 419. 
<p>
11)What new things have you learned in the last 6 months? -- I told from project-- And what about outside work? -- told about Kafka, educative study 
<p>
12)Name types of design patterns--- Name few structural DPs -- Explain Facade pattern 
<p>
13)What are SOLID principles? -- Can you explain with a real life example? -- explained with Car and MotorCar and ElectricCar
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>InfoGain 15/01/2022 2 PM
   </td>
   <td>1)How to avoid circular dependency in Spring? 
<p>
2)How can you create a custom annotation using core java api(w/o any framework)?
<p>
3)Can you create your own custom JdbcTemplate (w/o extending JdbcTemplate)?
<p>
4)Write a program to return 2nd highest integer from Array (w/o any sorting algo) 
<p>
5)Write a program to sort the string array as below
<p>
input: {"ab","a","aa","abc"};
<p>
Output: {a,aa,ab,abc}
<p>
6)What is the use of dialect in Hibernate? What will happen if I don't provide a dialect? 
<p>
7)Write a query to change the gender for all employees (Only M n F possible values)  
<p>
8)How do different microservices communicate with each other?
<p>
9)Do you know the circuit breaker pattern? What happens if I throw a user defined exception from a method annotated with @HysterixCommand? 
<p>
10)Difference between HTTP patch and update method. Can I do patch using update? 
<p>
11)Can I pass a list in REST to get a call? 
<p>
12)Difference between @Mock and @Spy in Mockito framework. 
<p>
13)Difference between interceptor and filter 
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>TSYS 2nd round 15/01/2022 4 pm
   </td>
   <td>1)Difference between <strong>@Mock and @Spy in the Mockito framework</strong>. 
<p>
2)Difference between <strong>git merge and git rebase</strong>
<p>
3)Do you have conflicts in your current team? How do you resolve them? 
<p>
4)How would you manage others deliverables if given a team lead role? Basically you would be 50% individual contributor and 50% team deliveries responsibility
<p>
5)
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Infogain  2nd round 18/01/2022 3 PM
   </td>
   <td>1)Explain current project 
<p>
2)You have worked on Azure cosmos DB earlier, so can you explain its features? How it is different from other nosqls or sqls? 
<p>
3)Any <strong>disadvantages of noSQL compared to SQL</strong>? Can I use NoSQL DB for SQL usecase? 
<p>
4)If I have a simple quotation system. E.g. I am a construction tools manufacturer and customers come to my portal to get quotations. Can I (Or should I) use Nosql for this use case?  
<p>
5)What is a<strong> spring actuator</strong>? 
<p>
6)Can you explain agile scrum in your project? 
<p>
7)In agile, if there's a stringent timeline for MVP and some of your teammates goes on unplanned leaves, how do you manage the work? 
<p>
8)Can you take up the Java team lead role?
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Tsys 3rd(US) round 19/01/2022 8.30 PM IST
   </td>
   <td>1)Can you explain typically <strong>how authorization is done for an API</strong>? 
<p>
2)What are parts of the JWT token and how does it help in MFA? How are these tokens used across multiple requests of a user HTTP session? 
<p>
3)How <strong>can you maintain a user session using cookies</strong>? Can you explain cookie architecture? 
<p>
4)I have 1 HTML form with different sections and a lot of fields and a single pojo is getting passed to the server side. And these fields are getting passed to the DAO layer w/o any validations. I want to fix this to use dependency injection and validate all i/p fields.  How would you do that in plain java (w/o spring boot)? 
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Infogain 3rd round 24/01/2022 1 PM
   </td>
   <td>1)What is the config server? and how does it work? 
<p>
2)What do you understand about microservices patterns? Advantages and disadvantages. 
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>AltiMetrik 2nd round 25/01/2022 7.30 PM 
   </td>
   <td>1)Quick intro and explain current project architecture in detail.
<p>
2)Java 8 features? Difference between collections and streams in java.
<p>
3)What are the main components of Unix OS and How do you run a background process in Unix? 
<p>
4)What are <strong>hard and soft links in Unix</strong>? 
<p>
5)What is the declare keyword in PL/SQL? In which case is it mandatory? 
<p>
6)What are <strong>cursors in PL/SQL</strong> and what is the difference between implicit and explicit cursors? 
<p>
7)What all things would you<strong> check in code to review</strong> it from <strong>memory leak perspective</strong>? 
<p>
8)What is <strong>garbage collection in java</strong>? 
<p>
9)2 problem statements 
<p>
Fruits and their count in Map
<p>
2nd highest integer in array(can use stream api)  
<p>
10)<strong>Which implementation of kafka did you have? pub-sub or queue</strong>? 
<p>
11)What is the <strong>difference between zookeeper and kafka brokers</strong>?
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>Persistence 28/01/2022 3PM 
   </td>
   <td>1)Explain basic java features with an example. 
<p>
2)What are new features in Java 8? 
<p>
3)Write a program to return words with unique chars in a string. 
<p>
I/p: "Harry chases around grass"
<p>
o/p: around 
<p>
4)Have you worked on docker and kubernetes? How to build a docker image and add it in the helm chart? 
<p>
5)What all things do you check when doing a java code review? -- Solid principles, no lines in method, .* imports, Code to interface, reusability
<p>
6)What tools have you used for static and dynamic code check in your project? 
<p>
7)Puzzle: you have 3 jars with colors- Blue, green, black. 3 balls of same colors are dropped in these jars randomly. How can you determine 
<p>
colors of balls inside each jar using a single pick?   
<p>
8)How much do you rate yourself to learn new technology? 
<p>
9)What new technologies did you learn in the last 6 months?  
   </td>
   <td>
   </td>
  </tr>
  <tr>
   <td>AltiMetrik 3rd tech round 01/02/2022 8.30 PM
   </td>
   <td>1)Introduction and architecture of recent projects-- Explained ING project architecture. 
<p>
2)Why did you use microservices for this use case? It looks like it can be mapped to a monolith as well. 
<p>
3)How authentication and authorization was happening in this architecture? 
<p>
4)<strong>JWT is application layer security</strong>. How did you <strong>implement transport layer security in this projec</strong>t?   
<p>
5)Program to identify count of anagrams in given string 
<p>
String="abcxxcbaxdbcaxabxooocababc"
<p>
pattern="abc"
<p>
result=5
<p>
6)Have you worked on an agile delivery model? 
   </td>
   <td>
   </td>
  </tr>
</table>