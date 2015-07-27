package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«Campaign_ID» tag (class name is used as tag name so should be like in response)</p>
 * <p>Campaign number (db auto increment)</p>
 * <p>Can't be empty</p>
 * <p>No default value (<a href="https://icanbuy.atlassian.net/browse/IC-405">IC-405</a>)</p>
 * <p>General correct value is purely empirical. (right now it's (including both) from 2 up to 4 digits)</p>
 */
public class Campaign_ID extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "\\d{2,4}";
    }
}