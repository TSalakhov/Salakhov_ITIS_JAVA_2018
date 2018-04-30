<html>
    <head>
        <meta charset="UTF-8">
        <title>Все голосования</title>
    </head>
    <body>
    <h1>Список голосований</h1>
    <p>Выберите голосование из списка:</p>
    <ul>
        <#list pollList as poll>
            <li><a href="/polls/${poll.id}">${poll.title}</a></li>
        </#list>
    </ul>
    </body>
</html>