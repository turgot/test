package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«RATE_LOCK_USED» tag (class name is used as tag name so should be like in response)</p>
 * <p>From api doc: «Indicates the rate lock period for the program»</p>
 * <p>Can't be empty</p>
 * <p>No default value</p>
 * <p>General values can have one of 3 values: «30», «45», «60» (from (as admin) «Advertiser» → «Margins and Fees» page
 * → «Settings» block</p>
 */
public class RATE_LOCK_USED extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "(30|45|60)";
    }
}