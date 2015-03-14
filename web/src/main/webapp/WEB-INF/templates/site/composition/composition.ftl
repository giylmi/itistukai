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
                    <div class="col-xs-12 col-lg-5 form-group">
                        <div class="input-group">
                            <input type="text" value="${(part.text)!}" class="form-control form-group js-part-autocomplete" placeholder="Поиск по фразе">
                            <a class="input-group-addon js-clear-part"><span aria-hidden="true">&times;</span></a>
                            <input type="hidden" value="${(part.id)!}" class="js-part-id"/>
                        </div>
                    </div>
                    <div class="col-xs-12 col-lg-4 form-group">
                        <select class="form-control form-group js-sort">
                            <option <#if sort?? && sort.value == "date_desc">selected</#if> value="date_desc">по дате добавления, сначала новые</option>
                            <option <#if sort?? && sort.value == "part.number_asc">selected</#if> value="part.number_asc">по порядку</option>
                        </select>
                    </div>
                    <div class="col-lg-3 hidden-xs">
                        <ul class="nav nav-pills">
                            <li class="js-view-type-selector-wrapper<#if viewType=="grid"> active</#if>" role="presentation"><a class="js-view-type-selector" href="#" data-type="grid">Сетка</a></li>
                            <li class="js-view-type-selector-wrapper<#if viewType=="feed"> active</#if>" role="presentation"><a class="js-view-type-selector" href="#" data-type="feed">Лента</a></li>
                        </ul>
                    </div>
                </form>
            </div>
        </div>
        <div class="row">
            <div class="js-gallery">

            </div>
        </div>
    </div>

</section>
</#macro>
<@m_page title="${composition.name}" customScripts=["js/composition.site.js", "plyr/plyr.js"] customStyles=["plyr/plyr.css"]/>