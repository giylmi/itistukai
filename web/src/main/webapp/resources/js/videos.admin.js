/**
 * Created by giylmi on 03.03.2015.
 */
$(document).ready(function () {
    var grid = $('.js-grid');

    var enableTab = function (tab) {
        grid.html('');
        loadVideos(tab);
    };

    Dashboard.enableTab = enableTab;
    Dashboard.oldTab = window.JS_DATA['tab'] || '';
    Dashboard.bindPanelDashboardClick();

    enableTab(Dashboard.oldTab);

    bindLoadMoreBtn();

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

    function bindOnStatusChangeSubmit() {
        var $statusChangeBtns = $('.js-video-status-change');
        $statusChangeBtns.unbind('click');
        $statusChangeBtns.on('click', function (e) {
            e.preventDefault();
            var $this = $(this);
            $this.parent().prevAll('.js-status-value').val($this.data('status'));
            var $form = $($this.parents('.js-videos-status-form'));
            var $wrapper = $form.parents('.js-videos-status-form-wrapper');
            var $video = $form.parents('.js-video');
            $.ajax({
                type: 'POST',
                url: '/admin/videos/status',
                data: $form.serialize(),
                success: function (data) {
                    Dashboard.ajaxSuccess(data, function (data) {
                        $video.remove();
                        //$wrapper.html(data);
                        //bindOnStatusChangeSubmit();
                    });
                }
            });
        });
    }

    function bindLoadMoreBtn() {
        $('.js-more-videos').on('click', function () {
            var $this = $(this);
            var page = $this.data('page');
            $this.remove();
            loadVideos(Dashboard.oldTab, page);
        });
    }


});
