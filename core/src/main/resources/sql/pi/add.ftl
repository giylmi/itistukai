<#include "../functions/sql.ftl">
insert into personnel_information (userId, firstName, middleName, lastName)
    values(${pi.userId}, '${sql(pi.firstName)}',
        <#if pi.middleName??> '${sql(pi.middleName)}' <#else> null </#if>, '${sql(pi.lastName)}');