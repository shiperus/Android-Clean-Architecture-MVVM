package com.example.android.androidcleanarchitecturemvvm.domain

import kotlinx.coroutines.Deferred

abstract class BaseUseCase<T> {
    abstract fun perform(): Deferred<T>
}