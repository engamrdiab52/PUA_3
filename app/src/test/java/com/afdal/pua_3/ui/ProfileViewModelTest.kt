package com.afdal.pua_3.ui


import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.afdal.pua_3.repository.MainRepository
import com.afdal.pua_3.repository.source.remoteDataSource.RemoteDataSource
import com.afdal.pua_3.utilis.getOrAwaitValue
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.setMain
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class ProfileViewModelTest {

    @ExperimentalCoroutinesApi
    private val testDispatcher = TestCoroutineDispatcher()

    private lateinit var repository: MainRepository
    private lateinit var viewModel: ProfileViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun setUp() {
        Dispatchers.setMain(testDispatcher)
        val remoteDataSource = RemoteDataSource()
        repository = MainRepository(remoteDataSource)
        viewModel = ProfileViewModel(repository)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }

    @ExperimentalCoroutinesApi
    @Test
    fun test_getUserName() {
        runBlockingTest {
            viewModel.provideName()
            val value = viewModel.getResponseFirebase().getOrAwaitValue()
            assertThat(value, `is`("****YasminAmyTalia****"))
        }
    }

}