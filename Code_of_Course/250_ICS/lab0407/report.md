# 数组边界实验报告

## 实验目的

探究C语言中数组边界检查机制，观察数组越界访问的行为，以及未初始化数组的特性。

## 实验代码

以下是原始的实验代码：

```c
#include <stdio.h>

char array_store(unsigned int index, char val) {
    char arr[10];  // 声明一个长度为10的字符数组
    char old_val = arr[index];  // 读取index位置的值
    arr[index] = val;  // 写入新值
    return old_val;  // 返回原来的值
}

int main() {
    const char* test_str = "012345678901234567890123456789";
    printf("原始字符串: %s\n", test_str);
    printf("逐个写入并输出返回值:\n");
    
    for (int i = 0; i < 30; i++) {
        char ret = array_store(i, test_str[i]);
        printf("位置 %d: 写入值 '%c', 返回值 '%c'\n", i, test_str[i], ret);
    }
    
    return 0;
} 
```

## 实验过程

为了更好地观察数组操作的行为，我对原始代码进行了修改，添加了显示数组内容的功能：

```c
#include <stdio.h>
#include <string.h>

// 定义全局数组用于显示
char display_arr[10];

char array_store(unsigned int index, char val) {
    char arr[10];  // 声明一个长度为10的字符数组
    
    // 添加边界检查，避免数组越界
    if (index >= 10) {
        // 索引超出范围，仅用于显示，不实际访问局部数组
        if (index < 30) { // 为了演示限制在30以内
            display_arr[index % 10] = val;
        }
        return '\0';
    }
    
    char old_val = arr[index];  // 读取index位置的值
    arr[index] = val;  // 写入新值
    
    // 将arr写入到全局数组以便显示
    display_arr[index] = val;
    
    return old_val;  // 返回原来的值
}

// 函数用于显示数组内容
void print_array() {
    printf("数组当前内容: ");
    for(int i = 0; i < 10; i++) {
        if(display_arr[i] >= 32 && display_arr[i] <= 126) {
            printf("'%c' ", display_arr[i]);
        } else {
            printf("\\x%02x ", (unsigned char)display_arr[i]);
        }
    }
    printf("\n");
}

int main() {
    const char* test_str = "012345678901234567890123456789";
    printf("原始字符串: %s\n", test_str);
    printf("逐个写入并输出返回值:\n");
    
    // 初始化显示数组
    memset(display_arr, 0, sizeof(display_arr));
    print_array();
    
    for (int i = 0; i < 30; i++) {
        char ret = array_store(i, test_str[i]);
        printf("位置 %d: 写入值 '%c', 返回值 '", i, test_str[i]);
        if(ret >= 32 && ret <= 126) {
            printf("%c", ret);
        } else {
            printf("\\x%02x", (unsigned char)ret);
        }
        printf("'\n");
        
        // 显示写入后的数组内容
        print_array();
    }
    
    return 0;
}
```

## 实验现象

在运行修改后的代码后，我观察到以下现象：

1. **未初始化的数组值**：
   - 在原始代码中，局部数组`arr`未被初始化，因此读取的原始值是内存中的随机数据
   - 运行结果中可以看到，前几次返回的`old_val`包含了不可预测的值，有些是不可打印字符，有些是可打印字符

2. **数组越界访问**：
   - 当我们尝试访问超出数组边界的元素（index ≥ 10）时，在原始程序中会导致"stack smashing detected"错误
   - 这是因为现代编译器（如gcc）会添加栈保护机制，当检测到栈被破坏时会终止程序

3. **修改后的行为**：
   - 在修改后的代码中，我们添加了边界检查，防止访问超出数组边界的元素
   - 同时使用了全局数组`display_arr`来记录和显示每次操作后的数组内容
   - 可以看到前10个写入操作正确地将数据写入数组，而后续操作使用取模运算确保索引在有效范围内

## 实验结论

1. **C语言的数组边界**：
   - C语言不提供自动的数组边界检查，程序员需要自行确保不越界
   - 越界访问可能导致未定义行为，包括程序崩溃、错误结果或安全漏洞

2. **未初始化的局部变量**：
   - C语言中的局部变量（包括数组）默认不初始化，包含"垃圾值"
   - 这些垃圾值是之前该内存位置存储的任何数据，具有不可预测性
   - 全局变量和静态变量会被自动初始化为零值

3. **数组的存储位置**：
   - 局部数组存储在栈上，每次函数调用时都会创建新实例，函数返回后被销毁
   - 全局数组存储在数据段，整个程序执行期间存在

4. **安全隐患**：
   - 数组越界访问是一种常见的安全漏洞，可能导致缓冲区溢出攻击
   - 现代编译器和操作系统提供了一些保护机制（如栈保护），但不应依赖这些机制
   - 良好的编程实践应包括手动边界检查和初始化

## 安全编程建议

1. 始终对数组进行初始化
2. 在访问数组前检查索引是否在有效范围内
3. 考虑使用安全的替代品，如C++的`std::vector`或C的动态分配数组
4. 启用编译器警告和保护选项（如`-Wall`、`-Wextra`、`-fstack-protector`）

这个实验很好地展示了C语言内存管理的特性和潜在的安全隐患，提醒我们在编写代码时需要格外注意数组边界检查和变量初始化。

---

# 结构体内存对齐实验报告

## 实验目的
观察不同结构体成员排列顺序对内存布局的影响，理解内存对齐机制。

