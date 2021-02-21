// IMessageHandler.aidl
package com.wtb.hook.message;

// Declare any non-default types here with import statements
import com.wtb.hook.message.IMessageReceiver;

interface IMessageHandler {
   // 用于转发送消息的方法
   void transitMessage(String sender, String targetUser, in byte[] message);
   // 用于注册消息的接收者
   void registerMessageReceiver(in IMessageReceiver receiver);
   // 用于注销消息的接收者
   void unregisterMessageReceiver(in IMessageReceiver receiver);
}