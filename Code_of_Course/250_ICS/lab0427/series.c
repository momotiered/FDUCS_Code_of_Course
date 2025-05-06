#include <stdio.h>

// 优化后的线性求和函数
int linear_sum(int n) {
    return n * (n + 1) / 2;  // 使用数学公式替代循环
}

// 优化后的平方和函数
int square_sum(int n) {
    return n * (n + 1) * (2 * n + 1) / 6;  // 使用数学公式替代循环
} 