package be.dolmen.adapter;

import static org.joda.time.DateMidnight.now;
import static org.joda.time.Years.yearsBetween;

// ADAPTER
public class HasBirthDateAdapter implements HasAge {

    private HasBirthDate hasBirthDate;

    public HasBirthDateAdapter(HasBirthDate hasBirthDate) {
        this.hasBirthDate = hasBirthDate;
    }

    @Override
    public int getAge() {
        return yearsBetween(hasBirthDate.getBirthDate(), now()).getYears();
    }

}
