package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«TAGLINE» tag (class name is used as tag name so should be like in response)</p>
 * <p>From api doc: «A brief description of the lender, usually a slogan up to 75 characters»</p>
 * <p>Can be empty.</p>
 * <p>No default value</p>
 * <p>General correct value is described in jira <a href="https://icanbuy.atlassian.net/browse/IC-905">IC-905</a>
 * task: «From the lender: » + «advertisers text». Though first part looks like not mandatory.</p>
 */
public class TAGLINE extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = createAdvertiserDisplayInfo();
    }
}