package models

data class Top250Data (
    val items: List<Top250DataDetail>,
    val errosMessage: String
)

data class Top250DataDetail(
    val id: String,
    val rank: String,
    val title: String,
    val fullTitleVar: String,
    val year: String,
    val image: String,
    val crew: String,
    val imDbRating: String,
    val imDbRatingCount: String
)

fun Top250DataDetail.toMovie(): Movie = Movie(
    title = this.title,
    image = this.image,
    grade = imDbRating.toDouble(),
    year = year.toInt()
)