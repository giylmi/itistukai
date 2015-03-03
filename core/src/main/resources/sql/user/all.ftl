<#include "../functions/joiner.ftl"/>
select u.id, u.login, u.password, u.salt, u.email, u.role<#if withPI!false>, pi.firstName, pi.middleName, pi.lastName</#if>
    from users u
        <#--joining name-->
        <#if withPI!false>
            join personnel_information pi on u.id=pi.userId
        </#if>
where 1=1
    <#--filtering common user and admins-->
    <#if withRoles?? && withRoles?has_content >
        and role in (<@join_enum values=withRoles/>)
    </#if>
