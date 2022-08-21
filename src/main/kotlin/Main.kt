// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import extensions.loadImageBitmap

@Composable
@Preview fun app() {
        val image = "https://img.elo7.com.br/product/zoom/2678F78/cartaz-poster-vingadores-4-ultimato-filme-marvel-avengers-colecionador.jpg"
        MaterialTheme (
            colors = darkColors(
                primary = Color.Black,
                background = Color(27, 27, 28),
                primaryVariant = Color.White)
                ) {
            Box(
                modifier = Modifier.background(color = MaterialTheme.colors.background).width(250.dp)
            ) {
                Column(
                    modifier = Modifier.align(Alignment.Center).width(250.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(bitmap = image.loadImageBitmap(),
                        contentDescription = "Poster do filme Vingadores: Ultimato",
                        modifier = Modifier.width(220.dp).padding(top=20.dp))
                    Row{
                        Row(modifier = Modifier.padding(20.dp)) {
                            Icon(Icons.Rounded.Star, contentDescription = "Estrela amarela", tint = Color.Yellow )
                            Text(
                                "10.0",
                                textAlign = TextAlign.Center,
                                color = MaterialTheme.colors.primaryVariant,
                                modifier = Modifier.padding(horizontal = 0.dp, vertical = 4.dp),
                                fontWeight = FontWeight(700)
                            )
                        }
                        Text("2019",
                            modifier = Modifier.weight(1f).padding(20.dp),
                            textAlign = TextAlign.Right,
                            color = MaterialTheme.colors.primaryVariant)
                    }
                    Text(
                        "Vingadores: Ultimato",
                        modifier = Modifier.width(100.dp).padding(bottom = 40.dp),
                        color = MaterialTheme.colors.primaryVariant,
                        textAlign = TextAlign.Center
                    )
                }

            }
        }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "IMDB") {
        app()
    }
}
