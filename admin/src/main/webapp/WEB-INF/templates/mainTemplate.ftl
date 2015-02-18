<#include "./nav.ftl"/>
<#assign c=JspTaglibs['http://java.sun.com/jstl/core']/>
<#macro m_page title customStyles=[] customScripts=[]>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>${title!"Панель администратора"}</title>
    <!-- Bootstrap -->
    <link href="<@url value="/resources/bootstrap/css/bootstrap.min.css"/>" rel="stylesheet">
    <link href="<@url value="/resources/admin/css/sb-admin-2.css"/>" rel="stylesheet">
    <link href="<@url value="/resources/admin/css/timeline.css"/>" rel="stylesheet">
    <link href="<@url value="/resources/admin/css/metisMenu.min.css"/>" rel="stylesheet">
    <link href="<@url value="/resources/admin/css/font-awesome.min.css"/>" rel="stylesheet">

    <#list customStyles as style>
        <link href="<@url value="/resources/css/${style}"/>" rel="stylesheet">
    </#list>
</head>
<body>
    <@nav></@nav>
    <div id="page-wrapper">
        <@m_body></@m_body>
    </div>
<#--TODO: скачать jquery вместо CDN-->
<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script src="<@c.url value="/resources/bootstrap/js/bootstrap.min.js"/>"></script>
<script src="<@c.url value="/resources/admin/js/metisMenu.min.js"/>"></script>
</body>
</html>
</#macro>
