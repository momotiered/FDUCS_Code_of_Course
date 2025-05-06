#include <stdio.h>

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

int main() {
    struct s1 var1 = {0, 10, 100};
    struct s2 var2 = {10, 100, 0};
    struct s3 var3 = {100, 0, 10};

    // 1. 输出结构体大小
    printf("结构体大小:\n");
    printf("sizeof(struct s1) = %zu\n", sizeof(struct s1));
    printf("sizeof(struct s2) = %zu\n", sizeof(struct s2));
    printf("sizeof(struct s3) = %zu\n", sizeof(struct s3));

    // 2. 输出地址
    printf("\n结构体s1的地址信息:\n");
    printf("var1地址: %p\n", (void*)&var1);
    printf("name地址: %p\n", (void*)&var1.name);
    printf("code地址: %p\n", (void*)&var1.code);
    printf("value地址: %p\n", (void*)&var1.value);

    printf("\n结构体s2的地址信息:\n");
    printf("var2地址: %p\n", (void*)&var2);
    printf("code地址: %p\n", (void*)&var2.code);
    printf("value地址: %p\n", (void*)&var2.value);
    printf("name地址: %p\n", (void*)&var2.name);

    printf("\n结构体s3的地址信息:\n");
    printf("var3地址: %p\n", (void*)&var3);
    printf("value地址: %p\n", (void*)&var3.value);
    printf("name地址: %p\n", (void*)&var3.name);
    printf("code地址: %p\n", (void*)&var3.code);

    return 0;
} 