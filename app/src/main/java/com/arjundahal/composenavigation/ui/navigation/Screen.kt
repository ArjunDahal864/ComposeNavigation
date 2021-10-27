package com.arjundahal.composenavigation.ui.navigation

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.UploadFile
import androidx.compose.ui.graphics.vector.ImageVector
import com.arjundahal.composenavigation.R


sealed class Screen(
    val route: String, @StringRes val resourceId: Int, val icon: ImageVector
) {
    object HomePage : Screen("home", R.string.home, Icons.Filled.Home,)
    object SearchPage : Screen("search", R.string.search,Icons.Filled.Search)
    object Document : Screen("document", R.string.document,Icons.Filled.UploadFile)
    object Profile : Screen("profile", R.string.profile,Icons.Filled.Person)
}
