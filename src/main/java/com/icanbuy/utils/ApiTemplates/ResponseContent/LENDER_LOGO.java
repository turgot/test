package com.icanbuy.utils.ApiTemplates.ResponseContent;

import com.icanbuy.utils.Settings;

/**
 * <p>«LENDER_LOGO» tag (class name is used as tag name so should be like in response)</p>
 * <p>According to api doc: Path to get the gif image for the lender logo. Use this path when you want to submit a click
 * to the Informa platform. This click will redirect the user to the lenders landing page.</p>
 * <p>Can't be empty</p>
 * <p>No default value</p>
 * <p>General correct value is empirical and based on advertisers id: (as admin) «Advertiser» → «Credentials» page →
 * «ID» column.</p>
 */
public class LENDER_LOGO extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "https?://" +
                Settings.CURRENT_SERVER_SHORT +
                "/images/lenderslogos/" +
                "(\\d{1,3}|\\d{6})" +       //advertiser id. Possible values (as admin) «Advertiser» → «Credentials» page → «ID» column
                "\\.gif";
    }
}