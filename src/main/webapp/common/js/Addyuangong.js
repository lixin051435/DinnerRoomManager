$(function () {
    layui.use('form', function () {
        var form = layui.form;
    });
    $("#adduser").click(
        function () {
            var uid = $("#uid").val();
            if (uid == "") {
                if (!check()) {
                    return;
                }
                // 添加
                var loginname = $("#loginname").val();
                var pwd = $("#pwd").val();
                var role = $("#role").val();
                var uname = $("#uname").val();
                var sex = $("input[name='sex']").val();
                var phone = $("#phone").val();
                var idcard = $("#idcard").val();
                var address = $("#address").val();
                $.post("Adduser", "uLoginname=" + loginname + "&uPwd=" + pwd
                    + "&uRole=" + role + "&uName=" + uname + "&uSex="
                    + sex + "&uPhone=" + phone + "&uIdcard=" + idcard
                    + "&uAddress=" + address, function (res) {
                    if (res == -3) {
                        layer.msg('登录名重复');
                        return;
                    }
                    if (res == -2) {
                        layer.msg('管理员不允许添加多个');
                        return;
                    }
                    if (res.code == 200) {
                        layer.msg('添加成功');
                        return;
                    }
                    if (res.code == 200) {
                        location.href = '/DinnerRoomManager/yuangong';
                        return;
                    }
                });
            } else {
                // 修改
                if (!check()) {
                    return;
                }
                $("#frm").attr("action", "updateuser");
                $("#frm").submit();
            }
        });
    $("#ret").click(function () {
        location.href = '/DinnerRoomManager/yuangong';
    });
});

function check() {
    var loginname = $("#loginname").val();
    var pwd = $("#pwd").val();
    var role = $("#role").val();
    var uname = $("#uname").val();
    var phone = $("#phone").val();
    var idcard = $("#idcard").val();
    var address = $("#address").val();
    var regphone = /^1[3|4|5|8|9|6|7][0-9]\d{4,8}$/;
    var regidcard = /^\d{17}(\d|x)$/;
    if (!loginname) {
        layer.msg('请输入登陆名');
        return;
    } else if (!pwd) {
        layer.msg('请输入登陆密码');
        return;
    } else if (role == -1) {
        layer.msg('请选择权限');
        return;
    } else if (!uname) {
        layer.msg('请输入姓名');
        return;
    } else if (!phone) {
        layer.msg('请输入手机');
        return;
    } else if (!regphone.test(phone)) {
        layer.msg('手机号码格式有误');
        return;
    } else if (!idcard) {
        layer.msg('请输入身份号');
        return;
    } else if (!regidcard.test(idcard)) {
        layer.msg('身份号号码格式有误');
        return;
    } else if (!address) {
        layer.msg('请输入地址');
        return;
    } else {
        return true;
    }
}