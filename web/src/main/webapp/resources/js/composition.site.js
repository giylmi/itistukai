/**
 * Created by giylmi on 13.03.2015.
 */
$(document).ready(function () {
    var $gallery = $('.js-gallery');

    loadVideos(1);

    function bindLoadMoreBtn() {
        $('.js-more-videos').on('click', function () {
            var $this = $(this);
            var page = $this.data('page');
            $this.remove();
            loadVideos(page);
        });
    }

    function loadVideos(page) {
        $.ajax({
            type: 'POST',
            data: (page?('&page=' + page):''),
            url: '/composition/videos',
            success: function (data) {
                $gallery.append(data);
                bindLoadMoreBtn();
            }
        });
    }
});