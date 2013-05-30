package be.dolmen.builder;

// BUILDER
public interface EmailBuilder<T extends EmailBuilder<?>> {

    T convertFrom(String from);
    T convertTo(String to);
    T convertSubject(String subject);
    T convertContent(String content);
    T addHeader(String header);
    T addFooter();

}
