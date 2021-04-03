package com.cobo.bootcobo.service;

import com.cobo.bootcobo.entity.User;
import com.cobo.bootcobo.model.request.User.LoginRequest;
import com.cobo.bootcobo.model.request.User.RegisterRequest;

public interface UserService {
    User login (LoginRequest loginRequest);
    User Register (RegisterRequest registerRequest);
}
