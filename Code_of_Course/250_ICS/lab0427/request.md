一、实验目标
使用 binutils 工具 观察 ELF 文件；

学习利用 Linux 系统提供的 二进制工具集 分析可执行文件的结构与依赖；

学会 编写动态链接库 并链接指定的动态库；

掌握动态链接库的 创建过程 及应用程序与自定义动态库的链接方式；

能够对 动态链接函数进行 Interposition；

理解 如何拦截和替换动态库中的函数调用，实现如性能监测等高级功能。

二、实验内容
1. 提供的文件
可执行文件：demo

动态链接库：libseries.so

2. 实验任务
使用 binutils 工具观察 ELF 文件；

编写高效的动态链接库；

实现函数 Interposition 并测量性能。

三、提交内容
请提交一份包含以下内容的文档：

观察报告（包括使用的命令及观察到的信息）；

动态链接库源码及说明；

Interposition 代码与运行现象解释。

四、详细步骤
1. 使用 binutils 工具观察 ELF 文件
使用 ldd 观察 demo 可执行文件

目标：确定 demo 链接了哪些动态库，存在的 undefined symbol；

使用 readelf 读取 ELF 文件信息

分析 demo 与 libseries.so 的动态链接信息、headers 与 sections；

使用 objdump 反汇编文件

配合 readelf，读取动态链接函数的 GOT 表；

分析函数原型与功能

阅读汇编代码，生成两个函数的原型，并进行逆向分析。

2. 编写高效的动态链接库
分析现有函数

逆向理解 libseries.so 中函数的功能与算法；

设计高效算法

运用数学知识，设计性能更优的实现方式；

编写并生成新的动态链接库

实现优化算法并使用 gcc -shared -fPIC 编译；

测试运行 demo

验证 demo 链接新库后的功能是否正常。

3. 实现函数 Interposition
实现目标：在 demo 执行期间，记录原始库函数与自定义库函数的执行时间。

参考实现步骤：
添加计时功能

使用 gettimeofday() 或 clock_gettime() 进行微秒或纳秒级精确计时（需引入 <sys/time.h> 或 <time.h>）；

编写 Wrapper 函数

封装原函数，实现在调用前后插入计时代码；

设置链接优先级

使用 LD_PRELOAD 或链接顺序确保 Wrapper 优先于原函数；

记录执行时间

比较并记录原始库与自定义库函数的执行时间差异。

