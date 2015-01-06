insert into personnel_information (userId, firstName, middleName, lastName)
    values(${pi.userId}, '${pi.firstName}', <#if pi.middleName??> '${pi.middleName}' <#else> null </#if>, '${pi.lastName}');