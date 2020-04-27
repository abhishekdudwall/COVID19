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
    private List<MonthlyData> monthlyDatas;
    private List<MonthlyData> monthlyDatas;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(NON_NULL)
    public static class MonthlyData {
        private String month;
        private List<DataType> dataTypes;

    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(NON_NULL)
    public static class DataType {
        private String type;
        private double testAvgCounts;

    }
    public final static Comparator<MonthlyData> monthlyDataComparator = new Comparator<MonthlyData>() {
        @Override
        public int compare(MonthlyData a1, MonthlyData a2) {
            String month1 = a1.getMonth().toLowerCase();
            String month2 = a2.getMonth().toLowerCase();
            return month1.compareTo(month2);
        }};
}
