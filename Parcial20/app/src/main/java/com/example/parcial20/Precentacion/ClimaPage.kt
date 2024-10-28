package com.example.parcial20.Precentacion

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel


@Composable
fun ClimaPage(
    modifier:Modifier = Modifier
) {
    val viewModel : ClimaViewModel = viewModel<ClimaViewModel>()
    ClimaView(
        modifier = Modifier,
        estado = viewModel.estado,
    ) {
        viewModel.ejecutar(it)
    }
}