package sam.sultan.tokenandmedia.entities

data class ProductResponse(
    val id: Int,
    val name: String,
    val price: Int,
    var photo: String = "",
    val short_description: String
)
