<html>
<head>
    <meta charset="UTF-8">
    <title>Все голосования</title>
</head>
<body>
    ${poll.id}. ${poll.title}
    <ul>
    <#list poll.answers as answer>
        <li>${answer.text}</li>
    </#list>
    </ul>
</body>
</html>