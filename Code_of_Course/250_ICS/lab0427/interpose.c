#define _GNU_SOURCE
#include <stdio.h>
#include <stdlib.h>
#include <dlfcn.h>
#include <time.h>
#include <sys/time.h>

// 原始函数的类型定义
typedef int (*linear_sum_t)(int);
typedef int (*square_sum_t)(int);

// 获取当前时间的微秒数
long get_time_usec() {
    struct timeval tv;
    gettimeofday(&tv, NULL);
    return tv.tv_sec * 1000000 + tv.tv_usec;
}

// 包装后的 linear_sum 函数
int linear_sum(int n) {
    static linear_sum_t orig_linear_sum = NULL;
    if (!orig_linear_sum) {
        orig_linear_sum = (linear_sum_t)dlsym(RTLD_NEXT, "linear_sum");
    }
    
    long start_time = get_time_usec();
    int result = orig_linear_sum(n);
    long end_time = get_time_usec();
    
    fprintf(stderr, "linear_sum(%d) took %ld microseconds\n", n, end_time - start_time);
    return result;
}

// 包装后的 square_sum 函数
int square_sum(int n) {
    static square_sum_t orig_square_sum = NULL;
    if (!orig_square_sum) {
        orig_square_sum = (square_sum_t)dlsym(RTLD_NEXT, "square_sum");
    }
    
    long start_time = get_time_usec();
    int result = orig_square_sum(n);
    long end_time = get_time_usec();
    
    fprintf(stderr, "square_sum(%d) took %ld microseconds\n", n, end_time - start_time);
    return result;
} 