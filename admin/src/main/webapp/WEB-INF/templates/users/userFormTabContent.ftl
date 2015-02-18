<#include "../functions.ftl"/>
<#macro userFormTab active=false>
        <div class="col-md-6">
            <h3>Форма создания пользователя</h3>
            <form role="form" action="<@url value="/users/register"/>">
                <div class="row">
                    <div class="col-xs-4 col-sm-4 col-md-4">
                        <div class="form-group">
                            <input type="text" name="lastName" id="lastName" class="form-control" placeholder="Фамилия">
                        </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4">
                        <div class="form-group">
                            <input type="text" name="firstName" id="firstName" class="form-control" placeholder="Имя">
                        </div>
                    </div>
                    <div class="col-xs-4 col-sm-4 col-md-4">
                        <div class="form-group">
                            <input type="text" name="middleName" id="middleName" class="form-control" placeholder="Отчество">
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" name="login" id="login" class="form-control" placeholder="Логин">
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="email" name="email" id="email" class="form-control" placeholder="Email">
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <label for="role">
                         Выберите роль пользователя:
                    </label>
                    <select class="form-control" name="role" id="role" >
                        <option value="user">Пользователь</option>
                        <option value="admin">Администратор</option>
                    </select>
                </div>

                <div class="row">
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="password" name="password" id="password" class="form-control" placeholder="Пароль">
                        </div>
                    </div>
                    <div class="col-xs-6 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="password" name="password_confirmation" id="password_confirmation" class="form-control" placeholder="Повторите пароль">
                        </div>
                    </div>
                </div>

                <input type="submit" value="Создать" class="btn btn-primary btn-block">

            </form>
        </div>
</#macro>