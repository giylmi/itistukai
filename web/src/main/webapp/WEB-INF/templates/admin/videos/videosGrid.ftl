<#include "videoStatus.ftl"/>
<#macro videosGrid videos=[]>
    <div>
    <#if (videos?has_content)>
        <#list videos as video>
        <div class="col-xs-12 col-md-4 well js-video">
            <div class="player">
                <video poster="${video.preloaderUrl}" controls crossorigin>
                    <!-- Video files -->
                    <source src="${video.url}" type="video/mp4">
                <#--<source src="//cdn.selz.com/plyr/1.0/movie.webm" type="video/webm">-->
                </video>
            </div>
            <div class="js-videos-status-form-wrapper">
                <@videoStatus video=video/>
            </div>
        </div>
        </#list>
        <#if hasNext!false>
        <button class="btn btn-link btn-block btn-lg js-more-videos" data-page="${page}">Больше видео</button>
        </#if>
    <#else>
        <h3>Видео пока нет! :(</h3>
    </#if>
    </div>
</#macro>