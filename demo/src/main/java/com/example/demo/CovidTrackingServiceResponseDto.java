package com.example.demo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import java.util.List;
import java.util.ArrayList;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CovidTrackingServiceResponseDto {

    private List<SingleDataDetails> details;

    public class SingleDataDetails {

        @JsonProperty("dateCollected")
        private String dateCollected;

        @JsonProperty("cdcLabs")
        private String cdcLabs;

        @JsonProperty("usPubHealthLabs")
        private String usPubHealthLabs;

        @JsonProperty("dailyTotal")
        private String dailyTotal;

        @JsonProperty("lag")
        private String lag;


    }

}
