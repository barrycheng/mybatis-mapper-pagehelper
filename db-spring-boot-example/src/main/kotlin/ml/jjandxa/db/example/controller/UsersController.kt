package ml.jjandxa.db.example.controller

import ml.jjandxa.db.example.mapper.model.Users
import ml.jjandxa.db.example.service.UsersService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController {

    @Autowired
    private lateinit var usersServices: UsersService

    @RequestMapping("/users")
    fun selectAll(pageNum: Int, pageSize: Int): List<Users> {
        return usersServices.selectAllByList(pageNum, pageSize).list
    }
}