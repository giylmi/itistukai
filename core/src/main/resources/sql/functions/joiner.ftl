<#macro join_roles roles=[]>
    <#list roles as role>
        ${role.value}<#if role_has_next>,</#if>
    </#list>
</#macro>