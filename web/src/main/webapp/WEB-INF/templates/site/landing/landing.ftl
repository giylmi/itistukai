
<#include "../mainTemplate.ftl"/>
<#macro m_body>
<!-- Header -->
<header>
    <div class="container">
        <div class="intro-text">
            <!--<div class="intro-lead-in">проект</div>-->
            <div class="intro-heading">IT IS Tuqay</div>
            <a href="#tuqai" class="page-scroll btn btn-xl"><@spring.message code="site.knowmore"/></a>
        </div>
    </div>
</header>

<!-- Services Section -->
<section id="tuqai">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading"><@spring.message code="site.gabdulla.tukay"/></h2>

                <h3 class="section-subheading text-muted">Татарский народный поэт, литературный критик, публицист,
                    общественный деятель и переводчик.</h3>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <img src="/resources/img/imgB.jpg" class="img_t">
            </div>
            <div class="col-sm-6">
                <p class="text_t"><@spring.message code="site.abouttukai"/></p>
            </div>
        </div>
    </div>
</section>


<!-- About Section -->
<section id="project" class="bg-light-gray">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading">IT IS Tuqay</h2>

                <h3 class="section-subheading text-muted">
                </h3>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <p><@spring.message code="site.itistuqaiinfo"/></p>
                <p>
                    Проект представляет собой флешмоб, для участия в котором желающий должен опубликовать в <a href="http://instagram.com" target="_blank">Инстаграме</a> видео, на котором он читает строчку из произведения Габдуллы Тукая. Все видео будут собираться в единую галерею - таким образом, шаг за шагом, мы получим полное произведение голосами и лицами участников. А к дню рождения великого поэта будет представлен смонтированный фильм с наилучшими прочтениями отрывков.
                </p>
            </div>
            <div class="col-sm-6">
                <img src="/resources/img/sh_2.png" class="logo_in">
            </div>
        </div>
    </div>
</section>

<!-- Team Section -->
<section id="rules">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading"><@spring.message code="site.flashmobrules"/></h2>

                <h3 class="section-subheading text-muted"></h3>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <img src="/resources/img/shu3.png" class="img_t">
            </div>
            <div class="col-sm-6">
                <p class="text_t"><@spring.message code="site.shurale"/></p>
                <ol>
                    <li>Запишите видео с прочтением части произведения. Свою часть можно получить <a class="page-scroll" href="#join">тут</a></li>
                    <li>Опубликуйте видео в <a href="http://instagram.com" target="_blank">Инстаграме</a>  c хэштегами проекта и части произведения</li>
                    <li>Пригласите своих друзей так же поучаствовать во флешмобе</li>
                    <li>Посмотреть галерею опубликованных видео Вы можете <a href="/composition" target="_blank">здесь</a></li>
                </ol>
            </div>

        </div>

    </div>
</section>
<section id="join" class="bg-light-gray">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading"><@spring.message code="site.flashmobjoin"/></h2>

                <h3 class="section-subheading text-muted"></h3>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <p class="text-center">
                    <ol>
                        <li>Запишите видео с прочтением части произведения.</li>
                        <li>Опубликуйте видео в <a href="http://instagram.com" target="_blank">Инстаграме</a>  c хэштегами #itistuqai и #part${(randomPart.id)!}</li>
                    </ol>
                </p>
            </div>
            <div class="col-sm-12">
                <p class="text-center text_p">
                    ${(randomPart.htmlText())!}
                </p>
            </div>
            <div class="text-center">
                <a href="/composition" class="btn btn-xl"> <@spring.message code="site.gallery"/></a></div>
        </div>

    </div>
</section>
</#macro>
<#assign title><@spring.message code="site.landing"/></#assign>
<@m_page title=title isLanding=true/>