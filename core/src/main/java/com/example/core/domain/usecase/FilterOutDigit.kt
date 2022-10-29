package com.example.core.domain.usecase

class FilterOutDigit {

    operator fun invoke(text : String) : String{
        return text.filter { it.isDigit() }
    }
}