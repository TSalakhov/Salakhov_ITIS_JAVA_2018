<html>
<head>
    <#include "links.ftl">
    <style>
        .container {
            margin-top: 30px;
            margin-left: 10px;
        }
    </style>
</head>
<body>
<#include "menu.ftl">
<#list MyFriend as user>
    <#include "csrf.ftl">
    <div class="container">
        <div class="row">
            <div class="col-1">Username:</div>
            <div class="col-11"><p> ${user.username}</p></div>
        </div>
        <div class="row">
            <div class="col-1">Firstname:</div>
            <div class="col-11"><p><a href="/user/${user.id}"> ${user.firstname}</a></p></div>
        </div>
        <div class="row">
            <div class="col-1">Secondname:</div>
            <div class="col-11"><p><a href="/user/${user.id}">${user.secondname}</a></p></div>
        </div>
    </div>
</#list>
</body>
</html>