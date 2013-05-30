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

public class VoterTest extends AbstractTest {

    private static final int AGE = 21;

    @Mock
    @InjectIntoByType
    private Person person;

    @TestedObject
    private Voter voter;

    @Before
    public void setUp() {
        when(person.getBirthDate()).thenReturn(now().minusYears(AGE));

        voter = new Voter(person);
    }

    @Test
    public void getAge() throws Exception {
        assertThat(voter.getAge()).isEqualTo(AGE);
    }

}
