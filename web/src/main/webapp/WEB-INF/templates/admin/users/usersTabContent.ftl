<#include "../functions.ftl"/>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]/>
<#macro usersTabContent users=[]>
<div class="col-md-6 panel panel-default panel-body" xmlns="http://www.w3.org/1999/html">
    <#list users as user>
        <p>${user.pi}</p>
    </#list>
</div>
</#macro>