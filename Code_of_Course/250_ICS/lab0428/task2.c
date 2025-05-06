#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>

int main() {
    pid_t pid;
    int status;
    
    // 创建子进程
    pid = fork();
    
    if (pid < 0) {
        // fork失败
        perror("fork调用失败");
        return EXIT_FAILURE;
    } else if (pid == 0) {
        // 子进程执行部分
        printf("子进程 (PID: %d) 开始执行\n", getpid());
        
        char *args[] = {"/bin/ls", "-l", NULL};
        char *env[] = {NULL};
        
        printf("子进程准备执行 ls -l 命令...\n");
        
        if (execve("/bin/ls", args, env) == -1) {
            perror("execve调用失败");
            exit(EXIT_FAILURE);
        }
        
        // 如果execve成功执行，这里的代码不会被执行
        printf("这行不会被打印\n");
        exit(EXIT_SUCCESS);
    } else {
        // 父进程执行部分
        printf("父进程 (PID: %d) 创建了子进程 (PID: %d)\n", getpid(), pid);
        printf("父进程正在等待子进程结束...\n");
        
        // 等待子进程结束
        waitpid(pid, &status, 0);
        
        if (WIFEXITED(status)) {
            printf("子进程已结束，退出码: %d\n", WEXITSTATUS(status));
        } else {
            printf("子进程异常终止\n");
        }
        
        printf("父进程继续执行，并结束\n");
    }
    
    return EXIT_SUCCESS;
} 