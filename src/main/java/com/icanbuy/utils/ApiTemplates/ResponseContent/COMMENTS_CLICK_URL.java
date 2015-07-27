package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«COMMENTS_CLICK_URL» tag (class name is used as tag name so should be like in response)</p>
 * <p>From api doc: «Clicking on this URL will register a click on the Informa platform and redirect the user to the
 * lender designated comments page»</p>
 * <p>Can be empty if advertiser not accept clicks.</p>
 * <p>Default value exist only {@link #createDefaultClickLeadLink() partially}</p>
 * <p>General correct value is {@link #createClickLeadLink() empirical}</p>
 */
public class COMMENTS_CLICK_URL extends ApiTag {
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