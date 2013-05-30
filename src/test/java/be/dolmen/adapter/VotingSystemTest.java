package be.dolmen.adapter;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;
import org.unitils.inject.annotation.TestedObject;

import be.dolmen.AbstractTest;

public class VotingSystemTest extends AbstractTest {

    @Mock
    private HasAge hasAge;

    @TestedObject
    private VotingSystem votingSystem;

    @Test
    public void canVote_whenChild() throws Exception {
        when(hasAge.getAge()).thenReturn(17);

        assertThat(votingSystem.canVote(hasAge)).isFalse();
    }

    @Test
    public void canVote_whenAdult() throws Exception {
        when(hasAge.getAge()).thenReturn(18);

        assertThat(votingSystem.canVote(hasAge)).isTrue();
    }

}
