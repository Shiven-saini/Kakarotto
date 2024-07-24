package com.shiven.kakarot

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shiven.kakarot.ui.theme.KakarottoTheme
import com.shiven.network.KtorClient
import com.shiven.network.model.domain.Character
import com.shiven.network.model.domain.Race


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
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Text(text=character.toString(), fontSize = 20.sp)
                    Spacer(Modifier.height(20.dp))
                    CharacterRaceComponent(race = Race.Saiyan)
                }
            }
        }
    }
}


@Composable
fun CharacterRaceComponent(race: Race) {
    Column (
        modifier = Modifier
            .width(IntrinsicSize.Min)
            .background(
                color = Color.LightGray,
            )
            .border(
                width = 2.dp,
                color = colorResource(id = race.color)
            )
    ) {
        Text( text = "Race", fontSize = 18.sp)
        Spacer(modifier = Modifier.height(30.dp))
        Text(text = race.displayName, fontSize = 24.sp, fontWeight = FontWeight.Bold)
    }
}
