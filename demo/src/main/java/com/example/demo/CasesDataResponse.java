package com.example.demo;
import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;
import java.util.Objects;
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
public class CasesDataResponse implements Serializable {
    private List<MonthlyData> monthlyDatas;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @JsonInclude(NON_NULL)
    public static class MonthlyData {
        private String month;
        private String type;
        private int testAvgCounts;
        private int totalDaysInMonth;

        @Override
        public int hashCode() {
            return Objects.hash();
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            return true;
        }

    }

    public final static Comparator<MonthlyData> monthlyDataComparator = new Comparator<MonthlyData>() {
        @Override
        public int compare(MonthlyData a1, MonthlyData a2) {
            String month1 = a1.getMonth().toLowerCase();
            String month2 = a2.getMonth().toLowerCase();
            return month1.compareTo(month2);
        }};
}
