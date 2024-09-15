package com.snor.opengs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.snor.opengs.ui.theme.BlueScreen
import com.snor.opengs.ui.theme.GreenScreen
import com.snor.opengs.ui.theme.OpenGreenScreenTheme
import com.snor.opengs.ui.theme.TrackerIcon
import com.snor.opengs.util.DeviceUtil

class ScreenActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()
        DeviceUtil.hideSystemBar(this.window)

        val trackerSize = intent.getIntExtra("TrackerSize", 40)
        val screenColor = if (intent.getStringExtra("ScreenColor") == "BLUE") {
            BlueScreen
        } else {
            GreenScreen
        }
        val trackerColor = if (intent.getStringExtra("TrackerColor") == "WHITE") {
            Color.White
        } else {
            Color.Black
        }

        setContent {

            //Disable onBackPress
            BackHandler(
                enabled = true
            ) {

            }

            OpenGreenScreenTheme {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(screenColor)
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(horizontal = 24.dp, vertical = 48.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            TrackerIcon(size = trackerSize, color = trackerColor, onClick = {})
                            TrackerIcon(size = trackerSize, color = trackerColor, onClick = {})
                        }

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight(),
                            contentAlignment = Alignment.Center,
                        ) {
                            TrackerIcon(size = trackerSize, color = trackerColor, onClick = {
                                finish()
                            })
                        }

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(horizontal = 24.dp, vertical = 48.dp),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            TrackerIcon(size = trackerSize, color = trackerColor, onClick = {})
                            TrackerIcon(size = trackerSize, color = trackerColor, onClick = {})
                        }


                    }


                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        DeviceUtil.unHideSystemBar(this.window)
    }


}