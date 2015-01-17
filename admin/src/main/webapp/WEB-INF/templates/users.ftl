<#include "mainTemplate.ftl"/>
<#macro m_body>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Пользователи</h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
    <#list users as user>
        <div class="list-group-item">${user.pi}</div>
    </#list>
</div>
</#macro>
<@m_page title="Пользователи"/>