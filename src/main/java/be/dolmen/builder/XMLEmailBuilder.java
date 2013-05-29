package be.dolmen.builder;

public class XMLEmailBuilder implements EmailBuilder<XMLEmailBuilder> {

    private StringBuilder result = new StringBuilder();

    @Override
    public XMLEmailBuilder convertFrom(String from) {
        result.append("\t<from>")
              .append(from)
              .append("</from>\n");
        return this;
    }

    @Override
    public XMLEmailBuilder convertTo(String to) {
        result.append("\t<to>")
              .append(to)
              .append("</to>\n");
        return this;
    }

    @Override
    public XMLEmailBuilder convertSubject(String subject) {
        result.append("\t<subject>")
              .append(subject)
              .append("</subject>\n");
        return this;
    }

    @Override
    public XMLEmailBuilder convertContent(String content) {
        result.append("\t<body>")
              .append(content)
              .append("</body>\n");
        return this;
    }

    @Override
    public XMLEmailBuilder addHeader(String header) {
        result.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n")
              .append("<message>\n");
        return this;
    }

    @Override
    public XMLEmailBuilder addFooter() {
        result.append("</message>");
        return this;
    }

    public String getXML() {
        return result.toString();
    }

}
