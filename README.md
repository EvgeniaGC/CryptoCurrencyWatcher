Description:
---
- Просмотр списка доступных криптовалют (REST-метод)
- Просмотр актуальной цены для указаной криптовалюты 
(REST-метод - код валюты передается пользователем)
- Запасать в лог сообщение о изменении цены более чем на 1%. 
Для это пользователь регестрирует себя с помощью REST-метода notify 
и передает свое имя(username) и код криптовалюты(symbol). 
В момент регистрации cохраняется текущая цена указаной криптовалюты 
с привязкой к пользоватлю. Как только актуальная цена для указаной 
валюты поменялась более чем на 1%., в лог сервера выводится сообщение 
уровня WARN в котором указан: код валюты, имя пользователя 
и процент изменения цены с момента регистрации.

Enter: 
---
URL database:
``` 
https://www.phpmyadmin.co/index.php
```
Server:
```
sql11.freesqldatabase.com
```
Username:
```
sql11506112
```
Password:
```
35G8yFiqRW
```