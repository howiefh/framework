<!doctype html>
<html lang="en">
<head>
	<meta charset="UTF-8" />
	<title>nested</title>
</head>
<body>
	<h3>嵌套</h3>
	<#macro border>
		<table border=4 cellspacing=0 cellpadding=4>
			<tr>
				<td><#nested></td>
			</tr>
		</table>
	</#macro>
	<p>
		<@border>The Bordered Text</@border>
	</p>
	<h3>多次嵌套</h3>
	<#macro do_thrice>
		<#nested>
		<#nested>
		<#nested>
	</#macro>
	<p>
		<@do_thrice>do something</@do_thrice>, 
	</p>
	<h3>嵌套内容里边可以使用其他FTL指令</h3>
	<p>
		<@border>
			<ul>
				<@do_thrice>
					<li>hello ooo</li>
				</@do_thrice>
			</ul>
		</@border>
	</p>
	<h3>在嵌套的内容中，宏的局部变量是不可见的。</h3>
	<#macro repeat count>
		<#local y="test">
		<#list 1..count as x>
			${y} ${count}/${x}: <#nested><br>
		</#list>
	</#macro>
	<p>
		<@repeat count=3>${y!"?"} ${x!"?"} ${count!"?"}</@repeat>
	</p>
	<h3>不同的局部变量是为每一个宏调用的，不会混淆</h3>
	<#macro test foo>${foo} (<#nested>) ${foo}</#macro>
	<p>
		<@test foo="A"><@test foo="B"><@test foo="C"/></@test></@test>
	</p>
	<h3>宏与循环变量</h3>
	<#macro do_thrice>
		<#nested 1>
		<#nested 2>
		<#nested 3>
	</#macro>
	<p>
		<#--自定义循环变量需要用;代替as-->
		<@do_thrice ; x>
			do_something : ${x}
		</@do_thrice>
	</p>
	<h3>一个宏可以使用多个循环变量</h3>
	<#macro repeat count>
		<#list 1..count as x>
			<#nested x, x/2, x==count><br>
		</#list>
	</#macro>
	<p>
		<@repeat count=4 ; c, half, last>
			${c}. ${half} <#if last> Last!</#if>
		</@repeat>
	</p>
</body>
</html>
