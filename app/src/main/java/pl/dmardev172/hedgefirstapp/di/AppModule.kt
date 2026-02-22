package pl.dmardev172.hedgefirstapp.di

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import pl.dmardev172.hedgefirstapp.MyViewModel

val appModule = module {
    viewModel { MyViewModel() }
}