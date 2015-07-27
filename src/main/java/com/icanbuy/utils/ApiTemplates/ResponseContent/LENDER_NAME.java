package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«LENDER_NAME» tag (class name is used as tag name so should be like in response)</p>
 * <p>Advertisers display name.</p>
 * <p>Can't be empty, it's mandatory advertiser property.</p>
 * <p>No default value</p>
 * <p>General correct value is empirical, based on values given on «Advertiser» → «Credentials» page → «Display name»
 * column</p>
 */
public class LENDER_NAME extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "[\\w\\s,\\.]+?";
    }
}