<div xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
    <head>
<#include "links.ftl">
    </head>
</div>

<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <a class="navbar-brand" href="/">EntertainmentAdviser</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
            aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
                <#if currentUser??>
                    <li class="nav-item active"><a class="nav-link" href="/">Главная</a></li>
                    <li class="nav-item active"><a class="nav-link" href="/user/${currentUser.id}">Профиль</a></li>
                </#if>
        </ul>
        <#if currentUser??>
            <form class="form-inline my-2 my-lg-0" action="/logout" method="post">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log out</button>
            </form>
        <#else>
            <form class="form-inline my-2 my-lg-0" action="/login" method="get">
                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Log in</button>
            </form>
        </#if>
    </div>
</nav>


<!DOCTYPE html>
<html lang="en">
<head>
    <style>
        html,
        body {
            font-family: 'Oswald', sans-serif;
        }

        .profile {
            min-height: 355px;
            display: inline-block;
            font-family: 'Lobster', cursive;
            font-size: 20px;
            margin-left: 30px;
        }

        .goodbutton {
            display: inline-block;
            margin-right: auto;
            font-family: 'Lobster', cursive;
            font-size: 24px;
        }
    </style>
</head>
</html>

<html>
<body>
<form action="/create" method="POST">
    <#list user_profile as user>
        <link href="https://fonts.googleapis.com/css?family=Lobster" rel="stylesheet">

        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <div class="well profile">
            <p><strong>Ваш id</strong></p>
            <p>${user.id}</p>
            <p><strong>username:</strong></p>
            <input type="text" name="username" id="username" value="${user.username}"> <br>
            <p><strong>firstname: </strong></p>
            <input type="text" name="firstname" id="firstname" value="${user.firstname}"> <br>
            <p><strong> secondname:</strong></p>
            <input type="text" name="secondname" id="secondname" value="${user.secondname}"> <br>
            <div class="goodbutton">
                <input type="submit" value="изменить профиль">
            </div>
        </div>
    </#list>
</form>
</body>
</html>





