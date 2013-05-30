package be.dolmen.flyweight;

import static be.dolmen.flyweight.IconType.iconType;
import static com.google.common.collect.Maps.newHashMap;

import java.util.Map;

public class IconFactory {

    private static final IconFactory FACTORY = new IconFactory();

    private Map<IconType, AbstractIcon> cachedIcons = newHashMap();

    public static IconFactory iconFactory() {
        return FACTORY;
    }

    private IconFactory () {}

    public synchronized AbstractIcon createIcon(String key) {
        IconType iconType = iconType(key);
        AbstractIcon icon = cachedIcons.get(iconType);
        if (icon == null) {
            icon = iconType.createIcon();
            cachedIcons.put(iconType, icon);
        }

        return icon;
    }

}
