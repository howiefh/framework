<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>自定义指令</title>
</head>
<body>
	<h2>没有参数</h2>
	<p>
		<#macro greet>
			<font size="+2">Hello Joe!</font>
		</#macro>
		<@greet/>
	</p>
	<h2>有参数</h2>
	<p>
		<#macro greet person>
			<font size="+2">Hello ${person}!</font>
		</#macro>
		<@greet person="Fred"/> and <@greet person="Bob"/>
	</p>
	<h2>多个参数时，可以设定默认值</h2>
	<p>
		<#macro greet person color="black">
			<font size="+2" color="${color}">Hello ${person}!</font>
		</#macro>
		<@greet person="Fred"/> and <@greet person="Bob" color="red"/>
	</p>
</body>
</html>