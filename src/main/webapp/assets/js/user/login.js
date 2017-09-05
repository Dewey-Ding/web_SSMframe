function login(){
    var host = window.location.host;
    //获取主机
    var url = "http://"+host+"/user/login";
    var userName = document.getElementById("userName").value;
    var passWord = document.getElementById("passWord").value;
    //发起请求
    $.post(url,{userName:userName,passWord:passWord},function (returnMap) {
        var storage = window.localStorage;
        //var session = window.sessionStorage;
        if (returnMap.success) {
            storage.setItem("userName",userName);
            //session.setAttribute("user",userName);
            window.location.href = "welcome.html";
        } else {
            alert("用户名或密码错误！");
            window.location.reload();
        }
    },"json")
}