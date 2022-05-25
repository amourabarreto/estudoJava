package br.com.estudo.lambdas;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileFunctionalProgramming {
    public static void main(String[] args) throws IOException {
        //long time = System.currentTimeMillis();
        Files.lines(Paths.get("file.txt"))
                .filter(line -> line.startsWith("A"))
                .map(lins -> lins.split(" "))
                .flatMap(Arrays::stream)
                .distinct()
                .sorted()
                .forEach(System.out::println);
        Files.list(Paths.get("."))
                .filter(Files::isDirectory)
                .forEach(System.out::println);
      //  System.out.println(System.currentTimeMillis()-time);
    }
}
