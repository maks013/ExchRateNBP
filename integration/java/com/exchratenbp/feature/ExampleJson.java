package com.exchratenbp.feature;

interface ExampleJson {

    default String currencyRequestBody() {
        return """
                {
                    "currency": "USD",
                    "name": "Jan Nowak"
                }
                """;
    }

    default String currencyRequestBodyWithInvalidCode() {
        return """
                {
                    "currency": "INVALIDCODE",
                    "name": "Jan Nowak"
                }
                """;
    }

    default String currencyRequestBodyWithEmptyCode() {
        return """
                {
                    "currency": "",
                    "name": "Jan Nowak"
                }
                """;
    }

    default String currencyRequestBodyWithNullCode() {
        return """
                {
                    "name": "Jan Nowak"
                }
                """;
    }

    default String currencyRequestBodyWithEmptyName() {
        return """
                {
                    "currency": "USD",
                    "name": ""
                }
                """;
    }

    default String currencyRequestBodyWithNullName() {
        return """
                {
                    "currency": "USD"
                }
                """;
    }
}
