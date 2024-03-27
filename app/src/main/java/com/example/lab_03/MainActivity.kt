package com.example.lab_03

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lab_03.ui.theme.Lab_03Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab_03Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Task_03_Navigation()
                }
            }
        }
    }
}

@Composable
fun Task_02_Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginPage(navController)
        }
        composable("signup") {
            SignupPage(navController)
        }
    }
}

@Composable
fun Task_03_Navigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "actorslist") {
        composable("actorslist") {
            FriendsrFrontPage(navController)
        }
        composable(
            route = "actordetails/{actorId}",
            arguments = listOf(
                navArgument("actorId") {
                    type = androidx.navigation.NavType.IntType
                }
            )
        ) { backStackEntry ->
            val actorId = backStackEntry.arguments?.getInt("actorId")

            actorId?.let{
                FriendsSecondPage(navController, actorId)
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Lab_03Theme {
        Task_03_Navigation()
    }
}
