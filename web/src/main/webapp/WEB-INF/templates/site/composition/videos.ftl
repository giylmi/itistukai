
<#-- @ftlvariable name="video" type="net.itistukai.core.domain.core.Video"-->
<#list videos as video>
<div class="col-md-4 col-lg-4">
    <div class="video_block">
        <div class="player">
            <video poster="${video.preloaderUrl}" controls crossorigin>
                <!-- Video files -->
                <source src="${video.url}" type="video/mp4">
            </video>
        </div>
        <#--<p class="video_text">-->
            <#--<#if video.part??>-->
                <#--${video.part.text}-->
            <#--</#if>-->
        <#--</p>-->
    </div>
</div>
</#list>
<#if hasNext!false>
<button class="btn btn-link btn-block btn-lg js-more-videos" data-page="${page}">Больше видео</button>
</#if>