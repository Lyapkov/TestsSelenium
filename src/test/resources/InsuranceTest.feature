#language: ru
Функционал: Страхование


  Сценарий: Заявка на Страхование путешественников

  Когда выбран пункт меню "Страхование"
  И выбрана категория страхования "Все страховые программы"
  И выбран вид страхования Страхование путешественников
  И выполнено нажати на кнопку Оформить онлайн
  И выполнено нажати на кнопку Оформить

  Тогда заголовок страницы - Страхование путешественников "Страхование путешественников"

  Когда заполняются поля:
  |Фамилия застрахованного|Иванов|
  |Имя застрахованного|Иван|
  |Дата рождения застрахованного|01.01.2000|
  |Фамилия|Иванов|
  |Имя|Иван|
  |Отчество|Иванович|
  |Дата рождения|11.02.1980|
  |Серия|1111|
  |Номер|010120|
  |Дата выдачи|20.02.2000|
  |Кем выдан|МРО|

  Тогда значения полей равны:
  |Фамилия застрахованного|Иванов|
  |Имя застрахованного|Иван|
  |Дата рождения застрахованного|01.01.2000|
  |Фамилия|Иванов|
  |Имя|Иван|
  |Отчество|Иванович|
  |Дата рождения|11.02.1980|
  |Серия|1111|
  |Номер|010120|
  |Дата выдачи|20.02.2000|
  |Кем выдан|МРО|

  Когда выполнено нажати на кнопку Продолжить

  И в поле "AlertMobile" присутствует сообщение об ошибке "Поле не заполнено."
  И в поле "AlertMail" присутствует сообщение об ошибке "Поле не заполнено."
  И в поле "AlertMailRepeated" присутствует сообщение об ошибке "Поле не заполнено."
  И в поле "AlertForm" присутствует сообщение об ошибке "При заполнении данных произошла ошибка"