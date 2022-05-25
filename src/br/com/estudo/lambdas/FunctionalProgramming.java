package br.com.estudo.lambdas;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FunctionalProgramming {
    public static void main(String[] args) {
        List<String> courses = List.of("Spring","Spring Boot","API","Microservices", "AWS","PCF","Azure","Docker","Kubernets");
        //Com Peek ele vai percorer o stream e parar na condição definida
        courses.stream().peek(System.out::println).filter(course -> course.length()>11).findFirst();
        //Imutavel quando criado com List.of
        //courses.replaceAll(course -> course.toUpperCase());

        List<String>  modificavelCurso = new ArrayList<>(courses);
        modificavelCurso.replaceAll(str->str.toUpperCase());
        modificavelCurso.stream().forEach(System.out::println);

        //Entendendo filter e map
        List<Integer> numbers = List.of(3,5,9,12,21,7,14,85);
        numbers.stream()
                .filter(x->x>20)
                        .map(x -> x+10)
                        .forEach(System.out::println);

    }
}
