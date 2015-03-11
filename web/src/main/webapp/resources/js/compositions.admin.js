/**
 * Created by giylmi on 03.03.2015.
 */
$(document).ready(function () {
    var enableTab = function(tab, oldTab) {
        $('.js-composition-' + oldTab + '-tab-content').hide();
        $('.js-composition-' + tab + '-tab-content').show();
    };
    Dashboard.oldTab = window.JS_DATA['tab'] || '';
    Dashboard.enableTab = enableTab;
    Dashboard.bindPanelDashboardClick();

    enableTab(Dashboard.oldTab);

});
