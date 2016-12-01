ШАБЛОН ПРОЕКТИРОВАНИЯ "АДАПТЕР/ADAPTER"
=======================================
**Адаптер** - преобразует интерфейс класса к другому интерфейсу, на который рассчитан клиент. Адаптер 
обеспечивает совместную работу классов, невозможную в обычных условиях из-за несовместимости интерфейсов.

КЛЮЧЕВЫЕ МОМЕНТЫ
----------------
- Если вам понадобится использовать существующий класс с неподходящим интерфейсом - используйте адаптер.
- Адаптер приводит интерфейс к тому виду, на который рассчитан клиент.
- Объем работы по реализации адаптера зависит от размера и сложности целевого интерфейса.
- Существуют две разновидности адаптеров: адаптеры объектов и адаптеры классов. Для адаптеров классов 
  необходимо множественное наследование.

Определение паттерна "Адаптер"
------------------------------
![CC0](https://github.com/Panchenko-Vlad/java-lessons/blob/master/LessonsJavaSE/src/HeadFirst/Adapter_7/Screenshots/adapter1.png)

Диаграмма на основе классов "Iter_Enum"
---------------------------------------
![CC0](https://github.com/Panchenko-Vlad/java-lessons/blob/master/LessonsJavaSE/src/HeadFirst/Adapter_7/Screenshots/adapter2.png)