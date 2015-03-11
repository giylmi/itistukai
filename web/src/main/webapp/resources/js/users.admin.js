/**
 * Created by adel on 18.02.15.
 */
$(document).ready(function () {
    var enableTab = function(tab, oldTab) {
        $('#' + oldTab + 'TabContent').hide();
        switch (tab) {
            case 'users': updateUsersTab(); break;
            case 'admins': updateAdminsTab(); break;
        }
        $('#' + tab + 'TabContent').show();
    };

    Dashboard.oldTab = window.JS_DATA['tab'];
    Dashboard.enableTab = enableTab;
    Dashboard.bindPanelDashboardClick();

    enableTab(Dashboard.oldTab);

    bindCreateUserBtn();

    function updateUsersTab() {
        var $tab = $('#usersTabContent');
        $.post('/admin/users/all', function (data) {
            Dashboard.ajaxSuccess(data, function(data){$tab.html(data);});
        });
    }

    function updateAdminsTab() {
        var $tab = $('#adminsTabContent');
        $.post('/admin/users/admins', function (data) {
            Dashboard.ajaxSuccess(data, function(data){$tab.html(data);});
        });
    }

    function bindCreateUserBtn() {
        $('#createUserBtn').on('click', function () {
            var $form = $(this).parent();
            var $tab = $('#userFormTabContent');
            $.post('/admin/users/register', $form.serialize(), function (data) {
                Dashboard.ajaxSuccess(data, function (data) {
                    $tab.html(data);
                    bindCreateUserBtn();
                })
            });
        });
    }

});
