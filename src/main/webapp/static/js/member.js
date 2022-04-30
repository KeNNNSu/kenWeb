/*<![CDATA[*/

$(function () {
    alert('載入完成');
    buildtable($memberList);
})

function buildtable(memberList) {
    let dom = [];
    let tableHead = `
        <tr>
            <td>No.</td>
            <td>ID</td>
            <td>NAME</td>
            <td>E-MAIL</td>
            <td>PHONE</td>
        </tr>
    `;
    dom.push(tableHead);
    for (let idx in memberList) {
        let tr = trBuild(idx, memberList[idx]);
        dom.push(tr);
    }
    $('#table').html(dom.join(''));

    // 渲染 member 的 tr
    function trBuild(idx, member) {
        return `
            <tr>
                <td>` + (Number(idx) + 1) + `</td>
                <td>` + member.id + `</td>
                <td>` + member.person.name + `</td>
                <td>` + member.person.email + `</td>
                <td>` + member.person.phone + `</td>
            </tr>
        `;
    }
}


/*]]>*/