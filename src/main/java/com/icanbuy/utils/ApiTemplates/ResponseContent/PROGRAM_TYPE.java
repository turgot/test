package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«PROGRAM_TYPE» tag (class name is used as tag name so should be like in response)</p>
 * <p>From api doc: «Indicated the type of the program» (government / army / ...)</p>
 * <p>Can't be empty</p>
 * <p>Default value is «CONV»</p>
 * <p>According to api doc general value can have one of 4 values: «CONV», «FHA» or «VA». Also short, numeric,
 * version of program type is used in click leads link: 0, 1 or 2</p>
 */
public class PROGRAM_TYPE extends ApiTag {
    protected String numericDefaultValue = "0";
    protected String numericValue = "(0|1|2)";

    /**
     * <p>Regexp which describe any correct value of this tag</p>
     */
    @Override
    protected void setValue() {
        value = "(CONV|FHA|VA)";
    }

    @Override
    protected void setDefaultValue() { value = "CONV"; }
}