/**
 * Created by giylmi on 11.03.2015.
 */
$(document).ready(function () {
    var cacheComposition = {};
    var cache = {};
    var $compositionId = $('.js-composition-id-value');
    var $partId = $('.js-part-id-value');
    var $compositionAutocomplete = $( ".js-composition-autocomplete" );
    var $partAutocomplete = $(".js-part-autocomplete");
    var $partText = $('.js-video-part-text-wrapper');

    enableCompositionAutocomplete();
    enablePartAutocomplete();

    function enableCompositionAutocomplete() {
        $compositionAutocomplete.autocomplete({
            minLength: 2,
            source: function (request, response) {
                var term = request.term;
                if (term in cacheComposition) {
                    response(cacheComposition[term]);
                    return;
                }

                $.post("/autocomplete/compositions", 'query=' + request.term, function (data, status, xhr) {
                    data = eval(data);
                    cache[term] = data;
                    response(data);
                });
            },
            select: function (event, ui) {
                $compositionId.val(ui.item.id);
                $compositionAutocomplete.val(ui.item.name);
                $partId.val('');
                $partAutocomplete.val('');
                $partText.html('Отрывок не выбран');
                return false;
            }
        }).autocomplete("instance")._renderItem = function (ul, item) {
            return $("<li>")
                .append("<a>" + item.name + "</a>")
                .appendTo(ul);
        };
    }

    function enablePartAutocomplete() {
        $partAutocomplete.autocomplete({
            minLength: 2,
            source: function (request, response) {
                var term = request.term;
                var compositionId = $compositionId.val();
                if (compositionId in cache && term in cache[$compositionId.val()]) {
                    response(cache[compositionId] [compositionId]);
                    return;
                }
                var data = {
                    query: request.term,
                    compositionId: $compositionId.val()
                };
                $.post("/autocomplete/parts", data, function (data, status, xhr) {
                    data = eval(data);
                    if (!(compositionId in cache)) cache[compositionId] = {};
                    cache[compositionId][term] = data;
                    response(data);
                });
            },
            select: function (event, ui) {
                $partId.val(ui.item.id);
                $partAutocomplete.val(ui.item.text);
                $compositionId.val(ui.item.composition.id);
                $compositionAutocomplete.val(ui.item.composition.name);
                $partText.html(ui.item.text);
                return false;
            }
        }).autocomplete("instance")._renderItem = function (ul, item) {
            return $("<li>")
                .append("<a>" + item.text + "</a>")
                .appendTo(ul);
        };
    }

});