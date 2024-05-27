package xyz.sina.dowr.tutorial

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.key
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDirection
import xyz.sina.dowr.utils.Texts


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tutorial(){


    val texts = listOf{
        Texts.gameName
        Texts.tutorialFirst
        Texts.about
    }
    Box(){

        val pagerStatus = rememberPagerState (initialPage = 0) {texts.size}
        HorizontalPager(state = pagerStatus, key = {texts[it]}) {index->
            TextScreens(text = index)
        }
    }

    
}

@Composable
fun TextScreens(text : String){

    Text(text = text, style = TextStyle(textDirection = TextDirection.Rtl))


}