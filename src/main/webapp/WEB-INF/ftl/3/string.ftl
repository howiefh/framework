<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>String</title>
</head>
<body>
	<h3>字符串</h3>
	<ul>
		<li>转义：${"It's \"quoted\" and this is a blackslash: \\"}</li>
		<li>版权符号：${"\xA9 1999-2000"}</li>
		<li>原生字符串：${r"${foo}"}</li>
	</ul>
	<h3>字符串操作</h3>
	<#assign user="Big Joe">
	<p>
		<ul>
			<li>读取一个字符：${user[0]}</li>
			<li>读取一定范围的字符：${user[1..5]}</li>
			<li>这种操作已经废弃了，现在使用内建函数substring，${user?substring(1, 5)}</li>
		</ul>
	</p>
</body>
</html>