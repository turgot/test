package com.icanbuy.cases.api;

import com.icanbuy.requirements.Api;
import com.icanbuy.steps.api.HTTPServiceSteps;
import com.icanbuy.steps.api.SearchResponseSteps;
import com.icanbuy.utils.Settings;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Story;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * <p>Goal. Check structure of xml from response.</p>
 * <p>Assumption. In this case i hope that default request (no parameters) will always return
 * at least 1 result.</p>
 * <p>Implementation.
 * <ol>
 *     <li>send request without parameters #HOST/api/search</li>
 *     <li>assert that xml matches expected regexp</li>
 * </ol>
 * </p>
 */
@RunWith(SerenityRunner.class)
@Story(Api.Search.XMLStructure.class)
public class TestMandatoryXmlStructure {
    @Steps
    public HTTPServiceSteps apiService;

    @Steps
    public SearchResponseSteps xmlService;

    @Test
    public void searchApiRequestShouldReturnCorrectXMLInResponseToDefaultRequest() {
        apiService.storeResponseFor(Settings.CURRENT_SERVER + "/api/search/");
        xmlService.storedDefaultResponseShouldMatchExpectedRegexp();
    }
}