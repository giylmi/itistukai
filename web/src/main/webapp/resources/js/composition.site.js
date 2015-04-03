/**
 * Created by giylmi on 13.03.2015.
 */
$(document).ready(function () {

    var compositionId = JS_DATA['compositionId'];
    var cache = {};
    var $gallery = $('.js-gallery');
    var $partAutocomplete = $('.js-part-autocomplete');
    var $partId = $('.js-part-id');
    var $hideRepeat = $('.js-hide-repeat');

    var $sort = $('.js-sort');
    var $viewTypeWrapper = $('.js-view-type-selector-wrapper');

    var $selector = $viewTypeWrapper.filter('.active').find('.js-view-type-selector');

    var $moreVideosHolder = $('.js-more-videos-holder');

    bindSort();
    bindViewType();
    bindClearPart();
    bindLoadMoreBtn();
    bindVideoTextEvents();
    bindHideRepeatCheckEvent();

    enablePartAutocomplete();

    loadVideos(1);

    function setUrlParam(name, value){
        history.pushState(null, null, jQuery.param.querystring(window.location.href, name + '=' + value));
    }

    function bindHideRepeatCheckEvent(){
        $hideRepeat.on('click', function () {
            clearPart();
            setUrlParam('hideRepeat', $hideRepeat.prop('checked'));
            loadVideos(1);
        });
    }

    function clearPart() {
        $partAutocomplete.val('');
        $partId.val('');
        setUrlParam('partId', $partId.val());
    }

    function clearHideRepeat(){
        $hideRepeat.prop('checked', false);
        setUrlParam('hideRepeat', $hideRepeat.prop('checked'));
    }

    function bindClearPart() {
        $('.js-clear-part').on('click', function () {
            if ($partAutocomplete.val() == '') return;
            clearPart();
            loadVideos(1);
        });
    }


    function enablePartAutocomplete() {
        $partAutocomplete.autocomplete({
            minLength: 2,
            source: function (request, response) {
                var term = request.term;
                if (compositionId in cache && term in cache[compositionId]) {
                    response(cache[compositionId] [compositionId]);
                    return;
                }
                var data = {
                    query: request.term,
                    compositionId: compositionId
                };
                $.post("/autocomplete/parts", data, function (data, status, xhr) {
                    data = eval(data);
                    if (!(compositionId in cache)) cache[compositionId] = {};
                    cache[compositionId][term] = data;
                    response(data);
                });
            },
            select: function (event, ui) {
                clearHideRepeat();
                $partAutocomplete.val(ui.item.text);
                $partId.val(ui.item.id);
                setUrlParam('partId', $partId.val());
                loadVideos(1);
                return false;
            }
        }).autocomplete("instance")._renderItem = function (ul, item) {
            return $("<li>")
                .append("<a>" + item.text + "</a>")
                .appendTo(ul);
        };
    }

    function bindViewType() {
        $('.js-view-type-selector').on('click', function (e) {
            e.preventDefault();
            $selector = $(this);
            var $wrapper = $selector.parents('.js-view-type-selector-wrapper');
            if ($wrapper.hasClass('active')) return;
            $viewTypeWrapper.removeClass('active');
            $wrapper.addClass('active');
            var type = $selector.data('type');
            var $videos = $('.js-video-wrapper');
            if (type == 'grid') {
                $videos.removeClass('col-md-8 col-md-push-2 col-lg-8 col-lg-push-2');
                $videos.addClass('col-md-4 col-lg-4');
            } else {
                $videos.removeClass('col-md-4 col-lg-4');
                $videos.addClass('col-md-8 col-md-push-2 col-lg-8 col-lg-push-2');
            }
            setUrlParam('viewType', type);
        });
    }

    function bindSort() {
        $sort.on('change', function () {
            loadVideos(1);
            setUrlParam('sort', $sort.val());
        });
    }

    function bindLoadMoreBtn() {
        $('.js-more-videos-holder').on('click', '.js-more-videos', function () {
            var $this = $(this);
            var page = $this.data('page');
            $this.remove();
            loadVideos(page);
        });
    }

    function loadVideos(page) {
        var sort = $sort.val(),
            type = $selector.data('type'),
            partId = $partId.val(),
            hideRepeat = $hideRepeat.prop('checked');
        $.ajax({
            type: 'POST',
            data:   (page?('&page=' + page):'') +
                    (sort?('&sort=' + sort):'') +
                    (type?('&viewType=' + type):'') +
                    (partId?('&partId=' + partId):'') +
                    (hideRepeat?('&hideRepeat=' + hideRepeat):''),
            url: '/composition/videos',
            success: function (data) {
                if (page == 1) $gallery.html('');
                var $data = $(data);
                var jsMoreVideosBtn = $data.find('.js-more-videos');
                $moreVideosHolder.html(jsMoreVideosBtn?jsMoreVideosBtn:'');
                //$data.remove(jsMoreVideosBtn);
                $gallery.append($data.find('.js-video-wrapper'));
                //var userAgent = window.navigator.userAgent;
                //
                //if (userAgent.match(/iPad/i) || userAgent.match(/iPhone/i)) {
                //    iPad or iPhone
                    //$('.js-video-text').remove();
                //} else {
                    plyr.setup({});
                    bindVideoEvents();
                    //bindLoadMoreBtn();
                //}
            }
        });
    }

    function bindVideoTextEvents() {
        $('.js-gallery').on('click', '.js-video-text', function (e) {
            var $this = $(e.originalEvent.target);
            if (!$this.hasClass('js-is-link')) {
                var jsVideo = $this.parents('.js-video-wrapper').find('.js-video');
                if ($this.parents('.player').hasClass('playing'))
                    jsVideo.trigger('pause');
                else
                    jsVideo.trigger('play');
            }
        });
    }

    function bindVideoEvents(){
        var $videos = $('.player');
        $videos.each(function (i, e) {
            var media = e.plyr.media;
            var playListener = function (e) {
                $videos.each(function (i, e) {
                    var anotherMedia = e.plyr.media;
                    if (anotherMedia != media)
                        anotherMedia.pause();
                });
            };
            media.removeEventListener('play', playListener);
            media.addEventListener('play', playListener);
        });
    }
});