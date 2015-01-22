<#include "../functions/joiner.ftl"/>
select count(*) from users u
where 1=1
<#--filtering common user and admins-->
<#if withRoles?? && withRoles?has_content >
and role in (<@join_roles roles=withRoles/>)
</#if>
