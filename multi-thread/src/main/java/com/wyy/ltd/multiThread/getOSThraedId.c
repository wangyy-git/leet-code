#include<pthread.h>
#include<stdio.h>
#include<stdlib.h>
//调用这个本地方法的JAVA类类名编译成的.h文件
#include "Example4Start.h"
 

JNIEXPORT void JNICALL Java_Example4Start_getOSThraedId(JNIEnv *env, jobject c1){
	
	printf("current java native tid:%lu-----\n",pthread_self());
	usleep(700);
} 