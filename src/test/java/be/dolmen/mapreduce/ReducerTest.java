package be.dolmen.mapreduce;

import static com.google.common.collect.Lists.newArrayList;
import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;

import be.dolmen.AbstractTest;

public class ReducerTest extends AbstractTest {

    @Test
    public void sum() throws Exception {
        assertThat(Reducer.sum(newArrayList(1, 2, 3, 4, 5))).isEqualTo(15);
    }

}
