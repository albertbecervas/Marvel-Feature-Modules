package com.abecerra.feature_characters.presentation.view

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.abecerra.feature_characters.R
import com.abecerra.feature_characters.presentation.presenter.CharactersPresenter
import com.abecerra.feature_characters.ui.characters.model.CharacterModel
import com.abecerra.feature_characters.utils.CharactersTestConfigurator
import com.abecerra.feature_characters.utils.matchers.RecyclerViewMatchers.Companion.withItemCount
import com.abecerra.feature_characters.utils.serviceMock.MockWebServerController
import com.abecerra.network.dto.CharacterDto
import com.abecerra.network.dto.ResponseDto
import com.abecerra.network.services.CharactersService
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit


@RunWith(AndroidJUnit4::class)
class CharactersFragmentTest {

    private lateinit var listPresenter: CharactersPresenter

    private lateinit var charactersService: CharactersService

    @Before
    fun setup() {
        charactersService =
            MockWebServerController.buildMockedService(CharactersService::class.java)
        listPresenter = CharactersTestConfigurator.configurePresenter(charactersService)
    }

    @Test
    fun test_list_is_filled() {
        getCharactersJson()?.let {
            MockWebServerController.setUpOkResponseWithBody(it)
        }

        launchFragmentInContainer<CharactersFragment>(
            factory = ListFragmentTestFactory(listPresenter)
        )
        CountDownLatch(1).await(10, TimeUnit.MILLISECONDS)
        onView(withId(R.id.rv_characters)).check(matches(withItemCount(20)))
    }

    @After
    fun tearDown() {
        MockWebServerController.shutDown()
    }

    private fun getCharactersJson(): String? {
        val fileInput = this.javaClass.classLoader?.getResourceAsStream("characters_response")
        return fileInput?.bufferedReader().use { it?.readText() }
    }

    private fun getCharactersFromFakeJson(fileName: String): List<CharacterDto>? {

        //Getting the file
        val charactersString = getCharactersJson()
        val type = object : TypeToken<ResponseDto<List<CharacterDto>>>() {}.type

        return if (charactersString != null) {
            //parse data into the specified object
            Gson().fromJson<ResponseDto<List<CharacterDto>>>(charactersString, type)
                ?.data?.results
        } else {
            arrayListOf()
        }
    }
}