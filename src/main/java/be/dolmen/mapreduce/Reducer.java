package be.dolmen.mapreduce;

import static be.dolmen.mapreduce.ReduceFunctions.sumFunction;

public class Reducer {

    public static int sum(Iterable<Integer> entries) {
        return reduce(entries, sumFunction(), 0);
    }

    public static <VALUE, REDUCED> REDUCED reduce(Iterable<VALUE> entries, ReduceFunction<VALUE, REDUCED> reduceFunction, REDUCED baseValue) {
        REDUCED result = baseValue;
        for(VALUE entry : entries) {
            result = reduceFunction.reduce(result, entry);
        }
        return result;
    }

}
