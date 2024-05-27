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



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tutorial(){


    val texts = listOf{
    }
    Box(){

        val pagerStatus = rememberPagerState (initialPage = 0) {texts.size}
        HorizontalPager(state = pagerStatus, key = {texts[it]}) {index->
            TextScreens(text = index.toString())
        }
    }

    
}

@Composable
fun TextScreens(text : String){

    Text(text = text, style = TextStyle(textDirection = TextDirection.Rtl))


}