<html>
<head>
    <meta charset="UTF-8">
    <title>Все голосования</title>
</head>
<body>
    ${poll.id}. ${poll.title}
    <form action="/vote" method="POST">
        <#list poll.answers as answer>
            <input type="radio" name="answer" value="${answer.id}">${answer.text}<br>
        </#list>
        <input type="submit" value="Проголосовать">
    </form>
</body>
</html>