package ua.vn.iambulance.natifeapp.presenter.ui.compose

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun NavigationComposable(paddingValues: PaddingValues, navController: NavHostController){
    NavHost(modifier = Modifier.padding(paddingValues), navController = navController, startDestination = "GridListScreen" ){
        composable("LinearListScreen"){
            
        }
        composable("GridListScreen"){
            
        }
    }
}