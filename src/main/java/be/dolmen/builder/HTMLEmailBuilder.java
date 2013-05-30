package be.dolmen.builder;

// CONCRETE BUILDER
public class HTMLEmailBuilder implements EmailBuilder<HTMLEmailBuilder> {

    private static final String TABLE_ROW = "\t\t<TR><TD>";

    private StringBuilder result = new StringBuilder();

    @Override
    public HTMLEmailBuilder convertFrom(String from) {
        result.append(TABLE_ROW).append("From: ").append(from).append("\n");
        return this;
    }

    @Override
    public HTMLEmailBuilder convertTo(String to) {
        result.append(TABLE_ROW).append("To: ").append(to).append("\n");
        return this;
    }

    @Override
    public HTMLEmailBuilder convertSubject(String subject) {
        result.append(TABLE_ROW).append("<I>").append(subject).append("</I>").append("\n");
        return this;
    }

    @Override
    public HTMLEmailBuilder convertContent(String content) {
        result.append(TABLE_ROW).append(content).append("\n");
        return this;
    }

    @Override
    public HTMLEmailBuilder addHeader(String header) {
        result.append("<HTML>\n")
              .append("<HEAD>\n")
              .append("\t<TITLE>").append(header).append("</TITLE>\n")
              .append("</HEAD>\n")
              .append("<BODY>\n")
              .append("\t<TABLE>\n");
        return this;
    }

    @Override
    public HTMLEmailBuilder addFooter() {
        result.append("\t</TABLE>\n")
              .append("</BODY>\n")
              .append("</HTML>");
        return this;
    }

    public String getHTML() {
        return result.toString();
    }

}
