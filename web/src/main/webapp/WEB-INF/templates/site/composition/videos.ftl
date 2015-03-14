<#-- @ftlvariable name="video" type="net.itistukai.core.domain.core.Video"-->
<#if videos?? && videos?has_content>
    <#list videos as video>
    <div class="col-xs 12 <#if viewType=="grid">col-md-4 col-lg-4<#else>col-md-12 col-lg-12</#if>">
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
<#else>
    <#if partId??>
    <p>К сожалению, видео c таким отрывком еще не загрузили.</p>
    <#else>
    <p>К сожалению, видео для этого произведения еще не загрузили. <a href="/#join">Станьте первым!</a></p>
    </#if>

</#if>