package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«MONTHLY_PAYMENT» tag (class name is used as tag name so should be like in response)</p>
 * <p>From api doc: «Indicates the monthly payment (Principal and interest only)»</p>
 * <p>Can't be empty</p>
 * <p>No default value</p>
 * <p>General correct value is purely empirical</p>
 */
public class MONTHLY_PAYMENT extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "\\$\\d{3}";
    }
}