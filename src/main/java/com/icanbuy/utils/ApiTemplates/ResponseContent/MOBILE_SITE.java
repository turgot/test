package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«MOBILE_SITE» tag (class name is used as tag name so should be like in response)</p>
 * <p>Show is this advertiser site optimized for mobile phones</p>
 * <p>Can't be empty</p>
 * <p>No default value</p>
 * <p>Can have «YES» or «NO» values</p>
 */
public class MOBILE_SITE extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "(YES|NO)";
    }
}