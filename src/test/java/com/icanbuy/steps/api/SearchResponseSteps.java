package com.icanbuy.steps.api;

import com.icanbuy.utils.ApiTemplates.SearchApi;
import com.icanbuy.utils.Settings;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.regex.Pattern;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Processing api search response
 */
public class SearchResponseSteps extends ScenarioSteps {

    private String actualResult;
    private Pattern expectedResult;

    /**
     * Verify that api request return xml that matches expected regexp. Include steps
     * <ol>
     *     <li>{@link #restoreActualXML restore} actual xml</li>
     *     <li>{@link #prepareDefaultXMLPattern create} expected xml pattern</li>
     *     <li>{@link #isActualResponseMatchesExpectedPattern() compare} results</li>
     * </ol>
     */
    @StepGroup
    public void storedDefaultResponseXMLShouldMatchExpectedRegexp() {
        actualResult = restoreActualXML();
        expectedResult = prepareDefaultXMLPattern();
        isActualResponseMatchesExpectedPattern();
    }

    /**
     * Restore {@link Settings#API_RESPONSE_XML xml} from test session
     * @return  xml as string
     */
    @Step
    public String restoreActualXML() {
        return Serenity.getCurrentSession().getMetaData().get(Settings.API_RESPONSE_XML);
    }

    /**
     * Default request (#HOST/api/search) response should match this pattern
     * @return  {@link Pattern#MULTILINE multiline} pattern (?m) that describe empty request
     */
    @Step
    private Pattern prepareDefaultXMLPattern() {
        return new SearchApi().prepareTemplate();
    }

    /**
     * Compare {@link #restoreActualXML() restored} and expected result
     */
    @Step
    public void isActualResponseMatchesExpectedPattern() {
        assertThat(actualResult).matches(expectedResult);
    }
}