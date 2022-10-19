/*<![CDATA[*/

$(function () {
    //alert('載入完成');
    buildtable($subjectList);
    
})

function buildtable(subjectList) {
    
    let dom = [];
    let tableHead = `
        <tr>
            <td>No.</td>
            <td>序號</td>
            <td>科目代號</td>
            <td>科目名稱</td>
        </tr>
    `;
    dom.push(tableHead);
    for (let idx in subjectList) {
        let tr = trBuild(idx, subjectList[idx]);
        dom.push(tr);
    }
    $('#table').html(dom.join(''));

    // 渲染  tr
    function trBuild(idx, subject) {
        console.log("有沒有")
        return `
            <tr>
                <td>` + (Number(idx) + 1) + `</td>
                <td>` + subject.id + `</td>
                <td>` + subject.code + `</td>
                <td>` + subject.name + `</td>
            </tr>
        `;
    }
}


/*]]>*/