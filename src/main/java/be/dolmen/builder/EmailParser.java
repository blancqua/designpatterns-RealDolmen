package be.dolmen.builder;

public class EmailParser {

    public Email parse(String email) {
        String[] emailFields = email.split("\n");

        return new Email(emailFields[0].replace("From: ", ""),
                         emailFields[1].replace("To: ", ""),
                         emailFields[2].replace("Subject: ", ""),
                         emailFields[3]);
    }

}
