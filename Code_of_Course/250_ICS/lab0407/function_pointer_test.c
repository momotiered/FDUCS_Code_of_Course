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