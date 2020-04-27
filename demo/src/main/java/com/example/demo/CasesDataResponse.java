package com.example.demo;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 *
 * CasesDataResponse contains month and avgMonthly
 * structural Data.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(NON_NULL)
public class CasesDataResponse {
    private String month;
    private List<MonthlyData> monthlyDatas;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(NON_NULL)
    public static class MonthlyData {
        private String type;
        private int avgTests;
    }
}
