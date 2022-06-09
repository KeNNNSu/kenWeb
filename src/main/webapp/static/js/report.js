/*<![CDATA[*/

$(function () {
    google.charts.load("current", { packages: ["corechart"] });
    google.charts.setOnLoadCallback(drawChart);
})

function drawChart() {

    build('donutchart1');
    build('donutchart2');

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
            title: 'My Daily Activities',
            pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById(donutChartId));
        chart.draw(data, options);
    }
}


/*]]>*/