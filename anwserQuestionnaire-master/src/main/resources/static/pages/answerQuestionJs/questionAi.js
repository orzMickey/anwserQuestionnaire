var UserInput = document.getElementById("UserInput");
function submitQuestion(){
    if (!UserInput.value) {
        alert("请先输入问题");
        UserInput.focus();
        return;
    }
    var UserQuestion = $("#UserInput").val();
    var da = {
        "UserInput":UserQuestion
    };
    commonAjaxPost(true, "/admin/aiQuestion", da,getAnswer)
}
function getAnswer(result){
    if (result.code == '666') {
        document.getElementById("getAnswer").innerHTML=result.data;
    }else{
        console.log('智能客服开小差中.....不能回答你的问题！');
    }
}
