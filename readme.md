##Настройки бд
находим database-local.properties.origin, перекладываем в файл без ориджина, делаем свои настройки.
##Настройки выгрузки видео
Видосы из инстаграма подгружаются через `InstagramDownloadJob`.
Чтобы не грузить постоянно(локально нам это не нужно), джоб активируется только при наличия спрингового профиля `uploadOn`.
Профиль можно проставить через VM options. Нужно добавить `-Dspring.profiles.active=uploadOn`
##добавление админа
выполняем через миграцию флайвеем. логин admin пароль admin_pa$$