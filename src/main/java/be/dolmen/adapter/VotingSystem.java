package be.dolmen.adapter;

import static org.joda.time.DateTimeConstants.DECEMBER;

import org.joda.time.DateMidnight;

public class VotingSystem {

    public boolean canVote(Voter voter) {
        return voter.getAge() >= 18;
    }

    public static void main(String[] args) {
        Person person = new Person(new DateMidnight(1985, DECEMBER, 24));

        System.out.println(new Voter(person).getAge());
    }

}
