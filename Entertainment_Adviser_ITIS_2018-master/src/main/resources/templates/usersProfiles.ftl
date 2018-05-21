<html>
<head>
    <#include "links.ftl">
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
     <#list AllUsers as user>
     <tr>
         <th scope="row">${user.id}</th>
         <td><a href="/user/${user.id}"
             <button type="button" class="btn btn-secondary"> ${user.username}</button> </a></td>
         <td>${user.firstname}</td>
         <td>${user.secondname}</td>
     </tr>
     </#list>
    </tbody>
</table>


</body>
</html>
