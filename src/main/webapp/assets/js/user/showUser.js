function getalluser() {
    var host = window.location.host;
    //获取主机
    var url = "http://"+host+"/user/getAll";
    console.log(url);
    $.ajax({
        type: "GET",
        url: url,
        dataType:"json",//自动转换json对象
        success:function (returnMap) {
            if(returnMap.success){
                var div = document.getElementById("divTable");
                var data = returnMap.data;
                var table = document.createElement("table");//创建table
                table.border="2";
                table.width = "50%";
                table.id = "userTable";
                var tr,td1,td2,td3,td4,td5;
                //创建表头
                tr = table.insertRow(table.rows.length);//指定位置插入新行，目前table,rows.length=0
                td1=tr.insertCell(tr.cells.length);
                td2=tr.insertCell(tr.cells.length);
                td3=tr.insertCell(tr.cells.length);
                td4=tr.insertCell(tr.cells.length);
                td5=tr.insertCell(tr.cells.length);
                td1.innerHTML="ID";
                td2.innerHTML="用户名";
                td3.innerHTML="密码";
                td4.innerHTML="修改";
                td5.innerHTML="删除";
                //填充数据
                for(var i=0;i<data.length;i++){
                    var button1 = document.createElement("button");
                    var button2 = document.createElement("button");
                    var input = document.createElement("input");
                    tr=table.insertRow(table.rows.length);
                    td1 = tr.insertCell(tr.cells.length);
                    td2 = tr.insertCell(tr.cells.length);
                    td3 = tr.insertCell(tr.cells.length);
                    td4 = tr.insertCell(tr.cells.length);
                    td5 = tr.insertCell(tr.cells.length);
                    input.type = "text";
                    input.value = data[i].passWord;
                    button1.innerHTML = "修改";
                    button2.innerHTML = "删除";
                    button1.setAttribute("onclick","updateUser("+(i+1)+")");//第几行数据
                    button2.setAttribute("onclick","deleteUser("+(i+1)+")");//第几行数据
                    td1.innerHTML=i+1;
                    td2.innerHTML=data[i].userName;
                    td3.appendChild(input);
                    td4.appendChild(button1);
                    td5.appendChild(button2);
                }
                div.appendChild(table);
                //document.querySelector("divTable").appendChild(table);
            }else{
                alert("服务器忙，请稍后重试！");
            }
        }
    })
}

function updateUser(id) {
    //获取table
    var table = document.getElementById("userTable");
    //获取指定行
    var tr = table.rows[id];
    //获取指定内容
    var userName = tr.cells[1].innerHTML;
    var passWord = tr.cells[2].getElementsByTagName("INPUT")[0].value;

    var host = window.location.host;
    //获取主机
    var url = "http://"+host+"/user/updateUser";
    $.ajax({
        url:url,
        type:"post",
        dataType:"json",
        data:{userName:userName,passWord:passWord},
        success:function (returnMap) {
            if(returnMap.success){
                alert("修改成功！");
                window.location.reload();
            }else{
                alert("服务器忙，");
                window.location.reload();
            }
        }
    })
}
function deleteUser(id) {
    //获取table
    var table = document.getElementById("userTable");
    //获取指定行
    var tr = table.rows[id];
    //获取指定内容
    var userName = tr.cells[1].innerHTML;

    var host = window.location.host;
    //获取主机
    var storage = window.localStorage;
    if(userName == storage.getItem("userName")){
        alert("不能删除自己！");
        return;
    }
    var url = "http://"+host+"/user/deleteUser";
    $.ajax({
        type:"delete",
        url:url+"?userName="+userName,
        dataType:"json",
        success:function (returnMap) {
            if(returnMap.success){
                alert("删除成功！");
                window.location.reload();
            }else{
                alert("服务器忙，请稍后重试！");
                window.location.reload();
            }
        }
    })
}


$('#addUser').click(
    function () {
        var userName = document.getElementById("userName").value;
        var passWord = document.getElementById("passWord").value;
        var host = window.location.host;
        //获取主机
        var url = "http://" + host + "/user/addUser";
        $.ajax({
            type: "put",
            url: url,
            data:{userName: userName, passWord: passWord},
            dataType: "json",
            success: function (returnMap) {
                if (returnMap.success) {
                    alert("添加成功");
                    window.location.reload();
                } else {
                    alert("服务器忙，请稍后重试！");
                    window.location.reload();
                }
            }
        })
    }
)
