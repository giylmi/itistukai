/**
 * Created by adel on 18.02.15.
 */
$(document).ready(function () {
    var activeTab = window.JS_DATA['tab'];

    enableTab(activeTab);

    function updateUsersTab() {
        var $tab = $('#usersTabContent');
        $.post('/admin/users/all', function (data) {
            $tab.html(data);
        });
    }

    function updateAdminsTab() {
        var $tab = $('#adminsTabContent');
        $.post('/admin/users/admins', function (data) {
            $tab.html(data);
        });
    }

    function enableTab(tab) {
        $('#' + activeTab + 'TabContent').hide();
        activeTab = tab;
        switch (activeTab) {
            case 'users': updateUsersTab(); break;
            case 'admins': updateAdminsTab(); break;
        }
        $('#' + activeTab + 'TabContent').show();


        history.pushState(null, null, jQuery.param.querystring(window.location.href, 'tab=' + activeTab));
    }

    $('.panel-dashboard').on('click', function () {
        var $self = $(this);
        var tab = $self.data('tab');
        enableTab(tab);
    });

    function bindCreateUserBtn() {
        $('#createUserBtn').on('click', function () {
            var $form = $(this).parent();
            var $tab = $('#userFormTabContent');
            $.post('/admin/users/register', $form.serialize(), function (data) {
                $tab.html(data);
                bindCreateUserBtn();
            });
        });
    }

    bindCreateUserBtn();
});
