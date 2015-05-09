<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>命名空间</title>
</head>
<body>
	<h3>使用import导入</h3>
	<p>
		<#import "../lib/my_test.ftl" as my>
		<@my.copyright date="2014-2016"/>
		${my.mail}
	</p>
	<h3>演示不同的命名空间</h3>
	<p>
		<#import "../lib/my_test.ftl" as my>
		<#assign mail="fred@acme.com">
		<@my.copyright date="2014-2016"/>
		${my.mail}<br>
		${mail}
	</p>
	<h3>在引入的命名空间上编写变量</h3>
	<p>
		<#import "../lib/my_test.ftl" as my>
		${my.mail}<br>
		<#assign mail="jsmith@other.com" in my>
		${my.mail}
	</p>
	<h3>数据模型中的变量在任何位置都是可见的</h3>
	<p>
		<#import "../lib/my_test.ftl" as my>
		<@my.copyright date="2014-2015"/>
	</p>
</body>
</html>