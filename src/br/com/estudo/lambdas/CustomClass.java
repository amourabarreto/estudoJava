package br.com.estudo.lambdas;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Data
public class CustomClass {

    public static void main(String[] args) {
       List<Course> courses =  List.of(new Course("Spring","Framework",98,20000),
                new Course("Spring Boot","Framework",95,18000),
                new Course("API","Microservices",97,22000),
                new Course("Microservices","Microservices",96,25000),
                new Course("FullStack","FullStack",91,14000),
                new Course("AWS","Cloud",92,21000),
                new Course("Azure","Cloud",99,21000),
                new Course("Docker","Cloud",92,20000),
                new Course("Kubernet","Cloud",91,20000)
       );
       //allMatch, noneMatch, anyMatch
        Predicate<Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;
        Predicate<Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<Course> reviewScoreLessThan90Predicate = course -> course.getReviewScore() < 90;

        System.out.println(courses.stream().allMatch(reviewScoreGreaterThan95Predicate));
        System.out.println(courses.stream().noneMatch(reviewScoreLessThan90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreLessThan90Predicate));
        System.out.println(courses.stream().anyMatch(reviewScoreGreaterThan95Predicate));

        List<Course> coursesGratherThan95 = courses.stream().filter(course -> {
            return courses.stream().map(Course::getReviewScore)
                    .anyMatch(innerCourse ->  innerCourse>95 && innerCourse==course.getReviewScore());
        } ).collect(Collectors.toList());
        coursesGratherThan95.stream().forEach(System.out::println);
        System.out.print("""
                ------------------------------------
                """);


        System.out.println(courses.stream().sorted(Comparator.comparing(Course::getNoOfSudents)).collect(Collectors.toList()));
        System.out.print("""
                ------------------------------------
                """);
        //courses.stream().sorted(Comparator.comparing(Course::getNoOfSudents).reversed()).forEach(System.out::println);
        System.out.println(courses.stream().sorted(Comparator.comparing(Course::getNoOfSudents).thenComparing(Course::getReviewScore)).collect(Collectors.toList()));
        System.out.print("""
                ------------------------------------
                """);
        courses.stream().limit(5).forEach(System.out::println);
        System.out.print("""
                ------------------------------------
                """);
        courses.stream().skip(2).limit(5).forEach(System.out::println);
        System.out.print("""
                ------------------------------------
                """);
        Comparator<Course> comaringByNoOfStudentsAndOfReviews = Comparator.comparing(Course::getNoOfSudents).thenComparing(Course::getReviewScore)
                .reversed();
        System.out.print("""
                ------------------------------------
                """);
        System.out.println(courses.stream()
                .sorted(comaringByNoOfStudentsAndOfReviews).collect(Collectors.toList()));
        System.out.println(courses.stream()
                .min(comaringByNoOfStudentsAndOfReviews));




    }
}
@Data
@AllArgsConstructor
class Course{
    private String name;
    private String category;
    private int reviewScore;
    private int noOfSudents;

    @Override
    public String toString(){
        return name+":"+noOfSudents+":"+reviewScore;
    }
}
