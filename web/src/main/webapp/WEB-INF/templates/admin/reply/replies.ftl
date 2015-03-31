<#include "../mainTemplate.ftl"/>
<#macro m_body>
<div class="row">
    <div class="col-xs-6">
        <h1>Таблица всех присланных фидбеков</h1>
    </div>
</div>
<div class="row" id="js-reply-info">
    <#if noData?? && noData>
        <div class="col-xs-6">
            <#include "replyErrorMessage.ftl">
        </div>
    <#else>
        <div class="col-xs-12">
            <table class="table table-striped table-bordered">
                <thead>
                <tr>
                    <td>blah</td>
                    <td>blah</td>
                    <td>blha</td>
                    <td>blah</td>
                    <td>blah</td>
                    <td>blah</td>
                </tr>
                </thead>
                <tbody id="js-reply-data">
                </tbody>
            </table>
            <input id="js-pageNum" value="0" type="hidden"/>
            <button type="button" class="btn btn-lg btn-default" id="js-loadMore">Load More</button>
        </div>
    </#if>

</div>
</#macro>

<@m_page title="Replies"
customScripts=[
"admin/js/replies.js"
]
customStyles=[
]
/>