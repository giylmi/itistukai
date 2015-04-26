<#include "../mainTemplate.ftl"/>
<#macro m_body>
<!-- Header -->
<header>
    <div class="container">
        <div class="intro-text">
            <!--<div class="intro-lead-in">проект</div>-->
            <div class="col-md-6 col-xs-12">
                <div class="intro-heading">IT IS Tuqay</div>
                <a href="#tuqai" class="page-scroll btn btn-xl"><@spring.message code="site.knowmore"/></a>
            </div>
            <div class="col-md-6 col-xs-12">
                <iframe width="560" height="315" src="https://www.youtube.com/embed/zX2eMyRE9pY" frameborder="0"
                        allowfullscreen=""></iframe>
            </div>
        </div>
    </div>
</header>

<!-- Services Section -->
<section id="tuqai">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading"><@spring.message code="site.gabdulla.tukay"/></h2>

                <h3 class="section-subheading text-muted"><@spring.message code="site.tukaiinfo"/></h3>
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
                    <@spring.message code="site.flashmobinfo"/>
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
                    <li><@spring.message code="site.rule1"/></li>
                    <li><@spring.message code="site.rule2"/></li>
                    <li><@spring.message code="site.rule3"/></li>
                    <li><@spring.message code="site.rule4"/></li>
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
                    <li><@spring.message code="site.joinrule1"/></li>
                    <li><@spring.messageArgs code="site.joinrule2" args=[(randomPart.id)!]/></li>
                    <li><@spring.message code="site.joinrule3"/></li>
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
<section id="team">
    <div class="container">
        <div class="row">
            <div class="col-lg-12 text-center">
                <h2 class="section-heading"><@spring.message code="site.team"/></h2>
            </div>
        </div>
        <div class="row">
        <#--col-sm-4 col-sm-push-2-->
            <div class="col-xs-12 col-sm-3 col-sm-push-3">
                <div class="team-member">
                    <div style="background-image: url('/resources/img/team/da.jpg')"
                         class="center-block img-responsive img-circle photo_block">
                    </div>

                    <h4><@spring.message code="site.team.da"/></h4>

                    <p class="text-muted"><@spring.message code="site.team.da.reg"/></p>
                </div>
            </div>
            <div class="col-xs-12 col-sm-3 col-sm-push-3">
                <div class="team-member">
                    <div style="background-image: url('/resources/img/team/ag.jpg')"
                         class="center-block img-responsive img-circle photo_block">
                    </div>

                    <h4><@spring.message code="site.team.ag"/></h4>
                </div>
            </div>

        </div>
        <div class="row">
            <div class="col-xs-12 col-sm-3 col-sm-push-1">
                <div class="team-member">
                    <div style="background-image: url('/resources/img/team/am.jpg')"
                         class="center-block img-responsive img-circle photo_block">
                    </div>

                    <h4><@spring.message code="site.team.am"/></h4>
                </div>
            </div>
            <div class="col-xs-12 col-sm-3 col-sm-push-2">
                <div class="team-member">
                    <div style="background-image: url('/resources/img/team/rs.jpg')"
                         class="center-block img-responsive img-circle photo_block">
                    </div>
                    <h4><@spring.message code="site.team.rs"/></h4>
                </div>
            </div>
            <div class="col-xs-12 col-sm-3 col-sm-push-3">
                <div class="team-member ">
                    <div style="background-image: url('/resources/img/team/pb.jpg')"
                         class="center-block img-responsive img-circle photo_block">
                    </div>

                    <h4><@spring.message code="site.team.pb"/></h4>
                </div>
            </div>
        </div>
    </div>
</section>
</#macro>
<#assign title><@spring.message code="site.landing"/></#assign>
<@m_page title=title isLanding=true/>