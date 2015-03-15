<#include "mainTemplate.ftl"/>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]/>
<#macro m_body>
<div class="row" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
    <div class="page-header">
        <h1>Авторизация</h1>
    </div>
</div>
<div class="row">
    <div class="col-md-6">
        <#if error!false>
            <p class="alert alert-danger">Неправильно введен логин или пароль</p>
        </#if>
        <form action="/admin/login" method="post">
            <div class="form-group">
                <label for="login">Логин</label>
                <input id="login" class="form-control" type="text" name="login"/>
            </div>
            <div class="form-group">
                <label for="password">Пароль</label>
                <input id="password" class="form-control" type="password" name="password"/>
            </div>
            <button class="btn btn-primary" type="submit">Auth</button>
        </form>
    </div>
</div>

</#macro>
<@m_page hideNav=true title="Авторизация в админской панели"
/>