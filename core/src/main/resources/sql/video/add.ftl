<#include "../functions/sql.ftl">
insert into videos
    (
        <#if video.partId??>partId,</#if>
        status,
        url,
        date
    )
values
    (
        <#if video.partId??>${video.partId},</#if>
        '${sql(video.status.value)}',
        '${sql(video.url)}',
        '${sql(video.date.getMillis())}'
    );