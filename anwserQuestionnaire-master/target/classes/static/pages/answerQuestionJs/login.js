var UserName = document.getElementById("UserName");
var Password = document.getElementById("Password");
var LoginButton = document.getElementById("LoginButton");
var UserNameText = '';

// isLoginFun();
//登录
function login() {
    if (!UserName.value) {
        alert("请先输入用户名");
        UserName.focus();
        return;
    }
    if(!Password.value) {
        alert("请输入密码");
        Password.focus();
        return;
    }

    UserNameText = $("#UserName").val();
    var PasswordTest = $("#Password").val();

    var da = {
        "username":UserNameText,
        "password":PasswordTest
    };
    commonAjaxPost(true, "/admin/userLogin", da, loginSuccess)
}

//登录成功回调
function loginSuccess(result){
    if (result.code == '666') {
        layer.msg(result.message, {icon:1});
        setCookie('isLogin','1');
        setCookie('userId',result.data.id);
        setCookie('userName',UserNameText);
        setCookie('power',result.data.role);
        setCookie('modelId',result.data.modelId)
        window.location.href = "myQuestionnaires.html"
    }else{
        layer.msg("此用户不存在",{icon:2});
    }
}

//回车事件
$(document).keydown(function (event) {
    if (event.keyCode == 13) {
        login();
    }
});

//aiLogin

let video = document.getElementById("video");
function aiLogin() {
    let constraints = {
        video: {width: 100, height: 100},
        audio: false
    };
    let promise = navigator.mediaDevices.getUserMedia(constraints);
    promise.then(function (MediaStream) {
        video.srcObject = MediaStream;
        video.play();
    }).catch(function (PermissionDeniedError) {
        console.log(PermissionDeniedError);
    })
}
function takePhoto() {
    //获得Canvas对象
    let canvas = document.getElementById("canvas");
    let ctx = canvas.getContext('2d');
    ctx.drawImage(video, 0, 0, 100, 100);
    var imgData = canvas.toDataURL();
    ctx.clearRect(0, 0, 100, 100);
    //console.log(imgData);
    commonAjaxPost(true,"/admin/aiLogin",{"imgData": imgData},Success);
}

function Success(result){
    if (result.code == '666') {
        layer.msg('识别成功', {icon:1});
        setCookie('isLogin','1');
        window.location.href = "myQuestionnaires.html"
    }else{
        layer.msg("识别失败",{icon:2});
    }
}

function aiService(){
    window.location.href = "questionAi.html"
}
