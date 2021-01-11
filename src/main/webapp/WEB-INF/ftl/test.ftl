<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <#--引入富文本编辑器-->
    <script src="/resources/wangEditor.min.js"></script>
</head>
<body>
    <button id="btnRead">读取内容</button>
    <button id="btnWrite">写入内容</button>
    <div id="divEditor" style="width: 800px; height: 600px"></div>
    <script>
        let E = window.wangEditor;
        //完成富文本编辑器初始化
        let editor = new E("#divEditor");
        //创建富文本编辑器，显示在页面上
        editor.create();
        document.querySelector("#btnRead").onclick = function () {
            //获取编辑器现有的html内容
            let content = editor.txt.html();
            console.log(content);
        }
        document.querySelector("#btnWrite").onclick = function () {
            let content = "<li style='color: red'>我是<b>新内容</b></li>";
            editor.txt.html(content);
        };
    </script>
</body>
</html>