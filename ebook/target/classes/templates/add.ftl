<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css">
        font{
            padding-left: 10px;
        }
        div {
            margin-top: 10px;
        }

        table {
            border-collapse: collapse;
        }

        table, th, td {
            border: 1px solid black;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }
        td{
            width: 400px;
        }
    </style>
</head>
<script type="application/javascript" src="/js/jquery-3.6.0.min.js"></script>
<body>
<h1 align="center">增加电子图书</h1>
<form action="/entry/insert" method="post" name="form1">
    <table align="center">
        <tbody>
        <tr>
            <th>图书名称(*)</th>
            <td><input type="text" name="title"><font color="red" id="tit"></font></td>
        </tr>
        <tr>
            <th>图书类别(*)</th>
            <td><select name="categoryId">

                </select></td>
        </tr>
        <tr>
            <th>图书摘要</th>
            <td><textarea name="summary" cols="30" rows="10"></textarea></td>
        </tr>
        <tr>
            <th>上传人</th>
            <td><input type="text" name="uploadUser"></td>
        </tr>
        <tr>
            <th>上传时间(*)</th>
            <td><input type="date" name="createDate">(yyyy-MM-dd)<font color="red" id="time"></font></td>
        </tr>
        </tbody>
    </table>
    <div align="center">
        <button type="submit" name="sub">提交</button>
        <button type="button" name="return">返回</button>
    </div>
</form>

</body>
<script type="application/javascript">
    $(function () {
        //获取图书分类
        $.get("/category/getAll", function (result) {
            for (var i = 0; i < result.length; i++) {
                $("select[name='categoryId']").append('<option value="' + result[i].id + '">' + result[i].name + '</option>')
            }
        });
        $("button[name='return']").click(function (){
            history.back()
        })
        $("button[name='sub']").click(function (){
            console.log("aaaaa")
            var tag = false;
            var val = $("input[name='title']").val();
            if (val == null || val.length == 0 ){
                $("#tit").text("图书名称不能为空")
            }

            var time = $("input[name='createDate']").val();
            if (time == null || time.length == 0 ){
                $("#time").text("上传时间不能为空")
            }
            var t1 = $("#time").text()
            var t2 = $("#tit").text()
            if (t1.length == 0 && t2.length == 0){
                tag = true;
            }
            return tag;

        })
        $("input").click(function (){
            var t1 = $("#tit").text();
            if (t1 != null || t1.length > 0){
                $("#tit").text("")
            }
            var t = $("#time").text();
            if (t != null || t.length > 0){
                $("#time").text("")
            }
        })
    })
</script>
</html>