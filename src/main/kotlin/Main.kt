fun main() {

    val list = mutableListOf<Post>(
        Post(1, "text1", 13),
        Post(2, "text2", 4),
        Post(3, "text3", 28),
        Post(4, "text4", 7),
        Post(5, "text5", 0),
        Post(6, "text6", 0)
    )

    /*
    //with type inference
    val short = ::liked
    // without type inference
    val full: (post: Post) -> Boolean = ::liked

    println(short(list.first()))
    println(full(list.first()))
    */

    /*
    val predicate = fun(post: Post) = post.likes > 0
    // val predicate = fun(post: Post): Boolean { return post.likes > 0 }
    val linkedList = list.filter(predicate)
    println(linkedList)
    */

    /*
    val linkedList = list.filter(fun(post: Post) = post.likes > 0)
    println(linkedList)
    val otherLinkedList = list.filterIndexed { index: Int, post: Post ->
        post.likes > 0
    }
    println(otherLinkedList.indices)
    */

    /*
    // если какой-то параметров нас не интересует, можно использовать _
    val otherLinkedList: List<Post> = list.filterIndexed { _, post ->
        post.likes > 0
    }
    println(otherLinkedList)
     */

    val linkeddList: List<Post> = list.filter { post ->
        return@filter post.likes > 10
    }
    println(linkeddList)

    val likedList: List<Post> = list.filter lambda@ { post ->
        return@lambda post.likes > 5
    }
    println(likedList)
}

fun liked(post: Post) = post.likes > 0

data class Post(
    val id: Int,
    val text: String,
    var likes: Int
)