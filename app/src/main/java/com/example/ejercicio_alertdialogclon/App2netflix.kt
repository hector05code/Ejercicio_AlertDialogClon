package com.example.ejercicio_alertdialogclon

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column


import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun bar() {
    var ventana by remember { mutableStateOf("home") }


    Scaffold(
        bottomBar = {
            BottomNavigationBarM3(
                selectedScreen = ventana,
                onScreenSelected = { ventana = it }
            )
        }
    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            when (ventana) {
                "inicio" -> inicio()
                "novedades" -> Novedades()
                "pelis" -> Peliseries()
            }
        }
    }
}

@Composable

fun inicio() {


    Column(
        modifier = Modifier
            .fillMaxSize()

            .background(color = Color.Black)
    ) {

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(horizontal = 10.dp)
                .padding(bottom = 10.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.logoletra),
                contentDescription = null,
                modifier = Modifier.fillMaxSize()


            )
        }
        Box(
            Modifier
                .fillMaxWidth()
                .weight(0.5f), Alignment.Center
        ) {
            Text(text = "Elige tu perfil", color = Color.White, fontSize = 20.sp)

        }
        Row(
            Modifier
                .weight(4f)
                .fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly

        ) {


            Column(
                Modifier.fillMaxHeight(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Box(Modifier.size(100.dp)) {
                    Image(
                        painter = painterResource(R.drawable.p1),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )

                }


                Text(color = Color.White, text = "perfil1")
                Spacer(Modifier.height(20.dp))
                Box(Modifier.size(100.dp)) {
                    Image(
                        painter = painterResource(R.drawable.p2),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(color = Color.White, text = "perfil2")
                Spacer(Modifier.height(20.dp))
                Box(
                    Modifier
                        .size(100.dp)
                        .border(width = 2.dp, color = Color.LightGray), Alignment.Center
                ) {
                    Text(
                        text = "+",
                        fontSize = 60.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Light
                    )

                }
                Text(color = Color.White, text = "Add perfil")
            }




            Column(Modifier.fillMaxHeight(), horizontalAlignment = Alignment.CenterHorizontally) {
                Box(Modifier.size(100.dp)) {
                    Image(
                        painter = painterResource(R.drawable.p3),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(color = Color.White, text = "perfil3")
                Spacer(Modifier.height(20.dp))
                Box(Modifier.size(100.dp)) {
                    Image(
                        painter = painterResource(R.drawable.pinfantil),
                        contentDescription = null,
                        modifier = Modifier.fillMaxSize()
                    )
                }
                Text(color = Color.White, text = "perfil infantil")
            }


        }


    }


}

@Composable
fun spacio() {
    Spacer(Modifier.height(20.dp))
}

@Composable
fun Peliseries() {
    val recomendacion = listOf(
        R.drawable.breakingbad,
        R.drawable.vikingos, R.drawable.nosferatu
    )

    val españolas = listOf(
        R.drawable.hoyo,
        R.drawable.cocina, R.drawable.elbola, R.drawable.alfa
    )

    val volveraver = listOf(
        R.drawable.sinnovedadalfrente

    )

    val porquehevisto = listOf(
        R.drawable.snieve

    )

    Column(
        Modifier
            .fillMaxSize()
            .background(Color.Black)


    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .height(65.dp)
                .background(Color.Black), horizontalArrangement = Arrangement.Start
        ) {
            Image(
                painter = painterResource(R.drawable.netflixlogo),
                contentDescription = null,

                )
            Row(
                Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.End,

                verticalAlignment = Alignment.CenterVertically
            ) {

                Image(
                    painter = painterResource(R.drawable.pantalla),
                    contentDescription = null,
                    modifier = Modifier.size(35.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Spacer(Modifier.width(15.dp))
                Image(
                    painter = painterResource(R.drawable.descargar),
                    contentDescription = null,
                    modifier = Modifier.size(35.dp),
                    colorFilter = ColorFilter.tint(Color.White)
                )
                Spacer(Modifier.width(15.dp))
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = null,
                    modifier = Modifier.size(40.dp),
                    tint = Color.White
                )
            }
        }

        Column(
            Modifier
                .weight(1f)
                .verticalScroll(rememberScrollState())
        ) {
            Text(text = "  Recomendaciones de hoy para ti", color = Color.White)
            Row(
                Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(8.dp), horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                for (i in 1..10) {


                    Card(
                        Modifier
                            .height(150.dp)
                            .width(115.dp)
                    ) {
                        Image(
                            painter = painterResource(id = recomendacion[i % recomendacion.size]),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }


            }
            Text(text = "  Volver a ver", color = Color.White)
            Row(
                Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())

                    .padding(8.dp), horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                for (i in 1..10) {


                    Card(
                        Modifier
                            .height(150.dp)
                            .width(115.dp)
                    ) {
                        Image(
                            painter = painterResource(id = volveraver[i % volveraver.size]),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }


            }
            Text(text = "  Series y perliculas españolas", color = Color.White)
            Row(
                Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(8.dp), horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                for (i in 1..10) {


                    Card(
                        Modifier
                            .height(150.dp)
                            .width(115.dp)
                    ) {
                        Image(
                            painter = painterResource(id = españolas[i % españolas.size]),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }


            }
            Text(text = "  Porque has visto Breaking Bad", color = Color.White)
            Row(
                Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())

                    .padding(8.dp), horizontalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                for (i in 1..10) {


                    Card(
                        Modifier
                            .height(150.dp)
                            .width(115.dp)
                    ) {
                        Image(
                            painter = painterResource(id = porquehevisto[i % porquehevisto.size]),
                            contentDescription = null,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier.fillMaxSize()
                        )
                    }
                }


            }
        }


    }

}

@Composable
fun Novedades() {

    Column(
        Modifier


    ) {
        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .height(50.dp)
                .background(Color.Black),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Text(
                text = "Novedades mas vistas", color = Color.White, fontSize = 20.sp

            )
            Spacer(Modifier.width(15.dp))
            Image(
                painter = painterResource(R.drawable.pantalla),
                contentDescription = null,
                modifier = Modifier.size(30.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Spacer(Modifier.width(15.dp))
            Image(
                painter = painterResource(R.drawable.descargar),
                contentDescription = null,
                modifier = Modifier.size(30.dp),
                colorFilter = ColorFilter.tint(Color.White)
            )
            Spacer(Modifier.width(15.dp))
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                modifier = Modifier.size(35.dp),
                tint = Color.White
            )

        }

        Row(
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .background(
                    Color.Black
                )
                .padding(10.dp)
                .height(40.dp)
                .horizontalScroll(
                    rememberScrollState()
                )
        ) {

            Box(
                modifier = Modifier
                    .background(Color.Black, shape = CircleShape)
                    .border(width = 2.dp, shape = CircleShape, color = Color.Gray)

                    .padding(4.dp).align(Alignment.CenterVertically)
            ) {
                Text(text = "Las 10 series mas populares", color = Color.White, fontSize = 10.sp)
            }
            Spacer(Modifier.width(5.dp))
            Box(
                modifier = Modifier
                    .background(Color.Black, shape = CircleShape)
                    .border(width = 2.dp, shape = CircleShape, color = Color.Gray)

                    .padding(4.dp).align(Alignment.CenterVertically)
            ) {
                Text(text = "Lo mas visto ", color = Color.White,fontSize = 10.sp)
            }
            Spacer(Modifier.width(5.dp))
            Box(
                modifier = Modifier
                    .background(Color.Black, shape = CircleShape)
                    .border(width = 2.dp, shape = CircleShape, color = Color.Gray)

                    .padding(4.dp).align(Alignment.CenterVertically)
            ) {
                Text(text = "Proximamente", color = Color.White,fontSize = 10.sp)
            }

        }
        Column(
            Modifier
                .weight(10f)
                .background(Color.Black)
                .verticalScroll(rememberScrollState())
        ) {

            Row(
                Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(end = 10.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxHeight()
                        .weight(1f)
                ) {
                    Text(text = "Dic", color = Color.Gray, fontSize = 20.sp)
                    Text(
                        text = "15",
                        color = Color.White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                }


                Column(
                    Modifier
                        .fillMaxHeight()
                        .weight(3.5f)
                ) {
                    Image(
                        painter = painterResource(R.drawable.transformers),
                        contentDescription = null,

                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Spacer(Modifier.height(15.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.size(35.dp),
                            tint = Color.White
                        )
                        Spacer(Modifier.width(15.dp))
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = null,
                            modifier = Modifier.size(35.dp),
                            tint = Color.White,
                        )
                        Spacer(Modifier.width(15.dp))
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            modifier = Modifier.size(35.dp),
                            tint = Color.White
                        )
                    }
                    Spacer(Modifier.height(15.dp))
                    Text(
                        text = "Estreno el 15 de diciembre",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Hhuighiuhguu uhgiu hga uhgiu huhiug hiuhgu eru uheruhg iurugeu hgeug uuwhg uegh urweu uhg uruhu heuh uhrruw rehgiu urhg uwiugh uewrh ",
                        color = Color.Gray
                    )

                    Text(text = "Adrenalina • Ciencia ficcion • Accion", color = Color.White)
                }


            }
            Spacer(Modifier.height(15.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(end = 10.dp)
            ) {
                Column(
                    Modifier
                        .fillMaxHeight()
                        .weight(1f)
                ) {
                    Text(text = "Dic", color = Color.Gray, fontSize = 20.sp)
                    Text(
                        text = "15",
                        color = Color.White,
                        fontSize = 40.sp,
                        fontWeight = FontWeight.Bold
                    )
                }


                Column(
                    Modifier
                        .fillMaxHeight()
                        .weight(3.5f)
                ) {
                    Image(
                        painter = painterResource(R.drawable.transformers),
                        contentDescription = null,

                        contentScale = ContentScale.FillHeight,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clip(RoundedCornerShape(16.dp))
                    )
                    Spacer(Modifier.height(15.dp))
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceEvenly,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = null,
                            modifier = Modifier.size(35.dp),
                            tint = Color.White
                        )
                        Spacer(Modifier.width(15.dp))
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = null,
                            modifier = Modifier.size(35.dp),
                            tint = Color.White,
                        )
                        Spacer(Modifier.width(15.dp))
                        Icon(
                            imageVector = Icons.Default.Info,
                            contentDescription = null,
                            modifier = Modifier.size(35.dp),
                            tint = Color.White
                        )
                    }
                    Spacer(Modifier.height(15.dp))
                    Text(
                        text = "Estreno el 15 de diciembre",
                        color = Color.White,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = "Hhuighiuhguu uhgiu hga uhgiu huhiug hiuhgu eru uheruhg iurugeu hgeug uuwhg uegh urweu uhg uruhu heuh uhrruw rehgiu urhg uwiugh uewrh ",
                        color = Color.Gray
                    )

                    Text(text = "Adrenalina • Ciencia ficcion • Accion", color = Color.White)
                }


            }


        }


    }


}

@Composable
fun BottomNavigationBarM3(
    selectedScreen: String,
    onScreenSelected: (String) -> Unit
) {
    NavigationBar(
        containerColor = Color.Black,
        contentColor = Color.White
    ) {
        NavigationBarItem(
            selected = selectedScreen == "inicio",
            onClick = { onScreenSelected("inicio") },
            icon = { Icon(Icons.Default.Home, contentDescription = "Inicio") },
        )
        NavigationBarItem(
            selected = selectedScreen == "novedades",
            onClick = { onScreenSelected("novedades") },
            icon = { Icon(Icons.Default.Star, contentDescription = "Novedades") },
        )
        NavigationBarItem(
            selected = selectedScreen == "pelis",
            onClick = { onScreenSelected("pelis") },
            icon = { Icon(Icons.Default.PlayArrow, contentDescription = "pelis") },
        )
    }
}