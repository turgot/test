package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«EDITORIAL» tag (class name is used as tag name so should be like in response)</p>
 * <p>From to api doc: «Indicates if this lender is an editorial lender.»</p>
 * <p>Can't be empty</p>
 * <p>No default value</p>
 * <p>General correct value is based on api doc. Tag can have only «Yes» or «NO» values</p>
 */
public class EDITORIAL extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "(YES|NO)";
    }
}