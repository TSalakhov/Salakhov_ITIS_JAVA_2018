<html>
<head>
    <#include "links.ftl">
</head>
<body>
<#include "menu.ftl">
<div class="container">
<#list AllUsers as user >
    <div class="row">
        <div class="col-1">Username:</div>
        <div class="col-11"><p> ${user.username} </p></div>
    </div>
    <div class="row">
        <div class="col-1">Firstname:</div>
        <div class="col-11"> <p> <a href="/user/${user.id}">${user.firstname}</a> </p></div>
    </div>
    <div class="row">
        <div class="col-1">Secondname:</div>
        <div class="col-11"><p> <a href="/user/${user.id}"> ${user.secondname}</a></p></div>
    </div>
</#list>
</div>
</body>
</html>
