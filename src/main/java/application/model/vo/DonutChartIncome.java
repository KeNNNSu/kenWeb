package application.model.vo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <p>
 * [DonutChartIncome]
 * </p>
 * 
 * <pre>
 * [
 *      ['Task', 'Hours per Day'],
 *      ['Work', 11],
 *      ['Eat', 2],
 *      ['Commute', 2],
 *      ['Watch TV', 2],
 *      ['Sleep', 7]
 * ]
 * </pre>
 * 
 * @author ken
 * @since 2022/06/09
 */
public class DonutChartIncome {

    private List<String> columnNames = Arrays.asList("Task", "Hours per Day");
    private List<DonutChartData> donutChartDatas;

    public DonutChartIncome(List<DonutChartData> donutChartDatas) {
        super();
        this.donutChartDatas = donutChartDatas;
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
        for (DonutChartData data : donutChartDatas) {
            donutChartModelData.add(ofColumnValue(data));
        }
        return donutChartModelData;
    }

    private List<Object> ofColumnNames() {
        return new ArrayList<>(columnNames);
    }

    private List<Object> ofColumnValue(DonutChartData data) {
        return Arrays.asList(data.getTask(), data.getHoursPerDay());
    }

    public static class DonutChartData {

        private String task;
        private int hoursPerDay;

        public DonutChartData(String task, int hoursPerDay) {
            super();
            this.task = task;
            this.hoursPerDay = hoursPerDay;
        }

        public String getTask() {
            return task;
        }

        public void setTask(String task) {
            this.task = task;
        }

        public int getHoursPerDay() {
            return hoursPerDay;
        }

        public void setHoursPerDay(int hoursPerDay) {
            this.hoursPerDay = hoursPerDay;
        }

        @Override
        public String toString() {
            return "DonutChartData [task=" + task + ", hoursPerDay=" + hoursPerDay + "]";
        }
    }
}
