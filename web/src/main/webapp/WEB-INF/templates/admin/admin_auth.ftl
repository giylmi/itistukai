<#include "mainTemplate.ftl"/>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]/>
<#macro m_body>
<div class="row" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
    <div class="page-header">
        <h1>Авторизация</h1>
    </div>
</div>
<div class="row">
    <#if saved!false>
        <div class="alert alert-success">
            Изменения сохранены
        </div>
    </#if>
    <form action="/login" method="post">
        <input type="text" name="login"/>
        <input type="password" name="password"/>
        <button type="submit">Auth</button>
    </form>
</div>

</#macro>
<@m_page title="Авторизация в админской панели"
/>