## 实验代码
```c
struct s1 {
    char name;
    short code;
    int value;
};

struct s2 {
    short code;
    int value;
    char name;
};

struct s3 {
    int value;
    char name;
    short code;
};
```

## 实验过程
1. 创建三个结构体变量并初始化：
   - s1: {0, 10, 100}
   - s2: {10, 100, 0}
   - s3: {100, 0, 10}

2. 使用sizeof获取结构体大小
3. 打印结构体变量及其成员的地址

## 实验结果

### 结构体大小
- sizeof(struct s1) = 8 字节
- sizeof(struct s2) = 12 字节
- sizeof(struct s3) = 8 字节

### 地址分布
#### struct s1
- var1地址: 0x7ffffc367e3c
- name地址: 0x7ffffc367e3c
- code地址: 0x7ffffc367e3e
- value地址: 0x7ffffc367e40

#### struct s2
- var2地址: 0x7ffffc367e4c
- code地址: 0x7ffffc367e4c
- value地址: 0x7ffffc367e50
- name地址: 0x7ffffc367e54

#### struct s3
- var3地址: 0x7ffffc367e44
- value地址: 0x7ffffc367e44
- name地址: 0x7ffffc367e48
- code地址: 0x7ffffc367e4a

## 实验分析

### 内存对齐原则
1. 基本数据类型的地址通常是其大小的整数倍（对齐到其自然边界）
2. 结构体的大小通常是其最大成员大小的整数倍
3. 在x86架构中：
   - char占1字节
   - short占2字节
   - int占4字节

### 各结构体分析

#### struct s1 (8字节)
- char(1字节) + 1字节padding
- short(2字节)
- int(4字节)
- 总大小：1 + 1 + 2 + 4 = 8字节

#### struct s2 (12字节)
- short(2字节)
- 2字节padding
- int(4字节)
- char(1字节) + 3字节padding
- 总大小：2 + 2 + 4 + 1 + 3 = 12字节

#### struct s3 (8字节)
- int(4字节)
- char(1字节) + 1字节padding
- short(2字节)
- 总大小：4 + 1 + 1 + 2 = 8字节

## 结论
1. 结构体成员的不同排列顺序会导致不同的内存布局和总大小
2. 通过合理排列结构体成员，可以优化内存使用
3. 内存对齐虽然会浪费一些空间，但能提高内存访问效率
4. 在实际编程中，应该注意结构体成员的排列顺序，以优化内存使用

# 函数指针实验报告

## 实验目的
探究C语言中函数指针的使用方式，观察不同函数指针赋值和调用方式的等价性。

## 实验代码
```c
#include <stdio.h>

int myfunc(unsigned int len) {
    int sum = 0;
    for (unsigned int i = 1; i <= len; i++) {
        sum += i * i;
    }
    return sum;
}

int main() {
    int (*pfun)(unsigned int);

    printf("测试1: pfun = myfunc\n");
    pfun = myfunc;
    printf("pfun(10) = %d\n", pfun(10));
    printf("(*pfun)(10) = %d\n", (*pfun)(10));

    printf("\n测试2: pfun = &myfunc\n");
    pfun = &myfunc;
    printf("pfun(10) = %d\n", pfun(10));
    printf("(*pfun)(10) = %d\n", (*pfun)(10));

    return 0;
}
```

## 实验过程
1. 编译并运行程序，观察不同调用方式的结果
2. 使用gcc -S生成汇编代码，分析函数指针的调用实现

## 实验结果

### 运行结果
```
测试1: pfun = myfunc
pfun(10) = 385
(*pfun)(10) = 385

测试2: pfun = &myfunc
pfun(10) = 385
(*pfun)(10) = 385
```

### 汇编代码分析
两种赋值方式（`pfun = myfunc` 和 `pfun = &myfunc`）生成的汇编代码：
```assembly
# 设置函数指针
leaq    myfunc(%rip), %rax    # 将myfunc的地址加载到rax寄存器
movq    %rax, -8(%rbp)        # 将地址存储到栈上的函数指针变量pfun中

# 调用函数（两种调用方式生成的代码相同）
movq    -8(%rbp), %rax        # 从栈上加载函数指针到rax
movl    $10, %edi             # 设置参数10到edi寄存器
call    *%rax                 # 通过rax间接调用函数
```

## 实验分析

### 函数指针赋值
1. `pfun = myfunc` 和 `pfun = &myfunc` 是等价的：
   - 在C语言中，函数名会自动转换为函数地址
   - 两种写法在编译后生成相同的机器码

### 函数指针调用
1. `pfun(10)` 和 `(*pfun)(10)` 是等价的：
   - `pfun(10)` 是C语言的语法糖，使函数指针调用更简洁
   - `(*pfun)(10)` 是显式地解引用函数指针后调用
   - 两种调用方式在编译后都使用 `call *%rax` 指令实现

### 汇编代码特点
1. 函数指针的调用都是通过间接跳转实现：
   - 使用 `call *%rax` 指令进行间接调用
   - 这是x86-64架构下函数指针调用的标准方式

## 结论
1. C语言中函数名和函数地址是等价的
2. 函数指针的两种调用语法在编译后会被转换为相同的机器码
3. 函数指针的调用都是通过间接跳转实现的
4. 这种实现方式确保了函数指针调用的灵活性，同时保持了代码的执行效率

## 编程建议
1. 在C语言中，可以自由选择使用函数名或取地址操作符来获取函数地址
2. 函数指针的调用可以使用更简洁的 `pfun()` 语法
3. 理解函数指针的底层实现有助于编写更高效的代码
