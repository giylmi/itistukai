select * from
    (select id, url, status, date from videos where
        id = '${id}') as video
    join instagram_videos iv using id
    join instagram_users iu on iv.user_id = iu.user_id;