/*<![CDATA[*/

$(function () {
    google.charts.load("current", { packages: ["corechart"] });
    google.charts.setOnLoadCallback(drawChart);

    google.charts.load('current', { 'packages': ['table'] });
    google.charts.setOnLoadCallback(drawTable);
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

function drawTable() {

    build($reportTableData.income);

    function build(tableData) {
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Code');
        data.addColumn('string', 'Subject');
        data.addColumn('number', '1月');
        data.addColumn('number', '2月');
        data.addColumn('number', '3月');
        data.addColumn('number', '4月');
        data.addColumn('number', '5月');
        data.addColumn('number', '6月');
        data.addColumn('number', '7月');
        data.addColumn('number', '8月');
        data.addColumn('number', '9月');
        data.addColumn('number', '10月');
        data.addColumn('number', '11月');
        data.addColumn('number', '12月');
        // data.addRows([
        //     ['Mike', { v: 10000 }, true],
        //     ['Jim', { v: 8000 }, false],
        //     ['Alice', { v: 12500 }, true],
        //     ['Bob', { v: 7000 }, true]
        // ]);
        data.addRows(buildTableData());

        var table = new google.visualization.Table(document.getElementById('table_div'));

        // table.draw(data, { showRowNumber: true, width: '100%', height: '100%' });
        table.draw(data, { width: '100%', height: '100%' });

    }
}

function buildTableData(tableData) {

    let incomeArr = toRows('總收入(A)', $reportTableData.income);
    let payArr = toRows('總支出(B)', $reportTableData.pay);
    let totalArr = toLastRows('收支餘絀(C=A-B)', $reportTableData.balance);

    return [].concat(incomeArr, payArr, totalArr);

    function toRows(totalName, tableData) {
        let arr = [];
        let rows = tableData.rows;
        for (let idx in rows) {
            let row = rows[idx];
            let objArr = [];
            objArr.push(row.code);
            objArr.push(row.subjectName);
            objArr.push({ v: row.monthColumns['M1'] });
            objArr.push({ v: row.monthColumns.M2 });
            objArr.push({ v: row.monthColumns.M3 });
            objArr.push({ v: row.monthColumns.M4 });
            objArr.push({ v: row.monthColumns.M5 });
            objArr.push({ v: row.monthColumns.M6 });
            objArr.push({ v: row.monthColumns.M7 });
            objArr.push({ v: row.monthColumns.M8 });
            objArr.push({ v: row.monthColumns.M9 });
            objArr.push({ v: row.monthColumns.M10 });
            objArr.push({ v: row.monthColumns.M11 });
            objArr.push({ v: row.monthColumns.M12 });
            arr.push(objArr);
        }
        let row2 = tableData.total;
        let objArr2 = [];
        objArr2.push('');
        objArr2.push(totalName);
        objArr2.push({ v: row2.M1 });
        objArr2.push({ v: row2.M2 });
        objArr2.push({ v: row2.M3 });
        objArr2.push({ v: row2.M4 });
        objArr2.push({ v: row2.M5 });
        objArr2.push({ v: row2.M6 });
        objArr2.push({ v: row2.M7 });
        objArr2.push({ v: row2.M8 });
        objArr2.push({ v: row2.M9 });
        objArr2.push({ v: row2.M10 });
        objArr2.push({ v: row2.M11 });
        objArr2.push({ v: row2.M12 });
        arr.push(objArr2);
        return arr;
    }

    function toLastRows(totalName, monthData) {
        let arr = [];
        let objArr = [];
        objArr.push('');
        objArr.push(totalName);
        objArr.push({ v: monthData.M1 });
        objArr.push({ v: monthData.M2 });
        objArr.push({ v: monthData.M3 });
        objArr.push({ v: monthData.M4 });
        objArr.push({ v: monthData.M5 });
        objArr.push({ v: monthData.M6 });
        objArr.push({ v: monthData.M7 });
        objArr.push({ v: monthData.M8 });
        objArr.push({ v: monthData.M9 });
        objArr.push({ v: monthData.M10 });
        objArr.push({ v: monthData.M11 });
        objArr.push({ v: monthData.M12 });
        arr.push(objArr);
        return arr;
    }

}


/*]]>*/