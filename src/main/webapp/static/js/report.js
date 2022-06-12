/*<![CDATA[*/

$(function () {
    google.charts.load("current", { packages: ["corechart"] });
    google.charts.setOnLoadCallback(drawChart);
})

function drawChart() {

    build('donutchart1');
    build2('donutchart2');

    function build(donutChartId) {
        // var data = google.visualization.arrayToDataTable([
        //     ['Task', 'Hours per Day'],
        //     ['Work', 11],
        //     ['Eat', 2],
        //     ['Commute', 2],
        //     ['Watch TV', 2],
        //     ['Sleep', 7]
        // ]);
        let data = google.visualization.arrayToDataTable($incomeTableData);

        var options = {
            title: '年收入',
            pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById(donutChartId));
        chart.draw(data, options);
    }

    function build2(donutChartId) {
        let data = google.visualization.arrayToDataTable($payTableData);

        var options = {
            title: '年支出',
            pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById(donutChartId));
        chart.draw(data, options);
    }
}


/*]]>*/