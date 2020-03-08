package com.abecerra.feature_characters.data

import com.abecerra.feature_characters.data.mapper.CharacterDtoMapper
import com.abecerra.feature_characters.domain.repository.CharactersRepository
import com.abecerra.feature_characters.domain.repository.CharactersRepositoryOutput
import com.abecerra.network.dto.CharacterDto
import com.abecerra.network.dto.ResponseDto
import com.abecerra.network.services.CharactersService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharactersRepositoryImpl(private val charactersService: CharactersService) :
    CharactersRepository {

    private var output: CharactersRepositoryOutput? = null
    override fun getCharacters(offset: Int) {
        charactersService.getCharacters(offset)
            .enqueue(object : Callback<ResponseDto<List<CharacterDto>>> {
                override fun onResponse(
                    call: Call<ResponseDto<List<CharacterDto>>>,
                    response: Response<ResponseDto<List<CharacterDto>>>
                ) {
                    response.body()?.let {
                        output?.onCharactersReceived(CharacterDtoMapper.map(it.data.results))
                    }
                }

                override fun onFailure(call: Call<ResponseDto<List<CharacterDto>>>, t: Throwable) {
                    val s = ""
                }
            })
    }

    override fun getCharactersStartingWith(name: String) {
    }

    override fun setOutput(output: CharactersRepositoryOutput) {
        this.output = output
    }
}