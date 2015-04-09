/**
 * Created by adel on 09.04.15.
 */
(function ($) {

    var videos = [];
    var $preloaderDiv, $videoDiv;

    $.fn.MoviePlayer = function (options) {
        var settings = $.extend({
            getVideosUrl: '/composition/videos/json',
            getVideosUrlType: 'POST',
            preloaderDivClass: 'js-movie-preloaders',
            videoDivClass: 'js-movie-video-wrapper'
        }, options);

        $videoDiv = $('<div class="' + settings.videoDivClass +'"></div>');
        $preloaderDiv =  $('<div class="' + settings.preloaderDivClass +'"></div>');
        this.append($videoDiv);
        this.append($preloaderDiv);

        $.ajax({
            type: settings.getVideosUrlType,
            url: settings.getVideosUrl,
            success: function (data) {
                videos = eval(data);
                afterVideosLoad();
            }
        });

        function afterVideosLoad() {
            $(videos).each(function (index, element){
                $preloaderDiv.append(
                    '<div><img src="' + element.preloaderUrl + '"></div>'
                );
            });
            $videoDiv.html(
                '<video poster="' + videos[0].preloaderUrl + '" controls="true">' +
                '<source src="' + videos[0].url + '" type="video/mp4">' +
                '</video>'
            );
        }
    };

}( jQuery ));