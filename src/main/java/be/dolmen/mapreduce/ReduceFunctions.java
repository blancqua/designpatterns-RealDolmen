package be.dolmen.mapreduce;

public class ReduceFunctions {

    public static ReduceFunction<Integer, Integer> sumFunction() {
        return new ReduceFunction<Integer, Integer>() {
            @Override
            public Integer reduce(Integer current, Integer toReduce) {
                return current + toReduce;
            }
        };
    }

}
