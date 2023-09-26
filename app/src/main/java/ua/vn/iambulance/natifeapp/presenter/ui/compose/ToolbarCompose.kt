package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import ua.vn.iambulance.natifeapp.presenter.*

@Composable
fun TopToolbarWithListSorting(
    title: String,
    onCrossClick: () -> Unit,
    onGridClick: () -> Unit,
    onLinearClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        ButtonClose(click = onCrossClick, modifier = Modifier.align(Alignment.CenterVertically))
        TextTitle(modifier = Modifier.align(Alignment.CenterVertically), text = title)
        Spacer(modifier = Modifier.weight(1f))
        ButtonGrid(click = onGridClick, modifier = Modifier.align(Alignment.CenterVertically))
        ButtonLinear(click = onLinearClick, modifier = Modifier.align(Alignment.CenterVertically))
    }
}

@Composable
fun TopToolbarWithOneButton(onClick: () -> Unit, state: Int) {
    Row(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        when (state) {
            SCREEN_IMAGE -> {
                ButtonBack(click = onClick, modifier = Modifier.align(Alignment.CenterVertically))
            }
            SCREEN_INTERNET_IS_NOT_AVAILABLE -> {
                ButtonClose(click = onClick, modifier = Modifier.align(Alignment.CenterVertically))
            }
        }
    }
}