<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>list指令</title>
</head>
<body>
	<h3>list指令</h3>
	<table border=1>
		<#list animals as animal>
			<tr>
				<#-- boolean类型要设置默认输出值，否则报错 -->
				<td>${animal.name}, ${animal.price}, ${animal.protect?c}</td>
			</tr>
		</#list>
	</table>
</body>
</html>