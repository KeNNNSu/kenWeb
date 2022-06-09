/*<![CDATA[*/

$(function () {
    alert('載入完成');
    buildtable($accountList);
    
})

function buildtable(accountList) {
    
    let dom = [];
    let tableHead = `
        <tr>
            <td>No.</td>
            <td>ID</td>
            <td>帳號</td>
            <td>密碼</td>
            <td>狀態</td>
        </tr>
    `;
    dom.push(tableHead);
    for (let idx in accountList) {
        let tr = trBuild(idx, accountList[idx]);
        dom.push(tr);
    }
    $('#table').html(dom.join(''));

    // 渲染 account 的 tr
    function trBuild(idx, account) {
        console.log("有沒有")
        return `
            <tr>
                <td>` + (Number(idx) + 1) + `</td>
                <td>` + account.id + `</td>
                <td>` + account.account + `</td>
                <td>` + account.password + `</td>
                <td>` + account.status + `</td>
            </tr>
        `;
    }
}


/*]]>*/