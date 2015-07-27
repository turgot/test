package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>Tags xml, tag «PROGRAM_ID» (class name is used as tag name so should be like in response)</p>
 * <p>From api doc: «Unique field for the particular loan scenario». From investigations: contains advertiser id (token)
 * + program (conv, fha, va) id. Example, test advertiser token = 112233, program = conv (0) → program id = 1122330 </p>
 * <p>Can't be empty</p>
 * <p>No default value</p>
 * <p>General value is empirical, based on values from (admin) Advertiser → Credentials (page) → token column + 1
 * digit</p>
 */
public class PROGRAM_ID extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = new LENDER_ID().getValue().replaceAll("\\?", "") + new PROGRAM_TYPE().numericValue;
    }
}