<#include "../functions/joiner.ftl"/>
select count(*) from compositions c
where 1=1
<#--filtering common user and admins-->
<#if withStatuses?? && withStatuses?has_content >
and status in (<@join_enum values=withStatuses/>)
</#if>
<#if params?? && (params.name??)>
and
(
    <#if params.name??>
        name = '${params.name}'
    </#if>
)
</#if>
