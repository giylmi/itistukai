<#-- @ftlvariable name="video" type="net.itistukai.core.domain.core.Video"-->
<#import "/spring.ftl" as spring/>
<#if videos?? && videos?has_content>
    <#list videos as video>
    <div class="col-xs 12 <#if viewType=="grid">col-md-4 col-lg-4<#else>col-md-8 col-md-push-2 col-lg-8 col-lg-push-2</#if>">
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
    <button class="btn btn-link btn-block btn-lg js-more-videos" data-page="${page}"><@spring.message code="site.morevideo"/></button>
    </#if>
<#else>
    <#if partId??>
    <p><@spring.message code="site.novideoswithpart"/></p>
    <#else>
    <p><@spring.message code="site.novideos"/></a></p>
    </#if>

</#if>