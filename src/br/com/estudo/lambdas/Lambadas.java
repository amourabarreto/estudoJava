package br.com.estudo.lambdas;

import java.util.List;
import java.util.Random;
import java.util.function.*;

public class Lambadas {
    //Filter efetua uma operação e retorna somente quem eu preciso - Retorno do Funcional Interface no Filter é um boolean
    private static void printODDNumbers(List<Integer> numbers){
        Predicate<? super Integer> predicate = x -> x%2!=0;
        filterAndPrint(numbers, predicate);
    }
    private static void printEvenNumbers(List<Integer> numbers){
       // Predicate<? super Integer> predicate = x -> x%2==0;
        filterAndPrint(numbers, x -> x%2==0);
    }
    private static void filterAndPrint(List<Integer> numbers, Predicate<? super Integer> predicate) {
        numbers.stream().filter(predicate).forEach(System.out::println);
    }

    //Map efetua uma operação em todos os elementos e retona o tipo de elemento da coleção
    private static void printSquareNumbers(List<Integer> numbers){
        Function<? super Integer,? extends Integer> function = number -> number*number;
        Consumer<? super Integer> consumer = System.out::println;
        Consumer<? super Integer> consumerLambda = x -> System.out.println(x);
        Consumer<Integer> objConsumer = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };


        numbers.stream().map(function).forEach(consumerLambda);

    }

    private static void reduce(List<Integer> numbers){
        BinaryOperator<Integer> binary = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a+b;
            }
        };
        //int sum = numbers.stream().reduce(0,(x,y)->x+y);
        int sum = numbers.stream().reduce(0,Integer::sum);
        //int sum = numbers.stream().reduce(0,binary );
        System.out.println(sum);
    }

    public static void main(String[] args) {
        List<Integer> numbers = List.of(2,5,10,21,35,44,1217,1892);
        printODDNumbers(numbers);

        System.out.print("""
                Imprimindo quadrado dos numeros
                """);
        printSquareNumbers(numbers);
        System.out.print("""
                Printing reduce numbers
                """);
        reduce(numbers);

        someFunctionalInterfaces();

        BiConsumer<Integer,String> biConsumer = (x,s) -> System.out.println(s+ " farofa "+x);
        biFunction(10,"Valor total",biConsumer);

        //STATIC REFERENCE
        List<String> strings = List.of("Spring Boot", "Spring Cloud","Spring cloud API Gateway","Teste");
        strings.stream().map(String::toUpperCase).forEach(Lambadas::print);

    }

    private static void someFunctionalInterfaces(){
        Consumer<Integer> consumer = x -> System.out.println(x);
        Predicate<Integer> predicate = x -> x>0;
        Function<Integer,Long> function = x -> x.longValue();
        BinaryOperator<Integer> binaryOperator = (x,y) -> x+y;
        Supplier<Integer> supplier = () -> new Random().nextInt(1000);
        System.out.println(supplier.get());
        //UnaryOperator - Extends Function mas só permite como retorno o mesmo tipo do input.
        UnaryOperator<Integer> unaryOperator = x -> x+10;

        BiPredicate<Integer,Integer> biPredicate = (x,y) -> x>y;

        BiFunction<Integer,Integer,Boolean> biFunctionBoolean = (x,y) -> x>y;
        BiFunction<Integer,Integer,Integer> biFunctionInteger = (x,y) -> x+y;
        BiConsumer<Integer,String> biConsumer = (x,s) -> System.out.println(s+ " farofa "+x);

        Consumer<String> consumerString = str -> {};
        Consumer<String> consumerStrings = System.out::println;

        Supplier<String> supplier1 = () -> "String retorno";
        Supplier<String> supplier2 = () -> {return "String retorno";};

        Supplier<String> supplier3 = String::new;
        String s = supplier3.get();


    }

    private static void biFunction(Integer valor, String mensagem, BiConsumer<Integer,String> biConsumer){
            biConsumer.accept(valor,mensagem);
    }

    private static final void print(String str){
        System.out.println(str);
    }


}
