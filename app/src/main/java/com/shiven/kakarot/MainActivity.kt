package com.shiven.kakarot

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.twotone.BookmarkAdd
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shiven.kakarot.ui.theme.KakarottoTheme
import com.shiven.kakarot.ui.theme.lalezarFont
import com.shiven.network.KtorClient
import com.shiven.network.model.domain.Character


// TODO: Add a surprise me fab
class MainActivity : ComponentActivity() {
    private val ktorClient = KtorClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            var character by remember {
                mutableStateOf<Character?>(null)
            }

            LaunchedEffect(key1 = Unit) {
//                kotlinx.coroutines.delay(3000)
                character = ktorClient.getCharacter(4)
            }

            KakarottoTheme {

            }
        }
    }
}

@Composable
fun CharacterDetailsScreen(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(color = 0xFFE3BC09))
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(
                    horizontal = 20.dp,
                    vertical = 10.dp
                )
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowBack,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
            Icon(
                imageVector = Icons.TwoTone.BookmarkAdd,
                contentDescription = null,
                modifier = Modifier.size(40.dp)
            )
        }

        Text(
            text = "Vegito",
            fontFamily = lalezarFont,
            fontSize = 44.sp,
            modifier = Modifier
                .fillMaxWidth()
                .height(IntrinsicSize.Min)
                .padding(horizontal = 20.dp)
        )

        Box (
            contentAlignment = Alignment.TopCenter,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Surface (
                color =  Color.White,
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.85f)
                    .align(Alignment.BottomCenter)
            ) {

            }

            // Character Image
            Image(
                painter = painterResource(id = R.drawable.vegetto),
                contentDescription = null,
                contentScale = ContentScale.Fit,
                modifier = Modifier.
                size(
                    width = 330.dp,
                    height = 450.dp
                )
            )
        }
    }
}


//@Composable
//fun CharacterDetails(modifier: Modifier = Modifier) {
//    Scaffold(
//        topBar = {
//            Row(
//                horizontalArrangement = Arrangement.SpaceBetween,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .padding(
//                        horizontal = 25.dp,
//                        vertical = 15.dp
//                    )
//            ) {
//                Icon(
//                    painter = painterResource(com.shiven.network.R.drawable.left),
//                    contentDescription = null
//                )
//                Icon(
//                    painter = painterResource(com.shiven.network.R.drawable.bookmark),
//                    contentDescription = null
//                )
//            }
//        }
//    ) { contentPadding ->
//        Box(
//            modifier = Modifier
//                .padding(contentPadding)
//                .background(color = Color.Black)
//        ) {
//        }
//    }
//}


// Refactor remove topAppBar and add custom container
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun CharacterDetails(modifier: Modifier = Modifier) {
//    Scaffold(
//        topBar = {
//            MediumTopAppBar(
//                title = @Composable {
//                    Text(
//                        "Grand Priest",
//                        fontFamily = lalezarFont,
//                        fontSize = 42.sp,
//                    )
//                },
//                windowInsets = TopAppBarDefaults.windowInsets,
//                colors = TopAppBarDefaults.mediumTopAppBarColors(containerColor = Color(color = 0xFFC6B5F9)),
//                navigationIcon = {
//                    Icon(
//                        imageVector = Icons.TwoTone.ArrowBack,
//                        contentDescription = null
//                    )
//                }
//            )
//        },
//    ) { innerPadding ->
//        Box(
//            contentAlignment = Alignment.TopCenter,
//            modifier = Modifier
//                .padding(innerPadding)
//                .fillMaxSize()
//                .background(Color(0xFFC6B5F9))
//        ) {
//
//            Surface(
//                color = Color.White,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight(0.87f)
//                    .align(Alignment.BottomCenter)
//                    .clip(
//                        RoundedCornerShape(
//                            topStart = 20.dp,
//                            topEnd = 20.dp
//                        )
//                    )
//            ) {
//
//            }
//            Image(
//                painter = painterResource(id = R.drawable.grand_priest),
//                contentDescription = null,
//                contentScale = ContentScale.Fit,
//                modifier = Modifier.
//                size(
//                    width = 330.dp,
//                    height = 570.dp
//                )
//            )
//
//        }
//    }


//@Composable
//fun CharacterScreen(modifier: Modifier = Modifier) {
//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.Red)
//    ) {
//
//        // Top Bar container, set align modifier to top start.
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .align(Alignment.TopStart),
//            verticalArrangement = Arrangement.Top,
//            horizontalAlignment = Alignment.Start
//        ) {
//            Row(
//                horizontalArrangement = Arrangement.SpaceBetween,
//                verticalAlignment = Alignment.CenterVertically,
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(
//                        horizontal = 20.dp,
//                        vertical = 15.dp
//                    )
//            ) {
//                Icon(
//                    imageVector = Icons.Filled.ArrowBack,
//                    contentDescription = null,
//                    modifier = Modifier.size(30.dp)
//                )
//                Icon(
//                    imageVector = Icons.TwoTone.BookmarkAdd,
//                    contentDescription = null,
//                    modifier = Modifier.size(30.dp)
//                )
//            }
//            Text(
//                text = "Jiren",
//                fontSize = 38.sp,
//                fontWeight = FontWeight.Bold,
//                modifier = Modifier.padding(horizontal = 20.dp)
//            )
//        }
//
//        // Bottom Spread Sheet
//        // approach set fill max width, maxheight(.7f)
//        Surface(
//            color = Color.White,
//            modifier = Modifier
//                .fillMaxWidth()
//                .fillMaxHeight(0.7f)
//                .align(Alignment.BottomCenter)
//                .clip(
//                    RoundedCornerShape(
//                        topStart = 18.dp,
//                        topEnd = 18.dp
//                    )
//                )
//        ) {
//
//        }
//
//        Box(
//            modifier = Modifier
//                .background(Color.Blue)
//                .height(450.dp)
//                .align(Alignment.TopEnd)
//                .offset(
//                    x = -80.dp,
//                    y = 100.dp
//                )
//        ) {
//
//        }


//        Image(
//            painter = painterResource(R.drawable.gogeta),
//            contentDescription = null,
//            modifier = Modifier
//                .height(450.dp)
//                .align(Alignment.TopEnd)
//                .offset(
//                    x = -80.dp,
//                    y = 100.dp
//                )
//        )
//}
//}


@Preview(showSystemUi = true)
@Composable
fun CharacterDetailsPreview() {
    KakarottoTheme {
        CharacterDetailsScreen()
    }
}

