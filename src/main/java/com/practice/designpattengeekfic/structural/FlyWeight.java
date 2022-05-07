package com.practice.designpattengeekfic.structural;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlyWeight {

    public static void main(String[] args) {

    }
}

/**

Since we have millions of Books following will take lots of space

@Data
class Book {
    private final String name;
    private final double price;
    private final String type;
    private final String otherData;
    private final String distributor;
}

 **/

@Data
class Book {
    private final String name;
    private final double price;
    private final BookType bookType;
}

@Getter
@AllArgsConstructor
class BookType {
    private final String type;
    private final String otherData;
    private final String distributor;
}

class BookFactory {

    private static final Map<String, BookType> bookTypes = new HashMap<>();

    public static BookType getBookType(String type, String otherData, String distributor) {
        return bookTypes.putIfAbsent(type, new BookType(type, otherData, distributor));
    }
}

class Store {

    private final List<Book> books = new ArrayList<>();

    public void storeBook(String name, double price, String type, String distributor, String otherData) {
        BookType bookType = BookFactory.getBookType(type, distributor, otherData);
        books.add(new Book(name, price, bookType));
    }

    public void displayBook() {
        books.forEach(System.out::println);
    }
}