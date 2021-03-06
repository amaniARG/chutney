package com.chutneytesting.task.http.function;

import com.github.tomakehurst.wiremock.verification.LoggedRequest;
import com.chutneytesting.task.spi.SpelFunction;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;

public class WireMockFunction {

    @SpelFunction
    public static Map<String, String> extractHeadersAsMap(LoggedRequest request) {
        Map<String, String> headersMap = new HashMap<>();
        for (String key : request.getAllHeaderKeys()) {
            headersMap.put(key, request.getHeader(key));
        }
        return headersMap;
    }

    @SpelFunction
    public static Map<String, String> extractParameters(LoggedRequest request) {
        Map<String, String> parameters = new HashMap<>();
        request.getQueryParams()
            .entrySet()
            .forEach(e -> {
                parameters.put(e.getValue().key(), StringUtils.join(e.getValue().values(), ", "));
            });

        return parameters;
    }
}
