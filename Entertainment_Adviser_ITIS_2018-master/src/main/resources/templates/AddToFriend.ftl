<html>
<head>
    <#include "links.ftl">
</head>
<body>
<#include "menu.ftl">
<div class="container">
<#include "usersProfiles.ftl">
    <#if currentUser.id != user.id>

    </#if>
</div>
</body>
</html>