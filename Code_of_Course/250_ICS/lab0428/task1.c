#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main() {
    char *args[] = {"/bin/ls", "-l", NULL};
    char *env[] = {NULL};
    
    printf("准备执行 ls -l 命令...\n");
    
    if (execve("/bin/ls", args, env) == -1) {
        perror("execve调用失败");
        return EXIT_FAILURE;
    }
    
    // 如果execve成功执行，这里的代码不会被执行
    printf("这行不会被打印，因为execve会替换当前进程\n");
    
    return EXIT_SUCCESS;
} 