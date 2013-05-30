package be.dolmen.adapter;

import org.joda.time.DateMidnight;

public class Person implements HasBirthDate {

    private DateMidnight birthDate;

    public Person(DateMidnight birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public DateMidnight getBirthDate() {
        return birthDate;
    }

}
