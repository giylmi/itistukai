<#include "../functions.ftl"/>
<#include "usersTabContent.ftl"/>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]/>
<div>
    <div class="js-panel-dashboard-wrapper">
        <#include "usersDashboardUpdate.ftl"/>
    </div>
    <div class="js-main-content-wrapper">
        <@usersTabContent users=users/>
    </div>
</div>