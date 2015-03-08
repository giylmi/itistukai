<#include "../functions/sql.ftl">
insert into instagram_videos
    (id, user_id, instagram_video_id, link)
    values
    (${video.id}, '${sql(video.instagramUser.id)}',
     '${sql(video.instagramId)}', '${sql(video.instagramUrl)}');