select * from instagram_videos iv
    join videos v on v.id=iv.id
        join instagram_users iu on iv.user_id=iu.user_id
            where status=${status.value};