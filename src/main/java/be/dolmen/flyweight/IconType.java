package be.dolmen.flyweight;

import static com.google.common.collect.Iterables.tryFind;
import static com.google.common.collect.Lists.newArrayList;

import com.google.common.base.Optional;
import com.google.common.base.Predicate;

public enum IconType {

    FOLDER("dir"),
    JAVA("java"),
    PDF("pdf"),
    PICTURE("picture"),
    TEXT("txt"),
    UNKNOWN(null);

    private String alias;

    private IconType(String alias) {
        this.alias = alias;
    }

    public AbstractIcon createIcon() {
        switch (this) {
        case FOLDER : return new FolderIcon();
        case JAVA : return new JavaIcon();
        case PDF : return new PdfIcon();
        case PICTURE : return new PictureIcon();
        case TEXT : return new TextIcon();
        default : return new UnknownIcon();
        }
    }

    public static IconType iconType(String alias) {
        Optional<IconType> iconType = tryFind(newArrayList(values()), withAlias(alias));

        return iconType.isPresent() ? iconType.get() : UNKNOWN;
    }

    private static Predicate<IconType> withAlias(final String alias) {
        return new Predicate<IconType> () {
            @Override
            public boolean apply(IconType input) {
                return alias.equals(input.alias);
            }
        };
    }

}
