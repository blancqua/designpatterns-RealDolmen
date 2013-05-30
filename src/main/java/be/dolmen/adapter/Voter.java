package be.dolmen.adapter;

import static org.joda.time.DateMidnight.now;
import static org.joda.time.Years.yearsBetween;

public class Voter implements HasAge {

    private Person person;

    public Voter(Person person) {
        this.person = person;
    }

    @Override
    public int getAge() {
        return yearsBetween(person.getBirthDate(), now()).getYears();
    }

}
