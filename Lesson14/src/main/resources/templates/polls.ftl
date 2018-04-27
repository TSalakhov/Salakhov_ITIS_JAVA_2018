<html>
<head>
    <meta charset="UTF-8">
    <title>Все голосования</title>
</head>
<body>
<ul>
   <#list pollList as poll>
   <li>${poll.title}</li>
   </#list>
   </ul>
</body>
</html>