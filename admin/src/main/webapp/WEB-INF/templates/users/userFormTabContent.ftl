<#include "../functions.ftl"/>
<#assign form=JspTaglibs["http://www.springframework.org/tags/form"]/>
<div class="col-md-6 panel panel-default panel-body" xmlns="http://www.w3.org/1999/html">
            <#if created!false>
                <div class="alert alert-success">Пользователь успешно создан</div>
            </#if>
            <h3>Форма создания пользователя</h3>

            <@form.form modelAttribute="userForm">
                <div class="row">
                    <div class="col-xs-4 col-sm-4 col-md-4">
                        <div class="form-group">
                            <input type="text" name="lastName" id="lastName" value="${userForm.lastName!}" class="form-control" placeholder="Фамилия">
                            <@form.errors path="lastName" cssClass="text-danger"/>
                        </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4">
                        <div class="form-group">
                            <input type="text" name="firstName" id="firstName" value="${userForm.firstName!}" class="form-control" placeholder="Имя">
                            <@form.errors path="firstName" cssClass="text-danger"/>
                        </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4">
                        <div class="form-group">
                            <input type="text" name="middleName" id="middleName" value="${userForm.middleName!}" class="form-control" placeholder="Отчество">
                            <@form.errors path="middleName" cssClass="text-danger"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" name="login" id="login" value="${userForm.login!}" class="form-control" placeholder="Логин">
                            <@form.errors path="login" cssClass="text-danger"/>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="email" name="email" id="email" value="${userForm.email!}" class="form-control" placeholder="Email">
                            <@form.errors path="email" cssClass="text-danger"/>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="role">
                         Выберите роль пользователя:
                    </label>
                    <select class="form-control" name="role" id="role">
                        <option value="USER" <#if userForm.role?? && userForm.role == "USER">selected="selected" </#if>>Пользователь</option>
                        <option value="ADMIN" <#if userForm.role?? && userForm.role == "ADMIN">selected="selected" </#if>>Администратор</option>
                    </select>
                    <@form.errors path="role" cssClass="text-danger"/>
                </div>

                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="password" name="password" id="password" value="${userForm.password!}" class="form-control" placeholder="Пароль">
                            <@form.errors path="password" cssClass="text-danger"/>
                        </div>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="password" name="repeatPassword" id="password_confirmation" value="${userForm.repeatPassword!}" class="form-control" placeholder="Повторите пароль">
                            <@form.errors path="repeatPassword" cssClass="text-danger"/>
                        </div>
                    </div>
                </div>

                <input id="createUserBtn" type="button" data-loading="Создаем..." value="Создать" class="btn btn-primary btn-block">

            </@form.form>
        </div>