package com.practice.javaconcepts.streams.collectors;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collector;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.*;

public class CollectorsExamples {

    public static List<Person> createPeople() {
        return List.of(new Person("Sara", 20),
                new Person("Sara", 22),
                new Person("Bob", 20),
                new Person("Paula", 32),
                new Person("Paul", 32),
                new Person("Jack", 3),
                new Person("Jack", 72),
                new Person("Jill", 11));
    }
    public static List<Person> createUniquePeople() {
        return List.of(new Person("George", 20),
                new Person("Sara", 22),
                new Person("Nancy", 20),
                new Person("Paula", 32),
                new Person("Paul", 32),
                new Person("Jack", 3),
                new Person("Bill", 72),
                new Person("Jill", 11));
    }

    public static void totalAgeOfPeople() {
        System.out.println(createPeople().stream()
                .map(Person::getAge)
                //.reduce(0, (total, age) -> total + age);
                //.reduce(0, (total, age) -> Integer.sum(total , age));
                .reduce(0, Integer::sum));
    }

    public static void getPeopleGreaterThan30InUpperCase() {
        /*
           Question::
           get the list of names, in uppercase, of those who are older than 30
         */
        List<String> namesOfOlderThan30 = new ArrayList<>();

        // SHARED MUTABILITY avoid writing this code
        //DON'T Do this as this is mutating "namesOfOlderThan30"
        createPeople().stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                .forEach(namesOfOlderThan30::add);
        System.out.println(namesOfOlderThan30);

        // Line no 55 and 59 are shared mutability
        // But following stream call does not have any side effect
        System.out.println(createPeople().stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(toList()));
        //.collect(toSet())
                /*.reduce(new ArrayList<>()
                        , (names, name) -> {
                            names.add(name);
                            return names;
                        }
                        , (names1, name2) -> {
                            names1.add(name2);
                            return names1;
                        });
                 */
    }

    public static void getNameAndAgeInMap() {
        // Imperative Way
        Map<String, Integer> nameAndAge = new HashMap<>();
        for (Person person : createUniquePeople())
            nameAndAge.put(person.getName(), person.getAge());
        System.out.println(nameAndAge);

        // Functional Way
        System.out.println(createUniquePeople().stream()
                //.collect(toMap(person -> person.getName(), person -> person.getAge()));
                .collect(toMap(Person::getName, Person::getAge)));
    }

    public static void getAllAgeValues() {
        List<Integer> ages = createUniquePeople().stream()
                .map(Person::getAge)
                //.collect(toList());
                .collect(toUnmodifiableList());

        //For unmodifiable list following code will cause ERROR
        //ages.add(99);

        System.out.println(ages);
        System.out.println(ages.getClass());
    }

    public static void getCommaSeparatedNamesOfPersonGreaterThan30InUpperCase() {
        /*
          get the list of names comma separated, in uppercase,
          of those who are older than 30
         */

        System.out.println(createPeople().stream()
                .filter(person -> person.getAge() > 30)
                .map(Person::getName)
                .map(String::toUpperCase)
                .collect(joining(", ")));
    }

    public static void getAllEvenOddAgedValues() {
        List<Person> evenAged = createPeople().stream()
                .filter(person -> person.getAge() % 2 == 0)
                .collect(toList());
        List<Person> oddAged = createPeople().stream()
                .filter(person -> person.getAge() % 2 != 0)
                .collect(toList());
        System.out.println(evenAged);
        System.out.println(oddAged);

        // Using partitioningBy for dividing into 2 groups
        System.out.println(createPeople().stream().collect(partitioningBy(person -> person.getAge() % 2 == 0)));

        // Groups based on names
    }

    public static void getGroupBasedOnNames() {
        List<Person> people = createPeople();
        Map<String, List<Person>> groupByName = new HashMap<>();

        // Imperative way
        for (Person person : people) {
            List<Person> list;
            if (groupByName.containsKey(person.getName())) {
                list = groupByName.get(person.getName());
            } else {
                list = new ArrayList<>();
                groupByName.put(person.getName(), list);
            }

            list.add(person);
        }
        System.out.println(groupByName);

        // Functional way
        Collector<Person, ?, Map<String, List<Integer>>> groupByNameCollectAge = groupingBy(Person::getName, mapping(Person::getAge, toList()));
        // Collector (function, Collector(function, Collector))
        Map<String, List<Integer>> getAgesGroupByName = people.stream().collect(groupByNameCollectAge);
        System.out.println(getAgesGroupByName);
    }

    public static void getGroupCountOnNames() {
        List<Person> people = createPeople();
        // Collector (function, Collector())
        Map<String, Long> countByNames1 = people.stream()
                .collect(groupingBy(Person::getName, counting()));
        System.out.println(countByNames1);

        Map<String, Integer> countByNames2 = people.stream()
                .collect(groupingBy(Person::getName, collectingAndThen(counting(), Long::intValue)));
        System.out.println(countByNames2);
    }

    public static void getSumBasedOnAge() {
        List<Person> people = createPeople();
        Integer sumAge = people.stream()
                .mapToInt(Person::getAge)
                .sum();
        System.out.println(sumAge);
    }

    public static void getMaxBasedOnAge() {
        List<Person> people = createPeople();

        OptionalInt maxAge = people.stream()
                .mapToInt(Person::getAge)
                .max();
        System.out.println(maxAge.getAsInt());

        Optional<Person> personWithMaxAge = people.stream()
                .collect(maxBy(comparing(Person::getAge)));
        System.out.println(personWithMaxAge.get());

        String personNameWithMaxAge = people.stream()
                .collect(collectingAndThen(maxBy(comparing(Person::getAge))
                        , person -> person.map(Person::getName).orElse("")));
        System.out.println(personNameWithMaxAge);
    }

    public static void getMinBasedOnAge() {
        List<Person> people = createPeople();

        OptionalInt minAge = people.stream()
                .mapToInt(Person::getAge)
                .max();
        System.out.println(minAge.getAsInt());

        Optional<Person> personWithMinAge = people.stream()
                .collect(maxBy(comparing(Person::getAge)));
        System.out.println(personWithMinAge.get());
    }

    public static void mapVsMappingFilterVsFiltering() {
        List<Person> people = createPeople();

        people.stream()
                .collect(groupingBy(Person::getAge
                        , mapping(Person::getName, toList())));

        people.stream()
                .collect(groupingBy(Person::getAge,
                        mapping(Person::getName, filtering(name -> name.length() > 4, toList()))));

    }

    public static void flatMapAndFlatMapping() {
        List<Integer> numbers = List.of(1, 2, 3);

        // One to One Function
        //Stream<T>.map(f11) ==> Stream<R>
        System.out.println(numbers.stream()
                .map(e -> e * 2)
                .collect(toList()));

        // One to Many Function
        //Stream<T>.map(f1n) ==> Stream<List<R>>
        System.out.println(numbers.stream()
                .map(e -> List.of(e - 1, e + 1))
                .collect(toList()));
    }

    public static void main(String[] args) {
        totalAgeOfPeople();
        getPeopleGreaterThan30InUpperCase();
        getNameAndAgeInMap();
        getAllAgeValues();
        getAllEvenOddAgedValues();
        getCommaSeparatedNamesOfPersonGreaterThan30InUpperCase();
        getGroupBasedOnNames();
        getGroupCountOnNames();
        getSumBasedOnAge();
        getMaxBasedOnAge();
        getMinBasedOnAge();
        mapVsMappingFilterVsFiltering();
        flatMapAndFlatMapping();
    }
}

@Getter
@Setter
@AllArgsConstructor
@ToString
class Person {
    private String name;
    private int age;
}
