package your.projectPackage.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.internal.composableLambda
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(navController.currentDestination?.route ?: "")
                        },
                    )
                },
                bottomBar = {
                    NavigationBar {
                        listOf("expected", "unexpected").forEach { route ->
                            NavigationBarItem(
                                selected = route == navController.currentDestination?.route,
                                icon = { Icon(Icons.Default.Home, contentDescription = null) },
                                label = { Text(route) },
                                onClick = {
                                    navController.navigate(route)
                                },
                            )
                        }
                    }
                },
            ) { innerPadding ->
                Column(Modifier.padding(innerPadding)) {
                    NavHost(
                        navController = navController,
                        startDestination = "expected",
                    ) {
                        composableLambda {}
                    }
                }
            }
        }
    }
}
