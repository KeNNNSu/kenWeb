package application.model.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>
 * [DonutChartPay]
 * </p>
 * 
 * <pre>
 * [
 *      ['Ken', 'Happy Day'],
 *      ['Watch TV', 11],
 *      ['Work', 2],
 *      ['Sleep', 2],
 *      ['Eat', 2],
 *      ['Commute', 7]
 * ]
 * </pre>
 * 
 * @author ken
 * @since 2022/06/08
 */
public class DonutChartPay {

    private List<String> columnNames = Arrays.asList("Ken", "Happy Day");
    private List<DonutChartPayData> donutChartData2s;

    public DonutChartPay(List<DonutChartPayData> donutChartData2s) {
        super();
        this.donutChartData2s = donutChartData2s;
    }

//    public String toJson() {
//        try {
//            return new ObjectMapper().writeValueAsString(transforModel());
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//            throw new IllegalArgumentException("Json 轉換錯誤!!");
//        }
//    }

    public List<List<Object>> transforModel() {
        List<List<Object>> donutChartModelData = new ArrayList<>();
        donutChartModelData.add(ofColumnNames());
        for (DonutChartPayData data : donutChartData2s) {
            donutChartModelData.add(ofColumnValue(data));
        }
        return donutChartModelData;
    }

    private List<Object> ofColumnNames() {
        return new ArrayList<>(columnNames);
    }

    private List<Object> ofColumnValue(DonutChartPayData data) {
        return Arrays.asList(data.getKen(), data.getHappyDay());
    }

    public static class DonutChartPayData {

        private String ken;
        private int happyDay;

        public DonutChartPayData(String ken, int happyDay) {
            super();
            this.ken = ken;
            this.happyDay = happyDay;
        }

        public String getKen() {
            return ken;
        }

        public int getHappyDay() {
            return happyDay;
        }

        public void setKen(String ken) {
            this.ken = ken;
        }

        public void setHappyDay(int happyDay) {
            this.happyDay = happyDay;
        }

        @Override
        public String toString() {
            return "DonutChartData [ken=" + ken + ", happyDay=" + happyDay + "]";
        }

    }
}
