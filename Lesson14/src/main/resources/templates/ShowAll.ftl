<html>
    <head>
        <meta charset="UTF-8">
        <title>Все голосования</title>
    </head>
    <body style= "background-image: url(https://wallpapershome.ru/images/pages/pic_h/15945.png)">
    <h1>Список ответов для  голосований</h1>
    <h1>||</h2>
<h2>    ||    </h2>
 <h2>   ||    </h2>
    <h2>\/ </h2>

    <table answer = "1">
    <tr>
    <th>id</th>
    <th>текст ответа</th>
    <th>Количество проголосовавших за этот вариант</th>
    </tr>
        <#list ListOfAnswers as Answer>
        <tr>
          <td> ${Answer.id}</td>
          <td>${Answer.text}</td>
        <td>  ${Answer.votesCount} </td>
            </tr>
        </#list>
  </table>
    </body>
</html>