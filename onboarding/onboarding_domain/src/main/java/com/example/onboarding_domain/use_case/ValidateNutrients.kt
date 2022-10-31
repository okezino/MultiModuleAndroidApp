package com.example.onboarding_domain.use_case

import com.example.core.util.UiText
import com.example.onboarding_domain.R

class ValidateNutrients {
    operator fun invoke(
        card : String, protein : String, fat : String
    ) : Result{

        val carbRatio = card.toIntOrNull()
        val proteinRatio = protein.toIntOrNull()
        val fatRatio = fat.toIntOrNull()
        if(carbRatio == null || proteinRatio == null || fatRatio == null){
            return Result.Error(UiText.StringResource(com.example.core.R.string.error_invalid_values))
        }

        if(carbRatio +  proteinRatio + fatRatio != 100){
            return Result.Error(UiText.StringResource(com.example.core.R.string.error_not_100_percent))
        }

        return Result.Success(carbRatio/100f, proteinRatio/100f, fatRatio/100f)
    }

    sealed class Result{
        data class Success(
            val card : Float, val protein : Float, val fat : Float
        ) : Result()

        data class Error(val message : UiText) : Result()
    }
}