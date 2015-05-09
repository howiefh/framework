<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>序列</title>
</head>
<body>
	<h3>list</h3>
	<#assign season=["summer", "winter", "spring", "autumn"]>
	<p>
		<#list season as s>
			${s},
		</#list>
	</p>
	<p>
		<#list season[2..] as x>
			${x},
		</#list>
	</p>
	<h3>序列的操作</h3>
	<ul>
		<li>+连接：
			<#list ["sumer", "winter"]+["spring", "autumn"] as x>
				${x}.
			</#list>
		</li>
		<li>序列切分：
			<#list season[2..3] as x>
			${x},
		</#list>
		</li>
	</ul>
</body>
</html>