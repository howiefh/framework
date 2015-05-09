<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>变量</title>
</head>
<body>
	<h3>简单变量</h3>
	<p>
		<#assign x=1> <#--创建变量x-->
		${x}<br>
		<#assign x=x+3> <#--替换变量x-->
		${x}
	</p>
	<h3>局部变量也会隐藏（而不是）同名的简单变量。循环变量也会隐藏（不是覆盖）同名的局部变量和简单变量。</h3>
	<#macro test>
		2. ${x}<br>
		<#local x="local">
		3. ${x}<br>
		<#list ["loop"] as x>
			4. ${x}<br>
		</#list>
		5. ${x}<br>
	</#macro>
	<p>
		<#assign x="plain">
		1. ${x}<br>
		<@test/>
		6. ${x}<br>
		<#list ["loop"] as x>
			7. ${x}<br>
			<#assign x="plain2"> <#--在这里替换了简单变量x-->
			8. ${x}<br>
		</#list>
		9. ${x}
	</p>
	<h3>内部循环可以隐藏外部循环的变量</h3>
	<p>
		<#list ["loop 1"] as x>
			${x}<br>
			<#list ["loop 2"] as x>
				${x}<br>
				<#list ["loop 3"] as x>
					${x}<br>
				</#list>
				${x}<br>
			</#list>
			${x}<br>
		</#list>
	</p>
	<h3>有时发生一个变量隐藏数据模型中的同名变量，但是如果想访问数据模型中的变量，就可以使用特殊变量`globals`。</h3>
	<p>
		<#assign user="Cindy">
		${user}, ${.globals.user}
	</p>
</body>
</html>