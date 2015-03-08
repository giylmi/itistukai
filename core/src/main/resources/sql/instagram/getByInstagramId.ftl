select * from
    (select * from instagram_videos where
        instagram_video_id = '${id}') as iv
    join videos v on v.id = iv.id
    join instagram_users iu on iv.user_id = iu.user_id;