package be.dolmen.mapreduce;

public interface ReduceFunction<VALUE, REDUCED> {

    REDUCED reduce(REDUCED current, VALUE toReduce);

}
