package be.dolmen.adapter;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.mockito.Mock;
import org.unitils.inject.annotation.TestedObject;

import be.dolmen.AbstractTest;

public class VotingSystemTest extends AbstractTest {

    @Mock
    private Voter voter;

    @TestedObject
    private VotingSystem votingSystem;

    @Test
    public void canVote_whenChild() throws Exception {
        when(voter.getAge()).thenReturn(17);

        assertThat(votingSystem.canVote(voter)).isFalse();
    }

    @Test
    public void canVote_whenAdult() throws Exception {
        when(voter.getAge()).thenReturn(18);

        assertThat(votingSystem.canVote(voter)).isTrue();
    }

}
