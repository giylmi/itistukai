<#include "videoStatus.ftl"/>
<#include "videosGrid.ftl"/>
<div>
    <div class="js-panel-dashboard-wrapper">
    <#include "videosDashboardUpdate.ftl"/>
    </div>
    <div class="js-main-content-wrapper">
        <@videosGrid videos=videos/>
    </div>
</div>