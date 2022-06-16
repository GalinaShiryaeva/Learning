enum class PostType {
    AUDIO, PHOTO, VIDEO, DIGEST
}

data class Post(
    val id: Long,
    val type: PostType,
    val content: String,
    val likes: Int = 0
)

fun main() {
    val posts: List<Post> = listOf(
        Post(6, PostType.PHOTO, "...", 2),
        Post(5, PostType.VIDEO, "...", 30),
        Post(4, PostType.PHOTO, "...", 21),
        Post(3, PostType.AUDIO, "...", 5),
        Post(2, PostType.VIDEO, "...", 60),
        Post(1, PostType.AUDIO, "...", 18)
    )

    /*
    val topBoundary = 10
    val topDigest = posts
        .filter { it.likes >= topBoundary }
        .joinToString(separator = "\n") { it.content }
        .let { Post(0, PostType.DIGEST, it) }
    println(topDigest)


    /*
    val filtered = posts.filter { it.likes > topBoundary }
    val likes = filtered.map { it.likes }
    // val likesSum = likes.reduce { acc, current -> acc + current }
    val likesSum = likes.sumOf { it }
     */

    val sum = posts
        .filter { it.likes > topBoundary }
        .map { it.likes }
        .sumOf { it }

    println("sum = $sum")
    */

    val topBoundary = 10
    val topCount = 5
    val emptyDigestContent = "Digest is empty"

    val topDigest = posts.asSequence()
        .filter { it.likes >= topBoundary }
        .take(topCount)
        .joinToString(separator = "\n") { it.content }
        .ifEmpty { emptyDigestContent }
        .let { Post(0, PostType.DIGEST, it) }

    println(topDigest)
}