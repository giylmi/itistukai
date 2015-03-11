<#include "../mainTemplate.ftl"/>
<#include "../functions.ftl"/>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]/>
<#macro m_body>
<div class="row" xmlns="http://www.w3.org/1999/html" xmlns="http://www.w3.org/1999/html">
    <div class="page-header">
        <h1>Редактирование видео</h1>
    </div>
</div>
<div class="row">
    <#if saved!false>
    <div class="alert alert-success">
        Изменения сохранены
    </div>
    </#if>
    <@form.form modelAttribute="videoForm" action="/admin/videos/${video.id}/edit" method="post">
    <div class="col-xs-4">
        <div class="player">
            <video poster="${video.preloaderUrl}" controls crossorigin>
                <!-- Video files -->
                <source src="${video.url}" type="video/mp4">
            <#--<source src="//cdn.selz.com/plyr/1.0/movie.webm" type="video/webm">-->
            </video>
        </div>
    </div>
    <div class="col-xs-8">
        <div class="row">
            <div class="form-group col-xs-12 js-video-part-text-wrapper">
                <#if video.part??>
                ${video.part.text}
                <#else>
                    Отрывок не выбран
                </#if>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-4">
                <div class="form-group">
                    <label for="composition">
                        Произведение:
                    </label>
                    <input type="hidden" class="js-composition-id-value" value="<#if video.part??>${video.part.composition.id}</#if>"/>
                    <input class="form-control js-composition-autocomplete" id="composition" type="text"
                           value="<#if video.part??>${video.part.composition.name}</#if>"/>
                </div>
            </div>
            <div class="col-xs-8">
                <div class="form-group">
                    <label for="part">
                        Отрывок:
                    </label>
                    <input class="form-control js-part-autocomplete" id="part" type="text"
                           value="<#if video.part??>${video.part.text}</#if>"/>
                    <input class="js-part-id-value" name="partId" type="hidden" value="<#if video.part??>${video.part.id}</#if>">
                </div>
            </div>

        </div>
        <div class="row">
            <label for="status">Статус:</label>

            <div id="status">
                <div class="col-xs-3">
                    <div class="form-group">
                        <label class="btn btn-block bt-lg btn-primary"
                               for="newStatus">Новое</label>
                        <input id="newStatus" value="NEW" type="radio" name="status"
                               <#if video.status == 'NEW'>checked</#if> />

                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <label class="btn btn-block bt-lg btn-warning"
                               for="viewedStatus">Просмотренно</label>
                        <input id="viewedStatus" value="VIEWED" type="radio" name="status"
                               <#if video.status == 'VIEWED'>checked</#if>/>

                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <label class="btn btn-block bt-lg btn-success"
                               for="okStatus">Новое</label>
                        <input id="okStatus" value="OK" type="radio" name="status"
                               <#if video.status == 'OK'>checked</#if>/>
                    </div>
                </div>
                <div class="col-xs-3">
                    <div class="form-group">
                        <label class="btn btn-block bt-lg btn-danger"
                               for="bannedStatus">Новое</label>
                        <input id="bannedStatus" value="BANNED" type="radio" name="status"
                               <#if video.status == 'BANNED'>checked</#if>/>

                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-xs-2">
                <div class="form-group">
                    <label for="btn">&nbsp;</label>
                    <button type="submit" id="btn" class="btn btn-success btn-block">Применить</button>
                </div>
            </div>
        </div>
    </div>
    </@form.form>
</div>

<script>
    (function (d, p) {
        var a = new XMLHttpRequest(),
                b = d.body;
        a.open("GET", p, !0);
        a.send();
        a.onload = function () {
            var c = d.createElement("div");
            c.style.display = "none";
            c.innerHTML = a.responseText;
            b.insertBefore(c, b.childNodes[0])
        }
    })(document, "/resources/plyr/sprite.svg");
</script>
</#macro>
<@m_page title="Видео"
customScripts=["js/videoEdit.admin.js", "plyr/plyr.js"]
customStyles=["plyr/plyr.css"]
/>