package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«PHONE» tag (class name is used as tag name so should be like in response)</p>
 * <p>From api doc: «Contains the phone number for this lender. If empty this indicates that this lender is not
 * accepting phone calls at this time» → toll free number</p>
 * <p>Can be empty.</p>
 * <p>No default value</p>
 * <p>General correct value is fully empirical</p>
 */
public class PHONE extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "(" +                   //can be empty (open)
                "\\(\\d{3}\\)" +        //phone provider code
                "\\s\\d{3}-\\d{4}" +    //phone number
                ")?";                   //can be empty (close)
    }
}