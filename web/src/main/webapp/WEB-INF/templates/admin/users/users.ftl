<#include "userFormTabContent.ftl"/>
<#include "../mainTemplate.ftl"/>
<#include "../functions.ftl"/>
<#macro m_body>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">
            Пользователи
        </h1>
    </div>
    <!-- /.col-lg-12 -->
</div>
<div class="row">
    <div class="col-lg-3 col-md-6 js-panel-dashboard-wrapper-data-tab-users">
        <div class="panel panel-dashboard panel-primary" data-tab="users">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="fa fa-users fa-5x"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div class="huge">${usersTotal!0}</div>
                        <div>пользователей</div>
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
    <div class="col-lg-3 col-md-6 js-panel-dashboard-wrapper-data-tab-admins">
        <div class="panel panel-dashboard panel-red" data-tab="admins">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="fa fa-users fa-5x"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div class="huge">${adminsTotal!0}</div>
                        <div>администраторов</div>
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
    <div class="col-lg-3 col-md-6 js-panel-dashboard-wrapper-data-tab-userForm">
        <div class="panel panel-dashboard panel-yellow" data-tab="userForm">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-xs-3">
                        <i class="fa fa-user fa-5x"></i>
                    </div>
                    <div class="col-xs-9 text-right">
                        <div class="huge">Создать</div>
                        <div>пользователя</div>
                    </div>
                </div>
            </div>
            <a href="#">
                <div class="panel-footer">
                    <span class="pull-left">Открыть форму</span>
                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                    <div class="clearfix"></div>
                </div>
            </a>
        </div>
    </div>
<#--<div class="col-lg-3 col-md-6">-->
<#--<div class="panel panel-dashboard panel-info">-->
<#--<div class="panel-heading">-->

<#--<div class="row">-->
<#--<div class="col-xs-3">-->
<#--<i class="fa fa-support fa-5x"></i>-->
<#--</div>-->
<#--<div class="col-xs-9 text-right">-->
<#--<div class="huge">Создать</div>-->
<#--<div>администратора</div>-->
<#--</div>-->
<#--</div>-->
<#--</div>-->
<#--<a href="#">-->
<#--<div class="panel-footer">-->
<#--<span class="pull-left">Открыть форму</span>-->
<#--<span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>-->
<#--<div class="clearfix"></div>-->
<#--</div>-->
<#--</a>-->
<#--</div>-->
<#--</div>-->
</div>

<div class="row">
    <div id="userFormTabContent" hidden="hidden">
        <@userFormTabContent created=created userForm=userForm/>
    </div>
    <div id="usersTabContent" hidden="hidden">
        <#--<#include "users/usersTabContent.ftl"/>-->
    </div>
    <div id="adminsTabContent" hidden="hidden">
        <#--<#include "users/userFormTabContent.ftl"/>-->
    </div>
</div>
<!-- /.row -->
<#--<div class="row">-->
    <#--<#list users as user>-->
        <#--<div class="list-group-item">${user.pi}</div>-->
    <#--</#list>-->
<#--</div>-->
</#macro>
<@m_page title="Пользователи"
    customScripts=["js/users.admin.js"]
    customStyles=["css/users.css"]
/>