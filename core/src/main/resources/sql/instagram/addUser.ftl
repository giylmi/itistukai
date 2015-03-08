<#include "../functions/sql.ftl">
insert into instagram_users
    (
        user_id, username, profile_picture, full_name
    )
    values
    (
        ${user.id},
        '${sql(user.userName)}',
        '${sql(user.profilePicture)}',
        '${sql(user.fullName)}'
    );