/**
 * Created by giylmi on 03.03.2015.
 */
$(document).ready(function () {
    var activeTab = window.JS_DATA['tab'] || '';
    var grid = $('.js-grid');

    enableTab(activeTab);

    //function updateUsersTab() {
    //    var $tab = $('#usersTabContent');
    //    $.post('/admin/users/all', function (data) {
    //        $tab.html(data);
    //    });
    //}
    //
    //function updateAdminsTab() {
    //    var $tab = $('#adminsTabContent');
    //    $.post('/admin/users/admins', function (data) {
    //        $tab.html(data);
    //    });
    //}

    function enableTab(tab) {
        grid.html('');
        $.ajax({
            type: 'POST',
            data: 'status=' + tab.toUpperCase(),
            url: '/admin/videos/videos',
            success: function (data) {
                grid.html(data);
            }
        });
        history.pushState(null, null, jQuery.param.querystring(window.location.href, 'tab=' + activeTab));
    }

    $('.panel-dashboard').on('click', function () {
        var $self = $(this);
        var tab = $self.data('tab');
        enableTab(tab);
    });

});
