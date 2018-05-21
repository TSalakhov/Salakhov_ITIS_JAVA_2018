<html>
<head>
    <#include "links.ftl">
</head>
<body>
<#include "menu.ftl">
 <#list user_profile as user>
     <#if currentUser.id == user.id>
<div class="container">
    <form action="/create" method="POST">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <h1>Профиль</h1>
        <div class="form-group has-success">
            <label class="col-form-label" for="inputSuccess1">Username:</label>
            <input type="text" class="form-control form-control-success" id="username" name="username" value="${user.username}">
        </div>
        <div class="form-group has-success">
            <label class="col-form-label" for="inputSuccess1">Firstname:</label>
            <input type="text" class="form-control form-control-success" id="firstname" name="firstname" value="${user.firstname}">
        </div>
        <div class="form-group has-success">
            <label class="col-form-label" for="inputSuccess1">Secondname:</label>
            <input type="text" class="form-control form-control-success" id="secondname" name="secondname" value="${user.secondname}">
        </div>
        <button type="submit" class="btn btn-warning">Сохранить изменения</button>
    </form>
</div>
     </#if>
     <#if currentUser.id != user.id>
      <form action="/add" method="post">
          <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
          <h1>Профиль</h1>
          <div class="row">
              <input type="hidden" name="username" id="username" value="${user.username}">
              <div class="col-1">Username:</div>
              <div class="col-11">${user.username}</div>
          </div>
          <div class="row">
              <input type="hidden" name="secondname" id="secondname" value="${user.firstname}">
              <div class="col-1">Firstname:</div>
              <div class="col-11">${user.firstname}</div>
          </div>
          <div class="row">
              <input type="hidden" name="secondname" id="secondname" value="${user.secondname}">
              <div class="col-1">Secondname:</div>
              <div class="col-11">${user.secondname}</div>
          </div>
          <button type="submit" class="btn btn-outline-success">Добавить в друзья</button>
      </form>
        </form>
    </div>
     </#if>
 </#list>
</body>
</html>





