import junit.framework.Assert.assertTrue
import org.junit.Test

class WallServiceTest {

    @Test
    fun updateExistingTruePost() {
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

        service.add(Post(0, 3535, 4444, 8989, 456567788, "Текст поста 1",
            5555, 6767, false, comments1, copiright1, likes1, reposts1, views1,
            "post", 3456, false, false, false, false, false,
            false, donut1, 3456
        ))
        service.add(Post(0, 4567, 3567, 4356, 345678956, "Текст поста 2",
            4567, 5467, true, comments2, copiright2, likes2, reposts2, views2,
            "copy", 9876, true, true, true, true, true,
            true, donut2, 4567
        ))

        val update = Post(1, 3535, 4444, 8989, 456567788, "Текст поста 1",
            5555, 6767, false, comments1, copiright1, likes1, reposts1, views1,
            "post", 3456, false, false, false, false, false,
            false, donut1, 3456)

        val result = service.update(update)

        assertTrue(result)
    }


    @Test
    fun updateExistingTrueCopy() {
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

        service.add(Post(0, 3535, 4444, 8989, 456567788, "Текст поста 1",
            5555, 6767, false, comments1, copiright1, likes1, reposts1, views1,
            "post", 3456, false, false, false, false, false,
            false, donut1, 3456
        ))
        service.add(Post(0, 4567, 3567, 4356, 345678956, "Текст поста 2",
            4567, 5467, true, comments2, copiright2, likes2, reposts2, views2,
            "copy", 9876, true, true, true, true, true,
            true, donut2, 4567
        ))

        val update = Post(2, 3535, 4444, 8989, 456567788, "Текст поста 1",
            5555, 6767, false, comments1, copiright1, likes1, reposts1, views1,
            "post", 3456, false, false, false, false, false,
            false, donut1, 3456)

        val result = service.update(update)

        assertTrue(result)
    }


    @Test
    fun updateExistingFalse() {
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

        service.add(Post(0, 3535, 4444, 8989, 456567788, "Текст поста 1",
            5555, 6767, false, comments1, copiright1, likes1, reposts1, views1,
            "post", 3456, false, false, false, false, false,
            false, donut1, 3456
        ))
        service.add(Post(0, 4567, 3567, 4356, 345678956, "Текст поста 2",
            4567, 5467, true, comments2, copiright2, likes2, reposts2, views2,
            "copy", 9876, true, true, true, true, true,
            true, donut2, 4567
        ))

        val update = Post(999, 3535, 4444, 8989, 456567788, "Текст поста 1",
            5555, 6767, false, comments1, copiright1, likes1, reposts1, views1,
            "post", 3456, false, false, false, false, false,
            false, donut1, 3456)

        val result = service.update(update)

        assertTrue(result)
    }
}