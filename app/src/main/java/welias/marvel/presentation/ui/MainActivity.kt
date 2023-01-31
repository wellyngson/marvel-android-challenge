package welias.marvel.presentation.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import welias.marvel.presentation.navigation.NavGraph
import welias.marvel.presentation.theme.MarvelTheme

class MainActivity : ComponentActivity() {

    private lateinit var navHostController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MarvelTheme {
                navHostController = rememberNavController()
                NavGraph(navController = navHostController)
            }
        }
    }
}
