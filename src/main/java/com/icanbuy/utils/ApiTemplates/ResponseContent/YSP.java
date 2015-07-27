package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«YSP» tag (class name is used as tag name so should be like in response)</p>
 * <p>From api doc: «Points for the program» (whatever this means)</p>
 * <p>Can't be empty</p>
 * <p>No default value</p>
 * <p>General correct value is purely empirical</p>
 */
public class YSP extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "-?\\d\\.\\d{3}";
    }
}