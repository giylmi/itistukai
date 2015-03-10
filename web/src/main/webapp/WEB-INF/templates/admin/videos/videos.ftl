<#include "../mainTemplate.ftl"/>
<#include "../functions.ftl"/>
<#macro m_body>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Видео
        </h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
    <div class="col-lg-3 col-md-6  js-panel-dashboard-wrapper-data-tab-new">
        <div class="panel panel-dashboard panel-primary" data-tab="new">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="fa fa-users fa-5x"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div class="huge">${newVideos!0}</div>
                        <div>новых видео</div>
                    </div>
                </div>
            </div>
            <a href="#">
                <div class="panel-footer">
                    <span class="pull-left">Подробнее</span>
                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                    <div class="clearfix"></div>
                </div>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-6  js-panel-dashboard-wrapper-data-tab-viewed">
        <div class="panel panel-dashboard panel-red" data-tab="viewed">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="fa fa-users fa-5x"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div class="huge">${viewedVideos!0}</div>
                        <div>просмотренных видео</div>
                    </div>
                </div>
            </div>
            <a href="#">
                <div class="panel-footer">
                    <span class="pull-left">Подробнее</span>
                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                    <div class="clearfix"></div>
                </div>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-6  js-panel-dashboard-wrapper-data-tab-ok">
        <div class="panel panel-dashboard panel-yellow" data-tab="ok">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="fa fa-user fa-5x"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div class="huge">${acceptedVideos!0}</div>
                        <div>принятых произведений</div>
                    </div>
                </div>
            </div>
            <a href="#">
                <div class="panel-footer">
                    <span class="pull-left">Подробнее</span>
                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                    <div class="clearfix"></div>
                </div>
            </a>
        </div>
    </div>
    <div class="col-lg-3 col-md-6  js-panel-dashboard-wrapper-data-tab-banned">
        <div class="panel panel-dashboard panel-yellow" data-tab="banned">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="fa fa-user fa-5x"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div class="huge">${bannedVideos!0}</div>
                        <div>отвергнутых видео</div>
                    </div>
                </div>
            </div>
            <a href="#">
                <div class="panel-footer">
                    <span class="pull-left">Подробнее</span>
                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                    <div class="clearfix"></div>
                </div>
            </a>
        </div>
    </div>
</div>
<div class="row">
    <div class="js-grid">
    </div>
</div>
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
<@m_page title="Видео"
    customScripts=["js/videos.admin.js", "plyr/plyr.js"]
    customStyles=["plyr/plyr.css"]
/>