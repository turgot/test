package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«application_link» tag (class name is used as tag name so should be like in response)</p>
 * <p>According to api doc: stored in this tag url is used to create informa click lead and will lead to advertisers
 * loan application landing page.</p>
 * <p>Can be empty if advertiser not accept clicks or don't have loan application landing page. Actually, this page is
 * mandatory field in campaign settings → tag will be empty only if clicks are not accepted.</p>
 * <p>Default value exist only {@link #createDefaultClickLeadLink() partially}</p>
 * <p>General correct value is {@link #createClickLeadLink() empirical}</p>
 */
public class application_link extends ApiTag {

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