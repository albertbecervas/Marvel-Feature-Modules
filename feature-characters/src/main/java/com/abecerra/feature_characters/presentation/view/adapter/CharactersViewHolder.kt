package com.abecerra.feature_characters.presentation.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.abecerra.feature_characters.ui.characters.model.CharacterModel
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_characters_list.view.*

class CharactersViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    fun bind(onCharacterSelected: (character: CharacterModel) -> Unit, character: CharacterModel) {
        view.tv_name?.text = character.name
        Glide.with(view.context).load(character.thumbnail).into(view.iv_character)
        view.setOnClickListener {
            onCharacterSelected(character)
        }
    }
}