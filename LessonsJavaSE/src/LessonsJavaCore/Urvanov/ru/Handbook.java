package LessonsJavaCore.Urvanov.ru;

/**
 * * * * * ЧТО Я УЗНАЛ НОВОГО * * * * *
 *
 * import static - можно прописать импорт для статической переменной                                                     import
 *
 * continue - оператор, позволяет пропустить текущую итерацию и перейти сразу к следующей итерации цикла              *  continue
 *
 * Сигнатура метода - это имя метода вместе со списком параметров                                                     *  signature
 *
 * Фактические параметры или аргументы - это то, что реально было передано в функцию, метод или процедуру             *  argument
 *
 * public void sum (int... parameter) { } - метод, принимающий произвольное число параметров                             int...
 *
 * Понятие "Bean" - это класс, у которого есть поля и они все приватные, также у этих полей есть геттеры и сеттеры.   *  Bean
 * * * Максимум что может быть в бине, это конструкторы и (или) реализованы методы: toString(), equals(), hashcode().
 * * * Главная особенность, что это простой класс. В нем не может быть сильно заумных методов.
 *
 * Сущность/Entity - всегда имеется ввиду некое существительное из предметной области.                                   Entity
 *
 * Чтобы подсчитать работу любого действия в программе, можно сделать следующее:                                      *  System.nanoTime();
 * * * long inTime = System.nanoTime();
 * * * <Действие, какое нужно проверить на время выполнения>
 * * * long outTime = System.nanoTime();
 * * * System.out.println("Время выполнения: " + outTime - inTime);
 *
 * Ключевое слово this может также использоваться для вызова из конструктора класса другого конструктора этого класса.   this
 * * * Вызов другого конструктора должен быть обязательно первым оператором/инструкцией в конструкторе:
 * * *
 * * * public Goblin(double health, int ammo) {
 * * *     this(health, ammo, 0); // ... остальная инициализация.
 * * * }
 * * *
 * * * public Goblin(double health, int ammo, int gold) {
 * * *     this.health = health;
 * * *     this.ammo = ammo;
 * * *     this.gold = gold;
 * * * }
 *
 * При создании объектов каждый объект получает свой отдельный набор переменных экземпляров.                          *  static
 * * * Если же нужно сделать какую-то переменную общей для всех экземпляров, то используется ключевое слово static.
 * * * Рекомендуется всегда обращаться к статическим свойствам через имя класса, чтобы подчеркнуть,
 * * * что оно относится именно к классу.
 *
 * Ключевое слово final может применяться к методу, тогда этот метод нельзя переопределять в классах-потомках для        final
 * * * методов экземпляров и нельзя скрывать (hide) в классах потомках для случая статических методов.
 * * * Можно применить final ко всему классу, что означает, что у класса не может быть потомков, то есть будет нельзя
 * * * наследоваться от этого класса.
 *
 * Если выражение инициализации не помещается в одну строку, или требуется обработка ошибок, использование циклов     *  blocks init
 * * * и прочее, то можно использовать блоки инициализации:
 * * * class Goblin {
 * * *     static int idCounter;
 * * *     int money;
 * * *
 * * *     static {
 * * *         // Инициализация статических полей
 * * *         idCounter = 3;
 * * *     }
 * * *
 * * *     {
 * * *         // Инициализации переменных экземпляров.
 * * *         money = 300;
 * * *     }
 * * * }
 * * * Блоки статической инициализации выполняются один раз при инициализации класса. Может быть несколько блоков
 * * * инициализации, и в таком случае они будут выполняться в порядке появления в исходном файле сверху вниз.
 * * *
 * * * Последовательность действий JVM:                                                                                  sequence blocks init
 * * * 1. Вычисляются аргументы конструктора. Если конструктор начинается с вызова другого конструктора этого класса,
 * * *    то вычисляются аргументы его и т.д.
 * * * 2. Если конструктор не начинается с вызова другого конструктора, то он начинается с явного или неявного вызова
 * * *    конструктора базового класса. Выполняется этот конструктор базового класса.
 * * * 3. Выполняются все выражения инициализации экземпляров и блоки инициализации экземпляров в том порядке,
 * * *    в котором они объявлены в исходном файле, словно они идут одним блоком.
 * * * 4. Выполняется остаток тела конструктора.
 *
 * Интерфейсы в Java - это некоторый контракт, описание методов, которые обязательно должны присутствовать в классе,     interface
 * * * реализующем этот интерфейс. Интерфейсы позволяют иметь несколько различных реализаций одного и того же действия,
 * * * но выполняемого различными способами или с различными видами данных.
 * * *
 * * * - Тела методов могут быть только у статических методов и методов по умолчанию.                                 *
 * * *
 * * * - Нельзя создать экземпляр интерфейса. Интерфейс может быть только реализован каким-либо классом,
 * * *   либо наследоваться другим интерфейсом.
 * * *
 * * * - Любой интерфейс является abstract, нет никакого смысла писать дополнительно это слово при объявлении         *
 * * *   интерфейса, хотя компилятор и проглотит фразу public abstract interface Monstr.
 * * *
 * * * - Любое объявление поля в интерфейсе является public static final.                                             *
 * * *
 * * * - Поскольку методы из интерфейса неявно имеют модификатор доступа public, то мы тоже должны объявить в классе
 * * *   эти методы как public, иначе будет ошибка компиляции.
 * * *
 * * * - Интерфейс может расширять другие интерфейсы наследуясь от них с помощью ключевого слова extends.
 * * *
 * * * - Интерфейс может содержать в себе вложенные типы:                                                             *
 * * *
 * * *   public interface Elemental extends Monster, Obstacle, Ghost, Enemy {
 * * *      // Константы и методы...
 * * *      class ElementalForce {
 * * *          private double x;
 * * *          private double y;
 * * *
 * * *          public void someMethod1() {
 * * *
 * * *          }
 * * *      }
 * * *   }
 * * *   - Вложенные типы неявно public и static.
 * * *   - Вложенный тип не может иметь модификатор доступа private или protected, иначе будет ошибка компиляции.
 * * *
 * * * - Если вам понадобилось добавить новый метод в интерфейс, то вы можете создать новый интерфейс,                *
 * * *   расширяющий старый и добавляющий этот метод:
 * * *
 * * *   public interface ExtendedMonster extends Monster {
 * * *      void doSomething();
 * * *   }
 * * *
 * * *   Теперь пользователи смогут выбрать, остаться ли им на старом интерфейсе, либо перейти на новый и получить
 * * *   дополнительные возможности.
 * * *
 * * *   Или вы можете использовать методы по умолчанию (default methods):                                            *
 * * *
 * * *   public interface Monster {
 * * *      boolean isSensitiveToSilver();
 * * *      void logic(VisibleWorld visibleWorld);
 * * *
 * * *      // Новый метод
 * * *      default void doSomething() {
 * * *       // Некий код
 * * *      }
 * * *   }
 * * *   Для методов по умолчанию нужно обязательно указать реализацию. Эта реализация может вызывать другие методы из
 * * *   этого интерфейса и интерфейсов, от которых он наследуется.
 * * *
 * * * - Интерфейс может содержать статические методы, как и класс. Статические методы могут иметь реализацию и
 * * *   относятся к самому типу и вызываются через него.
 * * *
 *
 * Есть три вида языков программирования:                                                                                definition
 * * * Императивный - подробно объясняем компьютеру что нужно сделать (Java, C#, C++, Pascal и т.д.)
 * * * Декларативный - говорим что хотим получить, а как это будет делаться мы не уточняем (SQL)
 * * * Функциональный -
 *
 * Класс, который наследуется от другого класса, называется подклассом (subclass), дочерним классом (child class),       definition
 * * * потомком или расширенным классом (extended class).
 *
 * Класс, от которого наследуется дочерний класс, называется родительским классом (parent class), предком,               definition
 * * * суперклассом (superclass) или базовым классом (base class).
 *
 * Goblin goblin = (Goblin) obj;                                                                                         type exception
 * * * Если obj ссылается на объект НЕ являющийся экземпляром класса Goblin или его потомков, то возникнет
 * * * исключение java.lang.ClassCastException.
 *
 * Если ваш метод переопределяет метод базового класса, то вы не можете вызвать метод базового класса напрямую           super
 * * * по имени. Вам нужно использовать ключевое слово super.
 * * * Goblin.super.methodInMonster();
 *
 * Если ваш класс определяет поле с тем же именем, что и поле в родительском классе, то нужно использовать ключевое      super
 * * * слово super.
 * * *
 * * * class Monster {
 * * *     double gold = 10.0;
 * * *
 * * *     void walk() {
 * * *         System.out.println("Monster walk.");
 * * *     }
 * * * }
 * * *
 * * * class Goblin extends Monster {
 * * *     // Это скрывает поле gold класса Monster.
 * * *     double gold = 20.0;
 * * *
 * * *     // Это переопределяет метод walk класса Monster.
 * * *     void walk() {
 * * *         System.out.println("Goblin walk");
 * * *
 * * *         System.out.println("Goblin gold = " + gold);
 * * *
 * * *         // Мы можем обратиться к скрытому полю
 * * *         // родительского класса
 * * *         System.out.println("Monster gold = " + super.gold);                                                    *
 * * *
 * * *         // Мы можем вызвать переопределённый метод родительского класса.
 * * *         super.walk();                                                                                          *
 * * *     }
 * * * }
 * * *
 * * * class Main {
 * * *     public static void main(StringLibrary[] args) {
 * * *         Goblin goblin = new Goblin();
 * * *         goblin.walk();
 * * *     }
 * * * }
 *
 * Если вы не вставили ни одного явного вызова конструктора родительского класса, то компилятор Java автоматически    *  constructor
 * * * добавит вызов конструктора родительского класса без параметров (конструктора по умолчанию). Если конструктор
 * * * родительского класса без параметров недоступен из-за модификатора доступа, или конструктора без параметров нет
 * * * в родительском классе, то возникнет ошибка компиляции.
 *
 * При создании экземпляра любого объекта происходит цепочка вызовов конструкторов от конструктора создаваемого          constructor
 * * * объекта до конструктора класса Object. Это называется цепочкой вызова конструкторов (constructor chaining).
 *
 * Класс Object является прямо или через череду других классов суперклассом для всех других классов в языке Java.        object
 * * * Он имеет некоторое количество методов:
 * * * clone() - создаёт копию объекта, если класс объекта реализует интерфейс java.lang.Cloneable, а в противном
 * * *           случае генерирует исключение CloneNotSupportedException. Сам интерфейс Cloneable не содержит никаких
 * * *           методов, а просто является меткой того, что объект, который его реализует поддерживает метод clone().
 * * *           Согласно соглашению классы, которые реализуют интерфейс Cloneable, и для объектов которых планируется
 * * *           использовать метод clone(), должны переопределить этот метод с protected на public.
 * * *
 * * * equals() - Реализация в классе Object возвращает true только тогда, когда две ссылки ссылаются на один и тот же
 * * *            экземпляр объекта, в противном случае нужно переопределять методы equals() и hashcode().
 * * *
 * * * hashcode() - Возвращает хеш-код для объекта. Реализация в Object возвращает адрес объекта. Этот хеш-код
 * * *              используется в хеш-таблицах вроде HashMap. Согласно соглашению если метод equals() для двух
 * * *              объектов возвращает true, то hashCode() для них должен возвращать одинаковое значение.
 *
 * Если при определении метода указать его как final, то этот метод будет нельзя переопределять в классах потомках.   *  final method
 * * * Это может быть полезно для методов, используемых конструкторами, так как переопределение метода, который
 * * * используется конструктором, может привести к нежелательным последствиям.
 * * * (Можно сделать весь класс final, что запретит указывать его в качестве родительского класса.)
 *
 * Если в классе есть абстрактные методы, то он ДОЛЖЕН быть объявлен абстрактным.                                        abstract
 *
 * Абстрактные классы очень похожи на интерфейсы, но абстрактные классы могут иметь поля экземпляров и могут иметь    *  abstract class
 * * * методы с модификатором доступа отличным от public. Также вы можете наследовать свой класс только от одного
 * * * другого класса, но вы можете реализовать любое количество интерфейсов.
 *
 * Используйте абстрактные классы, если:                                                                              *  abstract class
 * * * - Вы хотите использовать общий код в нескольких близко связанных классах.
 * * * - Вы ожидаете, что классы, которые будут наследоваться от вашего абстрактного класса, имеют большое количество
 * * *   общих полей или требуют использования модификаторов доступа отличных от public.
 * * * - Вам нужно объявить поля экземпляров или класса, а не только константы.
 *
 * Используйте интерфейсы в следующих ситуациях:                                                                      *  interface
 * * * - Вы ожидаете, что интерфейс будут реализовывать не связанные друг с другом классы. Интерфейсы Comparable и
 * * *   Cloneable, например, реализует очень большое количество совершенно разных классов.
 * * * - Вы хотите указать поведение определённого типа, но вам абсолютно не важно, кто будет реализовывать
 * * *   это поведение.
 * * * - Вам нужно множественное наследование типов.
 *
 * Для примера абстрактного класса представьте ситуацию, что вам нужно реализовать несколько различных                *  abstract class
 * * * видов монстров: Goblin, Hobgoblin, Orc, Gremlin и Genie. Каждый из эти монстров имеет свои различные
 * * * особенности, которые будут реализовываться в соответствующем классе, но все эти монстры будут уметь ходить и
 * * * иметь координаты в пространстве, и у каждого из них будет уровень здоровья. В этом случае можно заложить
 * * * умение ходить, координаты и уровень здоровья в базовом классе Monster, который сделать абстрактным,
 * * * и в котором объявить абстрактные классы для управления повадками и прочими вещами, реализации которых будут
 * * * в соответствующих дочерних классах.
 *
 * Абстрактные классы чаще всего называют начиная с Base*, Sceleton*, Abstract*.                                         abstract class
 *
 * В большинстве случаев можно использовать примитивный тип там, где ожидается объект, и объект там, где ожидается    *  primitive types
 * * * примитивный тип. В таких случаях компилятор Java автоматически вставляет преобразование из примитива в объект
 * * * и обратно. Это преобразование называется автоупаковкой (Autoboxing) и распаковкой (unboxing).
 * * *
 * * * Integer i1 = 3334; // Упаковка int в объект Integer
 * * * int i2 = i1;  // Распаковка Integer в примитивный тип int
 * * *
 * * * Каждый из классов Byte, Short, Integer, Long, Float, Double содержит константы MAX_VALUE и MIN_VALUE, которые
 * * * позволяют узнать максимально возможное и минимально возможное число.
 *
 * Абстрактный класс Number содержит несколько полезных методов, которые реализуются всеми его дочерними классами.       Number
 * * *
 * * * Методы для конвертации объекта Number в соответствующее число примитивного типа:
 * * * * * byte byteValue()
 * * * * * short shortValue()
 * * * * * int intValue()
 * * * * * long longValue()
 * * * * * float floatValue()
 * * * * * double doubleValue()
 * * *
 * * * Методы сравнения с примитивными типами:                                                                        *
 * * * * * int compareTo(Byte anotherByte)
 * * * * * int compareTo(Double anotherDouble)
 * * * * * int compareTo(Float anotherFloat)
 * * * * * int compareTo(Integer anotherInteger)
 * * * * * int compareTo(Long anotherLong)
 * * * * * int compareTo(Short anotherShort)
 * * *
 * * * Метод проверки на равенство:
 * * * * * boolean equals(Object obj)
 * * *
 * * * Конвертирует строку в число. Поддерживает десятичную, шестнадцатеричную и восьмеричную системы счисления:      *
 * * * * * static Integer decode(StringLibrary s)
 * * *
 * * * Возвращает int. Система счисления задаётся параметром radix (2, 8, 10 или 16).
 * * * * * static int parseInt(StringLibrary s, int radix)
 *
 * * * Возвращает объект Integer, содержащий разобранное значение из строки s в соответствии с системой счисления radix.
 * * * * * static Integer valueOf(StringLibrary s, int radix)
 *
 * Класс java.math.BigInteger позволяет хранить целые числа любой величины. Объекты этого класса являются             *  BigInteger
 * * * неизменямыми, то есть не меняют своего состояния после создания, но могут порождать новые объекты при сложении,
 * * * вычитании и т.д.
 * * *
 * * * Класс java.math.BigInteger является потомком класса java.lang.Number.
 * * *
 * * * Пример создания:
 * * * BigInteger bigNumber1 = new BigInteger("1000000000000000000000000000");
 * * *
 * * * Переполнение как в целочисленных операциях примитивов в BigInteger невозможно.                                 *
 * * *
 * * * В Java нет перегрузки операций, поэтому для выполнения арифметических операций с BigInteger нужно
 * * * использовать методы.
 * * *
 * * * Список методов:
 * * * * * public BigInteger abs(); // Возвращает BigInteger с положительным знаком и тем же числом.
 * * * * * public BigInteger negate(); // Возвращает BigInteger с отрицательным знаком и тем  же значением.
 * * * * * public int signum(); // Возвращает -1 для отрицательных чисел, 0 для нуля и 1 для положительных.
 * * * * * public int compareTo(BigInteger val); // Сравнивает значение в BigInteger со значением в val. Возвращает -1,
 * * * * *                                          если текущее значение меньше val , 0 если они равны, и 1, если
 * * * * *                                          текущее значение больше val.
 * * * * * public BigInteger add(BigInteger val); // Возвращает результат сложения текущего BigInteger с val.
 * * * * * public BigInteger subtract(BigInteger val); // Возвращает разность текущего значения и val.
 * * * * * public BigInteger multiply(BigInteger val); // Возвращает результат умножения текущего значения на val.
 * * * * * public BigInteger divide(BigInteger val) throws ArithmeticException // Возвращает результат целочисленного
 * * * * *                    деления текущего значения на val. Если val равен нулю, то возникает ArithmeticException.
 * * * * * public BigInteger remainder(BigInteger val) throws ArithmeticException // Возвращает остаток от деления
 * * * * *                            текущего значения на val. Если val равен нулю, то возникает ArithmeticException.
 * * *
 * * * BigInteger bigNumber1 = new BigInteger("1000000000000000000000000000");
 * * * BigInteger result = bigNumber1.add(new BigInteger("123"))
 * * *                               .subtract(new BigInteger("333"))
 * * *                               .multiply(new BigInteger("2"));
 *
 * Для хранения и обработки денежных значений нужно всегда использовать BigDecimal, так как он позволяет избежать     *  BigDecimal
 * * * ошибок округления, которые возникают из-за невозможности представить некоторые десятичные дроби без потери
 * * * точности в float и double.
 * * *
 * * * Методы и их реализация в этом классе очень похожи на методы в классе BigInteger.
 * * *
 * * * Для многих методов в BigDecimal нужно указать экземпляр класса java.math.MathContext, который определяет
 * * * точность результирующего значения и способ округления. У некоторых методов есть варианты без MathContext
 * * * и с ним, в этом случае нужно всегда использовать вариант с MathContext, так как методы без этого параметра
 * * * будут генерировать ArithmeticException, если их результат невозможно представить конечной десятичной дробью.
 * * * Пример использования BigDecimal и MathContext:
 * * * * * BigDecimal value1 = new BigDecimal("100.01");
 * * * * * // 4 знака после десятичной запятой
 * * * * * // Стандартное округление, которому учат в школе.
 * * * * * MathContext mathContext = new MathContext(4, RoundingMode.HALF_UP);
 * * * * * BigDecimal result = value1.add(new BigDecimal("2"), mathContext)
 * * * * *                           .subtract(new BigDecimal("0.001"), mathContext);
 *
 * Класс java.lang.Math содержит некоторые предопределённые константы и методы, позволяющие вычислять синус, косинус,    Math
 * * * возводить в степень и т. д.
 * * * Вот несколько полезных методов:
 * * * * * public static double sqrt(double a); // Возвращает квадратный корень от a
 * * * * * public static double pow(double a, double b); // Возвращает a возведённое в степень b
 * * * * * public static long round(double a); // Возвращает округлённое значение a
 *
 * Всегда когда указывается отрезок в массиве, строке, списке или ещё-где-то, начальный индекс включается в отрезок,     definition
 * * * а конечный исключается.
 *
 * Автоупаковка (autoboxing) - это автоматическая конвертация из примитивных типов в соответствующий этому типу          autoboxing
 * * * класс-обёртку, вставляемая компилятором Java, например из float во Float, из int в Integer.
 * * *
 * * * Компилятор Java применяет автоупаковку в следующих случаях:
 * * * - При передаче примитивного типа в параметр метода, ожидающего соответствующий ему класс-обёртку.
 * * * - При присвоении значения примитивного типа переменной соответствующего класса-обёртки.
 *
 * Распаковка (unboxing) - конвертация класса-обёртки в соответствующий ему примитивный тип. В процессе распаковки       unboxing
 * * * может произойти исключение java.lang.NullPointerException, если значение переменной равно null.
 * * *
 * * * Компилятор Java автоматически применяет распаковку в следующих случаях:
 * * * - При передаче объекта класса-обёртки в метод, ожидающий соответствующий примитивный тип.
 * * * - При присвоении экземпляра класса-обёртки переменной соответствующего примитивного типа.
 * * * - В выражениях, в которых один или оба аргумента являются экземплярами классов-обёрток (кроме операции == и != ).
 *
 *
 * * * Integer x1 = new Integer(10);                                                                                     example
 * * * Integer x2 = new Integer(10);
 * * * // x1 и x2 ссылаются на разные экземпляры объектов                                                             *
 * * * System.out.println("x1 >= x2 : " + (x1 >= x2)); //true
 * * * System.out.println("x1 <= x2 : " + (x1 <= x2)); //true
 * * * System.out.println("x1 == x2 : " + (x1 == x2)); //false происходит
 * * *                                                 // сравнение ссылок
 * * * System.out.println("x1 != x2 : " + (x1 != x2)); // true происходит
 * * *                                                 // сравнение ссылок
 * * *
 * * *
 * * * Integer x3 = Integer.valueOf(10);
 * * * Integer x4 = 10; // Здесь неявно вызывается Integer.valueOf                                                    *
 * * *                  // Теперь x3 и x4 указывают на один и тот же объект из-за кэширования.
 * * * System.out.println("x3 == x4 : " + (x3 == x4)); // true из-за кэширования
 * * *                                                 // см. метод Integer.valueOf
 * * * System.out.println("x3 != x4 : " + (x3 != x4)); // false из-за кэширования
 * * *                                                 // см. метод Integer.valueOf
 *
 *
 * * * class Main {                                                                                                      inheritance
 * * *
 * * *     static class Monster {}
 * * *
 * * *     static class Goblin extends Monster {}
 * * *
 * * *     static class Hobgoblin extends Goblin {}
 * * *
 * * *     static void method1(Monster obj) {
 * * *         System.out.println("1");
 * * *     }
 * * *
 * * *     static void method1(Goblin obj) {
 * * *         System.out.println("2");
 * * *     }
 * * *
 * * *     public static void main(StringLibrary[] args) {
 * * *         Monster obj = new Hobgoblin(); // Выведет 1                                                            *
 * * *         // Hobgoblin obj = new Hobgoblin(); // Выведет 2
 * * *         method1(obj);
 * * *     }
 * * * }
 * * *
 * * * Так как переменная obj имеет тип Monster. Фактически, конечно, obj ссылается на экземпляр Hobgoblin,
 * * * но выбор перегруженного метода осуществляется на этапе компиляции, а не на этапе выполнения, поэтому метод
 * * * выбирается на основе типа объявленной переменной.
 *
 * Термин "unchecked" означает непроверенные, то есть компилятор не имеет достаточного количества информации для         definition
 * * * обеспечения безопасности типов.
 *
 * Выведение типов - это возможность компилятора Java автоматически определять аргументы типа на основе контекста,       definition
 * * * чтобы вызов получился возможным.
 * * *
 * * * Выведение типов - это возможность компилятора Java автоматически определять аргументы типа на основе контекста,
 * * * чтобы вызов получился возможным.
 * * * * * static <T> T pick(T a1, T a2) { return a2; }
 * * * * * Serializable s = pick("d", new ArrayList<StringLibrary>());
 */

public class Handbook {
}
