package be.dolmen.builder;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.Test;
import org.unitils.inject.annotation.TestedObject;

import be.dolmen.AbstractTest;

public class XMLEmailBuilderTest extends AbstractTest {

    private static final String FROM = "me";
    private static final String TO = "you";
    private static final String SUBJECT = "design patterns";
    private static final String CONTENT = "nice course!";

    @TestedObject
    private XMLEmailBuilder builder;

    @Test
    public void convertFrom() throws Exception {
        String actual = builder.convertFrom(FROM).getXML();

        assertThat(actual).isEqualTo("\t<from>" + FROM + "</from>\n");
    }

    @Test
    public void convertTo() throws Exception {
        String actual = builder.convertTo(TO).getXML();

        assertThat(actual).isEqualTo("\t<to>" + TO + "</to>\n");
    }

    @Test
    public void convertSubject() throws Exception {
        String actual = builder.convertSubject(SUBJECT).getXML();

        assertThat(actual).isEqualTo("\t<subject>" + SUBJECT + "</subject>\n");
    }

    @Test
    public void convertContent() throws Exception {
        String actual = builder.convertContent(CONTENT).getXML();

        assertThat(actual).isEqualTo("\t<body>" + CONTENT + "</body>\n");
    }

    @Test
    public void addHeader() throws Exception {
        String actual = builder.addHeader(SUBJECT).getXML();

        assertThat(actual).isEqualTo("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
        		                     "<message>\n");

    }

    @Test
    public void addFooter() throws Exception {
        String actual = builder.addFooter().getXML();

        assertThat(actual).isEqualTo("</message>");
    }

}
