ШАБЛОН ПРОЕКТИРОВАНИЯ "НАБЛЮДАТЕЛЬ/OBSERVER"
============================================
**Наблюдатель** - определяет отношение "один-ко-многим" между объектами таким образом, что при изменении оостояния
одного объекта происходит автоматическое оповещение и обновление всех зависимых объектов

КЛЮЧЕВЫЕ МОМЕНТЫ
----------------
- Паттерн Наблюдатель определяет отношение "один-ко-многим" между объектами.
- Субъекты обновляют наблюдателей через единый интерфейс.
- Субъект ничего не знает о наблюдателях - кроме того, что они реализуют интерфейс Observer.
- При использовании паттерна возможен как запрос, так и активная доставка данных от субъекта
  (запрос, считается более "правильным").
- Работа кода не должна зависеть от порядка оповещения наблюдателей.
- Java содержит несколько реализаций паттерна Наблюдатель, включая обощенную реализацию java.util.Observable.
- Помните о недостатках java.util.Observable:
_Observable, это класс, а класс в Java можно наследовать только один. Следственно, если ваш субъект уже
   наследуется от другого класса, то вам придеться делать собственную реализацию паттерна Наблюдатель._
- Не бойтесь самостоятельно реализовать Observable при необходимости.
- Swing, как и многие GUI-инфраструктуры, широко применяет паттерн Наблюдатель.
- Паттерн также встречается во многих других местах, включая JavaBeans и RMI.

Диаграмма на основе классов "WeatherStation.StandardRealization"
----------------------------------------------------------------
![CC0](https://github.com/Panchenko-Vlad/java-lessons/blob/master/LessonsJavaSE/src/HeadFirst/Observer_2/Screenshots/observer1.png)

Диаграмма на основе классов "WeatherStation.Observable"
-------------------------------------------------------
![CC0](https://github.com/Panchenko-Vlad/java-lessons/blob/master/LessonsJavaSE/src/HeadFirst/Observer_2/Screenshots/observer2.png)