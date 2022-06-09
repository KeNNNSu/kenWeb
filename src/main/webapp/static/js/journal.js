/*<![CDATA[*/

$(function () {
    alert('載入完成');
    buildtable($journalList);

})

function queryAll() {
    
    $.ajax({
        method: 'POST',
        url: 'journal/queryAll',

        // 預期從 server 拿到的資料型態
        dataType: 'json',
        data: {},
        success: function (res) {
            alert(res.message);
            $journalList = res.data;
            buildtable(res.data);
        },
        error: function (err) {
            console.log(err)
        },
        complete: function (XMLHttpRequest, textStatus) {

        }
    })
}

function buildtable(journalList) {

    let dom = [];
    let tableHead = `
        <tr>
            <td>No.</td>
            <td>ID</td>
            <td>date</td>
            <td>debit</td>
            <td>credit</td>
            <td>reduce/<br>increase</td>
            <td>amount</td>
            <td>info</td>
            <td>account</td>
            <td>timeModify</td>
            <td>operate</td>
        </tr>
    `;
    dom.push(tableHead);
    for (let idx in journalList) {
        let tr = trBuild(idx, journalList[idx]);
        dom.push(tr);
    }
    $('#table').html(dom.join(''));

    // 渲染 journal 的 tr
    function trBuild(idx, journal) {
        let id = journal.journalBookId;
        return `
            <tr>
                <td>` + (Number(idx) + 1) + `</td>
                <td>` + id + `</td>
                <td id="jDate` + id + `">` + journal.date + `</td>
                <td id="jDebit` + id + `" data-code="` + journal.debitCode + `">` + journal.debit + `</td>
                <td id="jCredit` + id + `" data-code="` + journal.creditCode + `">` + journal.credit + `</td>
                <td>` + journal.plusOrMinusSign + `</td>
                <td id="jAmount` + id + `">` + journal.amount + `</td>
                <td>
                    <span id="jItem` + id + `">` + journal.item + `</span><br>`
            + `<span id="jPlace` + id + `">` + journal.place + `</span><br>`
            + `<span id="jWho` + id + `">` + journal.who + `</span></td>
                <td>` + journal.accountName + `</td>
                <td>` + journal.timeModify + `</td>
                <td>
                    <button type="button" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#modifyModal" onclick="modifyTriggerBtn(` + id + `)">編輯</button>&emsp;
                    <button type="button" class="btn btn-danger" onclick="remove(` + id + `)">刪除</button>
                </td>
            </tr>
        `;
    }
}

/** 新增 */
function add() {
    // 驗證

    let apiVo = {
        recordDate: $('#recordDate').val(),
        codeOfDebit: $('#debit').val(),
        codeOfCredit: $('#credit').val(),
        amount: $('#amount').val(),
        item: $('#item').val(),
        place: $('#place').val(),
        who: $('#who').val(),
        accountId: $('#accountId').val()
    }
    // 確認
    if (!confirm('是否確定要新增資料'))
        return;

    $.ajax({
        method: 'POST',
        url: 'journal/add',

        // 預期從 server 拿到的資料型態
        dataType: 'json',
        data: apiVo,
        success: function (res) {
            alert(res.message);
            $('#addCancel').trigger('click');
            clearForm();
            queryAll();
        },
        error: function (err) {
            console.log(err)
        },
        complete: function (XMLHttpRequest, textStatus) {

        }
    })

    function clearForm() {
        $('#recordDate').val('');
        $('#debit').val('-1');
        $('#credit').val('-1');
        $('#amount').val('');
        $('#item').val('');
        $('#place').val('');
        $('#who').val('');
    }
}

/** 修改 */
function modifyTriggerBtn(journalBookId) {
    // let jDate = $('#jDate' + journalBookId).text();
    // $('#modifyRecordDate').val(jDate);
    // let jDebit = $('#jDebit' + journalBookId).text();
    // $('#modifyDebit').val(jDebit);
    // let jCredit = $('#jCredit' + journalBookId).text();
    // $('#modifyCredit').val(jCredit);
    // let jAmount = $('#jAmount' + journalBookId).text();
    // $('#modifyAmount').val(jAmount);
    // let jItem = $('#jItem' + journalBookId).text();
    // $('#modifyItem').val(jItem);
    // let jPlace = $('#jPlace' + journalBookId).text();
    // $('#modifyPlace').val(jPlace);
    // let jWho = $('#jWho' + journalBookId).text();
    // $('#modifyWho').val(jWho);
    setAllData();

    function setAllData() {
        $('#modifyModal').attr('data-id', journalBookId);
        reset('jDate', 'modifyRecordDate');
        resetByDropDownList('jDebit', 'modifyDebit');
        resetByDropDownList('jCredit', 'modifyCredit');
        reset('jAmount', 'modifyAmount');
        reset('jItem', 'modifyItem');
        reset('jPlace', 'modifyPlace');
        reset('jWho', 'modifyWho');
    }

    function resetByDropDownList(trId, modalItem) {
        let j = $('#' + trId + journalBookId).attr('data-code');
        $('#' + modalItem).val(j);
    }

    function reset(trId, modalItem) {
        let j = $('#' + trId + journalBookId).text();
        $('#' + modalItem).val(j);
    }
}

function modify() {
    let journalBookId = $('#modifyModal').attr('data-id');

    // 驗證資料(同新增的檢查邏輯)

    let apiVo = {
        journalBookId: journalBookId,
        recordDate: $('#modifyRecordDate').val(),
        codeOfDebit: $('#modifyDebit').val(),
        codeOfCredit: $('#modifyCredit').val(),
        amount: $('#modifyAmount').val(),
        item: $('#modifyItem').val(),
        place: $('#modifyPlace').val(),
        who: $('#modifyWho').val()
    }

    // 確認
    if (!confirm('是否確定要更新資料'))
        return;

    $.ajax({
        method: 'POST',
        url: 'journal/modify',

        // 預期從 server 拿到的資料型態
        dataType: 'json',
        data: apiVo,
        success: function (res) {
            alert(res.message);
            $('#modifyCancel').trigger('click');
            clearForm();
            queryAll();
        },
        error: function (err) {
            console.log(err)
        },
        complete: function (XMLHttpRequest, textStatus) {

        }
    })

    function clearForm() {
        $('#modifyRecordDate').val('');
        $('#modifyDebit').val('-1');
        $('#modifyCredit').val('-1');
        $('#modifyAmount').val('');
        $('#modifyItem').val('');
        $('#modifyPlace').val('');
        $('#modifyWho').val('');
    }
}


/** 刪除 */
function remove(journalBookId) {
    console.log('journalBookId: ', journalBookId);
    // 確認
    if (!confirm('是否確定要刪除資料'))
        return;

    $.ajax({
        method: 'POST',
        url: 'journal/remove',

        // 預期從 server 拿到的資料型態
        dataType: 'json',
        data: {
            journalBookId: journalBookId
        },
        success: function (res) {
            alert(res.message);
            queryAll();
        },
        error: function (err) {
            console.log(err);
        },
        complete: function (XMLHttpRequest, textStatus) {

        }
    })
}

/*]]>*/