[#ftl]
${doc.book[0].title}
${doc.book.chapter[0].title}
${doc.book.chapte[0]!"title"}
[#if doc.book.chapte[0]??]
title;
[/#if]
[#list doc.book.chapter.para as p]
<p>${p}
[/#list]

[#list doc.book.@@ as attr]
- ${attr?node_name} = ${attr}
[/#list]

[#recurse doc]
[#macro book]
Book element with title ${.node.title}
[#recurse]
End book
[/#macro]
[#macro title]
Title element
[/#macro]
[#macro chapter]
Chapter element with title: ${.node.title}
[/#macro]

[#t]
[#recurse doc]
[#macro book]
<html>
<head>
<title>[#recurse .node.title]</title>
</head>
<body>
<h1>[#recurse .node.title]</h1>
[#recurse]
</body>
</html>
[/#macro]
[#macro chapter]
<h2>[#recurse .node.title]</h2>
[#recurse]
[/#macro]
[#macro para]
<p>[#recurse]
[/#macro]
[#macro title]
[#--
We have handled this element imperatively,
so we do nothing here.
--]
[/#macro]
[#macro @text]${.node?html}[/#macro]
[#macro mark]<font color=red>[#recurse]</font>[/#macro]

${person.name}
${person.testId()}
${person.id}
${test.name}

[#assign x = "something"]
${indexOf("met", x)}
${indexOf("foo", x)}

[@upper]
hello world!
[#list ["red","blue","white","black"] as color]
${color}
[/#list]
[/@upper]

[#compress]
[#import "lib/mylib.ftl" as cr]
[@cr.copyright date="2015.1.1"]
[/@cr.copyright]
${r"${user}"}: ${user}
${date?datetime}
${date?date}
${date?time}
${latestProduct.url}
${latestProduct.name}

${user?upper_case}

[#if user == "Big Joe"]
hello ${user}
[/#if]

[#macro greet  person="joe"]
hello ${person}
[/#macro]
[@greet person="jack"/]
${".main.greet:"}[@.main.greet person="jack"/]
${html?html}
[#escape  x as x?upper_case]
<div>
${html}
[#noescape]${html}[/#noescape]
</div>
[/#escape]
[/#compress]
[#assign date=date?string("yyyy")]
${date}
${enums["java.math.RoundingMode"].UP}
[#list File.listRoots() as fileSystemRoot]
${fileSystemRoot}
[/#list]
${File.separator}