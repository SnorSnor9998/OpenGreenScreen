package com.snor.opengs

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.snor.opengs.ui.theme.BlueScreen
import com.snor.opengs.ui.theme.ColorSelectBox
import com.snor.opengs.ui.theme.GCButton
import com.snor.opengs.ui.theme.GreenScreen
import com.snor.opengs.ui.theme.OpenGreenScreenTheme
import com.snor.opengs.ui.theme.TrackerColorSelectBox
import com.snor.opengs.ui.theme.TrackerSizeSlider

class MainActivity : ComponentActivity() {

    @SuppressLint("SourceLockedOrientationActivity")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

        enableEdgeToEdge()
        setContent {
            OpenGreenScreenTheme {

                var trackerSize by remember { mutableIntStateOf(40) }
                val colorSelect = remember { mutableStateOf(GreenScreen) }
                val trackerColorSelect = remember { mutableStateOf(Color.Black) }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 24.dp, vertical = 8.dp),
                        color = Color.White,
                        shape = RoundedCornerShape(15.dp),
                        shadowElevation = 5.dp
                    ) {

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Screen Color",
                                modifier = Modifier.padding(vertical = 10.dp)
                            )

                            Row(
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                                    .padding(vertical = 12.dp)
                            ) {
                                ColorSelectBox(colorSelect)
                            }
                        }
                    }

                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 24.dp, vertical = 8.dp),
                        color = Color.White,
                        shape = RoundedCornerShape(15.dp),
                        shadowElevation = 5.dp
                    ) {

                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Tracker Color",
                                modifier = Modifier.padding(vertical = 10.dp)
                            )

                            Row(
                                horizontalArrangement = Arrangement.Center,
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .wrapContentHeight()
                                    .padding(vertical = 18.dp)
                            ) {
                                TrackerColorSelectBox(trackerColorSelect)
                            }
                        }
                    }


                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .wrapContentHeight()
                            .padding(horizontal = 24.dp, vertical = 8.dp),
                        color = Color.White,
                        shape = RoundedCornerShape(15.dp),
                        shadowElevation = 5.dp
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .wrapContentHeight()
                                .padding(horizontal = 32.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Tracker Size: $trackerSize DP",
                                modifier = Modifier.padding(vertical = 10.dp),
                                color = Color.Black,
                                textAlign = TextAlign.Center
                            )

                            TrackerSizeSlider(trackerSize.toFloat(), onValueChange = { value ->
                                trackerSize = value
                            })
                        }
                    }

                    Text(
                        text = "Hold middle tracker to cancel",
                        modifier = Modifier.padding(top = 4.dp),
                        color = Color.Gray
                    )

                    GCButton(
                        text = "Start",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp, bottom = 24.dp, start = 24.dp, end = 24.dp),
                        onClick = {
                            val i = Intent(this@MainActivity, ScreenActivity::class.java)
                            i.putExtra("TrackerSize", trackerSize)
                            i.putExtra(
                                "ScreenColor",
                                if (colorSelect.value == BlueScreen) "BLUE" else "GREEN"
                            )
                            i.putExtra(
                                "TrackerColor",
                                if (trackerColorSelect.value == Color.White) "WHITE" else "BLACK"
                            )
                            startActivity(i)
                        })

                }
            }
        }
    }
}
