package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«LENDER_ID» tag (class name is used as tag name so should be like in response)</p>
 * <p>From api doc: ID of Lender, If lender does not support leads no ID will be present</p>
 * <p>Can be empty if leads not accepted</p>
 * <p>No default value</p>
 * <p>General correct value is empirical, based on values given on «Advertiser» → «Credentials» page → «Token» column
 * </p>
 */
public class LENDER_ID extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "(" +
                "\\d{10}|\\d{12,14}" +
                ")?";
    }
}