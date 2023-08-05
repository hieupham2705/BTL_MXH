data class Search(
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
    val role: Role,
)

data class Role(
    val id: Long,
    val name: String,
)