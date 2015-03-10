/**
 * Created by giylmi on 03.03.2015.
 */
$(document).ready(function () {
    var activeTab = window.JS_DATA['tab'] || '';
    var grid = $('.js-grid');

    Dashboard.bindPanelDashboardClick(enableTab);
    bindLoadMoreBtn();

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
    function loadVideos(tab, page) {
        $.ajax({
            type: 'POST',
            data: 'status=' + tab.toUpperCase() + (page?('&page=' + page):''),
            url: '/admin/videos/videos',
            success: function (data) {
                Dashboard.ajaxSuccess(data, function (data) {
                    grid.append(data);
                    bindOnStatusChangeSubmit();
                    bindLoadMoreBtn();
                });
            }
        });
    }

    function enableTab(tab) {
        grid.html('');
        loadVideos(tab);
        history.pushState(null, null, jQuery.param.querystring(window.location.href, 'tab=' + activeTab));
    }

    function bindOnStatusChangeSubmit() {
        var $statusChangeBtns = $('.js-video-status-change');
        $statusChangeBtns.unbind('click');
        $statusChangeBtns.on('click', function (e) {
            e.preventDefault();
            var $this = $(this);
            $this.parent().prev('.js-status-value').val($this.data('status'));
            var $form = $($this.parents('.js-videos-status-form'));
            var $wrapper = $form.parents('.js-videos-status-form-wrapper');
            $.ajax({
                type: 'POST',
                url: '/admin/videos/status',
                data: $form.serialize(),
                success: function (data) {
                    Dashboard.ajaxSuccess(data, function (data) {
                        $wrapper.html(data);
                        bindOnStatusChangeSubmit();
                    })
                }
            });
        });
    }

    function bindLoadMoreBtn() {
        $('.js-more-videos').on('click', function () {
            var $this = $(this);
            var page = $this.data('page');
            $this.remove();
            loadVideos(activeTab, page);
        });
    }


});
