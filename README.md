
# jProlog - A Simple Solver (*Java*)

===========================

## 0x00 Introduction / 介绍

**jProlog** is a language describing simple logical problems, using exhaustion to find solutions. Developed by ***bajdcc***.

**jProlog** 是一个简易的逻辑问题解答程序，主要运用穷举法搜寻解空间，因而时间复杂度受变量数量和长度影响，因而有待优化。

## 0x01 Grammar / 语法

*QUICK:* **See ANTLR Grammar File(.g4) at [Prolog.g4](https://github.com/bajdcc/jProlog/blob/master/Prolog.g4)**

PS. Supporting Chinese.

### I. Define Values of a Collection / 定义集合的值
> COLLECTION_NAME{} = {val1,val2,...};
> or
> 集合名称{} = {值1,值2,...};

COLLECTION_NAME, alias **Type**

example:
> 所有人{} = {"埃夫里","布莱克","克朗","戴维斯","其他人"};
> Digit{} = {0..9};

### II. Define Single Variable / 定义单变量
> COLLECTION_NAME var1,var2,...;
> or
> 集合名称 变量名1,变量名2,...;

example:
> 时间 死亡时刻;
> Digit A,B,C;

**Note:** System will searching in the SPACE of O(n), where n is *Elements of a Type* or Math Function *card(type)*;

### III. Define Sequence Variable / 定义序变量
> COLLECTION_NAME var1[],var2[],...;
> or
> 集合名称 变量名1[],变量名2[],...;

example:
> 时间 序列[];
> Digit A[],B[],C[];

**Note:** System will searching in the SPACE of O(n!), where n is card(type);

### IV. Define Argument Variable / 定义参变量
> COLLECTION_NAME var1(Type1,Type2,...),var2(Type1,Type2,...),...;
> or
> 集合名称 变量名1(参数类型1,参数类型2,...),变量名2(参数类型1,参数类型2,...),...;

example:
> 时间 在寓所(所有人);
> Digit Score(Everyone);

**Note:** System will searching in the SPACE of O(pow(n,t)), where n is card(type) and t is *The Product of card(type1), card(type2), ...*;

### V. Settings / 设置
usage:
> 设置(多解);
> 设置(定时,1000);
> 	设置(版权,"Copyright");

or (DIY)
> settings1(...);
> settings2(...);

**Note:** If you want to DIY them, modify [RtSettingFunc.java](https://github.com/bajdcc/jProlog/blob/master/src/com/bajdcc/rt/adv/func/RtSettingFunc.java). Edit attribute '*desc*' of SettingType. Extend method '*dealWithSettingId*' if you want to add new features. The setting function will apply settings in [RtSettings.java](https://github.com/bajdcc/jProlog/blob/master/src/com/bajdcc/rt/RtSettings.java).

### VI. Print / 输出
usage:
> 输出("foo", bar);
> 输出("foo", func((bar == 4) + 7, val3 9);

or (DIY)
> print(...);

**Note:** A Print Func will call println in the end.

### VII. Quantity / 量词
usage:
> 存在 x 属于 集合1, 任意 y 属于 集合2, ..., 逻辑表达式;

or (DIY)
> exists x in type1, any y in type2, ..., logical expression;

**Note:** Use of quantity will increase the complexity of solutions, leading to waiting for long time to see the results.

### VIII. Fixed, Pruning / 固定值，剪枝
usage:
> 参变量(参数...) = 字串 或 数值;

or
> Argument_Variable(param1,...) = String or Integer;

**Note:** Use of fixed will decrease the complexity of solutions.

### IX. Mutex / 互斥
usage:
> 互斥(逻辑表达式1.逻辑表达式2,...);

or (DIY)
> Mutex(Logical_exp1,Logical_exp2,...);

**Note:** Use of Mutex will increase the complexity of solutions. Use Sequence Variable instead if possible.

### X. Customize / 自定义函数
usage:
> 函数(逻辑表达式1.逻辑表达式2,...);

or
> Func(Logical_exp1,Logical_exp2,...);

**Note:** See Enum '*FuncType*' in [RtFuncFactory.java](https://github.com/bajdcc/jProlog/blob/master/src/com/bajdcc/rt/adv/func/RtFuncFactory.java).


## 0x02 Design / 设计

### I. Designing DSL / 设计领域特定语言
The Grammar of *jProlog* is referred to **智能通用逻辑问题解题器 ZnlogWin**. You can find it by Google or Baidu. Znlog is compiled by VC6.0. I have read its grammar.

I use ANTLR to analyze the input and generate a simple parse tree. Then, I convert it to an AST. The difference between Original Tree and AST is *String Factory* and *Semantic Analysis*.

### II. Original Parse Tree / 原始语法树
I generate OPT from [PrologBaseVisitorImpl.java](https://github.com/bajdcc/jProlog/blob/master/src/com/bajdcc/grammar/PrologBaseVisitorImpl.java). You can serialize OPT by calling *toString* method.

### III. String Factory / 字串工厂
I made a String Map from OPT. The String Factory is used to store any infomation of Variable Name and Literal String and then return an id. It made Semantic Analysis possible. Besides, it will be used in Code Generation, which I haven't done yet.

### IV. Semantic Analysis / 语义分析
ANTLR does not do semantic analysis. So I need to complete it by myself.
The exception of semantic problem is [SemanticException.java](https://github.com/bajdcc/jProlog/blob/master/src/com/bajdcc/rt/error/SemanticException.java).

### V. AST / 抽象语法树
The most complex work is to convert OPT to AST. I use Visitor Pattern and Stack to do semantic analysis, tree generation and maintenance of string factory at the same time. The AST is too abstract to be implemented carefully on *toString* method.

The converting work is in [RtBlock.java](https://github.com/bajdcc/jProlog/blob/master/src/com/bajdcc/rt/RtBlock.java).

### VI. Sequence Generator / 序列生成器
The underlying base of system running successfully is Sequence Generator.
1. With repetition and 1D
2. With repetition and nD, where n > 1
3. Without repetition

Generator 1 and 2 is made by exhaustion. I implemented *Fixed* feature by using a HashSet and skipping if its position is to be changed in a Foreach loop.

If one wants to generate a non-repetitive sequence, he should see [std::next_permutation](http://www.cplusplus.com/reference/algorithm/next_permutation/) written in C++. I implemented it with Java.

The Sequence Generator can be clone for storage of results, because system may find multiple solutions.

### VII. Runtime Environment / 运行时环境
The Environment object is passed to all of RtExp/RtToken/RtFunc, because the Env include the most infomation of runtime. If system find one solutions, it will clone the env and save it.

### VIII. Gui Application / 界面
In Swing, system is running in a background thread instead of main Gui thread. I used SwingWork<T, V>. Besides, PrologDialog needs support of JRE8.


## 0x03 Interface / 接口

### I. Query / 查询
Usage:
> IRtQueryAnswer query = PrologExecutor.getInstance().run(input_context);
> query.queryValue(id, var, params);

- id: The ordinal of results, default is 0. If multi-answer is turned on, the id is valid.
- var: Name of variable.
- params: Array index, or parameters of argument variable. The type of param is eithor String or Integer.

Exception: *SemanticException*

### II. Global Settings / 全局设置
See [PrologExecutor.java](https://github.com/bajdcc/jProlog/blob/master/src/com/bajdcc/prolog/PrologExecutor.java).

- out: Set output stream, whose type is PrintStream.
- future: For interruption, e.g., Stop Action of Gui.

If one wants to redirect the output stream to JTextArea. He can use SwingWorker to set the output stream to a new stream whose '*write*' method is overridden to print the messages on JTextArea.

The future is Future<T>, used for interruption where current thread is not Gui thread. 

## 0x04 Example / 例子 

### Screenshot

*Screenshot 1 - Lie1*
![Screenshot 1](https://bajdcc.github.io/host/screenshot/jprolog_1.png)

*Screenshot 2 - Gougu*
![Screenshot 2](https://bajdcc.github.io/host/screenshot/jprolog_2.png)