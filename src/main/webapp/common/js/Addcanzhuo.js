$(function () {
    $("#addtable").click(
        function () {
            var upid = $("#upid").val();
            if (upid == "") {
                // 添加
                if (!check()) {
                    return;
                }
                var tablenum = $("#table_num").val();
                var tablePernum = $("#table_Pernum").val();
                $.post("addTable", "tableNum=" + tablenum + "&tablePernum="
                    + tablePernum, function (res) {
                    if (res == 500) {
                        layer.msg('餐桌编号存在！');
                        return;
                    }
                    if (res.code == 200) {
                        alert("添加成功！");
                        location.href = '/DinnerRoomManager/canzhuo';
                    } else {
                        layer.msg('添加失败！');
                    }
                });
                // $("#frm").attr("action","addTable");
                // $("#frm").submit();
            } else {
                // 修改
                if (!check()) {
                    return;
                }
                $("#frm").attr("action", "updateTable");
                $("#frm").submit();
            }
        });
    $("#ret").click(function () {
        location.href = '/DinnerRoomManager/canzhuo';
    });
});

function check() {
    var table_num = $("#table_num").val();
    var table_Pernum = $("#table_Pernum").val();
    var regtable_Pernum = /^[0-9]*$/;
    if (!table_num) {
        layer.msg('请输入座位号');
        return false;
    } else if (!table_Pernum) {
        layer.msg('请输入可座人数');
        return false;
    } else if (!regtable_Pernum.test(table_Pernum)) {
        layer.msg('可座人数为整数！');
        return false;
    } else {
        return true;
    }
}

layui.use('form', function () {
    var form = layui.form;
});