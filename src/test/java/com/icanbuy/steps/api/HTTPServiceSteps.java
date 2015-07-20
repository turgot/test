package com.icanbuy.steps.api;

import com.icanbuy.utils.Settings;
import net.serenitybdd.core.Serenity;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.StepGroup;
import net.thucydides.core.steps.ScenarioSteps;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Work with http requests: send request, basic response check, saving response to serenity session
 */
public class HTTPServiceSteps extends ScenarioSteps {

    /**
     * Full server's {@link #fetch(String) response}: xml, headers, ... .
     */
    private HttpResponse response = null;

    /**
     * Part of server's {@link #segregateXMLFromResponse() response}, that contain information about advertisers (xml)
     */
    private String actualXml;

    /**
     * <p>This is step group which purpose is to acquire and store response xml to test session. Steps in group:
     * <ol>
     *     <li>{@link #fetch(String) acquire} response</li>
     *     <li>{@link #responseHttpStatusShouldBeOk() check} response status. I can imagine tests that need empty (null)
     *     response entity so i ignore it in this method.</li>
     *     <li>{@link #segregateXMLFromResponse() isolate} xml from headers</li>
     *     <li>{@link #storeResponseXMLToTestSession() store} xml to test session</li>
     * </ol>
     * </p>
     * @param uri    request uri (url)
     * @throws IOException  in case of a problem or the connection was aborted or if an error occurs reading the
     * response entity
     */
    @StepGroup
    public void storeXMLResponseFor(String uri) throws IOException {
        response = fetch(uri);
        responseHttpStatusShouldBeOk();
        actualXml = segregateXMLFromResponse();
        storeResponseXMLToTestSession();
    }

    /**
     * <p>Perform api request</p>
     * @param uri    request uri (url)
     * @return  server's response
     * @throws  IOException  in case of a problem or the connection was aborted
     */
    @Step
    private HttpResponse fetch(String uri) throws IOException {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet getRequest = new HttpGet(uri);
        return client.execute(getRequest);
    }

    /**
     * Assert that HTTP response status code is between 200 and 300 (ok statuses)
     */
    @Step
    public void responseHttpStatusShouldBeOk() {
        int statusCode = response.getStatusLine().getStatusCode();
        assertThat(statusCode).describedAs("Unexpected response status: " + statusCode).isBetween(200, 300);
    }

    /**
     * <p>Besides entity (content), which is optional, http response always contain some other information, like, for
     * example, headers, response status, e.t.c.</p>
     * <p>This method segregate entity from response</p>
     * @return  response entity or null if empty
     * @throws IOException  if an error occurs reading the response entity
     */
    @Step
    public String segregateXMLFromResponse() throws IOException {
        return EntityUtils.toString(response.getEntity());
    }

    /**
     * Store {@link #actualXml xml} from response to test {@link Settings#API_RESPONSE_XML session} for future use.
     */
    @Step
    public void storeResponseXMLToTestSession() {
        Serenity.getCurrentSession().addMetaData(Settings.API_RESPONSE_XML, actualXml);
    }
}