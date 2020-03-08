package com.abecerra.network.services

import com.abecerra.network.BuildConfig
import com.abecerra.network.dto.CharacterDto
import com.abecerra.network.dto.ResponseDto
import com.abecerra.network.utils.ApiParameters.PARAM_API_KEY
import com.abecerra.network.utils.ApiParameters.PARAM_HASH
import com.abecerra.network.utils.ApiParameters.PARAM_OFFSET
import com.abecerra.network.utils.ApiParameters.PARAM_TS
import com.abecerra.network.utils.Endpoints.CHARACTERS_URL
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CharactersService {

    @GET(CHARACTERS_URL)
    fun getCharacters(
        @Query(PARAM_OFFSET) offset: Int,
        @Query(PARAM_TS) ts: String = BuildConfig.TIME_STAMP,
        @Query(PARAM_API_KEY) key: String = BuildConfig.API_KEY,
        @Query(PARAM_HASH) hash: String = BuildConfig.HASH
    ): Call<ResponseDto<List<CharacterDto>>>
}