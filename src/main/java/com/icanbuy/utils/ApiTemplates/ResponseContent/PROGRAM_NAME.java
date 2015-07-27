package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«PROGRAM_NAME» tag (class name is used as tag name so should be like in response)</p>
 * <p>From api doc: «Deprecated» – looks like was used for something earlier, but no more</p>
 * <p>Always empty</p>
 * <p>No default value</p>
 * <p>No general value</p>
 */
public class PROGRAM_NAME extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "";
    }
}