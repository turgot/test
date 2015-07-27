package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«FEES» tag (class name is used as tag name so should be like in response)</p>
 * <p>From api doc: «Indicates total fees (total of all the fees - rebate). Should not consider this as a closing
 * coast»</p>
 * <p>Can't be empty</p>
 * <p>No default value</p>
 * <p>General correct value is purely empirical</p>
 */
public class FEES extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "[\\d,()$]{1,8}";
    }
}