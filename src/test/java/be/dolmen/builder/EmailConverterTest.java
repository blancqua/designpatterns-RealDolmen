package be.dolmen.builder;

import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;

import be.dolmen.AbstractTest;

public class EmailConverterTest extends AbstractTest {


    private static final String EMAIL_TEXT = "emailText";

    private static final String FROM = "from";
    private static final String TO = "to";
    private static final String SUBJECT = "subject";
    private static final String CONTENT = "content";

    private static final Email EMAIL = new Email(FROM, TO, SUBJECT, CONTENT);

    @SuppressWarnings("rawtypes")
    @Mock
    @InjectIntoByType
    private EmailBuilder builder;

    @Mock
    @InjectIntoByType
    private EmailParser parser;

    @TestedObject
    private EmailConverter converter;

    @Before
    public void setUp() {
        when(parser.parse(EMAIL_TEXT)).thenReturn(EMAIL);

        when(builder.addHeader(SUBJECT)).thenReturn(builder);
        when(builder.convertFrom(FROM)).thenReturn(builder);
        when(builder.convertTo(TO)).thenReturn(builder);
        when(builder.convertSubject(SUBJECT)).thenReturn(builder);
        when(builder.convertContent(CONTENT)).thenReturn(builder);
        when(builder.addFooter()).thenReturn(builder);

        converter = new EmailConverter(builder);
    }

    @Test
    public void convert() throws Exception {
        converter.convert(EMAIL_TEXT);

        InOrder inOrder = inOrder(builder);
        inOrder.verify(builder).addHeader(SUBJECT);
        inOrder.verify(builder).convertFrom(FROM);
        inOrder.verify(builder).convertTo(TO);
        inOrder.verify(builder).convertSubject(SUBJECT);
        inOrder.verify(builder).convertContent(CONTENT);
        inOrder.verify(builder).addFooter();

    }


}
