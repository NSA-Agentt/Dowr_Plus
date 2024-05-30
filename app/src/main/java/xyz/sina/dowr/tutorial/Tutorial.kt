package xyz.sina.dowr.tutorial

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDirection
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.sina.dowr.R
import xyz.sina.dowr.utils.Title
import xyz.sina.dowr.utils.Txts


@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun Tutorial(){



    val texts = listOf(Txts.firstPageTutorial,
        Txts.secondPageTutorial,
        Txts.thirdPageTutorial)

    val title = listOf(
        Title.firstPageTitle,
        Title.secondPageTitle,
        Title.thirdPageTitle
    )
    // TODO: please add the game icon and punishment icon
    val icon = listOf(R.drawable.ic_rule ,R.drawable.ic_rule, R.drawable.ic_rule)

    Box(modifier = Modifier
        .fillMaxSize()
        .padding(24.dp), ){

        val pagerState = rememberPagerState (pageCount = {3})

        HorizontalPager(state = pagerState, modifier = Modifier.fillMaxSize() , verticalAlignment = Alignment.CenterVertically) {
            Column (Modifier.padding(bottom = 12.dp)){

                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Absolute.Right){
                    Text(title[it], style = TextStyle(textDirection = TextDirection.Rtl, ), fontSize = 20.sp, fontWeight = FontWeight.Bold)
                    Icon(painter = painterResource(id = icon[it]), contentDescription = null)
                }

                Text(texts[it], style = TextStyle(textDirection = TextDirection.Rtl), fontSize = 16.sp)


            }
        }

        Row(
            Modifier
                .wrapContentHeight().align(Alignment.BottomCenter)
                .fillMaxWidth()){
            IconButton(onClick = { /*TODO*/ }) {
                Icon(Icons.Default.CheckCircle, contentDescription = null)
            }
        }

        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth().align(Alignment.BottomCenter)
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center){
            repeat(pagerState.pageCount){

                val color = if(pagerState.currentPage == it ) Color.Red else Color.LightGray
                Box(modifier = Modifier
                    .padding(2.dp)
                    .clip(CircleShape)
                    .background(color)
                    .size(16.dp))

            }
        }



    }

    
}

