package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class function {
    static List<Double> diapason(int start, int end, Function<Double, Double> func){
        List<Double> result = new ArrayList<>();
        for(int arg = start; arg < end; arg++){
            result.add(func.apply(Double.valueOf(arg)));
        }
        return result;
    }
}
