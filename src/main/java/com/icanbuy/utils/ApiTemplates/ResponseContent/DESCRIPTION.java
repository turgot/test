package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«DESCRIPTION» tag (class name is used as tag name so should be like in response)</p>
 * <p>From api doc: «A description of the program and or lender up to 350 characters»</p>
 * <p>Can be empty.</p>
 * <p>No default value</p>
 * <p>General correct value is described in jira <a href="https://icanbuy.atlassian.net/browse/IC-905">IC-905</a>
 * task: «From the lender: » + «advertisers text». Though first part looks like not mandatory.</p>
 */
public class DESCRIPTION extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = createAdvertiserDisplayInfo();
    }
}