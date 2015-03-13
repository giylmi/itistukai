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
        <#--<div class="row">-->
            <#--<div class="col-lg-12">-->
                <#--<form class="row video_pan">-->
                    <#--<div class="col-lg-5">-->
                        <#--<input type="text" class="form-control form-group" placeholder="Поиск по фразе">-->
                    <#--</div>-->
                    <#--<div class="col-lg-4">-->
                        <#--<select class="form-control form-group">-->
                            <#--<option>сортировка</option>-->
                            <#--<option>сортировка</option>-->
                            <#--<option>сортировка</option>-->
                        <#--</select>-->
                    <#--</div>-->
                    <#--<div class="col-lg-3">-->
                        <#--<ul class="nav nav-pills">-->
                            <#--<li role="presentation" class="active"><a href="#">Сетка</a></li>-->
                            <#--<li role="presentation"><a href="#">Лента</a></li>-->
                        <#--</ul>-->
                    <#--</div>-->
                <#--</form>-->
            <#--</div>-->



        <#--</div>-->
    <#--</div>-->
        <div class="row js-gallery">

        </div>
</section>
</#macro>
<@m_page title="${composition.name}" customScripts=["js/composition.site.js", "plyr/plyr.js"] customStyles=["plyr/plyr.css"]/>