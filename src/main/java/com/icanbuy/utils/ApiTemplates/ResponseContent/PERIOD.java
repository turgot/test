package com.icanbuy.utils.ApiTemplates.ResponseContent;

/**
 * <p>«PERIOD» tag (class name is used as tag name so should be like in response)</p>
 * <p>This is «Program type», from margins page</p>
 * <p>Can't be empty, one of few key values</p>
 * <p>If not given in request or given incorrect value, default is used: 30yr fixed</p>
 * <p>General correct value is based on api doc v3_26_2</p>
 */
public class PERIOD extends ApiTag {
    /**
     * Regexp which describe any correct value of this tag
     */
    @Override
    protected void setValue() {
        value = "PERIOD_(((FIXED_(10|15|20|30|40)|ARM_(1|3|5|7|10))YEARS)|(ARM_(3|5|7)YEARSIO))";
    }

    @Override
    protected void setDefaultValue() {
        value = "PERIOD_FIXED_30YEARS";
    }
}