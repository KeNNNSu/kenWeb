/** 使用者列表 */
var $userList = [];

$(function () {
    // 載入就先執行
    console.log('loading user page finish!!')
    query();
})

function tableBuild(userList) {
    let dom = []
    let tableHead = `
        <tr>
            <td>No.</td>
            <td>UID</td>
            <td>Account</td>
            <td>Level</td>
            <td>Operate</td>
        </tr>
    `;
    dom.push(tableHead);
    for (let idx in userList) {
        let tr = trBuild(idx, userList[idx]);
        dom.push(tr);
    }
    $('#userTable').html(dom.join(''));

    // 渲染 user 的 tr
    function trBuild(idx, user) {
        return `
            <tr>
                <td>` + (Number(idx) + 1) + `</td>
                <td>` + user.uid + `</td>
                <td>` + user.account + `</td>
                <td>` + user.level + `</td>
                <td>
                    <img class="funcBtn" src="../static/img/update.png" width="25" alt="修改" onclick="preModify(` + idx + `)" data-bs-toggle="modal" data-bs-target="#modifyModal">
                    <img class="funcBtn" src="../static/img/delete.png" width="25" alt="移除" onclick="remove('` + idx + `')">
                </td>
            </tr>
        `;
    }
}

/** 查詢 USER */
function query() {
    $.ajax({
        method: 'GET',
        url: '../k_api/k_user/all',

        // 預期從 server 拿到的資料型態
        dataType: 'json',
        data: {},
        success: function (res) {
            console.log(res);
            $userList = res.data;
            tableBuild(res.data);
        },
        error: function (err) {
            console.log(err)
        },
        complete: function (XMLHttpRequest, textStatus) {

        }
    })
}

/** 新增 USER */
function add() {
    let account = $('#account').val();
    let password = $('#password').val();
    let password2 = $('#password2').val();
    // check account
    if (!checkAccount(account))
        return;
    // check password
    if (!checkPassword(password, password2))
        return;

    let apiVo = {
        account: account,
        password: password
    };

    // ajax
    $.ajax({
        method: 'POST',
        url: '../k_api/k_user',
        dataType: 'json',
        data: apiVo,
        success: function (res) {
            // console.log(res);
            // {
            //     "info": "新增成功",
            //     "data": true,
            //     "statusCode": 201,
            //     "date": "2022-04-12 23:07:45"
            // }
            alert(res.info);
            // 關閉的按鈕
            $('#addClodsBtn').trigger('click');
            // 清空資料
            $('#account').val('');
            $('#password').val('');
            $('#password2').val('');
            // 顯示資料
            query();
        },
        error: function (err) {
            console.log(err)
        },
        complete: function (XMLHttpRequest, textStatus) {

        }
    })
}

/** 移除 USER */
function remove(idx) {
    let user = $userList[idx];

    if (!confirm('你確定要刪除 uid: ' + user.uid + ' 嗎?'))
        return;

    // ajax
    $.ajax({
        method: 'DELETE',
        url: '../k_api/k_user/' + user.uid,
        dataType: 'json',
        data: {},
        success: function (res) {
            // console.log(res);
            alert(res.info);
            // 顯示資料
            query();
        },
        error: function (err) {
            console.log(err)
        },
        complete: function (XMLHttpRequest, textStatus) {

        }
    })
}

/** 修改 USER 前置作業 */
function preModify(idx) {
    let user = $userList[idx];
    $('#muid').val(user.uid);
    $('#maccount').val(user.account);
}

/** 修改 USER */
function modify() {

    // if (!confirm('你確定要修改 uid: ' + user.uid + ' 嗎?'))
    //     return;

    let uid = $('#muid').val();
    let password = $('#mpassword').val();
    let password2 = $('#mpassword2').val();

    // check password
    if (!checkPassword(password, password2))
        return;

    let apiVo = {
        password: password
    }

    // if (true) {
    //     console.log('uid: ', uid);
    //     console.log('apiVo' + apiVo);
    //     console.log('apiVo', apiVo);
    //     return;
    // }

    // ajax
    $.ajax({
        method: 'PUT',
        url: '../k_api/k_user/' + uid,
        dataType: 'json',
        data: apiVo,
        success: function (res) {
            // console.log(res);
            alert(res.info);
            // 關閉的按鈕
            $('#modifyClodsBtn').trigger('click');
            // 清空資料
            $('#muid').val('');
            $('#maccount').val('');
            $('#mpassword').val('');
            $('#mpassword2').val('');
            // 顯示資料
            query();
        },
        error: function (err) {
            console.log(err)
        },
        complete: function (XMLHttpRequest, textStatus) {

        }
    })

}

function checkPassword(pass1, pass2) {
    if (!pass1 || !pass2) {
        alert('密碼不可為空');
        return false;
    }
    if (pass1 !== pass2) {
        alert('密碼輸入不一致, 請再確認');
        return false;
    }
    return true;
}

function checkAccount(account) {
    if (!account) {
        alert('帳號不可為空');
        return false;
    }
    if (account.length < 4) {
        alert('帳號不可小於 4 個字');
        return false;
    }
    return true;
}