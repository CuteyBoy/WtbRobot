package com.wtb.hook.utils

import android.util.Log

/**
 * @Description: 用于处理Log工具类
 */
object LogUtils {

    // DES: debug模式
    private const val DEBUG = 0
    // DES: 错误模式
    private const val ERROR = 1
    // DES: 警告模式
    private const val WARING = 2
    // DES: 默认log的标志
    const val DEFAULT_TAG = "hookLog"
    // DES: 用于判断是否debug模式
    var isDebug = true

    // DES: debug的时候打印的信息
    fun debug(tag: String?, vararg errorInfo: Any?) {
        if(!isDebug) return
        errorInfo.forEach {
            print(DEBUG, getTag(tag), it)
        }
    }

    // DES: 获取tag
    private fun getTag(tag: String?) = if(tag.isNullOrEmpty()) {
        DEFAULT_TAG
    } else {
        tag
    }

    // DES: 打印错误信息
    fun error(tag: String?, vararg errorInfo: Any?){
        if(!isDebug) return
        errorInfo.forEach {
            print(ERROR, getTag(tag), it)
        }
    }

    // DES: 打印警告信息
    fun waring(tag: String?, vararg errorInfo: Any?) {
        if(!isDebug) return
        errorInfo.forEach {
            print(WARING, getTag(tag), it)
        }
    }

    // DES: 打印日志
    private fun print(logType: Int, tag: String = DEFAULT_TAG, errorInfo: Any?) {
        errorInfo ?: return
        val throwableInfo = when (errorInfo) {
            is Throwable -> {
                getThrowableInfo(errorInfo)
            }
            !is String -> errorInfo.toString()
            else -> errorInfo
        }
        when (logType) {
            DEBUG -> Log.d(tag, throwableInfo)
            ERROR -> Log.e(tag, throwableInfo)
            WARING -> Log.w(tag, throwableInfo)
            else -> {}
        }
    }

    // DES: 获取堆栈信息
    fun getThrowableInfo(errorInfo: Throwable): String {
        val errorBuilder = StringBuffer()
        errorInfo.stackTrace.forEach {
            errorBuilder.append(it.toString() + "\n")
        }
        return errorInfo.toString()
    }
}