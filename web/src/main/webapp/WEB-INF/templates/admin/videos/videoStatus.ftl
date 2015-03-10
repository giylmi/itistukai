<#macro videoStatus video>
<form class="js-videos-status-form" action="/admin/videos/status" method="post">
    <input type="hidden" name="id" value="${video.id}">
    <input type="hidden" name="status" class="js-status-value" value="">

    <div class="form-control btn-group-sm">
        <#if !(video.status == "NEW")>
            <button type="submit" class="btn btn-sm btn-primary js-video-status-change" data-status="NEW">
                Новое
            </button></#if>
        <#if !(video.status == "VIEWED")>
            <button type="submit" class="btn btn-sm btn-warning js-video-status-change" data-status="VIEWED">
                Просмотренно
            </button></#if>
        <#if !(video.status == "OK")>
            <button type="submit" class="btn btn-sm btn-success js-video-status-change" data-status="OK">
                Одобренно
            </button></#if>
        <#if !(video.status == "BANNED")>
            <button type="submit" class="btn btn-sm btn-danger js-video-status-change" data-status="BANNED">
                Отказанно
            </button></#if>
    </div>
</form>

</#macro>