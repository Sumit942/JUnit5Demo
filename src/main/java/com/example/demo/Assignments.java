package com.example.demo;

import java.util.List;
import java.util.stream.Collectors;

public class Assignments {

    public List<Integer> getSquaredList(List<Integer> list) {
        return list
                .stream().map(n -> n * n)
                .collect(Collectors.toList());
    }

    public List<Integer> getEvenSquaredList(List<Integer> list) {

        return list
                .stream().filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .collect(Collectors.toList());
    }
}
