//
// Created by sg on 2015/12/27.
//

#include "com_view_sg_ndkdemo_MainActivity.h"
/*
* Class:     com_jnimobile_www_myjnidemo_MainActivity
* Method:    getStringFromNative
* Signature: ()Ljava/lang/String;
*/
JNIEXPORT jstring JNICALL Java_com_view_sg_ndkdemo_MainActivity_getStringFromNative
        (JNIEnv * env, jobject obj){
    return (*env)->NewStringUTF(env,"I'm comes from to Native Function!");
}