<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>If指令</title>
</head>
<body>
	<h1>Welcome ${user}<#if user == "Big Joe">, our beloved leader</#if></h1>
	<p>
		<#--大于号两边要加括号括起来，否则会以为是结束标签 -->
		<#if (animals.python.price > animals.elephant.price)>
			python.price > elephant.price
		<#else>
			python.price <= elephant.price
		</#if>
	</p>
	<p>
		<#if animals.python.protect>
			python.protect = true;
		</#if>
	</p>
</body>
</html>