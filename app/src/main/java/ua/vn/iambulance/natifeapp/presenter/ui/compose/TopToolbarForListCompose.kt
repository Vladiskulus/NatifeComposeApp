package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.*
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.*
import androidx.compose.ui.res.*
import ua.vn.iambulance.natifeapp.R
import ua.vn.iambulance.natifeapp.presenter.ui.theme.PurpleGrey80

@Composable
fun TopToolbar(
    title: String,
    onBackClick: () -> Unit,
    onGridClick: () -> Unit,
    onLinearClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .background(PurpleGrey80)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {

        IconButton(onClick = onBackClick,
            modifier = Modifier.align(Alignment.CenterVertically)) {
            Icon(Icons.Filled.Close, contentDescription = "Back")
        }
        Text(
            modifier = Modifier.align(Alignment.CenterVertically),
            text = title
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(onClick = onGridClick,
            modifier = Modifier.align(Alignment.CenterVertically)) {
            Icon(painterResource(id = R.drawable.ic_grid), contentDescription = "Grid")
        }
        IconButton(onClick = onLinearClick,
            modifier = Modifier.align(Alignment.CenterVertically)) {
            Icon(Icons.Filled.Menu, contentDescription = "Line")
        }
    }
}

@Composable
private fun ButtonBack(click: () -> Unit, modifier: Modifier){
    IconButton(onClick = click,
        modifier = modifier) {
        Icon(Icons.Filled.ArrowBack, contentDescription = "Back")
    }
}

@Composable
private fun ButtonClose(click: () -> Unit, modifier: Modifier){
    IconButton(onClick = click,
        modifier = modifier) {
        Icon(Icons.Filled.Close, contentDescription = "Back")
    }
}

@Composable
private fun ButtonGrid(modifier: Modifier, click: () -> Unit){
    IconButton(onClick = click,
        modifier = modifier) {
        Icon(painterResource(id = R.drawable.ic_grid), contentDescription = "Grid")
    }
}

@Composable
private fun ButtonLinear(modifier: Modifier, click: () -> Unit){
    IconButton(onClick = click,
        modifier = modifier) {
        Icon(Icons.Filled.Menu, contentDescription = "Line")
    }
}