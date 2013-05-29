package be.dolmen.builder;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.unitils.inject.annotation.TestedObject;

import be.dolmen.AbstractTest;

public class EmailParserTest extends AbstractTest {

    private static final String FROM = "me";
    private static final String TO = "you";
    private static final String SUBJECT = "subject";
    private static final String CONTENT = "Content";

    @TestedObject
    private EmailParser parser;

    @Test
    public void parse() throws Exception {
        Email email = parser.parse("From: " + FROM + "\n" +
                                   "To: " + TO + "\n" +
                                   "Subject: " + SUBJECT + "\n" +
                                   CONTENT);

        assertThat(email.getFrom()).isEqualTo(FROM);
        assertThat(email.getTo()).isEqualTo(TO);
        assertThat(email.getSubject()).isEqualTo(SUBJECT);
        assertThat(email.getContent()).isEqualTo(CONTENT);
    }

}
