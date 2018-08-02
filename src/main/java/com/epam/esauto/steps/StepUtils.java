package com.epam.esauto.steps;

import java.net.URI;
import java.net.URISyntaxException;

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
}
