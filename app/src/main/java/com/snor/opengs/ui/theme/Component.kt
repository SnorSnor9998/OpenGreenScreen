package com.snor.opengs.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.snor.opengs.R


@Composable
fun GCButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .size(120.dp, 50.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = GreenScreen,
            contentColor = Color.Black
        ),
        elevation = ButtonDefaults.buttonElevation(5.dp),
        shape = RoundedCornerShape(15.dp)
    ) {
        Text(text = text, fontSize = 16.sp)
    }
}

@SuppressLint("UnrememberedMutableInteractionSource")
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TrackerIcon(
    onClick: () -> Unit,
    size: Int = 80,
    color: Color = Color.Black
) {
    Icon(
        painter = painterResource(id = R.drawable.ic_tracker),
        contentDescription = "Tracker",
        modifier = Modifier
            .size(size.dp)
            .combinedClickable(
                interactionSource = MutableInteractionSource(),
                indication = null,
                onClick = {},
                onLongClick = {
                    onClick()
                }
            ),
        tint = color
    )
}

@Composable
fun TrackerSizeSlider(size: Float, onValueChange: (value: Int) -> Unit) {
    var sliderPosition by remember { mutableFloatStateOf(size) }
    Slider(
        value = sliderPosition,
        onValueChange = {
            sliderPosition = it
            onValueChange(it.toInt())
        },
        valueRange = 30f..150f,
        colors = SliderDefaults.colors(
            thumbColor = GreenScreen,
            activeTrackColor = GreenScreen
        )
    )
}

@SuppressLint("UnrememberedMutableState", "UnrememberedMutableInteractionSource")
@Composable
fun ColorSelectBox(colorValue: MutableState<Color>) {

    Box(
        modifier = Modifier
            .size(80.dp, 60.dp)
            .padding(horizontal = 16.dp)
            .background(color = GreenScreen, shape = RoundedCornerShape(10.dp))
            .border(
                2.dp,
                if (colorValue.value == GreenScreen) Color.Black else Color.Transparent,
                RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .clickable(
                onClick = {
                    colorValue.value = GreenScreen
                }
            )
    )

    Box(
        modifier = Modifier
            .size(80.dp, 60.dp)
            .padding(horizontal = 16.dp)
            .background(color = BlueScreen, shape = RoundedCornerShape(10.dp))
            .border(
                2.dp,
                if (colorValue.value == BlueScreen) Color.Black else Color.Transparent,
                RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .clickable(
                onClick = {
                    colorValue.value = BlueScreen
                }
            )
    )

}

@SuppressLint("UnrememberedMutableState", "UnrememberedMutableInteractionSource")
@Composable
fun TrackerColorSelectBox(colorValue: MutableState<Color>) {

    Box(
        modifier = Modifier
            .size(80.dp, 50.dp)
            .padding(horizontal = 16.dp)
            .background(color = GreenScreen, shape = RoundedCornerShape(10.dp))
            .border(
                2.dp,
                if (colorValue.value == Color.Black) Color.Black else Color.Transparent,
                RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .clickable(
                onClick = {
                    colorValue.value = Color.Black
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_tracker),
            contentDescription = "Tracker",
            modifier = Modifier
                .size(30.dp),
            tint = Color.Black
        )
    }

    Box(
        modifier = Modifier
            .size(80.dp, 50.dp)
            .padding(horizontal = 16.dp)
            .background(color = GreenScreen, shape = RoundedCornerShape(10.dp))
            .border(
                2.dp,
                if (colorValue.value == Color.White) Color.Black else Color.Transparent,
                RoundedCornerShape(10.dp)
            )
            .clip(RoundedCornerShape(10.dp))
            .clickable(
                onClick = {
                    colorValue.value = Color.White
                }
            ),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_tracker),
            contentDescription = "Tracker",
            modifier = Modifier
                .size(30.dp),
            tint = Color.White
        )
    }
}