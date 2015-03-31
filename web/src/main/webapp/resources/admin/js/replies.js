$(document).ready(function () {

    var $tbody = $('#js-reply-data');

    if($tbody){//shows that we have data to load
        loadData();
        $('#js-loadMore').on('click', loadData);
    }

});
function loadData(){
    var pageNumberHidden = $('#js-pageNum');
    var pageNum = parseInt(pageNumberHidden.val());
    var $tbody = $('#js-reply-data');

    $.ajax({
        url: "/admin/repliesMore",
        method: 'get',
        data: { "page": pageNum }
    }).success(function (data) {
        var lastItem = $tbody.find('tr:last-child');

        if(lastItem.length){
            lastItem.after(data);
        }else{
            $tbody.html(data);
        }

        if($('#js-disable-loadMore').length){//we should press button one more time to disable it/ idk why.
            $('#js-loadMore').prop('disabled', true);
        }

        pageNumberHidden.val(pageNum+1);
    }).error(function () {
        $('#js-reply-info').html('<div class="cols-xs-12"><p>Приносим свои извинения, но сервис пока недоступен</p></div>');
    });
}