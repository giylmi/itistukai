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
            <a class="navbar-brand page-scroll" href="#page-top">
                <img src="/resources/img/sh_2.png" class="logo">
            </a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav navbar-right">
                <li class="hidden">
                    <a href="#page-top"></a>
                </li>
                <li>
                    <a class="page-scroll" href="${navHref("#tuqai", isLanding)}">Габдулла Тукай</a>
                </li>
                <li>
                    <a class="page-scroll" href="${navHref("#project", isLanding)}">О проекте</a>
                </li>
                <li>
                    <a class="page-scroll" href="${navHref("#rules", isLanding)}">Правила</a>
                </li>
                <li>
                    <a class="page-scroll" href="${navHref("#join", isLanding)}">Участие</a>
                </li>
                <li>
                    <a href="/composition">Галерея</a>
                </li>
            </ul>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
</nav>
</#macro>