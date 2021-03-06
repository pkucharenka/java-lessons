ШАБЛОН ПРОЕКТИРОВАНИЯ "ОДИНОЧКА/SINGLETON"
===========================================
**Одиночка** - гарантирует что класс имеет только один экземпляр, и предоставляет глобальную 
точку доступа к этому экземпляру.

КЛЮЧЕВЫЕ МОМЕНТЫ
----------------
- Паттерн Одиночка гарантирует, что в приложении существует не более одного экземпляра данного класса.
- Паттерн Одиночка также предоставляет глобальную точку доступа к этому экземлпяру.
- Реализация паттерна Одиночка на языке Java использует приватный конструктор и статический метод 
  в сочетании со статической переменной.
- Проанализируйте ограничения по производительности и затратам ресурсов, тщательно выберите реализацию 
  Одиночки для многопоточного приложения.
- Будьте внимательны при использовании загрузчиков классов; они могут привести к созданию нескольких 
  экземпляров, а это противоречит основной цели паттерна.

Определение паттерна "Одиночка"
-------------------------------
![CC0](https://github.com/Panchenko-Vlad/java-lessons/blob/master/LessonsJavaSE/src/HeadFirst/Singleton_5/Screenshots/singleton1.png)

Предупрежения к использованию паттерна
--------------------------------------
Если у вас многопоточная программа, то нужно определиться какую версию паттерна лучше использовать:
1. Синхронизация getInstance() - простое и эффективное решение. Только помните, что синхронизация 
метода может замедлить его выполнение в сто и более раз. Если метод getInstance() применяется в интенсивно 
используемой части приложения, возможно, вам стоит пересмотреть свое решение. [ссылка на реализацию](https://github.com/Panchenko-Vlad/java-lessons/blob/master/LessonsJavaSE/src/HeadFirst/Singleton_5/Examples_For_Multithreading/SynchronizedMethod/)
2. Если приложение всегда создает и использует экземпляр синглетного класса или затраты на создание 
не столь существенны, экземпляр можно создать заранее. [ссылка на реализацию](https://github.com/Panchenko-Vlad/java-lessons/blob/master/LessonsJavaSE/src/HeadFirst/Singleton_5/Examples_For_Multithreading/InstanceInFieldClass/)
3. Воспользуйтесь "условной блокировкой", чтобы свести к минимуму использование синхронизации 
в getInstance(). [ссылка на реализацию](https://github.com/Panchenko-Vlad/java-lessons/blob/master/LessonsJavaSE/src/HeadFirst/Singleton_5/Examples_For_Multithreading/ConventionalLock/)