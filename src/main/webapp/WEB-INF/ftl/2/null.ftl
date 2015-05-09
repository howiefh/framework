<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>处理不存在的变量</title>
</head>
<body>
	<h3>处理不存在的变量</h3>
	<p>welcome, ${user!"anonymous"}</p>
	<p>检测user是否存在，<#if user??>Welcome, ${user}</#if></p>
	<#--不加括号会报错: nested exception is freemarker.core.InvalidReferenceException: The following has evaluated to null or missing-->
	<p>多级访问, ${(animals.python.price)!0}</p>
</body>
</html>