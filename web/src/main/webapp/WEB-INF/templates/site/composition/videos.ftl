<#-- @ftlvariable name="video" type="net.itistukai.core.domain.core.Video"-->
<#import "/spring.ftl" as spring/>
<#if videos?? && videos?has_content>
    <#list videos as video>
    <div class="js-video-wrapper col-xs 12 <#if viewType=="grid">col-md-4 col-lg-4<#else>col-md-8 col-md-push-2 col-lg-8 col-lg-push-2</#if>">
        <div class="video_block">
            <div class="player">
                <div class="video_text_block">
                    <p><br>Зур бу урман: читләре күренмидер, диңгез кеби,
                        <br>Биниһая, бихисаптыр, гаскәри Чыңгыз кеби.
                        <br>Кылт итеп искә төшәдер намнары, дәүләтләре
                        <br>Карт бабайларның, моны күрсәң, бөтен
                        сауләтләре.
                    </p>
                    <a href="dsfsdf">vk.com/fsdafa</a>
                </div>
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
    <button class="btn btn-link btn-block btn-lg js-more-videos"
            data-page="${page}"><@spring.message code="site.morevideo"/></button>
    </#if>
<#else>
    <#if partId??>
    <p><@spring.message code="site.novideoswithpart"/></p>
    <#else>
    <p><@spring.message code="site.novideos"/></a></p>
    </#if>

</#if>