<#include "../functions/sql.ftl"/>
INSERT INTO compositions (name, status)
values ('${sql(composition.name)}', ${composition.status.value});