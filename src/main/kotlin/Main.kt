// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import extensions.loadImageBitmap

@Composable
@Preview fun app() {
        val image = "https://img.elo7.com.br/product/zoom/2678F78/cartaz-poster-vingadores-4-ultimato-filme-marvel-avengers-colecionador.jpg"
        MaterialTheme (
            colors = darkColors(primary = Color.Black)
                ) {
            Box(
                modifier = Modifier.fillMaxSize()
            ) {
                Column {
                    Text("Vingadores: Ultimato")
                    Image(bitmap = image.loadImageBitmap(),
                        contentDescription = "Poster do filme Vingadores: Ultimato",
                        modifier = Modifier.height(500.dp))
                    Text(
                        "Nota: 10.0 - Ano: 2019",
                        modifier = Modifier.padding(vertical = 5.dp),
                        fontWeight = FontWeight(700),
                        textDecoration = TextDecoration.Underline)
                }

            }
        }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "IMDB") {
        app()
    }
}
