package be.dolmen.adapter;

import static org.fest.assertions.Assertions.assertThat;
import static org.joda.time.DateMidnight.now;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;

import be.dolmen.AbstractTest;

public class HasBirthDateAdapterTest extends AbstractTest {

    private static final int AGE = 21;

    @Mock
    @InjectIntoByType
    private HasBirthDate hasBirthDate;

    @TestedObject
    private HasBirthDateAdapter adapter;

    @Before
    public void setUp() {
        when(hasBirthDate.getBirthDate()).thenReturn(now().minusYears(AGE));

        adapter = new HasBirthDateAdapter(hasBirthDate);
    }

    @Test
    public void getAge() throws Exception {
        assertThat(adapter.getAge()).isEqualTo(AGE);
    }

}
