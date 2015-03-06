insert into instagram_users
    (
        id, username, profile_picture, full_name
    )
    values
    (
        ${user.id},
        '${user.userName}',
        '${user.profilePicture}',
        '${user.fullName}'
    );