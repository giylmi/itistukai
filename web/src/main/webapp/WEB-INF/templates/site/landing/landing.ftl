
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
                <p class="text_t">26 апреля исполнится 129 лет со дня рождения величайшего татарского поэта Габдуллы
                    Тукая.
                    Поэт, с тяжелой судьбой, сильным характером, и, безусловно, имевший великий талант писательского
                    дела.
                    Его стихотворения «И туган тел, и матур», «Авылым», поэмы «Идегэй», «Шурале», многочисленные сказки,
                    переводы, публицистические материалы золотой нитью проносятся по истории татарской литературы.
                    Ко дню рождения Габдуллы Тукая, мы бы хотели, чтобы одна из любимых читателями поэм «Шурале»
                    прозвучала
                    по всему миру. Ценители творчества Тукая и татарской литературы, любители «Шурале», и просто, те,
                    кто
                    хочет нас поддержать принимайте участие в нашем флешмобе “IT IS Tuqay”.</p>
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
                <p>“IT IS Tuqay” – проект Высшей школы ИТИС Казанского
                    Федерального Университета. Он создан с целью популяризации творчества великого татарского поэта
                    Габдуллы Тукая.</p>
                <p>
                    Проект представляет собой флешмоб, для участия в котором желающий должен опубликовать в <a href="http://instagram.com" target="_blank">Инстаграме</a>
                    видео, на котором он читает строчку из произведения Габдуллы Тукая. Все видео будут собираться в единую галерею - таким образом, шаг за шагом, мы получим полное произведение голосами и лицами участников.
                    А к дню рождения великого поэта будет представлен смонтированный фильм с наилучшими прочтениями отрывков.
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
                <h2 class="section-heading">Правила флешмоба</h2>

                <h3 class="section-subheading text-muted"></h3>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-6">
                <img src="/resources/img/shu3.png" class="img_t">
            </div>
            <div class="col-sm-6">
                <p class="text_t">Поэма «Шурале» - одна из самых колоритных произведений Тукая.
                    Именно, она

                    станет отправной точкой флешмоба.</p>
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
                <h2 class="section-heading">Принять участие</h2>

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
                <a href="/composition" class="btn btn-xl"> Галерея</a></div>
        </div>

    </div>
</section>
</#macro>
<@m_page title="Главная страница" isLanding=true/>