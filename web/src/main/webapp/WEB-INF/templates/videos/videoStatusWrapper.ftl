<#include "videoStatus.ftl"/>
<div>
    <div class="js-panel-dashboard-wrapper">
    <#include "videosDashboardUpdate.ftl"/>
    </div>
    <div class="js-main-content-wrapper">
        <@videoStatus video=video/>
    </div>
</div>