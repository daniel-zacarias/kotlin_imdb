// Copyright 2000-2021 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import extensions.loadImageBitmap
import models.Movie

@Composable
@Preview fun app() {
        val scrollState = rememberScrollState()
        MaterialTheme (
            colors = darkColors(
                primary = Color.Black,
                background = Color(27, 27, 28),
                primaryVariant = Color.White)
                ) {
            Surface {
                Box(
                    modifier = Modifier.fillMaxSize().scrollable(
                        state = scrollState,
                        orientation = Orientation.Vertical
                    )
                ) {
                    val movies = listOf<Movie>(
                        Movie(
                            "Vingadores: Ultimato",
                            "https://img.elo7.com.br/product/zoom/2678F78" +
                                    "/cartaz-poster-vingadores-4-ultimato-filme-marvel-avengers-colecionador.jpg",
                            10.0,
                            2019),
                        Movie(
                            "Homem-aranha: Longe de casa",
                            "https://br.web.img2.acsta.net/pictures/19/07/05/17/30/5167951.jpg",
                            8.0,
                            2019),
                        Movie(
                            "Homem-aranha: Longe de casa",
                            "https://br.web.img2.acsta.net/pictures/19/07/05/17/30/5167951.jpg",
                            8.0,
                            2019),
                        Movie(
                            "Homem-aranha: Longe de casa",
                            "https://br.web.img2.acsta.net/pictures/19/07/05/17/30/5167951.jpg",
                            8.0,
                            2019),
                        Movie(
                            "Homem-aranha: Longe de casa",
                            "https://br.web.img2.acsta.net/pictures/19/07/05/17/30/5167951.jpg",
                            8.0,
                            2019)
                    )
                    LazyColumn { items(movies) { movie -> movieItem(movie = movie) } }
                }
            }
        }
}

@Composable
private fun movieItem(movie: Movie){
    val image = movie.image
    return Column(
        modifier = Modifier.width(200.dp).padding(16.dp)
    ) {
        Image(bitmap = image.loadImageBitmap(),
            contentDescription = "Poster do filme Vingadores: Ultimato",
            modifier = Modifier.clip(RoundedCornerShape(4.dp)))
        Row (
            modifier = Modifier.fillMaxWidth()
                .padding(
                    top = 8.dp,
                    start = 8.dp,
                    end = 8.dp
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(Icons.Rounded.Star,
                    contentDescription = "Estrela amarela",
                    tint = Color.Yellow,
                    modifier = Modifier.height(16.dp)
                )
                Text(
                    movie.grade.toString(),
                    textAlign = TextAlign.Center,
                    color = MaterialTheme.colors.primaryVariant,
                    modifier = Modifier
                        .padding(start = 2.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(700)
                )
            }
            Text(movie.year.toString(),
                fontSize = 14.sp,
                color = Color(0xffeeeeee))
        }
        Text(
            movie.title,
            modifier = Modifier.padding(
                start = 16.dp,
                top = 8.dp,
                end = 16.dp
            ),
            fontSize = 12.sp,
            textAlign = TextAlign.Center
        )
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "IMDB") {
        app()
    }
}
