#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <time.h>

int main() {
    pid_t pid[3];
    int status, i;
    int sleep_time;
    
    // 初始化随机数生成器
    srand(time(NULL));
    
    printf("父进程 (PID: %d) 开始执行\n", getpid());
    
    // 创建三个子进程
    for (i = 0; i < 3; i++) {
        pid[i] = fork();
        
        if (pid[i] < 0) {
            // fork失败
            perror("fork调用失败");
            return EXIT_FAILURE;
        } else if (pid[i] == 0) {
            // 子进程执行部分
            // 生成1-9秒的随机数
            sleep_time = rand() % 9 + 1;
            
            printf("子进程 %d (PID: %d) 开始睡眠 %d 秒...\n", i+1, getpid(), sleep_time);
            
            // 睡眠指定的时间
            sleep(sleep_time);
            
            printf("子进程 %d (PID: %d) 已经睡眠了 %d 秒，即将退出\n", i+1, getpid(), sleep_time);
            
            // 将睡眠时间作为退出码
            exit(sleep_time);
        }
    }
    
    // 父进程等待所有子进程结束
    for (i = 0; i < 3; i++) {
        printf("父进程正在等待子进程 %d (PID: %d) 结束...\n", i+1, pid[i]);
        
        // 等待特定子进程结束
        waitpid(pid[i], &status, 0);
        
        if (WIFEXITED(status)) {
            printf("子进程 %d (PID: %d) 已正常结束，退出码(睡眠秒数): %d\n", 
                   i+1, pid[i], WEXITSTATUS(status));
        } else {
            printf("子进程 %d (PID: %d) 异常终止\n", i+1, pid[i]);
        }
    }
    
    printf("所有子进程已结束，父进程结束\n");
    
    return EXIT_SUCCESS;
} 