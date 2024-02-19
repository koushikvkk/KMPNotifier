package com.mmk.kmpnotifier.firebase

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.mmk.kmpnotifier.notification.Notifier
import com.mmk.kmpnotifier.notification.NotifierManagerImpl

internal class MyFirebaseMessagingService : FirebaseMessagingService() {

    private val notifierFactory by lazy { NotifierManagerImpl }
    override fun onNewToken(token: String) {
        super.onNewToken(token)
        println("FirebaseMessaging: onNewToken is called")
        notifierFactory.onNewToken(token)
    }

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)
        message.notification?.let {
            notifierFactory.onPushNotificationPayload(it.title ?: "", it.body ?: "")
        }
        if (message.data.isNotEmpty()){
            notifierFactory.onPushPayloadData(message.data)
        }
    }
}