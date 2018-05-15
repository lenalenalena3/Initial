#language: ru
Функционал: сценарий создания нового актива типа "Денежные средства" для ФО типа КО

  Предыстория:
    Дано открыт браузер и осуществлен переход по ссылке
    И открывается страница с формой "Вход в систему"
    Когда пользователь заполняет поле "Имя пользователя" значением "sua_all"
    И пользователь вводит в поле "Пароль" значением "Q1w2e3r4"
    И пользователь нажимает кнопку "Войти"
    Тогда открывается модальное окно "Выбор финансовой организации"
    Тогда пользователь выбирает финансовую организацию "10" типа КО
    И пользователь нажимает кнопку "Выбрать"
    Тогда открывается страница с логотипом "Агентство по страхованию вкладов"
    Тогда открывается страница с финансовой организацией "10"
    И пользователь нажимает кнопку с выпадающим списком "Настройка"
    И пользователь выбирает пункт "Справочники"
    Тогда открывается страница с таблицей "Справочники"
    И пользователь нажимает ссылку "План счетов  по КО" в столбце "Краткое наименование"
    И пользователь нажимает кнопку "Поиск" в верхней панели таблицы
    Тогда открывается модальное окно "Поиск..."
    Когда пользователь выбирает пункт "Номер счёта 2-го порядка" в выпадающем списке "ID Плана Счетов"
    И пользователь выбирает пункт "начинается с" в выпадающем списке "содержит"
    И пользователь заполняет поле значением "202"
    И пользователь нажимает кнопку "Найти"
    Тогда отображается "Номер счета 2-ого порядка" содержащий "202"

  @11119
  Сценарий: создание нового актива типа "Денежные средства для ФО типа КО"
    И пользователь нажимает кнопку с выпадающим списком "Сбор и ведение данных"
    И пользователь выбирает пункт "Список активов"
    И пользователь нажимает кнопку "Создать"
    Тогда открывается страница с формой "Создание актива (первый этап)"
    И на странице присутствуют поля
      | Наименование ФО           |
      | Тип актива функциональный |
    И пользователь выбирает пункт "Денежные средства" в выпадающем списке "Тип актива функциональный "
    И пользователь нажимает кнопку "Далее"
    Тогда открывается страница с формой "Создание актива (второй этап)"
    И на форме отображаются закладки
      | Основная информация |
      | Приём               |
      | План работы         |
      | Судебная работа     |
      | Инвентаризация      |
      | Хранение            |
      | Аренда              |
      | Оценка              |
      | Реализация          |
      | Списание            |
      | Утилизация          |
      | Связи с активами    |
      | Вовлечённые стороны |
    Когда пользователь перешел на вкладку "Основная информация"
    Когда пользователь заполняет обязательные поля на вкладке Основная информация
      | Номер счёта                    | 20202810000000000001 |
      | Начальная балансовая стоимость | 500000               |
      | В валюте счёта                 | 700000               |
      | Наименование актива            | Новый актив тест     |
    То на вкладке Основная информация заполнились поля
      | Текущая балансовая стоимость |
      | Валюта счёта                 |
    Когда пользователь перешел на вкладку "Приём"
    Когда пользователь заполняет обязательные поля на вкладке Прием
      | Дата начала действия актива    | 30.01.2018 |
      | Дата окончания действия актива | 01.01.2020 |
  #  И пользователь сохраняет по кнопке Сохранить
 #   И пользователь нажимает кнопку с выпадающим списком "Сбор и ведение данных"
  #  И пользователь выбирает пункт "Список активов"
 #   И пользователь нажимает кнопку "Поиск" в верхней панели таблицы
 #   Тогда открывается модальное окно "Поиск..."
 #   Когда пользователь выбирает пункт "Номер лицевого счета" в выпадающем списке "ID Плана Счетов"
 #   И пользователь выбирает пункт "содержит" в выпадающем списке "содержит"
 #   И пользователь заполняет поле значением "20202810000000000001"
 #   И пользователь нажимает кнопку "Найти"



