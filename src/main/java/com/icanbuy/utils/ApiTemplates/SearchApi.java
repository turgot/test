package com.icanbuy.utils.ApiTemplates;

import com.icanbuy.utils.ApiTemplates.ResponseContent.*;

import java.util.regex.Pattern;

/**
 * Templates (reg exp) for search api
 */
public class SearchApi {

    private static final String SEARCH_XML_HEADER =
            "^<\\?xml\\sversion=\"1\\.0\"\\sencoding=\"utf-8\"\\?>$\\n" +
            "^<results\\scount=\"\\d{1,2}\"\\stransaction_id=\"" +
            ApiTag.TRANSACTION_ID +
            "\">$\\n";

    private static final String SEARCH_XML_FOOTER = "^</results>$\\n";

    /**
     * Default request (#HOST/api/search) response should match this pattern
     * @return  {@link Pattern#MULTILINE multiline} pattern (?m) that describe empty request
     */
    public Pattern prepareTemplate() {
        return Pattern.compile(SEARCH_XML_HEADER + createDefaultXmlResult() + SEARCH_XML_FOOTER, Pattern.MULTILINE);
    }

    /**
     * Fill &lt;result> with (in order of appearance)
     * <ol>
     *     <li>program_id</li>
     *     <li>period</li>
     *     <li>lender name</li>
     *     <li>nmls</li>
     *     <li>license</li>
     *     <li>lender id</li>
     *     <li>campaign id</li>
     *     <li>lender logo</li>
     *     <li>lender logo click url</li>
     *     <li>comments click url</li>
     *     <li>application link</li>
     *     <li>tag line</li>
     *     <li>sponsored</li>
     *     <li>description</li>
     *     <li>comments</li>
     *     <li>program name</li>
     *     <li>ysp</li>
     *     <li>points</li>
     *     <li>apr</li>
     *     <li>rate</li>
     *     <li>monthly payment</li>
     *     <li>fees</li>
     *     <li>phone</li>
     *     <li>program type</li>
     *     <li>editorial</li>
     *     <li>rate lock used</li>
     *     <li>mobile site</li>
     * </ol>
     * @return  regexp
     */
    private String createDefaultXmlResult() {
        return
                "(^\\s+?<result>$\\n" +
                new PROGRAM_ID().assembleDefaultTag() +
                new PERIOD().assembleDefaultTag() +
                new LENDER_NAME().assembleDefaultTag() +
                new NMLS().assembleDefaultTag() +
                new LICENSE().assembleDefaultTag() +
                new LENDER_ID().assembleDefaultTag() +
                new Campaign_ID().assembleDefaultTag() +
                new LENDER_LOGO().assembleDefaultTag() +
                new LENDER_LOGO_CLICK_URL().assembleDefaultTag() +
                new COMMENTS_CLICK_URL().assembleDefaultTag() +
                new application_link().assembleDefaultTag() +
                new TAGLINE().assembleDefaultTag() +
                new SPONSORED().assembleDefaultTag() +
                new DESCRIPTION().assembleDefaultTag() +
                new COMMENTS().assembleDefaultTag() +
                new PROGRAM_NAME().assembleDefaultTag() +
                new YSP().assembleDefaultTag() +
                new POINTS().assembleDefaultTag() +
                new APR().assembleDefaultTag() +
                new RATE().assembleDefaultTag() +
                new MONTHLY_PAYMENT().assembleDefaultTag() +
                new FEES().assembleDefaultTag() +
                new PHONE().assembleDefaultTag() +
                new PROGRAM_TYPE().assembleDefaultTag() +
                new EDITORIAL().assembleDefaultTag() +
                new RATE_LOCK_USED().assembleDefaultTag() +
                new MOBILE_SITE().assembleDefaultTag() +
                "^\\s+</result>$\\n)*";
    }
}