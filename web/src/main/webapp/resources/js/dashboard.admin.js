/**
 * Created by giylmi on 10.03.2015.
 */
Dashboard = {

    ajaxSuccess: function (data, onSuccess) {
        var $data = $(data);
        var $wrapper = $($data.find('.js-panel-dashboard-wrapper'));
        $wrapper.find('.panel-dashboard').each(function (index, element) {
            var tab = $(element).data('tab');
            $('.js-panel-dashboard-wrapper-data-tab-' + tab).html(element);
        });
        this.bindPanelDashboardClick();
        onSuccess($data.find('.js-main-content-wrapper'));
    },
    bindPanelDashboardClick: function () {
        var $dashboard = $('.panel-dashboard');
        $dashboard.unbind('click');
        $dashboard.on('click', function () {
            var $self = $(this);
            var tab = $self.data('tab');
            Dashboard.enableTab(tab, Dashboard.oldTab);
            Dashboard.oldTab = tab;
            history.pushState(null, null, jQuery.param.querystring(window.location.href, 'tab=' + tab));
        });
    },
    oldTab: '',
    enableTab: function(){}
};
