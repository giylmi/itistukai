<#include "userFormTabContent.ftl"/>
<div>
    <div class="js-panel-dashboard-wrapper">
        <#include "usersDashboardUpdate.ftl"/>
    </div>
    <div class="js-main-content-wrapper">
        <@userFormTabContent created=created userForm=userForm/>
    </div>
</div>