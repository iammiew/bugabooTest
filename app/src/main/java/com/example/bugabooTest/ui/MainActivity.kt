package com.example.bugabooTest.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale.Companion.FillBounds
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.decode.SvgDecoder
import coil.request.ImageRequest


// response list header layout
var imageListHeaderTest = listOf(
    "https://ott-picture.bugaboo.tv/5295f706-5432-41b9-b108-aed0d81e33e0693586789710418060-l.jpeg",
    "https://ott-picture.bugaboo.tv/f90e4b31-d1a9-4401-9acf-cd1797981d365791574007745955270-l.jpeg",
    "https://ott-picture.bugaboo.tv/5295f706-5432-41b9-b108-aed0d81e33e0693586789710418060-l.jpeg"
)

var imageListRakon = listOf(
    "https://ott-picture.bugaboo.tv/5295f706-5432-41b9-b108-aed0d81e33e0693586789710418060-l.jpeg",
    "https://ott-picture.bugaboo.tv/5925d57a-2040-4f91-937c-db63e1e2da405382121168498665467-l.jpeg",
    "https://ott-picture.bugaboo.tv/c001200e-9b7f-42d9-bf91-6c98438cbe342773677227546064480-l.jpeg"
)

data class listDetailRakon(
    var rakon: List<DetailRakon>? = null
)

data class DetailRakon(
    var type: String,
    var description: String,
    var img: List<String>
)

var detailRakonTest = DetailRakon(
    type = "vertical1",
    description = "123",
    img = imageListRakon
)

var listDetailRakonTest = listDetailRakon(
    listOf(detailRakonTest)
)

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HeaderBugaboo()
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HeaderBugaboo() {
    val pagerState = rememberPagerState(pageCount = {
        imageListHeaderTest.size
    })

    Column(
        modifier = Modifier
            .padding(horizontal = 8.dp)
            .fillMaxWidth()
    ) {
        Row(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .fillMaxWidth()
        ) {
            coil.compose.AsyncImage(
                model = "https://inter.bugaboo.tv/assets/images/logo-ch7.png",
                contentDescription = null,
                modifier = Modifier
                    .size(45.dp)
                    .aspectRatio(1f / 1f)
            )
            coil.compose.AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data("https://inter.bugaboo.tv/assets/images/logo-bugaboo-inter.svg")
                    .decoderFactory(SvgDecoder.Factory())
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .size(65.dp)
            )
            Row(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = {}
                ) {
                    Text("เข้าสู่ระบบ")
                }
            }
        }
        Spacer(modifier = Modifier.width(8.dp))
        HorizontalPager(state = pagerState) { page ->
            Box {
                coil.compose.AsyncImage(
                    model = imageListHeaderTest[page],
                    contentDescription = null,
                    contentScale = FillBounds,
                    modifier = Modifier
                        .aspectRatio(16f / 9f)
                )
                Column(
                    modifier = Modifier.align(Alignment.BottomCenter)
                ) {
                    Row {
                        Column(
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(text = "คนกล้าท้าชน")
                            Row {
                                for (i in 0..5) {
                                    Icon(
                                        imageVector = Icons.Outlined.Star,
                                        contentDescription = null,
                                        tint = Color.Red
                                    )
                                }
                                Text(text = "2567", modifier = Modifier.padding(top = 3.dp, start = 3.dp))
                                Surface(
                                    modifier = Modifier.padding(start = 5.dp),
                                    shape = RoundedCornerShape(corner = CornerSize(3.dp)),
                                    border = BorderStroke(width = 2.dp, color = Color.White),
                                    color = Color.Transparent // This is what you're missing
                                ) {
                                    Text(
                                        modifier = Modifier.padding(start = 6.dp, end = 6.dp),
                                        text = "ท",
                                        color = Color.White
                                    )
                                }
                                Text(text = "18 ตอน", modifier = Modifier.padding(bottom = 3.dp, start = 5.dp))
//                                OutlinedCard(
//                                    border = BorderStroke(1.dp, Color.White),
//                                    shape = RoundedCornerShape(80)
//                                ) {
//                                    Text(text = "n")
//                                }
//                                for (i in 0..5) {
//                                    if (i == 4 || i == 5) {
//                                        Icon(
//                                            imageVector = Icons.Outlined.Star,
//                                            contentDescription = null
//                                        )
//                                    } else {
//                                        Icon(
//                                            imageVector = Icons.Outlined.Star,
//                                            contentDescription = null,
//                                            tint = Color.Red
//                                        )
//                                    }
//                                }
                            }
                        }
                    }
                }
            }
        }
        Row(
            Modifier
                .wrapContentHeight()
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            repeat(pagerState.pageCount) { iteration ->
                val color =
                    if (pagerState.currentPage == iteration) Color.Red else Color.LightGray
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(CircleShape)
                        .background(color)
                        .size(8.dp)
                )
            }
        }
        Column {
            Text("ละครแนะนำ")
            Column {
                listDetailRakonTest.rakon?.forEach { result ->
                    if (result.type == "vertical1") {
                        LazyRow {
                            items(imageListRakon) { index ->
                                coil.compose.AsyncImage(
                                    model = index,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .aspectRatio(9f / 16f)
                                        .widthIn(50.dp, 200.dp)
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                        }
                    } else {
                        LazyRow {
                            items(imageListRakon) { index ->
                                coil.compose.AsyncImage(
                                    model = index,
                                    contentDescription = null,
                                    modifier = Modifier
                                        .aspectRatio(1f)
                                        .fillMaxSize(),
                                )
                                Spacer(modifier = Modifier.width(10.dp))
                            }
                        }
                    }
                }
            }
        }

    }
}
