package com.quickBite.producer;

import com.quickBite.dtos.requests.RegisterUserRequest;
import com.quickBite.dtos.responses.RegisterUserResponse;

public interface UserServices {
    RegisterUserResponse registerUser(RegisterUserRequest request);


}
