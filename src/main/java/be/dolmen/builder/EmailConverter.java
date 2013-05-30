package be.dolmen.builder;

// DIRECTOR
public class EmailConverter {

    private EmailParser parser = new EmailParser();
    private EmailBuilder<?> builder;

    public EmailConverter(EmailBuilder<?> builder) {
        this.builder = builder;
    }

    public void convert(String emailText) {
        Email email = parser.parse(emailText);

        builder.addHeader(email.getSubject())
               .convertFrom(email.getFrom())
               .convertTo(email.getTo())
               .convertSubject(email.getSubject())
               .convertContent(email.getContent())
               .addFooter();
    }

    public static void main(String[] args) {
        String email = "From: me\n" +
                       "To: you\n" +
                       "Subject: subject\n" +
                       "Nice mail";

        HTMLEmailBuilder htmlEmailBuilder = new HTMLEmailBuilder();
        new EmailConverter(htmlEmailBuilder).convert(email);
        System.out.println(htmlEmailBuilder.getHTML());

        System.out.println();

        XMLEmailBuilder xmlEmailBuilder = new XMLEmailBuilder();
        new EmailConverter(xmlEmailBuilder).convert(email);
        System.out.println(xmlEmailBuilder.getXML());
    }

}
