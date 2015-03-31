<#-- @ftlvariable name="reply" type="net.itistukai.core.domain.core.UserReply"-->

<#list replies as reply>
<tr>
    <td>${reply.id}</td>
    <td>${reply.userName}</td>
    <td>${reply.userEmail}</td>
    <td>${reply.replyText}</td>
    <td>${reply.dateSent}</td>
    <td>${reply.replyType}</td>
</tr>
</#list>





<#if noData?? && noData>
<div id="js-disable-loadMore" style="display: none;"></div>
</#if>
