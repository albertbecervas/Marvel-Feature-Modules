package com.abecerra.network.dto

data class ResponseDto<T>(
    val code: Int,
    val status: String,
    val data: ResponseDataDto<T>
)



