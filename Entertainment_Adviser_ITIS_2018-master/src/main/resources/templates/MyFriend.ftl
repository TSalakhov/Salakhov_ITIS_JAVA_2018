<html>
<head>
    <#include "links.ftl">
    <style>

    </style>
</head>
<body>
<#include "menu.ftl">
<table class="table table-striped table-dark table-bordered table-hover">
    <thead>
    <tr>
        <th>#</th>
        <th>username</th>
        <th>firstname</th>
        <th>Secondname</th>
    </tr>
    </thead>
    <tbody>
     <#list MyFriend as user>
     <tr>
         <th scope="row">${user.id}</th>
         <td><a href="/user/${user.id}" </a>${user.username}</td>
         <td>${user.firstname}</td>
         <td>${user.secondname}</td>
     </tr>
     </#list>
    </tbody>
</table>
</body>
</html>