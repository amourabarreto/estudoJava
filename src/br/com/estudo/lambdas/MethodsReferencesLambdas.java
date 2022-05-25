package br.com.estudo.lambdas;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class MethodsReferencesLambdas {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring Boot", "Spring Cloud", "English", "Kama Sutra");
        courses.stream()
                //.map(str -> str.toUpperCase())
                .map(String::toUpperCase)
                .forEach(MethodsReferencesLambdas::print);
        System.out.print("""
                ---------------------------------------------
                """);
        courses.stream().filter(str -> str.startsWith("Spring")).forEach(System.out::println);
        System.out.print("""
                ---------------------------------------------
                """);
        courses.stream().takeWhile(str -> str.startsWith("Spring")).forEach(System.out::println);
        System.out.print("""
                ---------------------------------------------
                """);

        courses.stream().dropWhile(str -> str.startsWith("Spring")).forEach(System.out::println);
        System.out.print("""
                ---------------------------------------------
                """);
        String s = courses.stream().collect(Collectors.joining(" "));
        System.out.println(s);
        s = courses.stream().collect(Collectors.joining(","));
        System.out.println(s);

        List<String>
                ss = courses.stream().map(course->course.split("")).flatMap(Arrays::stream).collect(Collectors.toList());

    }

    private static void print(String s) {
        System.out.println(s);
    }
}
