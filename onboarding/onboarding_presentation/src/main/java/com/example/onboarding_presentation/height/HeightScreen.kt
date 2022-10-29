package com.example.onboarding_presentation.height

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.core.R
import com.example.core.util.UiEvent
import com.example.core_ui.LocalSpacing
import com.example.onboarding_presentation.component.ActionButton
import com.example.onboarding_presentation.component.SelectableButton
import com.example.onboarding_presentation.component.UnitTextField
import com.example.onboarding_presentation.gender.GenderViewModel
import com.plcoding.core.domain.model.Gender
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect

@Composable
fun HeightScreen(
    scaffoldState: ScaffoldState,
    onNextClick: (UiEvent.Navigate) -> Unit,
    viewModel: HeightViewModel = hiltViewModel()
){

    val spacing = LocalSpacing.current
    val context = LocalContext.current
    LaunchedEffect(key1 = true) {
        viewModel.uiEvent.collect { event ->
            when(event){
                is UiEvent.Navigate -> onNextClick(event)
                is UiEvent.ShowSnackbar -> {
                      scaffoldState.snackbarHostState.showSnackbar(
                          event.message.asString(context)
                      )
                }
                else -> Unit
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(spacing.spaceLarge)
    ){
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally


        ) {
            Text(text = stringResource(id = R.string.whats_your_age),
                style = MaterialTheme.typography.h3)

            Spacer(modifier = Modifier.height(spacing.spaceMedium))
            UnitTextField(value = viewModel.height, onValueChange = viewModel::onHeightEnter , unit = stringResource(
                id = R.string.cm
            ) )

        }
        ActionButton(text = stringResource(id = R.string.next),
            onClick = { viewModel::onNextClick },
            modifier = Modifier.align(Alignment.BottomEnd))
    }

}