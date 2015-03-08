select * from instagram_videos iv
    join videos v on v.id=iv.id
        where status=${status.value};