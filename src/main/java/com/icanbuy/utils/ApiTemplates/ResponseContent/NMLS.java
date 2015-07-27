package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«NMLS» tag (class name is used as tag name so should be like in response)</p>
 * <p>Some government / registration /licensing / ... / something like that number</p>
 * <p>Can be empty if advertiser did not provide it</p>
 * <p>No default value</p>
 * <p>General correct value is purely empirical. Can't find documentation on this field.</p>
 */
public class NMLS extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "(\\d{4,7})?";
    }
}