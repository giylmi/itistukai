<#list videos as video>
    <div class="col-xs-4">
        <div class="player">
            <video poster="//cdn.selz.com/plyr/1.0/poster.jpg" controls crossorigin>
                <!-- Video files -->
                <source src="${video.url}" type="video/mp4">
                <#--<source src="//cdn.selz.com/plyr/1.0/movie.webm" type="video/webm">-->
            </video>
        </div>
    </div>
</#list>