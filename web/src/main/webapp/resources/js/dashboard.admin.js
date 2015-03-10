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
        this.bindPanelDashboardClick(this.enableTab);
        onSuccess($data.find('.js-main-content-wrapper'));
    },
    bindPanelDashboardClick: function (enableTab) {
        this.enableTab = enableTab;
        $('.panel-dashboard').on('click', function () {
            var $self = $(this);
            var tab = $self.data('tab');
            enableTab(tab);
        });
    }
};
