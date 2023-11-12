package com.mmk.kmpnotifier.sample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.mmk.kmpnotifier.notification.NotifierFactory
import com.mmk.kmpnotifier.notification.configuration.NotificationPlatformConfiguration
import com.mmk.kmpnotifier.permission.AndroidPermissionUtil
import com.mmk.kmpnotifier.permission.permissionUtil

class MainActivity : ComponentActivity() {
    private val permissionUtil: AndroidPermissionUtil by permissionUtil()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        permissionUtil.askNotificationPermission()
        NotifierFactory.initialize(
            configuration = NotificationPlatformConfiguration.Android(
                R.drawable.ic_launcher_foreground,
            )
        )
        setContent {
            App()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App()
}