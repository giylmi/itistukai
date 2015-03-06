insert into videos
    (
        <#if video.partId??>partId,</#if>
        status,
        url
    )
values
    (
        <#if video.partId??>${video.partId},</#if>
        '${video.status}',
        '${video.url}'
    );