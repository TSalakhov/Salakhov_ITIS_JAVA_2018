<html>
<head>
 <#include "links.ftl">
</head>
<body>
<#include "menu.ftl">
<#list user_profile as user>
 <h1>Профиль</h1>
          <div class="row">
              <div class="col-1">Username:</div>
              <div class="col-11">${user.username}</div>
          </div>
          <div class="row">
              <div class="col-1">Firstname:</div>
              <div class="col-11">${user.firstname}</div>
          </div>
          <div class="row">
              <div class="col-1">Username:</div>
              <div class="col-11">${user.secondname}</div>
          </div>
</#list>
</body>
</html>