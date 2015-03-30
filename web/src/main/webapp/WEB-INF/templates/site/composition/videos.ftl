<#-- @ftlvariable name="video" type="net.itistukai.core.domain.core.Video"-->
<#import "/spring.ftl" as spring/>
<#if videos?? && videos?has_content>
    <#list videos as video>
    <div class="js-video-wrapper col-xs 12 <#if viewType=="grid">col-md-4 col-lg-4<#else>col-md-8 col-md-push-2 col-lg-8 col-lg-push-2</#if>">
        <div class="video_block">
            <div class="player">
                <div class="video_text_block js-video-text">
                    <p>
                    ${(video.part.htmlText())!}
                    </p>
                    <div class="media">
                        <div class="media-left">
                            <a href="${(video.instagramUser.userName)!"#"}">
                                <img class="media-object" src="${(video.instagramUser.profilePicture)!}" alt="" style="width: 64px;height: 64px"/>
                            </a>
                        </div>
                        <div class="media-body">
                            <h4 class="media-heading"><a href="${(video.instagramUser.userName)!"#"}">
                                ${(video.instagramUser.fullName)!""}
                            </a></h4>
                            <#if video.instagramUrl??>
                                <a class="js-is-link" target="_blank" href="${video.instagramUrl}"><@spring.message code="site.lookat.instagram"/></a>
                            </#if>
                        </div>
                    </div>
                </div>
                <video class="js-video" poster="${video.preloaderUrl}" controls="true" crossorigin>
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
    <button class="btn btn-link btn-lg btn-block js-more-videos"
            data-page="${page}"><@spring.message code="site.morevideo"/></button>
    </#if>
<#else>
    <#if partId??>
    <p><@spring.message code="site.novideoswithpart"/></p>
    <#else>
    <p><@spring.message code="site.novideos"/></a></p>
    </#if>

</#if>