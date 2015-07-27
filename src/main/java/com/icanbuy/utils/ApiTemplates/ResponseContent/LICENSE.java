package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«LICENSE» tag (class name is used as tag name so should be like in response)</p>
 * <p>Some government / registration /licensing / ... / something like that number. Can be different for each state (or
 * can be same). But should be unique.</p>
 * <p>Can be empty if advertiser did not provide it</p>
 * <p>No default value</p>
 * <p>General correct value is empirical. Some documentation can be found here
 * <a href="https://icanbuy.atlassian.net/browse/IC-1335">IC-1335</a>: any string with size up to 20 symbols (including)
 * </p>
 */
public class LICENSE extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "[\\w\\s]{0,20}";
    }
}