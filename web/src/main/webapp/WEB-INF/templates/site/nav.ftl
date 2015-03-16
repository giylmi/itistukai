<#import "/spring.ftl" as spring/>
<#function navHref href isLanding>
    <#if !isLanding>
        <#return "/" + href/>
    <#else>
        <#return href/>
    </#if>
</#function>
<#macro navigation isLanding>
<!-- Navigation -->
<nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header page-scroll">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand page-scroll" href="${navHref("#page-top", isLanding)}">
                <img src="/resources/img/sh_2.png" class="logo">
            </a>
            <a href="?lang=ru"><img width="30" height="20" src="/resources/img/Russia_Flag-icon.png"></a>
            <a href="?lang=en"><img width="30" height="20" src="/resources/img/english_flag.png"></a>
            <a href="?lang=tat"><img width="30" height="20" src="/resources/img/tat_flag.png"></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="hidden">
                    <a href="${navHref("#page-top", isLanding)}"></a>
                </li>
                <li>
                    <a class="page-scroll" href="${navHref("#tuqai", isLanding)}"><@spring.message code="site.gabdulla.tukay"/></a>
                </li>
                <li>
                    <a class="page-scroll" href="${navHref("#project", isLanding)}"><@spring.message code="site.about"/></a>
                </li>
                <li>
                    <a class="page-scroll" href="${navHref("#rules", isLanding)}"><@spring.message code="site.rules"/></a>
                </li>
                <li>
                    <a class="page-scroll" href="${navHref("#join", isLanding)}"><@spring.message code="site.join"/></a>
                </li>
                <#--<li>-->
                    <#--<a class="page-scroll" href="${navHref("#team", isLanding)}"><@spring.message code="site.team"/></a>-->
                <#--</li>-->
                <li>
                    <a href="/composition"><@spring.message code="site.gallery"/></a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
</#macro>