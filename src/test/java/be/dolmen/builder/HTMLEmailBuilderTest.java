package be.dolmen.builder;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.unitils.inject.annotation.TestedObject;

import be.dolmen.AbstractTest;

public class HTMLEmailBuilderTest extends AbstractTest {

    private static final String FROM = "me";
    private static final String TO = "you";
    private static final String SUBJECT = "design patterns";
    private static final String CONTENT = "nice course!";

    @TestedObject
    private HTMLEmailBuilder builder;

    @Test
    public void convertFrom() throws Exception {
        String actual = builder.convertFrom(FROM).getHTML();

        assertThat(actual).isEqualTo("\t\t<TR><TD>From: " + FROM + "\n");
    }

    @Test
    public void convertTo() throws Exception {
        String actual = builder.convertTo(TO).getHTML();

        assertThat(actual).isEqualTo("\t\t<TR><TD>To: " + TO + "\n");
    }

    @Test
    public void convertSubject() throws Exception {
        String actual = builder.convertSubject(SUBJECT).getHTML();

        assertThat(actual).isEqualTo("\t\t<TR><TD><I>" + SUBJECT + "</I>\n");
    }

    @Test
    public void convertContent() throws Exception {
        String actual = builder.convertContent(CONTENT).getHTML();

        assertThat(actual).isEqualTo("\t\t<TR><TD>" + CONTENT + "\n");
    }

    @Test
    public void addHeader() throws Exception {
        String actual = builder.addHeader(SUBJECT).getHTML();

        assertThat(actual).isEqualTo("<HTML>\n" +
        		                     "<HEAD>\n" +
        		                     "\t<TITLE>" + SUBJECT + "</TITLE>\n" +
        		                     "</HEAD>\n" +
        		                     "<BODY>\n" +
        		                     "\t<TABLE>\n"
                );

    }

    @Test
    public void addFooter() throws Exception {
        String actual = builder.addFooter().getHTML();

        assertThat(actual).isEqualTo("\t</TABLE>\n" +
                                     "</BODY>\n" +
                                     "</HTML>");
    }

}
