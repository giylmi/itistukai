<#include "../mainTemplate.ftl"/>
<#macro m_body>
<!-- Header -->
<header style="background-image: url(/resources/img/header-bg2.png)">
    <div class="container">
        <div class="intro-text">
            <!--<div class="intro-lead-in">проект</div>-->
            <div class="intro-heading">${composition.name}</div>
            <!--<a href="#services" class="page-scroll btn btn-xl">Узнать больше</a>-->
        </div>
    </div>
</header>

<!-- Services Section -->
<section id="tukai" class="not_mrg">
    <div class="container ">
        <div class="row">
            <div class="col-lg-12">
                <form class="row video_pan">
                    <div class="col-xs-12 col-lg-3 form-group">
                        <div class="input-group">
                            <input id="search" type="text" value="${(part.text)!}" class="form-control form-group js-part-autocomplete" placeholder="Поиск по фразе">
                            <a class="input-group-addon js-clear-part"><span aria-hidden="true">&times;</span></a>
                            <input type="hidden" value="${(part.id)!}" class="js-part-id"/>
                        </div>
                    </div>
                    <div class="col-xs-12 col-lg-3 form-group">
                        <select class="form-control form-group js-sort">
                            <option <#if sort?? && sort.value == "date_desc">selected</#if> value="date_desc"><@spring.message code="site.date_desc"/></option>
                            <option <#if sort?? && sort.value == "part.number_asc">selected</#if> value="part.number_asc"><@spring.message code="site.part.number_asc"/></option>
                        </select>
                    </div>
                    <div class="col-lg-2 hidden-xs">
                        <ul class="nav nav-pills">
                            <li class="js-view-type-selector-wrapper<#if viewType=="grid"> active</#if>" role="presentation"><a class="js-view-type-selector" href="#" data-type="grid"><@spring.message code="site.grid"/></a></li>
                            <li class="js-view-type-selector-wrapper<#if viewType=="feed"> active</#if>" role="presentation"><a class="js-view-type-selector" href="#" data-type="feed"><@spring.message code="site.feed"/></a></li>
                        </ul>
                    </div>
                    <div class="col-xs-12 col-lg-4">
                        <label class="repeat_show">
                            <input <#if hideRepeat!false>checked="checked"</#if> type="checkbox" name="hideRepeat" class=" js-hide-repeat">
                            <span class="repeat_label">Скрыть повторяющиеся фрагменты</span>
                        </label>
                    </div>
                </form>
                <div class="progress">
                    <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar"
                         aria-valuenow="${readParts}" aria-valuemin="0" aria-valuemax="${composition.parts?size}" style="width:${(readParts * 100 / composition.parts?size)?int}%">
                        <@spring.messageArgs code="site.read" args=[readParts, composition.parts?size]/>
                    </div>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="js-movie-player"></div>
        </div>
        <div class="row">
            <div class="js-gallery">

            </div>
            <div class="js-more-videos-holder"></div>
        </div>
    </div>

</section>
<script>
    (function(d,p){
        var a=new XMLHttpRequest(),
                b=d.body;
        a.open("GET",p,!0);
        a.send();
        a.onload=function(){
            var c=d.createElement("div");
            c.style.display="none";
            c.innerHTML=a.responseText;
            b.insertBefore(c,b.childNodes[0])
        }
    })(document,"/resources/plyr/sprite.svg");
</script>
</#macro>
<@m_page title="${composition.name}" customScripts=["js/composition.site.js", "js/movie-player.js", "plyr/plyr.js"] customStyles=["plyr/plyr.css"]/>