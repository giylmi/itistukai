/**
 * Created by giylmi on 13.03.2015.
 */
$(document).ready(function () {
    var compositionId = JS_DATA['compositionId'];
    var cache = {};
    var $gallery = $('.js-gallery');
    var $partAutocomplete = $('.js-part-autocomplete');
    var $partId = $('.js-part-id');

    var $sort = $('.js-sort');
    var $viewTypeWrapper = $('.js-view-type-selector-wrapper');

    var $selector = $viewTypeWrapper.filter('.active').find('.js-view-type-selector');
    bindSort();
    bindViewType();
    bindClearPart();

    enablePartAutocomplete();


    loadVideos(1, $sort.val(), $selector.data('type'), $partId.val());
    function bindClearPart() {
        $('.js-clear-part').on('click', function () {
            if ($partAutocomplete.val() == '') return;
            $partAutocomplete.val('');
            $partId.val('');
            history.pushState(null, null, jQuery.param.querystring(window.location.href, 'partId=' + $partId.val()));
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
                $partAutocomplete.val(ui.item.text);
                $partId.val(ui.item.id);
                history.pushState(null, null, jQuery.param.querystring(window.location.href, 'partId=' + $partId.val()));
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
            loadVideos(1);
            history.pushState(null, null, jQuery.param.querystring(window.location.href, 'viewType=' + type));
        });
    }

    function bindSort() {
        $sort.on('change', function () {
            loadVideos(1);
            history.pushState(null, null, jQuery.param.querystring(window.location.href, 'sort=' + $sort.val()));
        });
    }

    function bindLoadMoreBtn() {
        $('.js-more-videos').on('click', function () {
            var $this = $(this);
            var page = $this.data('page');
            $this.remove();
            loadVideos(page);
        });
    }

    function loadVideos(page) {
        var sort = $sort.val(),
            type = $selector.data('type'),
            partId = $partId.val();
        $.ajax({
            type: 'POST',
            data:   (page?('&page=' + page):'') +
                    (sort?('&sort=' + sort):'') +
                    (type?('&viewType=' + type):'') +
                    (partId?('&partId=' + partId):''),
            url: '/composition/videos',
            success: function (data) {
                if (page == 1) $gallery.html('');
                $gallery.append(data);
                bindLoadMoreBtn();
            }
        });
    }
});