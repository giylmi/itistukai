<#macro join_enum values=[]>
    <#list values as val>
        ${val.value}<#if val_has_next>,</#if>
    </#list>
</#macro>