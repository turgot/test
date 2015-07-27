package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«LENDER_LOGO_CLICK_URL» tag (class name is used as tag name so should be like in response)</p>
 * <p>From api doc: «Use this path when you want to submit a click to the Informa platform. This click will redirect
 * the user to the lenders landing page»</p>
 * <p>Can be empty if advertiser not accept clicks.</p>
 * <p>Default value exist only {@link #createDefaultClickLeadLink() partially}</p>
 * <p>General correct value is {@link #createClickLeadLink() empirical}</p>
 */
public class LENDER_LOGO_CLICK_URL extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = createClickLeadLink();
    }

    @Override
    protected void setDefaultValue() {
        value = createDefaultClickLeadLink();
    }
}