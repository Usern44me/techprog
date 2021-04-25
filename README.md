#Курс 19/20 - ТП1/2 - Технологии программирования I/II
[Задания курса.](https://docs.google.com/document/d/1TUxcZclZ6zkdXw5X98irdYX5vn2FBd_-oBdZ2_1vPT0)

##Курсовая работа

Программа, которая автоматически скачивает заданный набор веб-страниц и строит по ним поисковый индекс. Поиск по поисковому индексу через командную строку.

  *Есть две программы: паук и поисковик. Паук получает список веб страниц в виде текстового файла и строит по ним поисковый индекс, который записывается в текстовый файл. Поисковик на вход получает из командной строки запрос в виде списке ключевый слов, а на выход выдает ранжированный  список из веб страниц (в виде HTML файла), ранее загруженных пауком. Больший ранг в списке имеют веб страницы, релевантные запросу.
  *Для построения поискового индекса каждая веб страница разбирается на слова (рекомендуется для простоты работать со страницами на английском языке). В каждой странице находятся слова, которые встречаются на ней чаще всего (исключая предлоги). Пять самых частых слов будем считать ключевыми словами, описывающими эту страницу.
  *Поисковый индекс состоит из строк вида: имя веб страницы, список ее ключевых слов, частоты ключевых слов.
  *Наиболее релевантной к запросу будем считать страницу, у которой максимальное количество ключевых слов пересекается со словами запроса. Также можно учитывать частоты ключевых слов. 