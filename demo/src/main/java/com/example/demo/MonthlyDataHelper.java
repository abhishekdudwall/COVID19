package com.example.demo;

import java.util.Calendar;
import java.text.SimpleDateFormat;
public class MonthlyDataHelper {

        public CasesDataResponse prepareMonthlyCasesData(CovidTrackingServiceResponseDto covidTrackingServiceResponseDto){
            CasesDataResponse casesDataResponse = new CasesDataResponse();
            try {
                List<MonthlyData> monthlyDatas = null;
                if (!ObjectUtils.isEmpty(covidTrackingServiceResponseDto.getDetails())) {

                    ObjectMapper mapper = new ObjectMapper();
                    monthlyDatas = covidTrackingServiceResponseDto.getDetails().stream().map(temp -> {
                        MonthlyData monthlyData = null;
                        String strDate = temp.getDateCollected();
                        java.util.Date date = new SimpleDateFormat("MM/dd").parse(strDate);
                        Calendar cal = Calendar.getInstance();
                        cal.setTime(date);
                        //Month Name
                        String month = cal.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.getDefault());
                        monthlyData.setMonth(month);

                        int days = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

                        int tests = temp.getDailyTotal();
                        DataType dataType = new DataType();
                        dataType.setTestAvgCounts(tests);
                        monthlyData.setTypes((new ArrayList<dataTypes>().add(dataType)));

                        return monthlyData;
                    }).collect(Collectors.toList());

                    Map<List<CasesDataResponse.MonthlyData>,Integer> monthlyDatas =
                            monthlyDatas.stream().collect(Collectors.groupingBy(CasesDataResponse.MonthlyData ::month, Collectors.counting()));



                    casesDataResponse.set

            } catch (ApiFailedException ae) {

            } catch (Exception e) {

            }
            return casesDataResponse;
        }



    }
