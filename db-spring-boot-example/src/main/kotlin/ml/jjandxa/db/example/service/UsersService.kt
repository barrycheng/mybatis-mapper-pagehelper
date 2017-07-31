package ml.jjandxa.db.example.service

import ml.jjandxa.db.example.mapper.model.Users
import ml.jjandxa.db.service.BaseService
import org.springframework.stereotype.Service

@Service
class UsersService : BaseService<Users>()