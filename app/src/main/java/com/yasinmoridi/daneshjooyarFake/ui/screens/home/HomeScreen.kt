package com.yasinmoridi.daneshjooyarFake.ui.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import com.yasinmoridi.daneshjooyarFake.R
import com.yasinmoridi.daneshjooyarFake.data.model.HomeCategory
import com.yasinmoridi.daneshjooyarFake.ui.screens.home.cat.AiCategory
import com.yasinmoridi.daneshjooyarFake.ui.screens.home.cat.BusinessCategory
import com.yasinmoridi.daneshjooyarFake.ui.screens.home.cat.GameCategory
import com.yasinmoridi.daneshjooyarFake.ui.screens.home.cat.MobileCategory
import com.yasinmoridi.daneshjooyarFake.ui.screens.home.cat.SiteCategory

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(navHostController: NavHostController) {
    val tabItem = listOf<HomeCategory>(
        HomeCategory(
            title = "طراحی سایت",
            icon = painterResource(id = R.drawable.sitecat)
        ),

        HomeCategory(
            title = "برنامه نویسی موبایل",
            icon = painterResource(id = R.drawable.andcat)
        ),

        HomeCategory(
            title = "هوش مصنوعی",
            icon = painterResource(id = R.drawable.hosh)
        ),
        HomeCategory(
            title = "بازی سازی",
            icon = painterResource(id = R.drawable.bazisazi)
        ),
        HomeCategory(
            title = "کسب و کار",
            icon = painterResource(id = R.drawable.casbokar)
        ),

        )
    val pagerState = rememberPagerState { tabItem.size }
    Scaffold(
        containerColor = Color.White,
        topBar = {
            TabSection(
                pagerState = pagerState,
                tabItem = tabItem
            )
        }
    ) { innerPadding ->
        HorizontalPager(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            state = pagerState
        ) {page->
            when(page){
                0-> SiteCategory(navHostController = navHostController)
                1-> MobileCategory(navHostController = navHostController)
                2-> AiCategory(navHostController = navHostController)
                3-> GameCategory(navHostController = navHostController)
                4-> BusinessCategory(navHostController = navHostController)
                else ->MobileCategory(navHostController)
            }
        }
    }
}