package com.epam.esauto.steps.header_footer;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Map.Entry.comparingByKey;

public class StepUtils {

    public static final String ATTRIBUTE_HREF = "href";
    public static final String ATTRIBUTE_TITLE = "title";
    public static final String ATTRIBUTE_CLASS = "class";

    public static boolean isAbsoluteUrl(String url) {
        return URI.create(url).isAbsolute();
    }

    public static String getFullUrl(String mainPageUrl, String href) {
        return isAbsoluteUrl(href) ? href : mainPageUrl + href;
    }

    public static LinkedHashMap sortMap(Map<String,String> map){
        return map
                .entrySet()
                .stream()
                .sorted(comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
    }
}
