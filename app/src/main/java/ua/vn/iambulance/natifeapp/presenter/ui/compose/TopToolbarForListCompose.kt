package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import ua.vn.iambulance.natifeapp.R
import ua.vn.iambulance.natifeapp.presenter.SCREEN_IMAGE
import ua.vn.iambulance.natifeapp.presenter.SCREEN_INTERNET_IS_NOT_AVAILABLE
import ua.vn.iambulance.natifeapp.presenter.ui.theme.PurpleGrey80

@Composable
fun TopToolbarWithListSorting(
    title: String,
    onCrossClick: () -> Unit,
    onGridClick: () -> Unit,
    onLinearClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(PurpleGrey80)
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
            .background(PurpleGrey80)
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

@Composable
private fun TextTitle(modifier: Modifier, text: String) {
    Text(
        modifier = modifier,
        text = text
    )
}

@Composable
private fun ButtonBack(click: () -> Unit, modifier: Modifier) {
    IconButton(
        onClick = click,
        modifier = modifier
    ) {
        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
    }
}

@Composable
private fun ButtonClose(click: () -> Unit, modifier: Modifier) {
    IconButton(
        onClick = click,
        modifier = modifier
    ) {
        Icon(Icons.Filled.Close, contentDescription = "Back")
    }
}

@Composable
private fun ButtonGrid(click: () -> Unit, modifier: Modifier) {
    IconButton(
        onClick = click,
        modifier = modifier
    ) {
        Icon(painterResource(id = R.drawable.ic_grid), contentDescription = "Grid")
    }
}

@Composable
private fun ButtonLinear(modifier: Modifier, click: () -> Unit) {
    IconButton(
        onClick = click,
        modifier = modifier
    ) {
        Icon(Icons.Filled.Menu, contentDescription = "Line")
    }
}