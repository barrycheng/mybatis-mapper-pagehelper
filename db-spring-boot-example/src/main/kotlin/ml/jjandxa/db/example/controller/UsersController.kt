package ml.jjandxa.db.example.controller

import com.github.pagehelper.PageHelper
import ml.jjandxa.db.example.mapper.mapper.UsersMapper
import ml.jjandxa.db.example.mapper.model.Users
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController {

    @Autowired
    private lateinit var userMapper: UsersMapper

    @RequestMapping("/users")
    fun selectAll(pageNum: Int, pageSize: Int): List<Users> {
        PageHelper.startPage<Users>(pageNum, pageSize)
        return userMapper.selectAll()
    }
}