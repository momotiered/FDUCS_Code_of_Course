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