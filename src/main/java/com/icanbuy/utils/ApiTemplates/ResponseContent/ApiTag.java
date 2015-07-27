package com.icanbuy.utils.ApiTemplates.ResponseContent;

import java.util.HashMap;

import static com.icanbuy.utils.Settings.CURRENT_SERVER_SHORT;

/**
 * Abstract class for generation api tags.
 */
public abstract class ApiTag {
    private String tagName = this.getClass().getSimpleName();
    protected String value;
    private HashMap<String, String> linkTypes = new HashMap<>();

    /**
     * <p>Transaction id = search id, unique search request identifier. (as advertiser) «Reports» → «Searched» page →
     * «Tracking ID» column</p>
     */
    public static final String TRANSACTION_ID = "\\d{19}";

    /**
     * <p>Identify element on which user click</p>
     * <ol>
     *     <li>6 – logo</li>
     *     <li>7 – api apply online?</li>
     *     <li>8 – comments, ui = ?</li>
     * </ol>
     * looks like it's not full list
     */
    public static final String LOCATION_ID = "3(6|7|8)";

    public ApiTag() {
        linkTypes.put("LENDER_LOGO_CLICK_URL", "logo");
        linkTypes.put("COMMENTS_CLICK_URL", "comment");
        linkTypes.put("application_link", "application");
    }

    /**
     * Regexp which describe any correct value of this tag
     */
    protected abstract void setValue();

    protected String getValue() {
        setValue();
        return value;
    }

    /**
     * <p>Special case, exist only for {@link PERIOD} and {@link PROGRAM_TYPE} tags. Also, in some way, for click leads:
     * {@link application_link}, {@link LENDER_LOGO_CLICK_URL}, {@link COMMENTS_CLICK_URL}</p>
     * <p>For all other tags general value will be taken</p>
     */
    protected void setDefaultValue() {
        setValue();
    }

    /**
     * Combine tag name and tag value
     * @return  regexp like «^\s+?&lt;{@link #tagName}>{@link #value}&lt;/{@link #tagName}>$\n».
     */
    private String combineTag() {
        return "^\\s+?<" + tagName + ">" + value + "</" + tagName + ">$\\n";
    }

    /**
     * {@link #combineTag() Create} correct tag using general value that can describe any correct value including
     * default.
     * @return  string, regexp
     */
    public final String assambleCorrectTag() {
        setValue();
        return combineTag();
    }

    /**
     * {@link #setDefaultValue() Default} = some key parameters not set at all or set incorrectly → default value is
     * used.
     * @return  {@link #combineTag() regexp}, default if possible, otherwise – general correct
     */
    public final String assembleDefaultTag() {
        setDefaultValue();
        return combineTag();
    }

    /**
     * <p>Assemble click lead
     * <ol>
     *     <li>server name (http(s) + HOST)</li>
     *     <li>request type + search id (/api/click/index/searchID/)</li>
     *     <li>lenderid</li>
     *     <li>siteid</li>
     *     <li>CampaignID</li>
     *     <li>Sponsored</li>
     *     <li>locationID</li>
     *     <li>programtype</li>
     * </ol></p>
     * @param   isDefault define witch link variant you need: default or general. Default will set default values to
     *                    site id and program type parameters
     * @return  according to {@link #tagName} correct regexp for each click lead types: {@link LENDER_LOGO_CLICK_URL},
     * {@link COMMENTS_CLICK_URL}, {@link application_link}
     */
    private String createClickLeadLink(Boolean isDefault) {
        String linkType = linkTypes.get(tagName);
        String siteId = getSiteId(isDefault);
        String programType = getNumericProgramType(isDefault);

        return "(" +
                "https?://" +
                CURRENT_SERVER_SHORT +
                "/api/click/index/searchID/" +
                TRANSACTION_ID +
                "/lenderid/" +
                new LENDER_ID().getValue() +
                "/click/" +
                linkType +
                "/siteid/" +
                siteId +
                "/CampaignID/" +
                new Campaign_ID().getValue() +
                "/Sponsored/" +
                new SPONSORED().getValue() +
                "/locationID/" +
                LOCATION_ID +
                "/programtype/" +
                programType +
                ")?";
    }

    /**
     * General version of correct {@link #createClickLeadLink(Boolean) click lead} (default = false)
     * @return  regexp
     */
    protected String createClickLeadLink() {
        return createClickLeadLink(false);
    }

    /**
     * "Default" {@link #createClickLeadLink(Boolean) click lead} =
     * <ol>
     *     <li>/siteid/ = icanbuy id</li>
     *     <li>/programtype/ = CONV</li>
     * </ol>
     * @return  regexp
     */
    protected String createDefaultClickLeadLink() {
        return createClickLeadLink(true);
    }

    /**
     * <p>Unique affiliate id. List of all current ids displayed in affiliate → credentials.</p>
     * <p>Default = icanbuy id. Currently this value is same for test servers and production</p>
     * <p>General regexp is empirical</p>
     * <p>Used in different api functions as part of click leads under «siteid» parameter.</p>
     * <p>Example: &lt;LENDER_LOGO_CLICK_URL>#HOST/api/click/index/searchID/.../<u>siteid/d4ea9f8db0477778</u></p>
     * @param isDefault    define what kind of site id is needed: default or common
     * @return  affiliate id (affiliate url token)
     */
    private String getSiteId(Boolean isDefault) {
        if (isDefault) return "d4ea9f8db0477778";
        return "[a-f\\d]{15,16}";
    }

    /**
     * <p>Numeric version of {@link PROGRAM_TYPE program type}</p>
     * <p>Example: &lt;COMMENTS_CLICK_URL>#HOST/api/click/index/searchID/...<u>/programtype/0</u></p>
     * @param isDefault    do you need general or default value
     * @return  regexp
     */
    private String getNumericProgramType(Boolean isDefault) {
        if (isDefault) {
            return new PROGRAM_TYPE().numericDefaultValue;
        }
        return new PROGRAM_TYPE().numericValue;
    }

    /**
     * <p>Those are advertiser descriptions from ((admin) advertiser | (advertiser) my settings) →
     * company info.</p>
     * <p>Used for tags {@link TAGLINE}, {@link DESCRIPTION}, {@link COMMENTS}</p>
     * <p>doc in <a href="https://icanbuy.atlassian.net/browse/IC-905">IC-905</a></p>
     * @return  regexp, string
     */
    protected String createAdvertiserDisplayInfo() {
        return
                "(From the lender:)?" +     //though this part is mandatory by doc it's not mandatory in reality
                "([\\s\\w:+!\\.,\"'-]+?)?"; //this part can be empty (
    }
}