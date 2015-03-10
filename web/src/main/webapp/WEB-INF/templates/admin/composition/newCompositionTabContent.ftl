<#include "../functions.ftl"/>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]/>
<div class="col-md-6 panel panel-default panel-body" xmlns="http://www.w3.org/1999/html">
<#if created!false>
    <div class="alert alert-success">Произведение успешно создано</div>
</#if>
    <h3>Форма создания произведения</h3>

<@form.form modelAttribute="compositionForm" method='post' action="/admin/compositions/upload" enctype="multipart/form-data">
        <div class="form-group">
            <input type="text" name="name" id="name" value="${compositionForm.name!}" class="form-control" placeholder="Название">
            <@form.errors path="name" cssClass="text-danger"/>
        </div>

    <div class="row">
        <div class="col-md-6">
            <div class="form-group">
                <input type="file" name="file" id="file" class="form-control" >
                <@form.errors path="file" cssClass="text-danger"/>
            </div>
        </div>
    </div>

    <input id="createCompositionBtn" type="submit" data-loading="Создаем..." value="Создать" class="btn btn-primary btn-block">

</@form.form>
</div>