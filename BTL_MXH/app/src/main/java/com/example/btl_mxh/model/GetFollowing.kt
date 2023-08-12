data class GetFollowing(
    val meta: Meta,
    val items: List<Item>,
)

data class Meta(
    val totalElements: Long,
    val totalPages: Long,
    val pageNum: Long,
    val pageSize: Long,
    val sortBy: String,
    val sortType: String,
)

data class Item(
    val createdDate: String,
    val lastModifiedDate: String,
    val id: String,
    val email: String,
    val fullName: String,
    val username: String,
    val phone: String,
    val gender: String,
    val avatar: String,
    val birthday: String,
    val roleName: String,
)
