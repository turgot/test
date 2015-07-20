package com.icanbuy.utils;

/**
 * General constants like urls, paths, e.t.c.
 */
public class Settings {
    //urls
    private static final String DEMO = "http://demo.icanbuy.com";
    private static final String AWSUAT = "http://awsuat.icanbuy.com";

    public static final String CURRENT_SERVER = DEMO;
    /**
     * same as {@link #CURRENT_SERVER} but with out http:// (https://)
     */
    public static final String CURRENT_SERVER_SHORT = CURRENT_SERVER.replaceAll("https?://", "");

    //Serenity session keys
    public static final String API_RESPONSE_XML = "xmlResponse";
}