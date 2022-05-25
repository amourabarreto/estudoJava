package br.com.estudo.lambdas;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.*;

@Data
public class _$CustomClass2 {
    public static void main(String[] args) {
        List<Course2> courses = List.of(new Course2("Spring", "Framework", 98, 20000),
                new Course2("Spring Boot", "Framework", 95, 18000),
                new Course2("API", "Microservices", 97, 22000),
                new Course2("Microservices", "Microservices", 96, 25000),
                new Course2("FullStack", "FullStack", 91, 14000),
                new Course2("AWS", "Cloud", 92, 21000),
                new Course2("Azure", "Cloud", 99, 21000),
                new Course2("Docker", "Cloud", 92, 20000),
                new Course2("Kubernet", "Cloud", 91, 20000)
        );
        //allMatch, noneMatch, anyMatch
        Predicate<Course2> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course2> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course2> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

        System.out.println(
                courses
        );

        System.out.println(
                courses.stream().filter(reviewScoreGreaterThan95Predicate)
                        .mapToInt(Course2::getNoOfSudents)
                        .max()
        );
        System.out.println(
                courses.stream().collect(Collectors.groupingBy(Course2::getCategory))
        );
        System.out.println(
            courses.stream().collect(Collectors.groupingBy(Course2::getCategory, Collectors.counting()))
        );
        System.out.print("""
                ------------------------------------------------------- 
                """);
        System.out.println(
                courses.stream().collect(Collectors.groupingBy(Course2::getCategory, Collectors.maxBy(Comparator.comparing(Course2::getReviewScore))))
        );

        Integer sum = IntStream.of(12,10,2,3,5,8,9,21).reduce(0,Integer::sum);
        System.out.println(sum);

         double average = IntStream.range(1,10).average().getAsDouble();
         System.out.println("Average "+average);
         int soma  = IntStream.iterate(2, x -> x+2).limit(10).peek(System.out::println).sum();
         System.out.println(soma);

        List<Integer> ll = IntStream.iterate(2, x -> x+2).limit(10).boxed().collect(Collectors.toList());
        System.out.print("""
                ------------------------------------------------------- 
                """);
        IntStream.range(1,10).forEach(System.out::println);
        System.out.print("""
                CLOSED
                """);
        IntStream.rangeClosed(1,10).forEach(System.out::println);
        System.out.print("""
                ------------------------------------------------------- 
                """);
        System.out.println(LongStream.rangeClosed(1,40).mapToObj(BigInteger::valueOf)
                .reduce(BigInteger.ONE,BigInteger::multiply));





    }
}

@Data
@AllArgsConstructor
class Course2 {
    private String name;
    private String category;
    private int reviewScore;
    private int noOfSudents;

    @Override
    public String toString() {
        return name + ":" + noOfSudents + ":" + reviewScore;
    }
}

