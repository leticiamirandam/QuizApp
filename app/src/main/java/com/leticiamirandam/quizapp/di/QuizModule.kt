package com.leticiamirandam.quizapp.di

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.leticiamirandam.quizapp.data.api.AuthorizationInterceptor
import com.leticiamirandam.quizapp.data.api.QuizService
import com.leticiamirandam.quizapp.data.datasource.QuizRemoteDataSource
import com.leticiamirandam.quizapp.data.datasource.QuizRemoteDataSourceImpl
import com.leticiamirandam.quizapp.data.repository.QuizRepositoryImpl
import com.leticiamirandam.quizapp.domain.repository.QuizRepository
import com.leticiamirandam.quizapp.domain.usecase.GetQuizUseCase
import com.leticiamirandam.quizapp.presentation.QuizViewModel
import okhttp3.OkHttpClient
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://quizapi.io/api/v1/"

val networkModule = module {
    single<Gson> { GsonBuilder().create() }
    single {
        OkHttpClient.Builder()
            .addInterceptor(AuthorizationInterceptor())
            .build()
    }
    single<GsonConverterFactory> { GsonConverterFactory.create(get()) }
    single<RxJava2CallAdapterFactory> {
        RxJava2CallAdapterFactory.create()
    }
    single<Retrofit.Builder> {
        Retrofit.Builder()
            .client(get())
            .addConverterFactory(get<GsonConverterFactory>())
            .addCallAdapterFactory(get<RxJava2CallAdapterFactory>())
    }
}

val quizNetworkModule = module {
    single<Retrofit> {
        get<Retrofit.Builder>()
            .baseUrl(BASE_URL)
            .build()
    }
    single<QuizService> {
        get<Retrofit>().create(QuizService::class.java)
    }
}

val domainModule = module {
    factory { GetQuizUseCase(get()) }
}

val dataModule = module {
    factory<QuizRemoteDataSource> { QuizRemoteDataSourceImpl(get()) }
    factory<QuizRepository> { QuizRepositoryImpl(get()) }
}

val presentationModule = module {
    viewModel {
        QuizViewModel(
            getQuizUseCase = get()
        )
    }
}