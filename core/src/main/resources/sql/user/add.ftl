<#include "../functions/sql.ftl">
INSERT INTO users (login, password, salt, email, role)
    values ('${sql(login)}', '${sql(password)}', '${sql(salt)}', '${sql(email)}', '${sql(role)}');