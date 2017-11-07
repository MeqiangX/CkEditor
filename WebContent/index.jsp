<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!-- Ckeditor 文本编辑器的使用
     1.将ckeditor整个文件拷贝到项目网络资源目录下
     2.在要使用编辑器的地方插入HTML插件  
       <textarea id="TextArea1" 	rows="2" cols="20" class="ckeditor"></textarea>
       
       
      3. 将相应的控件替换成编辑器代码
      <script type="text/javascript" src="ckeditor/ckeditor.js"></script>
    <script type="text/javascript">CKEDITOR.replace("TextArea1");</script>
    
    4.配置编辑器，大小 皮肤功能 等配置，在config,js里面配置，不配置也可以用默认
    
    -->
<script type="text/javascript" src="ckeditor/ckeditor.js"></script>
<script type="text/javascript">
CKEDITOR.replace("TextArea1");
</script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="ArticleServlet" method="post">
<textarea id="TextArea1" rows="2" cols="20" class="ckeditor" name="edit"></textarea>
<input type="submit" value="提交">
</form>

</body>
</html>