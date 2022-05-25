package br.com.estudo.lambdas;

import java.util.stream.LongStream;

public class ParallezingPrograming {
    public static void main(String[] args) {

        long time = System.currentTimeMillis();
        //0,1000000000
        System.out.println(LongStream.range(0,1000000000).parallel().sum());

        System.out.println(System.currentTimeMillis()-time);
    }
}
