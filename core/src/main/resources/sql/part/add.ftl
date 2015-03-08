<#include "../functions/sql.ftl">
insert into parts (compositionId, text)
values(${part.compositionId}, '${sql(part.text)}');