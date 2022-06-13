/*<![CDATA[*/

$(function () {
    google.charts.load("current", { packages: ["corechart"] });
    google.charts.setOnLoadCallback(drawChart);
})

function drawChart() {

    build('年收入', 'donutchart1', $incomeTableData);
    build('年支出', 'donutchart2', $payTableData);

    function build(tableTitle, donutChartId, tableData) {
        // var data = google.visualization.arrayToDataTable([
        //     ['Task', 'Hours per Day'],
        //     ['Work', 11],
        //     ['Eat', 2],
        //     ['Commute', 2],
        //     ['Watch TV', 2],
        //     ['Sleep', 7]
        // ]);
        let data = google.visualization.arrayToDataTable(tableData);

        var options = {
            title: tableTitle,
            pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById(donutChartId));
        chart.draw(data, options);
    }

    
}


/*]]>*/