package com.abecerra.feature_characters.domain.repository

import com.abecerra.base.data.BaseRepository

interface CharactersRepository : BaseRepository<CharactersRepositoryOutput>{
    fun getCharacters(offset: Int)

    fun getCharactersStartingWith(name: String)
}