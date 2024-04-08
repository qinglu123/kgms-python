<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style type="text/css">

        div{
            margin-top: 10px;
            margin-left: 30px;
        }
        table {
            border-collapse: collapse;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        table, th, td {
            border: 1px solid black;
        }

        th, td {
            text-align: left;
            padding: 8px;
        }

        tr:hover {
            background-color: #f5f5f5
        }

        tr:nth-child(even) {
            background-color: #f2f2f2
        }
    </style>
</head>
<script type="application/javascript" src="/js/jquery-3.6.0.min.js"></script>
<body>
<#--当前页-->
<input type="hidden" name="pageNum"/>
<#--总页数-->
<input type="hidden" name="pages"/>
<div>
    图书分类：<select id="category">
        <option value="-1">全部</option>
    </select>
    <button type="button" name="query">查询</button>

    <button type="button" name="add">新增电子图书</button>
</div>
<h1 align="center">电子图书列表</h1>

<table align="center">

</table>

<div align="center">
    <a href="#" no="f">首页</a>
    <a href="#" no="p">上一页</a>
    <a href="#" no="n">下一页</a>
    <a href="#" no="l">尾页</a>
</div>

</body>
<script>
    $(function () {
        showList()
        //获取图书分类
        $.get("/category/getAll", function (result) {
            for (var i = 0; i < result.length; i++) {
                $("#category").append('<option value="' + result[i].id + '">' + result[i].name + '</option>')
            }
        });
        $("a[no]").click(function () {
            var attr = $(this).attr("no");
            // console.log("attr  " + attr)
            var number = parseInt($("input[name='pageNum']").val());
            // console.log("number  " + number)

            if (attr == "f") {
                $("input[name='pageNum']").val(1);
            }
            if (attr == "p") {
                $("input[name='pageNum']").val(number - 1);
            }
            if (attr == "n") {
                $("input[name='pageNum']").val(number + 1);
            }
            if (attr == "l") {
                $("input[name='pageNum']").val($("input[name='pages']").val())
            }
            showList()
        })
        //获取图书信息
        // $.get("/entry/getEntryAll", function (result) {
        //     for (var i = 0; i < result.length; i++) {
        //
        //     }
        // });
        //删除图书
        //新增电子图书
        $("button[name='add']").click(function () {
            location.href = "http://127.0.0.1:8080/entry/add"
        })
        // 查询分类图书
        $("button[name='query']").click(function () {
            //获取分类ID
            var val = $("select").val();
            // console.log("val " + val);
            //设置当前页为第一页
            $("input[name=pageNum]").val(1)
            var data = $("input[name=pageNum]").val()
            // console.log("data -- " + data)
            showList()

        })
    })

    // function showPageList() {
    //     //获取当前页码
    //     var data = $("input[name=pageNum]").val()
    //     // console.log("data -- " + data)
    //     //AJAX get请求
    //     $.get("/entry/getEntryAll", {"pageNum": data}, function (result) {
    //         // console.log("result.pageNum  " + result.pageNum)
    //         $("input[name='pageNum']").val(result.pageNum);
    //         $("input[name='pages']").val(result.pages);
    //         var entrys = result.list;
    //         //页面处理，展示集合
    //         $("table").empty();
    //         var str = " <thead>\n" +
    //             "    <tr>\n" +
    //             "        <th>图书编号</th>\n" +
    //             "        <th>图书名称</th>\n" +
    //             "        <th>图书摘要</th>\n" +
    //             "        <th>上传人</th>\n" +
    //             "        <th>上传时间</th>\n" +
    //             "        <th>操作</th>\n" +
    //             "    </tr>\n" +
    //             "    </thead>";
    //         for (var i = 0; i < entrys.length; i++) {
    //             str += "<tr><td>" + entrys[i].id + "</td><td>" +
    //                 entrys[i].title + "</td><td>" + entrys[i].summary +
    //                 "</td><td>" + entrys[i].uploadUser + "</td><td>" + entrys[i].createDate +
    //                 "</td><td><a href='#'>修改</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='#'>删除</a></td></tr>";
    //         }
    //
    //         $("table").append(str);
    //     }, "json");
    // }

    function showList() {
        //获取当前页码
        var data = $("input[name=pageNum]").val()
        // console.log("data -- " + data)
        //获取分类ID
        var val = $("select").val();
        //AJAX get请求
        $.get("/entry/getEntryByCategoryId", {"pageNum": data, "categoryId": val}, function (result) {
            // console.log("result.pageNum  " + result.pageNum)
            $("input[name='pageNum']").val(result.pageNum);
            $("input[name='pages']").val(result.pages);
            var entrys = result.list;
            //页面处理，展示集合
            $("table").empty();
            var str = " <thead>\n" +
                "    <tr>\n" +
                "        <th>图书编号</th>\n" +
                "        <th>图书名称</th>\n" +
                "        <th>图书摘要</th>\n" +
                "        <th>上传人</th>\n" +
                "        <th>上传时间</th>\n" +
                "        <th>操作</th>\n" +
                "    </tr>\n" +
                "    </thead>";
            for (var i = 0; i < entrys.length; i++) {
                str += "<tr><td>" + entrys[i].id + "</td><td>" +
                    entrys[i].title + "</td><td>" + entrys[i].summary +
                    "</td><td>" + entrys[i].uploadUser + "</td><td>" + entrys[i].createDate +
                    "</td><td><a href='javascript:void(0)' onclick='toUpdate(" + entrys[i].id + ")'>修改1</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href='javascript:void(0)' onclick='del(" + entrys[i].id + ")'>删除1</a></td></tr>";
            }
            $("table").append(str);
        }, "json");
    }

    function del(id) {
        $.post("/entry/del", {"id": id}, function (result) {
            location.href = "http://127.0.0.1:8080/entry/index"
        });
    }

    function toUpdate(id) {
        location.href = "http://127.0.0.1:8080/entry/getById?id="+id
    }
</script>
</html>