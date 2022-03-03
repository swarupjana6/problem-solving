package com.practice.javaconcepts;

public class TextBlockString {

    public static void main(String[] args) {
        String oldJsonToPreserveFormat = "[\n\t{\n" +
                "\t\t\"name\"\t:\t\"tom\",\n" +
                "\t\t\"age\"\t: 19\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"name\"\t:\t\"tom\",\n" +
                "\t\t\"age\"\t: 19\n" +
                "\t}\n]";
        System.out.println(oldJsonToPreserveFormat);



        String textBlockJSON =
                """                
                        [
                            {
                                "name" : "tom",
                                "age" : 19
                            },
                            {
                                "name" : "dick",
                                "age" : 21
                            }
                        ]            
                        """;
        System.out.println(textBlockJSON);
    }
}
