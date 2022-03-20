fun main() {
    val comments1 = Post.Comments(100, false, false, false, false)
    val comments2 = Post.Comments(1, true, true, true, true)
    val copiright1 = Post.Copyright(2556, "Ivanych", "Petr", "user")
    val copiright2 = Post.Copyright(3635, "OneJournal99", "OneJournal", "journal")
    val likes1 = Post.Likes(25, false, false, false)
    val likes2 = Post.Likes(25, true, true, true)
    val reposts1 = Post.Reposts(10, false)
    val reposts2 = Post.Reposts(1, true)
    val views1 = Post.View(10)
    val views2 = Post.View(0)
    val placeholder = Post.Donut.Placeholder("Заглушка");
    val donut1 = Post.Donut(false, 200, placeholder, false, "duration")
    val donut2 = Post.Donut(true, 100, placeholder, true, "all")

    val service = WallService
    println(service.add(Post(0, 3535, 4444, 8989, 456567788, "Текст поста 1",
        5555, 6767, false, comments1, copiright1, likes1, reposts1, views1,
        "post", 3456, false, false, false, false, false,
        false, donut1, 3456)))
}


object WallService {
    private var posts = emptyArray<Post>()

    fun add(post: Post): Post {
        if (!posts.isEmpty()) {
            val oldId = posts.last().id
            val postCopy = post.copy(id = oldId + 1);
            posts += postCopy
        } else {
            posts += post.copy(1)
        }
        return posts.last()
    }

    fun update(post: Post): Boolean {
        val id = post.id
        for ((index, oldPost) in posts.withIndex()) {
            if (id == oldPost.id) {
                val tempPost = oldPost
                posts[index] = post.copy(date = oldPost.date);
                return true
            }
        }
        return false
    }
}


data class Post (
    val id: Int = 0,
    val ownerId: Int,
    val fromId: Int,
    val createdBy: Int,
    val date: Int,
    val text: String,
    val replyOwnerId: Int,
    val replyPostId: Int,
    val friendsOnly: Boolean,
    val comments: Comments,
    val copyright: Copyright,
    val likes: Likes,
    val reposts: Reposts,
    val view: View,
    val postType: String,
    val signerId: Int,
    val canPin: Boolean,
    val canDelete: Boolean,
    val canEdit: Boolean,
    val isPinned: Boolean,
    val markedAsAds: Boolean,
    val isFavorite: Boolean,
    val donut: Donut,
    val postponedId: Int
        ) {
    data class Comments (
        val count: Int,
        val canPost: Boolean,
        val groupsCanPost: Boolean,
        val canClose: Boolean,
        val canOpen: Boolean
            )
    data class Copyright (
        val id: Int,
        val link: String,
        val name: String,
        val type: String
            )
    data class Likes (
        val count: Int,
        val userLikes: Boolean,
        val canLike: Boolean,
        val canPublish: Boolean
            )
    data class Reposts (
        val count: Int,
        val userReposted: Boolean
            )
    data class View (
        val count: Int
            )
    data class Donut (
        val isDonut: Boolean,
        val paidDuration: Int,
        val placeholder: Placeholder,
        val canPublishFreeCopy: Boolean,
        val editMode: String
            ) {
        class Placeholder (
            val text: String
                )
    }
}


