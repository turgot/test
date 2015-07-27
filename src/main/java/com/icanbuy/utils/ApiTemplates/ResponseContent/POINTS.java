package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«POINTS» tag (class name is used as tag name so should be like in response)</p>
 * <p>From api doc: «Number of points» (whatever this means). Not to be confused with points in request. Response
 * points is different thing.</p>
 * <p>Can't be empty</p>
 * <p>No default value</p>
 * <p>General correct value is purely empirical</p>
 */
public class POINTS extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "-?\\d\\.\\d{3}";
    }
}