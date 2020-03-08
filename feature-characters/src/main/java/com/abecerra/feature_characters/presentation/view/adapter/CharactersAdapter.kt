package com.abecerra.feature_characters.presentation.view.adapter

import android.view.ViewGroup
import com.abecerra.base.presentation.BaseAdapter
import com.abecerra.base.utils.inflate
import com.abecerra.feature_characters.R
import com.abecerra.feature_characters.ui.characters.model.CharacterModel

class CharactersAdapter(private val onCharacterSelected: (characterModel: CharacterModel) -> Unit) :
    BaseAdapter<CharactersViewHolder, CharacterModel>() {

    override fun onBindViewHolder(holder: CharactersViewHolder, item: CharacterModel, pos: Int) {
        holder.bind(onCharacterSelected, item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder =
        CharactersViewHolder(parent.inflate(R.layout.item_characters_list))
}