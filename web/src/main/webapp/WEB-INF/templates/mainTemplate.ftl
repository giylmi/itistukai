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
    <link href="/resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/resources/admin/css/sb-admin-2.css" rel="stylesheet">
    <link href="/resources/admin/css/timeline.css" rel="stylesheet">
    <link href="/resources/admin/css/metisMenu.min.css" rel="stylesheet">
    <link href="/resources/admin/css/font-awesome.min.css" rel="stylesheet">

    <#list customStyles as style>
        <link href="/resources/${style}" rel="stylesheet">
    </#list>

    <script src="/resources/js/jquery-2.1.3.min.js"></script>
    <script src="/resources/js/params.jquery.js"></script>
    <script src="/resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="/resources/admin/js/metisMenu.min.js"></script>
    <#list customScripts as script>
        <script src="/resources/${script}"></script>
    </#list>

    <script>
        window.JS_DATA = ${__js_data__!'{}'};
    </script>
</head>
<body>
    <@nav></@nav>
    <div id="page-wrapper">
        <@m_body></@m_body>
    </div>

</body>
</html>
</#macro>
